package com._5icodes.wechat.domain.notify.message;

import com._5icodes.wechat.domain.notify.NotifyEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 文本消息
 */
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Data
public class TextMessage extends BaseMessage {
    // 文本消息内容
    private String Content;

    @Override
    public String getMsgType() {
        return NotifyEnum.TEXT_MESSAGE.getMsgType();
    }
}