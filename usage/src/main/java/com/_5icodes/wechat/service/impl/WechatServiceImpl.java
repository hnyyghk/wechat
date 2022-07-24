package com._5icodes.wechat.service.impl;

import com._5icodes.wechat.WechatConfig;
import com._5icodes.wechat.WechatFeign;
import com._5icodes.wechat.service.WechatService;
import com._5icodes.wechat.utils.WXBizMsgCrypt;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
public class WechatServiceImpl implements WechatService {
    @Autowired
    private WXBizMsgCrypt wxBizMsgCrypt;
    @Autowired
    private WechatFeign wechatFeign;
    @Autowired
    private WechatConfig wechatConfig;

    private String accessToken = "";

    @Override
    public String refreshAccessToken() {
        //todo or post ?
        String result = wechatFeign.token("client_credential", wechatConfig.getAppId(), wechatConfig.getSecret());
        log.info("refreshAccessToken result: {}", result);
        //todo 使用对象接收
        String accessToken = JSON.parseObject(result).getString("access_token");
        if (StringUtils.isNotBlank(accessToken)) {
            this.accessToken = accessToken;
        }
        return result;
    }

    @Override
    public String sendCustomMessage(String toUser, String content) {
        Map<String, Object> map = new HashMap<>();
        map.put("touser", toUser);
        map.put("msgtype", "text");
        Map<String, String> text = new HashMap<>();
        text.put("content", content);
        map.put("text", text);
        String s = wechatFeign.sendCustomMessage(accessToken, map);
        log.info(s);
        return s;
    }
}