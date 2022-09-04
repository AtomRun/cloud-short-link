package com.leeup.link.common.exception.error;

import com.leeup.link.common.exception.BaseException;

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
