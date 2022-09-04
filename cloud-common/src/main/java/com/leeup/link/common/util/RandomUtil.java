package com.leeup.link.common.util;

import java.util.Random;
import java.util.UUID;

/**
 * @author clee
 * @description
 * @date 4/9/2022 下午5:44
 **/
@SuppressWarnings("unused")
public class RandomUtil {
    /**
     * 获取验证码随机数
     *
     * @param length 随机数长度
     * @return 随机数
     */
    public static String getRandomCode(int length) {
        String sources = "0123456789";
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < length; j++) {
            sb.append(sources.charAt(random.nextInt(9)));
        }
        return sb.toString();
    }

    /**
     * 获取当前时间戳
     *
     * @return 时间戳
     */
    public static long getCurrentTimestamp() {
        return System.currentTimeMillis();
    }

    /**
     * ⽣成uuid
     *
     * @return UUID
     */
    public static String generateUUID() {
        return UUID.randomUUID().toString().replaceAll("-", "").substring(0, 32);
    }


    private static final String ALL_CHAR_NUM = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

    /**
     * 获取随机⻓度的串
     *
     * @param length 随机串的长度
     * @return 随机串
     */
    public static String getStringNumRandom(int length) {
        //⽣成随机数字和字⺟
        Random random = new Random();
        StringBuilder saltString = new StringBuilder(length);
        for (int i = 1; i <= length; ++i) {
            saltString.append(ALL_CHAR_NUM.charAt(random.nextInt(ALL_CHAR_NUM.length())));
        }
        return saltString.toString();
    }
}
