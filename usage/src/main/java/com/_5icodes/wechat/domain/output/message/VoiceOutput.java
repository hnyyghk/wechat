package com._5icodes.wechat.domain.output.message;

import com._5icodes.wechat.domain.output.OutputEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 回复语音消息
 */
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Data
public class VoiceOutput extends BaseOutput {
    // 语音
    private Voice Voice;

    @Override
    public String getMsgType() {
        return OutputEnum.VOICE_OUTPUT.getMsgType();
    }
}