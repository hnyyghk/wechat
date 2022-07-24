package com._5icodes.wechat;

import com._5icodes.wechat.utils.WXBizMsgCrypt;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class WechatApplication {
    public static void main(final String[] args) {
        SpringApplication.run(WechatApplication.class, args);
    }

    /**
     * 微信加解密工具
     *
     * @param wechatConfig
     * @return
     * @throws Exception
     */
    @Bean
    public WXBizMsgCrypt wxBizMsgCrypt(WechatConfig wechatConfig) throws Exception {
        return new WXBizMsgCrypt(wechatConfig.getToken(), wechatConfig.getEncodingAesKey(), wechatConfig.getAppId());
    }
}