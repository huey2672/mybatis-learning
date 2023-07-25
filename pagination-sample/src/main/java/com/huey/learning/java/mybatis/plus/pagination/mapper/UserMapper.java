package com.huey.learning.java.mybatis.plus.pagination.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.huey.learning.java.mybatis.plus.pagination.User;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

public interface UserMapper extends BaseMapper<User> {

    IPage<User> queryUsers(IPage<User> page, @Param("params") Map<String, Object> params);

}