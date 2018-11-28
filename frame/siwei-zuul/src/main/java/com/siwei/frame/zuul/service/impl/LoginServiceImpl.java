package com.siwei.frame.zuul.service.impl;

import com.siwei.frame.common.utils.entity.User;
import com.siwei.frame.common.utils.entity.UserLogin;
import com.siwei.frame.common.utils.enums.ExceptionResultEnum;
import com.siwei.frame.common.utils.enums.LoginTypeEnum;
import com.siwei.frame.common.utils.enums.SystemCodeEnum;
import com.siwei.frame.common.utils.helper.GlobalConstant;
import com.siwei.frame.common.utils.helper.ResponseBody;
import com.siwei.frame.common.utils.util.JWTUtil;
import com.siwei.frame.common.utils.util.MD5Util;
import com.siwei.frame.common.utils.util.StringUtil;
import com.siwei.frame.zuul.client.SiweiServiceProviderClient;
import com.siwei.frame.zuul.util.RedisOperator;
import com.siwei.frame.zuul.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	SiweiServiceProviderClient siweiServiceProviderClient;
	
	@Autowired
	private RedisOperator redisOperator;

	@Override
	public synchronized ResponseBody baseLogin(UserLogin userLogin, Integer systemCode) {
		UserLogin findUserLogin = null;
		Map<String, Object> returnMap = new HashMap<String, Object>();
		if (StringUtil.isMobile(userLogin.getIdentifier())) {
			userLogin.setIdentityType(LoginTypeEnum.MOBILE_PASSWORD_TYPE.getCode());
			findUserLogin = siweiServiceProviderClient.findByIdentifierAndIdentityType(userLogin.getIdentifier(), LoginTypeEnum.MOBILE_PASSWORD_TYPE.getCode());
		} else if (StringUtil.isValidEmail(userLogin.getIdentifier())) {
			userLogin.setIdentityType(LoginTypeEnum.EMAIL_PASSWORD_TYPE.getCode());
			findUserLogin = siweiServiceProviderClient.findByIdentifierAndIdentityType(userLogin.getIdentifier(), LoginTypeEnum.EMAIL_PASSWORD_TYPE.getCode());
		} else {
			userLogin.setIdentityType(LoginTypeEnum.USERNAME_PASSWORD_TYPE.getCode());
			findUserLogin = siweiServiceProviderClient.findByIdentifierAndIdentityType(userLogin.getIdentifier(), LoginTypeEnum.USERNAME_PASSWORD_TYPE.getCode());
		}
		
		if (findUserLogin != null && findUserLogin.getUserId() != null && findUserLogin.getUserId() > 0 && findUserLogin.getCredential().equals(MD5Util.encode(userLogin.getCredential(), GlobalConstant.MD5_SALT))) {
			User user = siweiServiceProviderClient.findUserById(findUserLogin.getUserId());
			if (!user.getEnabled()) {
				return new ResponseBody(ExceptionResultEnum.USER_UNENABLED);
			}
			
			SystemCodeEnum systemCodeEnum = SystemCodeEnum.getSystemCodeEnum(systemCode);
			if (systemCodeEnum == null) {
				userLogin.setCredential(null);
				return new ResponseBody(ExceptionResultEnum.UNKNOW_SYSTEM_CODE);
			} else {
				switch (systemCodeEnum) {
				case ASTACK_ADMIN_SYSTEM:
					if (user.getAstackAdminSystem() == null || !user.getAstackAdminSystem()) {
						userLogin.setCredential(null);
						return new ResponseBody(ExceptionResultEnum.NO_PERMISSION_ON_THIS_SYSTEM);
					}
					break;
				case ASTACK_AGENT_SYSTEM:
					if (user.getAstackAgentSystem() == null || !user.getAstackAgentSystem()) {
						userLogin.setCredential(null);
						return new ResponseBody(ExceptionResultEnum.NO_PERMISSION_ON_THIS_SYSTEM);
					}
					break;
				case ASTACK_WEBAPP_SYSTEM:
					if (user.getAstackWebappSystem() == null || !user.getAstackWebappSystem()) {
						userLogin.setCredential(null);
						return new ResponseBody(ExceptionResultEnum.NO_PERMISSION_ON_THIS_SYSTEM);
					}
					break;
				case ASTACK_STATISTICAL_SYSTEM:
					if (user.getAstackStatisticalSystem() == null || !user.getAstackStatisticalSystem()) {
						userLogin.setCredential(null);
						return new ResponseBody(ExceptionResultEnum.NO_PERMISSION_ON_THIS_SYSTEM);
					}
					break;
				case LIFE_INSURANCE_SYSTEM:
					if (user.getLifeInsuranceSystem() == null || !user.getLifeInsuranceSystem()) {
						userLogin.setCredential(null);
						return new ResponseBody(ExceptionResultEnum.NO_PERMISSION_ON_THIS_SYSTEM);
					}
					break;
				case DAFENG_STATISTICAL_SYSTEM:
					if (user.getDafengStatisticalSystem() == null || !user.getDafengStatisticalSystem()) {
						userLogin.setCredential(null);
						return new ResponseBody(ExceptionResultEnum.NO_PERMISSION_ON_THIS_SYSTEM);
					}
					break;
				case ASTACK_AGENT_SMALL_PROGRAM_SYSTEM:
					if (user.getAstackAgentSmallProgramSystem() == null || !user.getAstackAgentSmallProgramSystem()) {
						userLogin.setCredential(null);
						return new ResponseBody(ExceptionResultEnum.NO_PERMISSION_ON_THIS_SYSTEM);
					}
					break;
				case ASTACK_TOC_SMALL_PROGRAM_SYSTEM:
					if (user.getAstackTocSmallProgramSystem() == null || !user.getAstackTocSmallProgramSystem()) {
						userLogin.setCredential(null);
						return new ResponseBody(ExceptionResultEnum.NO_PERMISSION_ON_THIS_SYSTEM);
					}
					break;
				default:
					userLogin.setCredential(null);
					return new ResponseBody(ExceptionResultEnum.UNKNOW_SYSTEM_CODE);
				}
			}
			
			Set<String> rolesSet = new HashSet<>(siweiServiceProviderClient.findRolesByUserId(user.getId(), systemCode));
			Set<String> permissionsSet = new HashSet<>(siweiServiceProviderClient.findPermissionsByUserId(user.getId(), systemCode));
			List<Map<String, Object>> menuPermissions = siweiServiceProviderClient.findMenuPermissionsByUserId(user.getId(), systemCode);
			
			String tokenKey = GlobalConstant.TOKEN_PREFIX + user.getId().toString() + "token";
			String tokenValue = JWTUtil.generateJwt(user, rolesSet, permissionsSet);
			
			redisOperator.set(tokenKey, tokenValue, GlobalConstant.TOKEN_EXPIRE_SECOND * 60);
			returnMap.put("userLogin", findUserLogin);
			returnMap.put("user", user);
			returnMap.put("token", tokenValue);
			returnMap.put("menuPermissions", menuPermissions);
		} else if (findUserLogin != null && !findUserLogin.getCredential().equals(MD5Util.encode(userLogin.getCredential(), GlobalConstant.MD5_SALT))) {
			userLogin.setCredential(null);
			return new ResponseBody(ExceptionResultEnum.USERNAME_PASSWORT_ERROR);
		} else {
			// 第三方登录时使用以下判断
//			if (findUserLogin == null) {
//				userLogin.setUserId(0);
//				findUserLogin = siweiServiceProviderClient.insertUserLogin(userLogin);
//			}
			if (findUserLogin == null) {
				userLogin.setCredential(null);
				return new ResponseBody(ExceptionResultEnum.ACCOUNT_NOT_EXIST);
			}
			returnMap.put("userLogin", findUserLogin);
			returnMap.put("user", null);
			returnMap.put("token", null);
			returnMap.put("menuPermissions", null);
		}
		return new ResponseBody(returnMap);
	}
	
	@Override
	public ResponseBody logout(Integer id) {
		redisOperator.del(GlobalConstant.TOKEN_PREFIX + id.toString() + "token");
		return new ResponseBody();
	}

}
