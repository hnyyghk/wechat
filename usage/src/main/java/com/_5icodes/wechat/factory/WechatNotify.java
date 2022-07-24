package com._5icodes.wechat.factory;

import com._5icodes.wechat.domain.notify.BaseNotify;

import java.util.Map;

/**
 * 微信事件推送策略的最上层抽象
 */
public interface WechatNotify<T extends BaseNotify> {
    /**
     * 上层事件推送策略抽象接口
     *
     * @param xmlMap 微信推送的参数数据
     * @return 返回给微信的回复信息
     * @throws Exception
     */
    default String wechatNotify(Map<String, String> xmlMap) throws Exception {
        return wechatNotify(mapToBean(xmlMap));
    }

    String wechatNotify(T t) throws Exception;

    T mapToBean(Map<String, String> xmlMap);
}