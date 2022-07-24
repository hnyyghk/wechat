package com._5icodes.wechat.domain.notify.event;

import com._5icodes.wechat.domain.notify.NotifyEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 上报地理位置事件
 */
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Data
public class LocationEvent extends BaseEvent {
    // 地理位置纬度
    private String Latitude;
    // 地理位置经度
    private String Longitude;
    // 地理位置精度
    private String Precision;

    @Override
    public String getMsgType() {
        return NotifyEnum.LOCATION_EVENT.getMsgType();
    }

    @Override
    public String getEvent() {
        return NotifyEnum.LOCATION_EVENT.getEvent();
    }
}