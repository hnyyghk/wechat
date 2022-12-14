package com._5icodes.wechat.domain.notify.message;

import com._5icodes.wechat.domain.notify.NotifyEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 语音消息
 */
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Data
public class VoiceMessage extends BaseMessage {
    // 语音消息媒体id，可以调用多媒体文件下载接口拉取数据。
    private String MediaId;
    // 语音格式，如amr，speex等
    private String Format;
    // 语音识别结果，使用UTF8编码
    private String Recognition;

    @Override
    public String getMsgType() {
        return NotifyEnum.VOICE_MESSAGE.getMsgType();
    }
}