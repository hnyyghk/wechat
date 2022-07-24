package com._5icodes.wechat.factory.event;

import com._5icodes.wechat.annotation.NotifyType;
import com._5icodes.wechat.domain.notify.NotifyEnum;
import com._5icodes.wechat.domain.notify.event.SubscribeEvent;
import com._5icodes.wechat.domain.output.message.TextOutput;
import com._5icodes.wechat.factory.WechatNotify;
import com._5icodes.wechat.utils.ReplyMessageUtils;
import com._5icodes.wechat.utils.WXBizMsgCrypt;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
@NotifyType(NotifyEnum.SUBSCRIBE_EVENT)
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public abstract class SubscribeEventNotify implements WechatNotify<SubscribeEvent> {
    @Autowired
    private WXBizMsgCrypt wxBizMsgCrypt;

    @Override
    public String wechatNotify(SubscribeEvent message) throws Exception {
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

        output.setContent("你好，欢迎关注！");

        String replyMsg = ReplyMessageUtils.sendTextMessage(output);
        return wxBizMsgCrypt.encryptMsg(replyMsg, "", "");
    }
}