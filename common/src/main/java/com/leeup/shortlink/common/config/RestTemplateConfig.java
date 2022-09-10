package com.leeup.shortlink.common.config;

import com.leeup.shortlink.common.properties.HttpConfigProperties;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * @author clee
 * @description
 * @date 2022年9月10日 20:34
 **/
@Configuration
@EnableConfigurationProperties(HttpConfigProperties.class)
public class RestTemplateConfig {

    @Bean
    @ConditionalOnMissingBean(name = "restTemplate")
    public RestTemplate restTemplate(HttpConfigProperties config) {
        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
        factory.setConnectTimeout(config.getConnectTimeout());
        factory.setReadTimeout(config.getReadTimeout());
        return new RestTemplate(factory);
    }
}
