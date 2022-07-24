package com._5icodes.wechat.domain.notify.event;

import com._5icodes.wechat.domain.notify.NotifyEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 取消关注事件
 */
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Data
public class UnsubscribeEvent extends BaseEvent {
    @Override
    public String getMsgType() {
        return NotifyEnum.UNSUBSCRIBE_EVENT.getMsgType();
    }

    @Override
    public String getEvent() {
        return NotifyEnum.UNSUBSCRIBE_EVENT.getEvent();
    }
}