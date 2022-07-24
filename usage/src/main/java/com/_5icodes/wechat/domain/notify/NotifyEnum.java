package com._5icodes.wechat.domain.notify;

import java.util.Objects;

/**
 * 推送类型枚举
 */
public enum NotifyEnum {
    // 文本消息
    TEXT_MESSAGE("text"),
    // 图片消息
    IMAGE_MESSAGE("image"),
    // 语音消息
    VOICE_MESSAGE("voice"),
    // 视频消息
    VIDEO_MESSAGE("video"),
    // 小视频消息消息
    SHORT_VIDEO_MESSAGE("shortvideo"),
    // 地理位置消息
    LOCATION_MESSAGE("location"),
    // 链接消息
    LINK_MESSAGE("link"),
    // 事件类型：关注、用户未关注时的扫描带参数二维码
    SUBSCRIBE_EVENT("event", "subscribe"),
    // 事件类型：取消关注
    UNSUBSCRIBE_EVENT("event", "unsubscribe"),
    // 事件类型：用户已关注时的扫描带参数二维码
    SCAN_EVENT("event", "SCAN"),
    // 事件类型：上报地理位置
    LOCATION_EVENT("event", "LOCATION"),
    // 事件类型：点击菜单拉取消息
    CLICK_EVENT("event", "CLICK"),
    // 事件类型：点击菜单跳转链接
    VIEW_EVENT("event", "VIEW"),
    ;

    private final String msgType;
    private final String event;

    NotifyEnum(String msgType) {
        this.msgType = msgType;
        this.event = null;
    }

    NotifyEnum(String msgType, String event) {
        this.msgType = msgType;
        this.event = event;
    }

    public String getMsgType() {
        return msgType;
    }

    public String getEvent() {
        return event;
    }

    /**
     * 解析推送类型
     *
     * @param msgType
     * @param event
     * @return
     */
    public static NotifyEnum resolveMessage(String msgType, String event) {
        for (NotifyEnum notifyEnum : NotifyEnum.values()) {
            if (Objects.equals(msgType, notifyEnum.getMsgType()) && Objects.equals(event, notifyEnum.getEvent())) {
                return notifyEnum;
            }
        }
        return null;
    }
}