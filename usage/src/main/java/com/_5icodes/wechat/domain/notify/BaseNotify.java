package com._5icodes.wechat.domain.notify;

import lombok.Data;

/**
 * 推送的公共字段类
 */
@Data
public abstract class BaseNotify {
    // 开发者微信号
    private String ToUserName;
    // 发送方帐号（一个OpenID）
    private String FromUserName;
    // 消息创建时间 （整型）
    private String CreateTime;

    /**
     * 获取消息类型
     *
     * @return 消息类型
     */
    public abstract String getMsgType();
}