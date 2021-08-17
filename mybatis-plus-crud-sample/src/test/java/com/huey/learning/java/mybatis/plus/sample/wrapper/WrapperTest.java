package com.huey.learning.java.mybatis.plus.sample.wrapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.huey.learning.java.mybatis.plus.sample.entity.User;
import com.huey.learning.java.mybatis.plus.sample.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author huey
 */
@SpringBootTest
public class WrapperTest {

    @Autowired
    private UserService userService;

    @Test
    void testWrapper() {
        QueryWrapper<User> query = Wrappers.<User>query()
                .eq("name", "Huey")
                .gt("age", 24);
        userService.list(query).forEach(System.out::println);
    }

    @Test
    void testEq() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name", "Huey");
        System.out.println("queryWrapper.getTargetSql() = " + queryWrapper.getTargetSql());
    }

    @Test
    void testNe() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.ne("name", "Huey");
        System.out.println("queryWrapper.getTargetSql() = " + queryWrapper.getTargetSql());
    }

    @Test
    void testGt() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.gt("age", 20);
        System.out.println("queryWrapper.getTargetSql() = " + queryWrapper.getTargetSql());
    }

    @Test
    void testGe() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.ge("age", 20);
        System.out.println("queryWrapper.getTargetSql() = " + queryWrapper.getTargetSql());
    }

    @Test
    void testLt() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.lt("age", 24);
        System.out.println("queryWrapper.getTargetSql() = " + queryWrapper.getTargetSql());
    }

    @Test
    void testLe() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.le("age", 24);
        System.out.println("queryWrapper.getTargetSql() = " + queryWrapper.getTargetSql());
    }

    @Test
    void testBetween() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.between("age", 20, 24);
        System.out.println("queryWrapper.getTargetSql() = " + queryWrapper.getTargetSql());
    }

    @Test
    void testNotBetween() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.notBetween("age", 20, 24);
        System.out.println("queryWrapper.getTargetSql() = " + queryWrapper.getTargetSql());
    }

    @Test
    void testLike() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("name", "ue");
        System.out.println("queryWrapper.getTargetSql() = " + queryWrapper.getTargetSql());
        userService.list(queryWrapper).forEach(System.out::println);
    }

    @Test
    void testIn() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.in("name", "Huey", "Jack");
        System.out.println("queryWrapper.getTargetSql() = " + queryWrapper.getTargetSql());
        userService.list(queryWrapper).forEach(System.out::println);
    }

    @Test
    void testNotIn() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.notIn("name", "Huey", "Jack");
        System.out.println("queryWrapper.getTargetSql() = " + queryWrapper.getTargetSql());
        userService.list(queryWrapper).forEach(System.out::println);
    }

    @Test
    void testQueryWrapper() {
        QueryWrapper<User> queryWrapper = Wrappers.<User>query()
                .select("id", "name", "age")
                .eq("name", "Huey")
                .gt("age", 24);
        userService.list(queryWrapper).forEach(System.out::println);
    }

    @Test
    void testUpdateWrapper() {
        UpdateWrapper<User> updateWrapper = Wrappers.<User>update()
                .set("name", "huey")
                .set("age", 18)
                .eq("id", 0L);
        userService.update(updateWrapper);
    }

    @Test
    void testLambda() {
        Wrapper<User> queryWrapper = Wrappers.lambdaQuery(User.class)
                .select(User::getId, User::getName)
                .eq(User::getName, "Huey");
        userService.list(queryWrapper).forEach(System.out::println);
    }

}
