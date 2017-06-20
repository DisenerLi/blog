package com.baj.common.spring;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.StringWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by liqiang on 2017/6/19.
 */
public class WebExceptionHandler implements HandlerExceptionResolver {

	private Logger logger = LoggerFactory.getLogger(WebExceptionHandler.class);


	@Override
	public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
		ExceptionResult result = new ExceptionResult();
		result.setCode(90);
		result.setMessage("Web unhandled exception");
		logger.error("Web unhandled exception:" + httpServletRequest.getPathInfo(), e);
		StringWriter writer = new StringWriter();
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			objectMapper.writeValue(writer,result);
			httpServletResponse.getWriter().write(writer.getBuffer().toString());
			httpServletResponse.getWriter().flush();
		}catch (IOException e1){
			logger.error("Web unhandled exception:",e1);
		}
		return null;
	}

	public static class ExceptionResult {
		private int code;
		private String message;

		public int getCode() {
			return code;
		}

		public void setCode(int code) {
			this.code = code;
		}

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}
	}
}
