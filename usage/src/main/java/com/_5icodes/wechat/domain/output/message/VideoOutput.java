package com._5icodes.wechat.domain.output.message;

import com._5icodes.wechat.domain.output.OutputEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 回复视频消息
 */
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Data
public class VideoOutput extends BaseOutput {
    // 视频
    private Video Video;

    @Override
    public String getMsgType() {
        return OutputEnum.VIDEO_OUTPUT.getMsgType();
    }
}