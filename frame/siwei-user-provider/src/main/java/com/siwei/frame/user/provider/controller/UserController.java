package com.siwei.frame.user.provider.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.siwei.frame.common.utils.entity.User;
import com.siwei.frame.common.utils.helper.GlobalConstant;
import com.siwei.frame.common.utils.helper.PageResponseBody;
import com.siwei.frame.common.utils.helper.ResponseBody;
import com.siwei.frame.common.utils.vo.UserVO;
import com.siwei.frame.user.provider.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(tags = "系统用户管理")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/findUsers")
    @ApiOperation(value = "查询用户基本信息", notes = "查询用户基本信息")
    public ResponseBody findUsers( @RequestParam(defaultValue = GlobalConstant.PAGE_NUMBER)int pageNumber,
    @RequestParam(defaultValue = GlobalConstant.PAGE_SIZE)int pageSize) {
        User user = new User();
        PageHelper.startPage(2,2);
        List<User> userList =  userService.findUsers(user);
        PageInfo<User> pageInfo = new PageInfo<>(userList);
        PageResponseBody pageResponseBody = new PageResponseBody(pageInfo.getTotal(),pageSize,userList);
        return new ResponseBody(pageResponseBody);
    }
}
