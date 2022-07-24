package com._5icodes.wechat.domain.output.message;

import com._5icodes.wechat.domain.output.OutputEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 回复音乐消息
 */
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Data
public class MusicOutput extends BaseOutput {
    // 音乐
    private Music Music;

    @Override
    public String getMsgType() {
        return OutputEnum.MUSIC_OUTPUT.getMsgType();
    }
}