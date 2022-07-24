package com._5icodes.wechat.domain.output.message;

import com._5icodes.wechat.domain.output.OutputEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 回复图片消息
 */
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Data
public class ImageOutput extends BaseOutput {
    // 图片
    private Image Image;

    @Override
    public String getMsgType() {
        return OutputEnum.IMAGE_OUTPUT.getMsgType();
    }
}