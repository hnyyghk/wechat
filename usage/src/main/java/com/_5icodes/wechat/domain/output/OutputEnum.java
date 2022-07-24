package com._5icodes.wechat.domain.output;

/**
 * 响应类型枚举
 */
public enum OutputEnum {
    //文本消息
    TEXT_OUTPUT("text"),
    //图片消息
    IMAGE_OUTPUT("image"),
    //语音消息
    VOICE_OUTPUT("voice"),
    //视频消息
    VIDEO_OUTPUT("video"),
    //音乐消息
    MUSIC_OUTPUT("music"),
    //图文消息
    NEWS_OUTPUT("news"),
    ;

    private final String msgType;

    OutputEnum(String msgType) {
        this.msgType = msgType;
    }

    public String getMsgType() {
        return msgType;
    }
}