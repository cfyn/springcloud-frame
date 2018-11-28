package com.siwei.frame.user.consumer.service;

import com.siwei.frame.common.utils.enums.ExceptionResultEnum;
import com.siwei.frame.common.utils.helper.ResponseBody;
import org.springframework.stereotype.Component;

@Component
public class UserFeignServiceFallBack implements UserFeignService {
    @Override
    public ResponseBody test(Test test) {
        return new ResponseBody(ExceptionResultEnum.REQUEST_TIME_OUT);
    }

    @Override
    public ResponseBody findUsers(int pageNumber, int pageSize) {
        return new ResponseBody(ExceptionResultEnum.ACCOUNT_NOT_EXIST);
    }
}
