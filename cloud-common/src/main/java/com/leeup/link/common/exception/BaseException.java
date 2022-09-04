package com.leeup.link.common.exception;

import com.leeup.link.common.exception.error.DefaultErrorFormat;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author clee
 * @description 基础异常定义，可以通过枚举继承该类+ResponseCode的方式配合统一响应使用
 * @date 4/9/2022 下午3:24
 **/
@Getter
@Setter(AccessLevel.PROTECTED)
@SuppressWarnings("unused")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class BaseException extends RuntimeException {
    private Integer code;

    public BaseException(Integer code, String message, Object... args) {
        super(args.length > 0 ? DefaultErrorFormat.format(message, args) : message);
        this.code = code;
    }
}