package com.huey.learning.java.mybatis.plus.sample.crud.service;

import com.huey.learning.java.mybatis.plus.sample.entity.User;
import com.huey.learning.java.mybatis.plus.sample.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author huey
 */
@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    void testSave() {
        User user = new User();
        user.setId(1002L);
        user.setName("Yuan");
        user.setAge(18);
        user.setEmail("yuan@example.com");
        userService.save(user);
    }

}
