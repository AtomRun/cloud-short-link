package com.leeup.shortlink.common.component;

import com.leeup.shortlink.common.properties.SmsConfigProperties;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.client.RestTemplate;

/**
 * @author clee
 * @description
 * @date 2022年9月10日 21:53
 **/
@RequiredArgsConstructor
@Slf4j
@SuppressWarnings("unused")
public class SmsService {

    private final SmsConfigProperties smsConfig;
    private final RestTemplate restTemplate;

    @Async("threadPoolTaskExecutor")
    public void send(String mobile, String templateId, String value) {
        String template = smsConfig.getSmsUrl() + "?mobile=%s&templateId=%s&value=%s";
        log.info("[短信发送],mobile={},templateId={},value={}", mobile, templateId, value);
        String url = String.format(template, mobile, templateId, value);
        HttpHeaders headers = new HttpHeaders();
        //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
        headers.set("Authorization", "APPCODE " + smsConfig.getAppCode());
        try {
            ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, new HttpEntity<>(headers), String.class);
            if (response.getStatusCode().is2xxSuccessful()) {
                log.info("[发送成功],url={},response={}", url, response);
                return;
            }
            log.info("[发送失败],url={},response={}", url, response);
        } catch (Exception e) {
            log.info("[发送失败],message={}", e.getMessage());
            throw e;
        }
    }
}
