package com.leeup.shortlink.common.util;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * @author clee
 * @description
 * @date 4/9/2022 下午5:49
 **/
@SuppressWarnings("unused")
public class RequestUtil {
    /**
     * 获取全部请求Header
     *
     * @param request 请求
     * @return 请求头K-V
     */
    public static Map<String, String> getAllRequestHeader(HttpServletRequest request) {
        Enumeration<String> headerNames = request.getHeaderNames();
        Map<String, String> map = new HashMap<>();
        while (headerNames.hasMoreElements()) {
            String key = headerNames.nextElement();
            //根据名称获取请求头的值
            String value = request.getHeader(key);
            map.put(key, value);
        }
        return map;
    }
}
