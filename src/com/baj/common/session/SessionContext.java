package com.baj.common.session;

import com.baj.entity.dto.SessionDTO;
import org.springframework.core.NamedThreadLocal;

/**
 * Created by liqiang on 2017/6/19.
 */
public class SessionContext {

	private static final ThreadLocal<SessionDTO> currentSession = new NamedThreadLocal<>("sessionDTO");

	public static SessionDTO getSession() {
		SessionDTO sessionDTO = currentSession.get();
		if(null == sessionDTO){
			throw new RuntimeException("session is null, need to add @SessionAuth to action's method.");
		}
		return sessionDTO;
	}

	public static void setCurrentSession(SessionDTO session){
		currentSession.set(session);
	}

	public static String getSessionId(){
		SessionDTO sessionDTO = getSession();
		return null != sessionDTO ? sessionDTO.getSessionId() : "";
	}
	public static Long getPid(){
		SessionDTO session = getSession();
		return  null != session ? session.getPid() : null;
	}
	public static Integer getRole(){
		SessionDTO session = getSession();
		return  null != session ? session.getRole() : null;
	}
	public static Integer getLoginType(){
		SessionDTO session = getSession();
		return  null != session ? session.getLoginType() : null;
	}
}
