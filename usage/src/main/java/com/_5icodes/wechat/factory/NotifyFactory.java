package com._5icodes.wechat.factory;

import com._5icodes.wechat.annotation.NotifyType;
import com._5icodes.wechat.domain.notify.BaseNotify;
import com._5icodes.wechat.domain.notify.NotifyEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.SmartInitializingSingleton;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@Slf4j
public class NotifyFactory implements SmartInitializingSingleton {
    /**
     * 策略列表
     */
    private final Map<NotifyEnum, WechatNotify<?>> notifyMap = new HashMap<>();

    @Autowired(required = false)
    private List<WechatNotify<?>> wechatNotifyList;

    /**
     * 工厂获取事件执行策略对象
     *
     * @param notifyEnum
     * @return
     */
    public WechatNotify<?> loadWechatNotify(NotifyEnum notifyEnum) {
        // 对于没配置的策略 返回一个默认的空实现即可
        return notifyMap.getOrDefault(notifyEnum, new WechatNotify<BaseNotify>() {
            @Override
            public String wechatNotify(BaseNotify baseNotify) throws Exception {
                // todo or return "success" ?
                log.info("未匹配到推送类型对应的策略实现");
                return "SUCCESS";
            }

            @Override
            public BaseNotify mapToBean(Map<String, String> xmlMap) {
                return null;
            }
        });
    }

    /**
     * 获取实现了WechatNotify接口并带有NotifyType注解的bean组装成map
     * 新加策略时 在类上加入注解@NotifyType(...)即可
     * 支持枚举多个策略事件
     */
    @Override
    public void afterSingletonsInstantiated() {
        if (CollectionUtils.isEmpty(wechatNotifyList)) {
            return;
        }
        for (WechatNotify<?> wechatNotify : wechatNotifyList) {
            NotifyType notifyType = wechatNotify.getClass().getSuperclass().getAnnotation(NotifyType.class);
            if (notifyType == null) {
                continue;
            }
            for (NotifyEnum notifyEnum : notifyType.value()) {
                WechatNotify<?> put = notifyMap.put(notifyEnum, wechatNotify);
                if (put != null) {
                    throw new RuntimeException("exist duplicate notify type");
                }
            }
        }
    }
}