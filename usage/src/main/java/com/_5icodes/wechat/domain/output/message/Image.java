package com._5icodes.wechat.domain.output.message;

import lombok.Data;

/**
 * 图片
 */
@Data
public class Image {
    // 通过素材管理中的接口上传多媒体文件，得到的id
    private String MediaId;
}