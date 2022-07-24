package com._5icodes.wechat.domain.notify.event;

import com._5icodes.wechat.domain.notify.NotifyEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 点击菜单拉取消息事件
 */
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Data
public class ClickEvent extends BaseEvent {
    // 事件KEY值，与自定义菜单接口中KEY值对应
    private String EventKey;

    @Override
    public String getMsgType() {
        return NotifyEnum.CLICK_EVENT.getMsgType();
    }

    @Override
    public String getEvent() {
        return NotifyEnum.CLICK_EVENT.getEvent();
    }
}