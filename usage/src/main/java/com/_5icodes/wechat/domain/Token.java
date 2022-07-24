package com._5icodes.wechat.domain;

import lombok.Data;

/**
 * token凭证 签名
 * {"errcode":40164,"errmsg":"invalid ip 112.10.209.170 ipv6 ::ffff:112.10.209.170, not in whitelist rid: 62dad84a-62c7fcd3-489205b4"}
 * {"errcode":40164,"errmsg":"invalid ip 112.10.209.170 ipv6 ::ffff:112.10.209.170, not in whitelist rid: 62dad934-53c17937-793f1009"}
 */
@Data
public class Token {
    // 接口访问凭证
    private String accessToken;
    // 有效期限
    private Integer expiresIn;
    // 获取token的最新时间
    private Long addTime;
    // 签名
    private String ticket;
    private String errCode;
    private String errMsg;
}