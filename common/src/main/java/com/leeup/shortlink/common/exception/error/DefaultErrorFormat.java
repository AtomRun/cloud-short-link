package com.leeup.shortlink.common.exception.error;

import java.text.MessageFormat;

/**
 * @author clee
 * @description
 * @date 4/9/2022 下午3:26
 **/
public class DefaultErrorFormat {
    public static String format(String message, Object... args) {
        return MessageFormat.format(message, args);
    }

}
