package com.baj.common.exception;

/**
 * Created by liqiang on 2017/6/20.
 */
public class BlogRuntimeException extends RuntimeException {

	public BlogRuntimeException() {
		super();
	}

	public BlogRuntimeException(String message) {
		super(message);
	}

	public BlogRuntimeException(String message, Throwable cause) {
		super(message, cause);
	}

	public BlogRuntimeException(Throwable cause) {
		super(cause);
	}

	protected BlogRuntimeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
