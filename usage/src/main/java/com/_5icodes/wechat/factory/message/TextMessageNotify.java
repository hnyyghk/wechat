package com._5icodes.wechat.factory.message;

import com._5icodes.wechat.annotation.NotifyType;
import com._5icodes.wechat.domain.notify.NotifyEnum;
import com._5icodes.wechat.domain.notify.message.TextMessage;
import com._5icodes.wechat.domain.output.message.TextOutput;
import com._5icodes.wechat.factory.WechatNotify;
import com._5icodes.wechat.utils.ReplyMessageUtils;
import com._5icodes.wechat.utils.WXBizMsgCrypt;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
@NotifyType(NotifyEnum.TEXT_MESSAGE)
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public abstract class TextMessageNotify implements WechatNotify<TextMessage> {
    @Autowired
    private WXBizMsgCrypt wxBizMsgCrypt;

    @Override
    public String wechatNotify(TextMessage message) throws Exception {
        log.info(message.toString());
        // 发送方帐号
        String fromUserName = message.getFromUserName();
        // 开发者微信号
        String toUserName = message.getToUserName();

        // 封装文本返回消息
        TextOutput output = new TextOutput();
        output.setCreateTime(Long.toString(System.currentTimeMillis()));
        output.setFromUserName(toUserName);
        output.setToUserName(fromUserName);

        String content = message.getContent();
        output.setContent("您发送的是文本消息：" + content);

        String replyMsg = ReplyMessageUtils.sendTextMessage(output);
        return wxBizMsgCrypt.encryptMsg(replyMsg, "", "");
    }
}