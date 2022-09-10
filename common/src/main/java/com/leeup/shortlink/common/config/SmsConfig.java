package com.leeup.shortlink.common.config;

import com.leeup.shortlink.common.component.SmsService;
import com.leeup.shortlink.common.properties.SmsConfigProperties;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author clee
 * @description
 * @date 2022年9月10日 21:59
 **/
@Configuration
@AutoConfigureAfter(RestTemplateConfig.class)
@EnableConfigurationProperties(SmsConfigProperties.class)
public class SmsConfig {

    @Bean
    public SmsService smsUtil(SmsConfigProperties smsConfig, RestTemplate restTemplate) {
        return new SmsService(smsConfig, restTemplate);
    }
}
