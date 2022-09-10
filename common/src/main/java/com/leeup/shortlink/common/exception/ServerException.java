package com.leeup.shortlink.common.exception;

import com.leeup.shortlink.common.exception.error.ServerError;
import lombok.Getter;
import lombok.Setter;

/**
 * 系统异常：500
 *
 * @author liu.yj
 * @since 2022/1/8 18:47
 */
@Getter
@Setter
public class ServerException extends BaseException {

    public ServerException(String code, String message, Object... args) {
        super(code, message, args);
    }

    public ServerException(ServerError error, Object... args) {
        super(error.getCode(), error.getMessage(), args);
    }
}
