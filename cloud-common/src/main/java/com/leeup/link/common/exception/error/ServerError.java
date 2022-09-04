package com.leeup.link.common.exception.error;

import com.leeup.link.common.exception.ServerException;
import lombok.Getter;

/**
 * 系统异常
 *
 * @author liu.yj
 * @since 2022/1/8 19:11
 */
@Getter
public enum ServerError implements BaseError {

    SYSTEM_ERROR("system_error", "系统异常：{0}"),
    RPC_ERROR("rpc_error", "第三方调用异常：{0}"),
    UNKNOWN_ERROR("unknown_error", "未知异常：{0}"),
    ;

    private final String code;
    private final String message;

    ServerError(String code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public ServerException args(Object... args) {
        return new ServerException(this, args);
    }
}
