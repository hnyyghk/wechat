package com._5icodes.wechat.service;

public interface WechatService {
    /**
     * 刷新access_token
     *
     * @return
     */
    String refreshAccessToken();

    String sendCustomMessage(String toUser, String content);
}