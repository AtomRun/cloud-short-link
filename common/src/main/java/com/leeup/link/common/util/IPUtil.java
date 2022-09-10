package com.leeup.link.common.util;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author clee
 * @description
 * @date 4/9/2022 下午5:32
 **/
@SuppressWarnings("unused")
public class IPUtil {
    /**
     * 获取ip
     *
     * @param request 请求
     * @return 解析出的IP
     */
    public static String getIpAddress(HttpServletRequest request) {
        String ipAddress;
        try {
            ipAddress = request.getHeader("x- forwarded - for ");
            if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
                ipAddress = request.getHeader("Proxy-Client-IP");
            }
            if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
                ipAddress = request.getHeader("WL- Proxy - Client - IP");
            }
            if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
                ipAddress = request.getRemoteAddr();
                if (ipAddress.equals("127.0.0.1")) {
                    // 根据⽹卡取本机配置的IP
                    InetAddress inet = null;
                    try {
                        inet = InetAddress.getLocalHost();
                    } catch (UnknownHostException e) {
                        e.printStackTrace();
                    }
                    if (null == inet) {
                        ipAddress = "";
                    } else {
                        ipAddress = inet.getHostAddress();
                    }
                }
            }
            // 对于通过多个代理的情况，第⼀个IP为客户端真实IP, 多个IP按照 ',' 分割
            // if (ipAddress != null && ipAddress.length() > 15) {
            // "***.***.***.***".length() = 15
            if (ipAddress.indexOf(",") > 0) {
                ipAddress = ipAddress.substring(0, ipAddress.indexOf(","));
            }
        } catch (Exception e) {
            ipAddress = "";
        }
        return ipAddress;
    }
}
