package com.baj.entity.dto;

/**
 * Created by liqiang on 2017/6/19.
 */
public class SessionDTO {

	private String sessionId;

	private Long pid;

	private Integer role;

	private String roleSign;

	private Integer clientType;

	private Integer loginType;

	/**
	 * session状态,默认有效
	 */
	private Integer sessionState;

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public Long getPid() {
		return pid;
	}

	public void setPid(Long pid) {
		this.pid = pid;
	}

	public Integer getRole() {
		return role;
	}

	public void setRole(Integer role) {
		this.role = role;
	}

	public String getRoleSign() {
		return roleSign;
	}

	public void setRoleSign(String roleSign) {
		this.roleSign = roleSign;
	}

	public Integer getClientType() {
		return clientType;
	}

	public void setClientType(Integer clientType) {
		this.clientType = clientType;
	}

	public Integer getLoginType() {
		return loginType;
	}

	public void setLoginType(Integer loginType) {
		this.loginType = loginType;
	}

	public Integer getSessionState() {
		return sessionState;
	}

	public void setSessionState(Integer sessionState) {
		this.sessionState = sessionState;
	}
}
