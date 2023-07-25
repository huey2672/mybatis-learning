package com.huey.learning.java.mybatis.plus.pagination;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;

/**
 * @author huey
 */
@RestController
public class UserController {

    @Resource
    private UserService userService;

    @PostMapping("queryUsers")
    public Response<?> queryUsers(@RequestBody UserQueryRequest request) {
        long pageNum = request.getPageNum();
        long pageSize = request.getPageSize();
        long pageCount = request.getPageCount();
        IPage<User> page = userService.queryUsers(new HashMap<>(), pageNum, pageSize, pageCount);
        return Response.success(page);
    }

}
