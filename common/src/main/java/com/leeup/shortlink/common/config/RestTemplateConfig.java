package com.leeup.shortlink.common.config;

import com.leeup.shortlink.common.properties.HttpConfigProperties;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
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

        Registry<ConnectionSocketFactory> registry = RegistryBuilder.<ConnectionSocketFactory>create()
                .register("http", PlainConnectionSocketFactory.getSocketFactory())
                .register("https", SSLConnectionSocketFactory.getSocketFactory())
                .build();
        PoolingHttpClientConnectionManager manager = new PoolingHttpClientConnectionManager(registry);

        // 连接池最大500个连接
        manager.setMaxTotal(500);
        // 最大路由数，对maxTotal的细分，每个主机的并发最大是300，route指的是域名
        // 例如只请求a.com 最大并发只有300

        // 同时请求了a/b.com 每个主机的最大并发不能超过300，即DefaultMaxPerRoute,加起来不能超过maxTotal
        manager.setDefaultMaxPerRoute(300);

        RequestConfig requestConfig = RequestConfig.custom()
                // 返回数据的超时时间
                .setSocketTimeout(config.getSocketTimeout())
                // 连接到服务器的超时时间
                .setConnectTimeout(config.getConnectTimeout())
                // 从连接池获取连接的超时时间
                .setConnectionRequestTimeout(config.getConnectionRequestTimeout())
                .build();

        CloseableHttpClient httpClient = HttpClientBuilder.create().setDefaultRequestConfig(requestConfig)
                .setConnectionManager(manager)
                .build();

        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
        factory.setConnectTimeout(config.getSocketTimeout());
        factory.setReadTimeout(config.getConnectTimeout());
        return new RestTemplate(new HttpComponentsClientHttpRequestFactory(httpClient));
    }
}
