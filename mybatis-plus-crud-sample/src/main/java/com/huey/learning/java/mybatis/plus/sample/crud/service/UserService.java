package com.huey.learning.java.mybatis.plus.sample.crud.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.huey.learning.java.mybatis.plus.sample.crud.entity.User;
import com.huey.learning.java.mybatis.plus.sample.crud.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
 * @author huey
 */
@Service
public class UserService extends ServiceImpl<UserMapper, User> {
}
