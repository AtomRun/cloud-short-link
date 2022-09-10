package com.leeup.shortlink.common.properties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author clee
 * @description
 * @date 2022年9月10日 21:43
 **/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ConfigurationProperties(prefix = "sms")
public class SmsConfigProperties {

    private String smsUrl;
    private String templateId;
    private String appCode;
}
