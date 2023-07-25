package com.huey.learning.java.mybatis.plus.pagination;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.huey.learning.java.mybatis.plus.pagination.mapper.UserMapper;
import com.huey.learning.java.mybatis.plus.pagination.metadata.FastPage;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

@Service
public class UserService extends ServiceImpl<UserMapper, User> {

    @Resource
    private UserMapper userMapper;

    public IPage<User> queryUsers(Map<String, Object> params, long pageNum, long pageSize, long pageCount) {
        IPage<User> page = new FastPage<>(pageNum, pageSize, pageCount);
        return userMapper.queryUsers(page, params);
    }

}