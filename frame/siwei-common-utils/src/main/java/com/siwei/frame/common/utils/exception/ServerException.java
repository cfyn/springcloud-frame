package com.siwei.frame.common.utils.exception;

import com.netflix.hystrix.exception.HystrixBadRequestException;
import com.siwei.frame.common.utils.enums.ExceptionResultEnum;

/**
 * 服务器异常类
 * @author linxiunan
 * @date 2018年7月25日
 */
public class ServerException extends HystrixBadRequestException {
	
	private static final long serialVersionUID = 1L;
	
	private Integer state;
	
	public ServerException(Integer state, String message) {
		super(message);
		this.state = state;
	}
	
	public ServerException(ExceptionResultEnum exceptionResultEnum) {
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
