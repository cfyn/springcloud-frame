package com.siwei.frame.common.utils.util;

import org.springframework.validation.BindingResult;

/**
 * @Description 获取验证消息工具类
 * @author siwei
 * @date 2018年8月24日
 */
public class BindingResultUtil {

	public static String getBindingResultErrMsg(BindingResult bindingResult) {
		StringBuffer errorMsg = new StringBuffer("");
		bindingResult.getAllErrors().forEach(e -> errorMsg.append(e.getDefaultMessage()).append(";"));
		return errorMsg.toString();
	}
}
