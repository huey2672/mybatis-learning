package com.huey.learning.java.mybatis.plus.pagination;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class PaginationSampleApplicationTests {

    @Resource
    private UserService userService;

    @Test
    public void testPagination() {

        Map<String, Object> params = new HashMap<>();
        long pageNum = 1L;
        long pageSize = 5L;

        IPage<User> page = userService.queryUsers(params, pageNum, pageSize, 2);
        page.getRecords().forEach(System.out::println);

    }

}
