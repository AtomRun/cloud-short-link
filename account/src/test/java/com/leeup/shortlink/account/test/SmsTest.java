package com.leeup.shortlink.account.test;

import com.leeup.shortlink.account.AccountApplication;
import com.leeup.shortlink.common.component.SmsService;
import groovy.util.logging.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author clee
 * @description
 * @date 2022年9月12日 10:26
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = AccountApplication.class)
@Slf4j
public class SmsTest {

    @Autowired
    private SmsService smsService;

    @Test
    public void testSmsSend() {
        smsService.send("yourPhone","M105EABDEC","541234");
    }
}
