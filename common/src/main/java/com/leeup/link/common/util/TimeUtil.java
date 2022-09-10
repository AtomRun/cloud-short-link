package com.leeup.link.common.util;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;

/**
 * @author clee
 * @description
 * @date 4/9/2022 下午5:22
 **/
@SuppressWarnings("unused")
public class TimeUtil {
    /**
     * 默认⽇期格式
     */
    private static final String DEFAULT_PATTERN = "yyyy-MM-dd HH:mm:ss";
    /**
     * 默认⽇期格式
     */
    private static final DateTimeFormatter DEFAULT_DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern(DEFAULT_PATTERN);
    private static final ZoneId DEFAULT_ZONE_ID = ZoneId.systemDefault();

    /**
     * LocalDateTime 转字符串，指定⽇期格式
     *
     * @param time 时间
     * @param pattern 日期格式
     * @return String时间
     */
    public static String format(LocalDateTime time, String pattern) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return formatter.format(time.atZone(DEFAULT_ZONE_ID));
    }

    /**
     * Date 转 字符串, 指定⽇期格式
     *
     * @param time 时间
     * @param pattern 日期格式
     * @return String时间
     */
    public static String format(Date time, String pattern) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return formatter.format(time.toInstant().atZone(DEFAULT_ZONE_ID));
    }

    /**
     * Date 转 字符串，默认⽇期格式
     *
     * @param time 日期
     * @return String时间
     */
    public static String format(Date time) {
        return DEFAULT_DATE_TIME_FORMATTER.format(time.toInstant().atZone(DEFAULT_ZONE_ID));
    }

    /**
     * timestamp 转 字符串，默认⽇期格式
     *
     * @param timestamp 时间戳
     * @return String时间
     */
    public static String format(long timestamp) {
        return DEFAULT_DATE_TIME_FORMATTER.format(new Date(timestamp).toInstant().atZone(DEFAULT_ZONE_ID));
    }

    /**
     * 字符串 转 Date
     *
     * @param time String日期
     * @return Date
     */
    public static Date strToDate(String time) {
        LocalDateTime localDateTime = LocalDateTime.parse(time, DEFAULT_DATE_TIME_FORMATTER);
        return Date.from(localDateTime.atZone(DEFAULT_ZONE_ID).toInstant());
    }

    /**
     * 获取当天剩余的秒数,⽤于流量包过期配置
     *
     * @param currentDate 当天日期
     * @return 剩余秒数
     */
    public static Integer getRemainSecondsOneDay(Date currentDate) {
        LocalDateTime midnight = LocalDateTime
                .ofInstant(currentDate.toInstant(),
                        ZoneId.systemDefault())
                .plusDays(1)
                .withHour(0)
                .withMinute(0)
                .withSecond(0)
                .withNano(0);
        LocalDateTime currentDateTime = LocalDateTime
                .ofInstant(currentDate.toInstant(), ZoneId.systemDefault());
        long seconds = ChronoUnit.SECONDS.between(currentDateTime, midnight);
        return (int) seconds;
    }
}
