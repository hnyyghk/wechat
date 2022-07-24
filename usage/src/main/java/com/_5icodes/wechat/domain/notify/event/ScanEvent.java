package com._5icodes.wechat.domain.notify.event;

import com._5icodes.wechat.domain.notify.NotifyEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 用户已关注时的扫描带参数二维码事件
 */
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Data
public class ScanEvent extends BaseEvent {
    // 事件KEY值，是一个32位无符号整数，即创建二维码时的二维码scene_id
    private String EventKey;
    // 二维码的ticket，可用来换取二维码图片
    private String Ticket;

    @Override
    public String getMsgType() {
        return NotifyEnum.SCAN_EVENT.getMsgType();
    }

    @Override
    public String getEvent() {
        return NotifyEnum.SCAN_EVENT.getEvent();
    }
}