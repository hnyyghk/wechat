package com._5icodes.wechat;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@ConfigurationProperties(prefix = "wechat")
@Component
public class WechatConfig {
    private String appId;
    private String secret;
    private String token;
    private String encodingAesKey;
}