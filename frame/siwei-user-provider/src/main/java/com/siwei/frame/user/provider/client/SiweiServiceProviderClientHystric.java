package com.siwei.frame.user.provider.client;

import com.siwei.frame.common.utils.entity.BaseLog;
import com.siwei.frame.common.utils.enums.ExceptionResultEnum;
import com.siwei.frame.common.utils.exception.ServerException;
import com.siwei.frame.common.utils.helper.ResponseBody;
import org.springframework.stereotype.Component;

@Component
public class SiweiServiceProviderClientHystric implements SiweiServiceProviderClient {

	@Override
	public ResponseBody insertLog(BaseLog baseLog) {
		throw new ServerException(ExceptionResultEnum.SERVER_ERROR);
	}
}
