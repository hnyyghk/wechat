package com._5icodes.wechat.web;

import com._5icodes.starter.webmvc.advice.NotAutoWrap;
import com._5icodes.wechat.domain.notify.NotifyEnum;
import com._5icodes.wechat.factory.NotifyFactory;
import com._5icodes.wechat.factory.WechatNotify;
import com._5icodes.wechat.utils.WXBizMsgCrypt;
import com._5icodes.wechat.utils.XMLParse;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * 微信调用接口
 */
@NotAutoWrap
@RestController
@RequestMapping
@Slf4j
public class WechatController {
    @Autowired
    private WXBizMsgCrypt wxBizMsgCrypt;
    @Autowired
    private NotifyFactory notifyFactory;

    /**
     * 开发者接入验证
     *
     * @param signature 微信加密签名
     * @param echostr   随机字符串
     * @param timestamp 时间戳
     * @param nonce     随机数
     * @return
     * @throws Exception
     */
    @GetMapping
    public String get(String signature, String echostr, String timestamp, String nonce) throws Exception {
        log.info("signature: {}", signature);
        log.info("echostr: {}", echostr);
        log.info("timestamp: {}", timestamp);
        log.info("nonce: {}", nonce);
        // 校验signature，确认此次GET请求来自微信服务器
        wxBizMsgCrypt.verifyUrl(signature, timestamp, nonce);
        if (StringUtils.isAnyBlank(echostr)) {
            return "";
        }
        // 原样返回echostr参数内容
        return echostr;
    }

    /**
     * 公众号消息和事件推送
     *
     * @param signature     微信加密签名
     * @param timestamp     时间戳
     * @param nonce         随机数
     * @param openid
     * @param encrypt_type
     * @param msg_signature 消息体签名
     * @param postData      消息体
     * @return
     * @throws Exception
     */
    @PostMapping
    public String post(String signature, String timestamp, String nonce, String openid, String encrypt_type, String msg_signature, @RequestBody(required = false) String postData) throws Exception {
        log.info("signature: {}", signature);
        log.info("timestamp: {}", timestamp);
        log.info("nonce: {}", nonce);
        log.info("openid: {}", openid);
        log.info("encrypt_type: {}", encrypt_type);
        log.info("msg_signature: {}", msg_signature);
        log.info("postData: {}", postData);
        // 校验signature，确认此次POST请求来自微信服务器
        wxBizMsgCrypt.verifyUrl(signature, timestamp, nonce);
        if (StringUtils.isAnyBlank(msg_signature, postData)) {
            return "";
        }
        // 校验msg_signature，解密数据
        String decryptXml = wxBizMsgCrypt.decryptMsg(msg_signature, timestamp, nonce, postData);
        Map<String, String> xmlMap = XMLParse.extract(decryptXml);
        log.info("解密之后信息: {}", xmlMap);
        // 获取推送类型
        NotifyEnum notifyEnum = NotifyEnum.resolveMessage(xmlMap.get("MsgType"), xmlMap.get("Event"));
        log.info("推送类型枚举: {}", notifyEnum);
        WechatNotify<?> infoType = notifyFactory.loadWechatNotify(notifyEnum);
        log.info("执行策略对象: {}", infoType.getClass().getSimpleName());
        // 执行具体的策略，得到给微信的响应信息(微信有重试机制，需要考虑幂等性)
        String result = infoType.wechatNotify(xmlMap);
        log.info("返回微信信息: {}", result);
        return result;
    }
}