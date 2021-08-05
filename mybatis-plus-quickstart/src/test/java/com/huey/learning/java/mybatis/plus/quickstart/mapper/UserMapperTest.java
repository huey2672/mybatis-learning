package com.huey.learning.java.mybatis.plus.quickstart.mapper;

import com.huey.learning.java.mybatis.plus.quickstart.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

@SpringBootTest
class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    void testSelect() {
        List<User> userList = userMapper.selectList(null);
        userList.forEach(System.out::println);
        assertThat(5, equalTo(userList.size()));
    }

}
