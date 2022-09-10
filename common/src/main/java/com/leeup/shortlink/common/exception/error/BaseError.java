package com.leeup.shortlink.common.exception.error;

import com.leeup.shortlink.common.exception.BaseException;

/**
 * @author clee
 * @description
 * @date 4/9/2022 下午3:26
 **/
@SuppressWarnings("unused")
public interface BaseError {

    String getCode();

    String getMessage();

    BaseException args(Object... args);
}
