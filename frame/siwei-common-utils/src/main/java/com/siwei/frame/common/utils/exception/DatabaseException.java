package com.siwei.frame.common.utils.exception;

import com.siwei.frame.common.utils.enums.ExceptionResultEnum;

/**
 * 数据库异常类
 * @author linxiunan
 * @date 2018年7月25日
 */
public class DatabaseException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	
	private Integer state;
	
	public DatabaseException(Integer state, String message) {
		super(message);
		this.state = state;
	}
	
	public DatabaseException(ExceptionResultEnum exceptionResultEnum) {
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
