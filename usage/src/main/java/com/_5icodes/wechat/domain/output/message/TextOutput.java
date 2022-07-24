package com._5icodes.wechat.domain.output.message;

import com._5icodes.wechat.domain.output.OutputEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 回复文本消息
 */
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Data
public class TextOutput extends BaseOutput {
    // 回复的消息内容（换行：在 content 中能够换行，微信客户端就支持换行显示）
    private String Content;

    @Override
    public String getMsgType() {
        return OutputEnum.TEXT_OUTPUT.getMsgType();
    }
}