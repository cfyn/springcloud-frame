package com.siwei.frame.common.utils.exception;

import com.siwei.frame.common.utils.enums.ExceptionResultEnum;

/**
 * 文件转换异常
 * @author linxiunan
 * @date 2018年7月25日
 */
public class FileResolverException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	
	private Integer state;
	
	public FileResolverException(Integer state, String message) {
		super(message);
		this.state = state;
	}
	
	public FileResolverException(ExceptionResultEnum exceptionResultEnum) {
		super(exceptionResultEnum.getMessage());
		this.state = exceptionResultEnum.getCode();
	}

	public Integer getCode() {
		return state;
	}

	public void setstate(Integer state) {
		this.state = state;
	}
}
