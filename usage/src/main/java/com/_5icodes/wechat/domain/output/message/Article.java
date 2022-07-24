package com._5icodes.wechat.domain.output.message;

import lombok.Data;

/**
 * 图文
 */
@Data
public class Article {
    // 图文消息标题
    private String Title;
    // 图文消息描述
    private String Description;
    // 图片链接，支持JPG、PNG格式，较好的效果为大图360*200，小图200*200
    private String PicUrl;
    // 点击图文消息跳转链接
    private String Url;
}