package com.siwei.frame.common.utils.exception;

import com.siwei.frame.common.utils.enums.ExceptionResultEnum;

/**
 * excel表格处理异常类
 * @author linxiunan
 * @date 2018年7月25日
 */
public class ExcelException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	
	private Integer code;
	
	private Object excelErrors;
	
	public ExcelException(Integer state, String message) {
		super(message);
		this.code = state;
	}
	
	public ExcelException(Integer state, String message, Object excelErrors) {
		super(message);
		this.code = state;
		this.excelErrors = excelErrors;
	}
	
	public ExcelException(ExceptionResultEnum exceptionResultEnum) {
		super(exceptionResultEnum.getMessage());
		this.code = exceptionResultEnum.getCode();
	}
	
	public ExcelException(ExceptionResultEnum exceptionResultEnum, Object excelErrors) {
		super(exceptionResultEnum.getMessage());
		this.code = exceptionResultEnum.getCode();
		this.excelErrors = excelErrors;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public Object getExcelErrors() {
		return excelErrors;
	}

	public void setExcelErrors(Object excelErrors) {
		this.excelErrors = excelErrors;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
