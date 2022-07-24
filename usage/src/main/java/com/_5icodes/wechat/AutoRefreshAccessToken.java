package com._5icodes.wechat;

import com._5icodes.wechat.service.WechatService;
import org.apache.commons.lang3.concurrent.BasicThreadFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 自动刷新access_token
 */
@Component
public class AutoRefreshAccessToken implements ApplicationListener<ApplicationReadyEvent> {
    @Autowired
    private WechatService wechatService;

    private final ScheduledThreadPoolExecutor scheduledPool = new ScheduledThreadPoolExecutor(1,
            new BasicThreadFactory.Builder().namingPattern("refresh-access-token-%d").daemon(true).build());

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        scheduledPool.scheduleAtFixedRate(() -> wechatService.refreshAccessToken(), 0, 3600, TimeUnit.SECONDS);
    }
}