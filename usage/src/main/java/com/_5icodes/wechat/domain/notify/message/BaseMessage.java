package com._5icodes.wechat.domain.notify.message;

import com._5icodes.wechat.domain.notify.BaseNotify;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 消息的公共字段类
 */
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Data
public abstract class BaseMessage extends BaseNotify {
    // 消息id，64位整型
    private String MsgId;
    // 消息的数据ID（消息如果来自文章时才有）
    private String MsgDataId;
    // 多图文时第几篇文章，从1开始（消息如果来自文章时才有）
    private String Idx;
}