package com.huey.learning.java.mybatis.plus.sample.pagination;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.huey.learning.java.mybatis.plus.sample.entity.User;
import com.huey.learning.java.mybatis.plus.sample.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

/**
 * @author huey
 */
@SpringBootTest
public class PaginationTest {

    @Autowired
    private UserService userService;

    @Test
    public void testPagination() {

        Map<String, Object> params = new HashMap<>();
        long pageNum = 0L;
        long pageSize = 2L;

        IPage<User> page = userService.queryUsers(params, pageNum, pageSize);
        page.getRecords().forEach(System.out::println);

    }

}
