package com.leeup.shortlink.common.component;

import com.leeup.shortlink.common.properties.SmsConfigProperties;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
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


    String key = "%s";

    public void send(String mobile, String templateId, String value) {
        String URL_TEMPLATE = smsConfig.getSmsUrl() + "?" + "mobile=" + key + "&templateId=" + key + "&value=" + key;
        log.info("[短信发送],mobile={},templateId={},value={}", mobile, templateId, value);
        String url = String.format(URL_TEMPLATE, mobile, templateId, value);
        HttpHeaders headers = new HttpHeaders();
        //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
        headers.set("Authorization", "APPCODE " + smsConfig.getAppCode());
        try {
            ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, new HttpEntity<>(headers), String.class);
            if (response.getStatusCode().is2xxSuccessful()) {
                return;
            }
            log.info("[发送失败],url={},response={}", url, response);
        } catch (Exception e) {
            log.info("[发送失败],message={}", e.getMessage());
            throw e;
        }
    }
}
