package com.siwei.frame.user.consumer.controller;

import com.siwei.frame.common.utils.helper.ResponseBody;
import com.siwei.frame.user.consumer.service.UserFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class UserConsumerController {
    @Autowired
    RestTemplate restTemplate;
    @Autowired
    UserFeignService feignService;
    @RequestMapping("/hi")
    public String hi(String id){
        return restTemplate.getForObject("http://SIWEI-USER-PROVIDER/test",String.class);
    }
    @RequestMapping("/findUsers")
    public ResponseBody findUsers(String b){
        return feignService.findUsers(1,2);
    }
}
