package com.siwei.frame.zuul.client;

import com.siwei.frame.common.utils.entity.BaseLog;
import com.siwei.frame.common.utils.entity.User;
import com.siwei.frame.common.utils.entity.UserLogin;
import com.siwei.frame.common.utils.helper.ResponseBody;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@FeignClient(value = "siwei-service-provider", fallback = SiweiServiceProviderClientHystric.class)
public interface SiweiServiceProviderClient {
	
	@RequestMapping(value = "/user/findRolesByUserId", method = RequestMethod.POST)
	List<String> findRolesByUserId(@RequestParam("userId") Integer userId, @RequestParam("systemCode") Integer systemCode);
	
	@RequestMapping(value = "/user/findPermissionsByUserId", method = RequestMethod.POST)
	List<String> findPermissionsByUserId(@RequestParam("userId") Integer userId, @RequestParam("systemCode") Integer systemCode);
	
	@RequestMapping(value = "/user/findMenuPermissionsByUserId", method = RequestMethod.POST)
	List<Map<String, Object>> findMenuPermissionsByUserId(@RequestParam("userId") Integer userId, @RequestParam("systemCode") Integer systemCode);
	
	@RequestMapping(value = "/log/insert", method = RequestMethod.POST)
    ResponseBody insertLog(@RequestBody BaseLog baseLog);
	
	@RequestMapping(value = "/userLogin/findByIdentifierAndIdentityType", method = RequestMethod.POST)
    UserLogin findByIdentifierAndIdentityType(@RequestParam("identifier") String identifier, @RequestParam("identityType") Integer identityType);
	
	@RequestMapping(value = "/user/findById", method = RequestMethod.POST)
    User findUserById(@RequestParam("id") Integer id);
}
