package com._5icodes.wechat.domain.output.message;

import lombok.Data;

/**
 * 视频
 */
@Data
public class Video {
    // 通过素材管理中的接口上传多媒体文件，得到的id
    private String MediaId;
    // 视频消息的标题
    private String Title;
    // 视频消息的描述
    private String Description;
}