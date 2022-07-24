package com._5icodes.wechat.domain.output.message;

import com._5icodes.wechat.domain.output.OutputEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;

/**
 * 回复图文消息
 */
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Data
public class NewsOutput extends BaseOutput {
    // 图文消息个数；当用户发送文本、图片、语音、视频、图文、地理位置这六种消息时，开发者只能回复1条图文消息；其余场景最多可回复8条图文消息
    private int ArticleCount;
    // 图文消息信息，注意，如果图文数超过限制，则将只发限制内的条数
    private List<Article> Articles;

    @Override
    public String getMsgType() {
        return OutputEnum.NEWS_OUTPUT.getMsgType();
    }
}