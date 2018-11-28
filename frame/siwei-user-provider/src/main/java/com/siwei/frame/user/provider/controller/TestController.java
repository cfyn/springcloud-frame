package com.siwei.frame.user.provider.controller;

import com.siwei.frame.user.provider.service.TestService;
import com.siwei.frame.user.provider.entity.Test;
import com.siwei.frame.common.utils.annotation.RequirePermission;
import com.siwei.frame.common.utils.annotation.RequireRole;
import com.siwei.frame.common.utils.enums.Logical;
import com.siwei.frame.common.utils.helper.ResponseBody;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "车辆管理")
public class TestController {
	
	@Autowired
	private TestService testService;

	@RequestMapping("/carManager")
	@RequirePermission(value = {"astack:car:manager", "test"}, logical = Logical.OR)
	@ApiOperation(value = "车辆管理", notes = "车辆管理")
	public ResponseBody carManager() {
		return new ResponseBody();
	}
	
	@RequestMapping("/403")
	public String unable() {
		return "未授权";
	}
	
	@RequestMapping("/test")
	@RequirePermission("astack:car:manager")
	@RequireRole(value = {"test"})
	public ResponseBody test(@RequestBody Test test) {
		testService.savetest(test);
		testService.updatetest1(test);
		return new ResponseBody();
	}
}
