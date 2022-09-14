package com.leeup.shortlink.common.properties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author clee
 * @description
 * @date 2022年9月10日 20:38
 **/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ConfigurationProperties(prefix = "http")
public class HttpConfigProperties {
    private int socketTimeout = 5000;
    private int connectTimeout = 5000;
    private int connectionRequestTimeout = 1000;
}

