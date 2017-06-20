package com.baj.entity;

import java.util.Date;

/**
 * Created by liqiang on 2017/6/16.
 */
public class PojoDO {

	//主键id
	private Long id;
	//地区
	private String location;
	//地区城市编号Id
	private Long cityId;
	//细节描述
	private String detail;
	//日期
	private Date tdate;
	//最高温度
	private int temperatureMax ;
	//最低温度
	private int temperatureMin;
	//布尔值
	private Integer isBool;
	//单字节
	private Integer aByte;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Long getCityId() {
		return cityId;
	}

	public void setCityId(Long cityId) {
		this.cityId = cityId;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public Date getTdate() {
		return tdate;
	}

	public void setTdate(Date tdate) {
		this.tdate = tdate;
	}

	public int getTemperatureMax() {
		return temperatureMax;
	}

	public void setTemperatureMax(int temperatureMax) {
		this.temperatureMax = temperatureMax;
	}

	public int getTemperatureMin() {
		return temperatureMin;
	}

	public void setTemperatureMin(int temperatureMin) {
		this.temperatureMin = temperatureMin;
	}

	public Integer getIsBool() {
		return isBool;
	}

	public void setIsBool(Integer isBool) {
		this.isBool = isBool;
	}

	public Integer getaByte() {
		return aByte;
	}

	public void setaByte(Integer aByte) {
		this.aByte = aByte;
	}
}
