package com.huey.learning.java.mybatis.plus.sample.crud.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.huey.learning.java.mybatis.plus.sample.entity.User;
import com.huey.learning.java.mybatis.plus.sample.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    void testInsert() {
        User user = new User();
        user.setId(0L);
        user.setName("Huey");
        user.setAge(24);
        user.setEmail("huey@example.com");
        userMapper.insert(user);
    }

    @Test
    void testUpdateById() {
        User user = new User();
        user.setId(0L);
        user.setAge(25);
        userMapper.updateById(user);
    }

    @Test
    void testUpdate() {
        User user = new User();
        user.setAge(26);
        UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("name", "Huey");
        userMapper.update(user, updateWrapper);
    }

    @Test
    void testSelectById() {
        User user = userMapper.selectById(0L);
        System.out.println("user = " + user);
    }

    @Test
    void testSelectOne() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name", "Huey");
        User user = userMapper.selectOne(queryWrapper);
        System.out.println("user = " + user);
    }

    @Test
    void testSelectBatchIds() {
        List<User> userList = userMapper.selectBatchIds(Arrays.asList(0L, 1L));
        userList.forEach(System.out::println);
    }

    @Test
    void testSelectList() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.ge("age", 24);
        List<User> userList = userMapper.selectList(queryWrapper);
        userList.forEach(System.out::println);
    }

    @Test
    void testSelectPage() {
        Page<User> userPage = new Page<>(2L, 2L);
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.ge("age", 0);
        userMapper.selectPage(userPage, queryWrapper);
        userPage.getRecords().forEach(System.out::println);
    }

    @Test
    void testSelectCount() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.ge("age", 24);
        int count = userMapper.selectCount(queryWrapper);
        System.out.println("count = " + count);
    }

}
