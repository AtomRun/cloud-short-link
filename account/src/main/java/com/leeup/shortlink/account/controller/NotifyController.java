package com.leeup.shortlink.account.controller;


import com.leeup.shortlink.account.Summary;
import com.leeup.shortlink.common.component.SmsService;
import com.leeup.shortlink.common.util.RandomUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author cLee
 * @since 2022-09-06
 */
@RestController
@RequestMapping(Summary.SERVICE_NAME + Summary.VERSION + "/notify")
@RequiredArgsConstructor
public class NotifyController {

    private final SmsService smsService;

    @GetMapping("send-sms")
    public void smsSend(@RequestParam("mobile") String mobile) {
        smsService.send(mobile, "M105EABDEC", RandomUtil.getRandomCode(6));
    }
}

