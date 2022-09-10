package com.leeup.shortlink.common.exception.error;

import com.leeup.shortlink.common.exception.RequestException;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * 客户端错误
 *
 * @author liu.yj
 * @since 2022/1/8 19:11
 */
@Getter
@RequiredArgsConstructor
public enum RequestError implements BaseError {
    PARAMETER_ERROR("parameter_error", "参数错误：{0}"),
    REQUEST_LIMIT("request_limit", "请求太频繁，请稍后再试"),
    METHOD_NOT_ALLOWED("method_not_allowed", "不支持[{0}]请求方法：{1}"),
    ;

    private final String code;
    private final String message;

    @Override
    public RequestException args(Object... args) {
        return new RequestException(this.code, this.message, args);
    }
}
