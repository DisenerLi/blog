package com.test;

import com.baj.common.redis.RedisHandler;
import com.baj.common.test.AbstractTest;
import org.junit.Test;
import org.unitils.spring.annotation.SpringBeanByType;

/**
 * Created by liqiang on 2017/6/20.
 */
public class RedisHandleTest extends AbstractTest{

	@SpringBeanByType
	private RedisHandler redisHandler;

	@Test
	public void setRedisHandlerTest(){
		redisHandler.setString("123","11312");
		System.out.println(redisHandler.getStringVal("123"));
	}

}
