package com._5icodes.wechat.domain.output.message;

import lombok.Data;

/**
 * 语音
 */
@Data
public class Voice {
    // 通过素材管理中的接口上传多媒体文件，得到的id
    private String MediaId;
}