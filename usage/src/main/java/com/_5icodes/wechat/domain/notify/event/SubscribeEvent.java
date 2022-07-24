package com._5icodes.wechat.domain.notify.event;

import com._5icodes.wechat.domain.notify.NotifyEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 关注事件、用户未关注时的扫描带参数二维码事件
 */
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Data
public class SubscribeEvent extends BaseEvent {
    // 事件KEY值，qrscene_为前缀，后面为二维码的参数值
    private String EventKey;
    // 二维码的ticket，可用来换取二维码图片
    private String Ticket;

    @Override
    public String getMsgType() {
        return NotifyEnum.SUBSCRIBE_EVENT.getMsgType();
    }

    @Override
    public String getEvent() {
        return NotifyEnum.SUBSCRIBE_EVENT.getEvent();
    }
}