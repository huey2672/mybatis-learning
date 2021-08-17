package com.huey.learning.java.mybatis.plus.sample.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.huey.learning.java.mybatis.plus.sample.entity.User;
import com.huey.learning.java.mybatis.plus.sample.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author huey
 */
@Service
public class UserService extends ServiceImpl<UserMapper, User> {

    @Autowired
    private UserMapper userMapper;

    public IPage<User> queryUsers(Map<String, Object> params, long pageNum, long pageSize) {
        Page<User> page = new Page<>(pageNum, pageSize);
        return userMapper.queryUsers(page, params);
    }

}
