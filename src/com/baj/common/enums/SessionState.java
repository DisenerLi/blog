package com.baj.common.enums;

/**
 * Created by liqiang on 2017/6/19.
 */
public enum SessionState {


	enable(1, "有效"),
	unable(2, "无效");

	private Integer code;
	private String name;

	SessionState(Integer code, String name){
		this.code = code;
		this.name = name;
	}

	public boolean equals(Integer code){
		return code != null && this.code.equals(code);
	}

	public static SessionState getState(Integer code){
		for(SessionState stat : SessionState.values()){
			if(stat.equals(code)){
				return stat;
			}
		}
		return null;
	}

	public Integer getCode() {
		return code;
	}

	public String getName() {
		return name;
	}
}
