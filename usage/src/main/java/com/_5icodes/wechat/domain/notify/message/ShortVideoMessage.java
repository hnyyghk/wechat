package com._5icodes.wechat.domain.notify.message;

import com._5icodes.wechat.domain.notify.NotifyEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 小视频消息
 */
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Data
public class ShortVideoMessage extends BaseMessage {
    // 视频消息媒体id，可以调用多媒体文件下载接口拉取数据。
    private String MediaId;
    // 视频消息 视频消息缩略图的媒体id，可以调用多媒体文件下载接口拉取数据。
    private String ThumbMediaId;

    @Override
    public String getMsgType() {
        return NotifyEnum.SHORT_VIDEO_MESSAGE.getMsgType();
    }
}