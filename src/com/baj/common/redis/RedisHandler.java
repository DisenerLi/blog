package com.baj.common.redis;

import com.baj.common.exception.BlogRuntimeException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Set;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;


/**
 * Created by liqiang on 2017/6/19.
 */
public class RedisHandler  {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	private JedisPool jedisPool;

	private String redisHost;

	private int port ;

	private int timeout;

	private int dbindex;

	public RedisHandler(String host, int port, int timeout, int dbIndex){
		JedisPoolConfig config = new JedisPoolConfig();
		config.setMaxTotal(50);
		config.setMaxIdle(20);
		config.setMinIdle(20);
		jedisPool = new JedisPool(config,host,port,timeout);
		this.dbindex = dbIndex;
	}

	public RedisHandler(GenericObjectPoolConfig poolConfig, String host, int port, int timeout) {
		jedisPool = new JedisPool(poolConfig, host, port, timeout);
	}

	public Jedis getJedis(){
		Jedis jedis = jedisPool.getResource();
		jedis.select(dbindex);
		return jedis;
	}

	public String getStringVal(String key){
		Jedis jedis = null;
		try{
			jedis = getJedis();
			String res = jedis.get(key);
			return res;
		}finally {
			closeJedis(jedis);
		}
	}

	public void setString(String key ,String val){
		Jedis jedis = null;
		try {
			jedis = getJedis();
			jedis.set(key, val);
		}finally {
			closeJedis(jedis);
		}
	}

	public <T> T getValue(String key,Class<T> cls){
		Jedis jedis = null;
		try{
			ObjectMapper objectMapper = new ObjectMapper();
			jedis = getJedis();
			String jsonValue = jedis.get(key);
			if(StringUtils.isBlank(jsonValue)){
				return objectMapper.readValue(jsonValue,cls);
			}else {
				return null;
			}
		}catch (IOException ex){
			logger.error("jackson parse json value error", ex);
			throw new BlogRuntimeException("jackson parse json value error");
		}finally {
			closeJedis(jedis);
		}
	}

	public void setValue(String key,Object val){
		Jedis jedis = null;
		try{
			ObjectMapper objectMapper = new ObjectMapper();
			jedis = getJedis();
			StringWriter stringWriter = new StringWriter();
			objectMapper.writeValue(stringWriter,val);
			jedis.set(key,stringWriter.getBuffer().toString());
		}catch (Exception ex){
			logger.error("jackson write json value error", ex);
			throw new BlogRuntimeException("jackson write json value error");
		}finally {
			closeJedis(jedis);
		}
	}

	public void setEx(String key,Object val,int seconds){
		Jedis jedis = null;
		try{
			ObjectMapper objectMapper = new ObjectMapper();
			jedis = getJedis();
			StringWriter stringWriter = new StringWriter();
			objectMapper.writeValue(stringWriter,val);
			jedis.setex(key,seconds,stringWriter.getBuffer().toString());
		}catch (Exception ex){
			logger.error("jackson write json value error", ex);
			throw new BlogRuntimeException("jackson write json value error");
		}finally {
			closeJedis(jedis);
		}
	}

	public long setNXValue(String key,Object val){
		Jedis jedis = null;
		try{
			ObjectMapper objectMapper = new ObjectMapper();
			jedis = getJedis();
			StringWriter stringWriter = new StringWriter();
			objectMapper.writeValue(stringWriter,val);
			return jedis.setnx(key,stringWriter.getBuffer().toString());
		}catch (Exception ex){
			logger.error("jackson write json value error", ex);
			throw new BlogRuntimeException("jackson write json value error");
		}finally {
			closeJedis(jedis);
		}
	}

	public boolean existsKey(String key){
		Jedis jedis = null;
		try{
			jedis = getJedis();
			return jedis.exists(key);
		}finally {
			closeJedis(jedis);
		}
	}

	public void expireKey(String key,int second){
		Jedis jedis = null;
		try{
			jedis = getJedis();
			jedis.expire(key,second);
		}finally {
			closeJedis(jedis);
		}
	}

	public void del(String... key){
		Jedis jedis = null;
		try{
			jedis = getJedis();
			jedis.del(key);
		}finally {
			closeJedis(jedis);
		}
	}

	public Set<String> keys(String pattern){
		Jedis jedis = null;
		try{
			jedis = getJedis();
			return jedis.keys(pattern);
		}catch (Exception e){
			logger.error("redis get keys err",e);
		}finally{
			closeJedis(jedis);
		}
		return null;
	}

	public void delKeys(String pattern){
		Jedis jedis = null;
		try{
			jedis = getJedis();
			Set<String> keys = jedis.keys(pattern);
			if(keys != null&& !keys.isEmpty()){
				String[] keyStr = new String[keys.size()];
				int index = 0;
				for (String key : keys) {
					keyStr[index] = key;
					++index;
				}
				jedis.del(keyStr);
			}
		}catch (Exception e){
			logger.error("redis delKeys err",e);
		}finally {
			closeJedis(jedis);
		}
	}


	public void closeJedis(Jedis jedis) {
		if(null != jedis){
			jedis.close();
		}
	}
}
