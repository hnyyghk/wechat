package com._5icodes.wechat.domain.notify.message;

import com._5icodes.wechat.domain.notify.NotifyEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 链接消息
 */
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Data
public class LinkMessage extends BaseMessage {
    // 消息标题
    private String Title;
    // 消息描述
    private String Description;
    // 消息链接
    private String Url;

    @Override
    public String getMsgType() {
        return NotifyEnum.LINK_MESSAGE.getMsgType();
    }
}