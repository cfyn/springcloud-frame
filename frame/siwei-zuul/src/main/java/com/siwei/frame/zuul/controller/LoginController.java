package com.siwei.frame.zuul.controller;

import com.siwei.frame.common.utils.entity.UserLogin;
import com.siwei.frame.common.utils.helper.GlobalConstant;
import com.siwei.frame.common.utils.helper.ResponseBody;
import com.siwei.frame.common.utils.util.BindingResultUtil;
import com.siwei.frame.zuul.service.LoginService;
import com.siwei.frame.zuul.vo.UserLoginVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@Api(tags = "登录退出")
public class LoginController {
	
	@Autowired
	private LoginService loginService;

	@PostMapping("/base/login")
	@ApiOperation(value = "非第三方登录", notes = "非第三方登录接口")
	public ResponseBody baseLogin(@Valid @RequestBody UserLoginVO userLoginVO, BindingResult bindingResult) throws Exception {
		if (bindingResult.hasErrors()) {
			return new ResponseBody(GlobalConstant.GENERAL_ERROR, BindingResultUtil.getBindingResultErrMsg(bindingResult));
		}
		UserLogin userLogin = new UserLogin();
		BeanUtils.copyProperties(userLoginVO, userLogin);
		return loginService.baseLogin(userLogin, userLoginVO.getSystemCode());
	}

	@PostMapping("/logout/{userId}")
	@ApiOperation(value = "退出", notes = "用户退出接口")
	@ApiImplicitParam(name = "userId", value = "用户id", required = true, dataType = "Long", paramType = "path")
	public ResponseBody logout(@PathVariable Integer userId) {
		return loginService.logout(userId);
	}
}
