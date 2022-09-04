package com.leeup.link.common.util;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

/**
 * @author clee
 * @description
 * @date 4/9/2022 下午5:42
 **/
@SuppressWarnings("unused")
public class MD5Util {
    /**
     * MD5加密
     *
     * @param data 待加密的String
     * @return MD5
     */
    public static String MD5(String data) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] array = md.digest(data.getBytes(StandardCharsets.UTF_8));
            StringBuilder sb = new StringBuilder();
            for (byte item : array) {
                sb.append(Integer.toHexString((item & 0xFF) | 0x100), 1, 3);
            }
            return sb.toString().toUpperCase();
        } catch (Exception ignored) {
        }
        return null;
    }
}
