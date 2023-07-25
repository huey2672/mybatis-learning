package com.huey.learning.java.mybatis.plus.pagination;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * @author huey
 */
@NoArgsConstructor
@AllArgsConstructor
public class Response<T> {

    private boolean success;
    private T data;

    public static <T> Response<T> success(T data) {
        return new Response<>(true, data);
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
