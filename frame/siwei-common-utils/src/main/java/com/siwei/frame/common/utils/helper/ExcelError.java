package com.siwei.frame.common.utils.helper;

/**
 * @Description Excel读取错误实体类 
 * @author siwei
 * @date 2018年9月25日
 */
public class ExcelError {
	
	private String errorPlace;
	
	private String errorInfo;
	
	public ExcelError() {};
	
	public ExcelError(String errorPlace, String errorInfo) {
		this.errorPlace = errorPlace;
		this.errorInfo = errorInfo;
	}

	public String getErrorPlace() {
		return errorPlace;
	}

	public void setErrorPlace(String errorPlace) {
		this.errorPlace = errorPlace;
	}

	public String getErrorInfo() {
		return errorInfo;
	}

	public void setErrorInfo(String errorInfo) {
		this.errorInfo = errorInfo;
	}
}
