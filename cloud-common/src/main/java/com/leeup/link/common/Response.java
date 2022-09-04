package com.leeup.link.common;

import com.leeup.link.common.constant.WordConstant;
import com.leeup.link.common.exception.BaseException;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author clee
 * @description 接口返回统一规范
 * @date 4/9/2022 下午3:27
 **/
@Data
@NoArgsConstructor
@SuppressWarnings("unused")
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Response<T> {

    private Integer code;

    private String message;

    private T result;

    private Long timestamp;

    public static <T> Response<T> ok() {
        return ok(null);
    }

    public static <T> Response<T> ok(T result) {
        return new Response<>(0, "请求成功", result, System.currentTimeMillis());
    }

    public static <T> Response<T> error(BaseException e) {
        return new Response<>(e.getCode(), e.getMessage(), null, System.currentTimeMillis());
    }

    public static <T> Response<T> error(Integer code, String message) {
        return new Response<>(code, message, null, System.currentTimeMillis());
    }

    public static <T> Response<T> error(BaseException e, T result) {
        return new Response<>(e.getCode(), e.getMessage(), result, System.currentTimeMillis());
    }
}
