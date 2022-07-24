package com._5icodes.wechat.factory.message;

import com._5icodes.wechat.annotation.NotifyType;
import com._5icodes.wechat.domain.notify.NotifyEnum;
import com._5icodes.wechat.domain.notify.message.ImageMessage;
import com._5icodes.wechat.domain.output.message.Article;
import com._5icodes.wechat.domain.output.message.NewsOutput;
import com._5icodes.wechat.factory.WechatNotify;
import com._5icodes.wechat.utils.ReplyMessageUtils;
import com._5icodes.wechat.utils.WXBizMsgCrypt;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@NotifyType(NotifyEnum.IMAGE_MESSAGE)
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public abstract class ImageMessageNotify implements WechatNotify<ImageMessage> {
    @Autowired
    private WXBizMsgCrypt wxBizMsgCrypt;

    @Override
    public String wechatNotify(ImageMessage message) throws Exception {
        log.info(message.toString());
        // 发送方帐号
        String fromUserName = message.getFromUserName();
        // 开发者微信号
        String toUserName = message.getToUserName();

        // 这里回复图片 或者图文消息 以图文消息为例
        NewsOutput output = new NewsOutput();
        output.setCreateTime(Long.toString(System.currentTimeMillis()));
        output.setFromUserName(toUserName);
        output.setToUserName(fromUserName);

        Article article = new Article();
        // 图文消息描述
        article.setDescription("图文消息描述");
        // 图文消息图片地址
        article.setPicUrl("https://p4.ssl.cdn.btime.com/dmfd/192_108_/t019d0b65e33000f8a0.jpg?size=458x240");
        // 图文消息标题
        article.setTitle("图文消息标题");
        // 图文url链接
        article.setUrl("https://www.baidu.com");
        // 这里发送的是单图文，如果需要发送多图文则在这里 list 中加入多个Article
        List<Article> list = new ArrayList<>();
        list.add(article);
        output.setArticleCount(list.size());
        output.setArticles(list);

        String replyMsg = ReplyMessageUtils.sendImageTextMessage(output);
        return wxBizMsgCrypt.encryptMsg(replyMsg, "", "");
    }
}