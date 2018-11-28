package com.siwei.frame.common.utils.exception;

import com.siwei.frame.common.utils.enums.ExceptionResultEnum;

/**
 * 参数传递异常
 * @author linxiunan
 * @date 2018年7月25日
 */
public class ParamException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	
	private Integer state;
	
	public ParamException(Integer state, String message) {
		super(message);
		this.state = state;
	}
	
	public ParamException(ExceptionResultEnum exceptionResultEnum) {
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
