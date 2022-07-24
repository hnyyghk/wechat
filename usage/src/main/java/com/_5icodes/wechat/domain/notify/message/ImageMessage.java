package com._5icodes.wechat.domain.notify.message;

import com._5icodes.wechat.domain.notify.NotifyEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 图片消息
 */
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Data
public class ImageMessage extends BaseMessage {
    // 图片链接
    private String PicUrl;
    // 图片消息媒体id，可以调用多媒体文件下载接口拉取数据。
    private String MediaId;

    @Override
    public String getMsgType() {
        return NotifyEnum.IMAGE_MESSAGE.getMsgType();
    }
}