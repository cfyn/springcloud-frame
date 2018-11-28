package com.siwei.frame.user.provider.handle;

import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSSException;
import com.netflix.hystrix.exception.HystrixRuntimeException;
import com.siwei.frame.common.utils.enums.ExceptionResultEnum;
import com.siwei.frame.common.utils.exception.CommonException;
import com.siwei.frame.common.utils.exception.DatabaseException;
import com.siwei.frame.common.utils.exception.ParamException;
import com.siwei.frame.common.utils.exception.ServerException;
import com.siwei.frame.common.utils.helper.GlobalConstant;
import io.jsonwebtoken.SignatureException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.FileNotFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	@ExceptionHandler(Exception.class)
	@ResponseBody
	public Object defultExcepitonHandler(HttpServletRequest request,Exception e) {
		e.printStackTrace();
		if (e instanceof DatabaseException) {
			log.error("业务异常：" + e.getMessage());
			DatabaseException exception = (DatabaseException) e;
			return new com.siwei.frame.common.utils.helper.ResponseBody(exception.getCode(), exception.getMessage());
		} else if (e instanceof MissingServletRequestParameterException) {
			log.error("业务异常：" + e.getMessage());
			return new com.siwei.frame.common.utils.helper.ResponseBody(GlobalConstant.GENERAL_ERROR, "所需参数未传入");
		} else if (e instanceof HttpMessageNotReadableException) {
			log.error("业务异常：" + e.getMessage());
			return new com.siwei.frame.common.utils.helper.ResponseBody(GlobalConstant.GENERAL_ERROR, "所需参数未传入");
		} else if (e instanceof OSSException) {
			log.error("业务异常：" + e.getMessage());
			return new com.siwei.frame.common.utils.helper.ResponseBody(GlobalConstant.GENERAL_ERROR, "OSS异常");
		} else if (e instanceof ClientException) {
			log.error("业务异常：" + e.getMessage());
			return new com.siwei.frame.common.utils.helper.ResponseBody(GlobalConstant.GENERAL_ERROR, "OSS客户端异常");
		} else if (e instanceof FileNotFoundException) {
			log.error("业务异常：" + e.getMessage());
			return new com.siwei.frame.common.utils.helper.ResponseBody(GlobalConstant.GENERAL_ERROR, "文件找不到");
		} else if (e instanceof ParamException) {
			log.error("业务异常：" + e.getMessage());
			return new com.siwei.frame.common.utils.helper.ResponseBody(GlobalConstant.GENERAL_ERROR, "参数传递错误");
		} else if (e instanceof CommonException) {
			log.error("业务异常：" + e.getMessage());
			CommonException exception = (CommonException) e;
			return new com.siwei.frame.common.utils.helper.ResponseBody(exception.getCode(), exception.getMessage());
		} else if (e instanceof ServerException) {
			log.error("业务异常：" + e.getMessage());
			ServerException exception = (ServerException) e;
			return new com.siwei.frame.common.utils.helper.ResponseBody(exception.getCode(), exception.getMessage());
		} else if (e instanceof HystrixRuntimeException) {
			log.error("业务异常：" + e.getMessage());
			return new com.siwei.frame.common.utils.helper.ResponseBody(ExceptionResultEnum.SERVER_ERROR);
		} else if (e instanceof SignatureException) {
			log.error("业务异常：" + e.getMessage());
			return new com.siwei.frame.common.utils.helper.ResponseBody(ExceptionResultEnum.TOKEN_ANALYSIS_ERROR);
		}
		return new com.siwei.frame.common.utils.helper.ResponseBody(GlobalConstant.SYSTEM_ERROR, "系统异常,请稍后重试");
	}
	
}
