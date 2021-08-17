package com.huey.learning.java.mybatis.plus.sample.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.huey.learning.java.mybatis.plus.sample.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserMapper extends BaseMapper<User> {

    IPage<User> queryUsers(Page<User> page, @Param("params") Map<String, Object> params);

}