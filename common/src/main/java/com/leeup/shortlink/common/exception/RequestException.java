package com.leeup.shortlink.common.exception;

import lombok.Getter;
import lombok.Setter;

/**
 * 客户端错误：400
 *
 * @author liu.yj
 * @see BaseException
 * @since 2022/1/8 18:47
 */
@Getter
@Setter
public class RequestException extends BaseException {

    public RequestException(String code, String message, Object... args) {
        super(code, message, args);
    }
}
