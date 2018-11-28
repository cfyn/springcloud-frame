package com.siwei.frame.user.provider.client;

import com.siwei.frame.common.utils.entity.BaseLog;
import com.siwei.frame.common.utils.helper.ResponseBody;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "siwei-service-provider", fallback = SiweiServiceProviderClientHystric.class)
public interface SiweiServiceProviderClient {

	@RequestMapping(value = "/log/insert", method = RequestMethod.POST)
    ResponseBody insertLog(@RequestBody BaseLog baseLog);
}
