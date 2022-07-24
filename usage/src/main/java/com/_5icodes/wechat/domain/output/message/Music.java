package com._5icodes.wechat.domain.output.message;

import lombok.Data;

/**
 * 音乐
 */
@Data
public class Music {
    // 音乐标题
    private String Title;
    // 音乐描述
    private String Description;
    // 音乐链接
    private String MusicUrl;
    // 高质量音乐链接，WIFI环境优先使用该链接播放音乐
    private String HQMusicUrl;
    // 缩略图的媒体id，通过素材管理中的接口上传多媒体文件，得到的id
    private String ThumbMediaId;
}