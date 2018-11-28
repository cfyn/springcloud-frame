package com.siwei.frame.user.provider.exception;

import com.siwei.frame.common.utils.enums.ExceptionResultEnum;

/**
 * 登录异常
 * @author linxiunan
 * @date 2018年7月25日
 */
public class LoginException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	
	private Integer state;
	
	public LoginException(Integer state, String message) {
		super(message);
		this.state = state;
	}
	
	public LoginException(ExceptionResultEnum exceptionResultEnum) {
		super(exceptionResultEnum.getMessage());
		this.state = exceptionResultEnum.getCode();
	}

	public Integer getCode() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}
}
