package com.siwei.frame.user.provider.service.impl;

import com.github.pagehelper.PageHelper;
import com.siwei.frame.common.utils.entity.User;
import com.siwei.frame.user.provider.dao.UserMapper;
import com.siwei.frame.user.provider.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper mapper;
    @Override
    public void updateById(User user) {
        mapper.updateById(user);
    }

    @Override
    public void insert(User user) {
        mapper.insert(user);
    }

    @Override
    public User findByMobile(String mobile) {
        return mapper.findByMobile(mobile);
    }

    @Override
    public User findById(Integer id) {
        return mapper.findById(id);
    }

    @Override
    public List<User> findUsers(User user) {
        return mapper.findUsers(user);
    }
}
