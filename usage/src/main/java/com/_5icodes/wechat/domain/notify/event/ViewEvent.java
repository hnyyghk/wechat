package com._5icodes.wechat.domain.notify.event;

import com._5icodes.wechat.domain.notify.NotifyEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 点击菜单跳转链接事件
 */
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Data
public class ViewEvent extends BaseEvent {
    // 事件KEY值，设置的跳转URL
    private String EventKey;

    @Override
    public String getMsgType() {
        return NotifyEnum.VIEW_EVENT.getMsgType();
    }

    @Override
    public String getEvent() {
        return NotifyEnum.VIEW_EVENT.getEvent();
    }
}