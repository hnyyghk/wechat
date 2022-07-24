package com._5icodes.wechat.web;

import com._5icodes.wechat.service.WechatService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * api调用接口
 */
@RestController
@RequestMapping("/api")
@Slf4j
public class ApiController {
    @Autowired
    private WechatService wechatService;

    /**
     * 手动刷新access_token
     *
     * @return
     */
    @GetMapping("/refreshAccessToken")
    public String refreshAccessToken() {
        return wechatService.refreshAccessToken();
    }

    /**
     * 发送自定义消息
     *
     * @return
     */
    @PostMapping("/sendCustomMessage")
    public String sendCustomMessage(String toUser, String content) {
        return wechatService.sendCustomMessage(toUser, content);
    }
}