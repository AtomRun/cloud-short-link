package com.leeup.shortlink.common.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * 参数校验信息
 *
 * @author liu.yj
 * @since 2022/1/9 18:00
 */
@Getter
@Setter
@AllArgsConstructor
public class ValidatedFieldError {

    private String field;
    private String message;
}
