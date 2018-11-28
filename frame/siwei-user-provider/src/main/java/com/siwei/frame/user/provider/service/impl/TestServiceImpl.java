package com.siwei.frame.user.provider.service.impl;

import com.siwei.frame.user.provider.entity.Test;
import com.siwei.frame.user.provider.service.TestService;
import com.siwei.frame.common.utils.helper.ResponseBody;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService {

	@Override
	public ResponseBody savetest(Test test) {
		
		return new ResponseBody();
	}

	@Override
	public void updatetest1(Test test) {
		
	}
}
