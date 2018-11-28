package com.siwei.frame.user.consumer.service;

import com.siwei.frame.common.utils.helper.ResponseBody;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient( name = "siwei-user-provider",fallback = UserFeignServiceFallBack.class)
public interface UserFeignService {
    @RequestMapping(value = "/test")
    ResponseBody test(@RequestBody Test test);


    @RequestMapping(value = "/findUsers", method = RequestMethod.POST)
    ResponseBody findUsers(@PathVariable("st")int pageNumber, @PathVariable("si")int pageSize);
}
