package com._5icodes.wechat.domain.output.message;

import lombok.Data;

/**
 * 回复消息的公共字段类
 */
@Data
public abstract class BaseOutput {
    // 接收方帐号（收到的OpenID）
    private String ToUserName;
    // 开发者微信号
    private String FromUserName;
    // 消息创建时间 （整型）
    private String CreateTime;

    // 获取消息类型
    public abstract String getMsgType();
}