package com._5icodes.wechat.domain.notify.event;

import com._5icodes.wechat.domain.notify.BaseNotify;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 事件的公共字段类
 */
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Data
public abstract class BaseEvent extends BaseNotify {
    /**
     * 获取事件类型
     *
     * @return 事件类型
     */
    public abstract String getEvent();
}