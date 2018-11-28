package com.siwei.frame.zuul.client;

import com.siwei.frame.common.utils.entity.BaseLog;
import com.siwei.frame.common.utils.entity.User;
import com.siwei.frame.common.utils.entity.UserLogin;
import com.siwei.frame.common.utils.enums.ExceptionResultEnum;
import com.siwei.frame.common.utils.exception.ServerException;
import com.siwei.frame.common.utils.helper.ResponseBody;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class SiweiServiceProviderClientHystric implements SiweiServiceProviderClient {

	@Override
	public List<String> findRolesByUserId(Integer userId, Integer systemCode) {
		throw new ServerException(ExceptionResultEnum.SERVER_ERROR);
	}

	@Override
	public List<String> findPermissionsByUserId(Integer userId, Integer systemCode) {
		throw new ServerException(ExceptionResultEnum.SERVER_ERROR);
	}

	@Override
	public List<Map<String, Object>> findMenuPermissionsByUserId(Integer userId, Integer systemCode) {
		throw new ServerException(ExceptionResultEnum.SERVER_ERROR);
	}

	@Override
	public ResponseBody insertLog(BaseLog baseLog) {
		throw new ServerException(ExceptionResultEnum.SERVER_ERROR);
	}

	@Override
	public UserLogin findByIdentifierAndIdentityType(String identifier, Integer identityType) {
		throw new ServerException(ExceptionResultEnum.SERVER_ERROR);
	}

	@Override
	public User findUserById(Integer id) {
		throw new ServerException(ExceptionResultEnum.SERVER_ERROR);
	}

}
