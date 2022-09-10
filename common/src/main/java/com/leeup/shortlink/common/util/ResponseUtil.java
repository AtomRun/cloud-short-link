package com.leeup.shortlink.common.util;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author clee
 * @description
 * @date 4/9/2022 下午5:46
 **/
@Slf4j
@SuppressWarnings("unused")
public class ResponseUtil {

    /**
     * 响应json数据给前端
     *
     * @param response 请求响应
     * @param obj      对象
     */
    public static void sendJsonMessage(HttpServletResponse response, Object obj) {
        response.setContentType("application/json;charset=utf-8");
        try (PrintWriter writer = response.getWriter()) {
            writer.print(JSONUtil.obj2Json(obj));
            response.flushBuffer();
        } catch (IOException e) {
            log.warn("响应json数据给前端异常:{}", e.getMessage());
        }
    }
}
