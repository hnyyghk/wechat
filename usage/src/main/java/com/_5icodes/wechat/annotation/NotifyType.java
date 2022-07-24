package com._5icodes.wechat.annotation;

import com._5icodes.wechat.domain.notify.NotifyEnum;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 推送类型注解
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface NotifyType {
    /**
     * 推送类型 支持枚举多个事件
     *
     * @return
     */
    NotifyEnum[] value();
}