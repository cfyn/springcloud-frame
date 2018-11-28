package com.siwei.frame.common.utils.helper;

import com.siwei.frame.common.utils.enums.ExceptionResultEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 返回对象封装类
 * @author siwei
 * @date 2018年7月26日
 */
@ApiModel
public class ResponseBody {
	
	@ApiModelProperty(value = "状态码")
	private Integer code;
	
	@ApiModelProperty(value = "提示信息")
	private String message;

	@ApiModelProperty(value = "返回数据")
	private Object data;

	public ResponseBody(Integer code, String message) {
		this.code = code;
		this.message = message;
	}

	public ResponseBody() {
		this.code = ExceptionResultEnum.SUCCESS.getCode();
		this.message = ExceptionResultEnum.SUCCESS.getMessage();
	}

	public ResponseBody(Object data) {
		this.code = ExceptionResultEnum.SUCCESS.getCode();
		this.message = ExceptionResultEnum.SUCCESS.getMessage();
		this.data = data;
	}

	public ResponseBody(ExceptionResultEnum exResEnum) {
		this.message = exResEnum.getMessage();
		this.code = exResEnum.getCode();
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

}
