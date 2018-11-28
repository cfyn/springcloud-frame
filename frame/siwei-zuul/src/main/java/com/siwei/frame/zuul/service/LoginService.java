package com.siwei.frame.zuul.service;

import com.siwei.frame.common.utils.entity.UserLogin;
import com.siwei.frame.common.utils.helper.ResponseBody;

public interface LoginService {

	ResponseBody baseLogin(UserLogin userLogin, Integer systemCode);
	
	ResponseBody logout(Integer id);
	
}
