package com.siwei.frame.user.provider.service;

import com.siwei.frame.user.provider.entity.Test;
import com.siwei.frame.common.utils.helper.ResponseBody;

public interface TestService {

	ResponseBody savetest(Test test);
	
	void updatetest1(Test test);
}
