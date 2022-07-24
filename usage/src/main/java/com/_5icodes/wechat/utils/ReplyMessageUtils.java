package com._5icodes.wechat.utils;

import com._5icodes.wechat.domain.output.message.*;
import lombok.experimental.UtilityClass;

/**
 * 构建回复消息
 */
@UtilityClass
public class ReplyMessageUtils {
    /**
     * <pre>{@code
     * <xml>
     *     <ToUserName><![CDATA[toUser]]></ToUserName>
     *     <FromUserName><![CDATA[fromUser]]></FromUserName>
     *     <CreateTime>12345678</CreateTime>
     *     <MsgType><![CDATA[text]]></MsgType>
     *     <Content><![CDATA[你好]]></Content>
     * </xml>
     * }</pre>
     *
     * @param textOutput
     * @return
     * @Title sendTextMessage
     * @Description 回复文本消息
     */
    public String sendTextMessage(TextOutput textOutput) {
        return "<xml>" +
                "<ToUserName><![CDATA[" + textOutput.getToUserName() + "]]></ToUserName>" +
                "<FromUserName><![CDATA[" + textOutput.getFromUserName() + "]]></FromUserName>" +
                "<CreateTime>" + textOutput.getCreateTime() + "</CreateTime>" +
                "<MsgType><![CDATA[" + textOutput.getMsgType() + "]]></MsgType>" +
                "<Content><![CDATA[" + textOutput.getContent() + "]]></Content>" +
                "</xml>";
    }

    /**
     * <pre>{@code
     * <xml>
     *     <ToUserName><![CDATA[toUser]]></ToUserName>
     *     <FromUserName><![CDATA[fromUser]]></FromUserName>
     *     <CreateTime>12345678</CreateTime>
     *     <MsgType><![CDATA[image]]></MsgType>
     *     <Image>
     *         <MediaId><![CDATA[media_id]]></MediaId>
     *     </Image>
     * </xml>
     * }</pre>
     *
     * @param imageOutput
     * @return
     * @Title sendImageMessage
     * @Description 回复图片消息
     */
    public String sendImageMessage(ImageOutput imageOutput) {
        return "<xml>" +
                "<ToUserName><![CDATA[" + imageOutput.getToUserName() + "]]></ToUserName>" +
                "<FromUserName><![CDATA[" + imageOutput.getFromUserName() + "]]></FromUserName>" +
                "<CreateTime>" + imageOutput.getCreateTime() + "</CreateTime>" +
                "<MsgType><![CDATA[" + imageOutput.getMsgType() + "]]></MsgType>" +
                "<Image>" +
                "<MediaId><![CDATA[" + imageOutput.getImage().getMediaId() + "]]></MediaId>" +
                "</Image>" +
                "</xml>";
    }

    /**
     * <pre>{@code
     * <xml>
     *     <ToUserName><![CDATA[toUser]]></ToUserName>
     *     <FromUserName><![CDATA[fromUser]]></FromUserName>
     *     <CreateTime>12345678</CreateTime>
     *     <MsgType><![CDATA[voice]]></MsgType>
     *     <Voice>
     *         <MediaId><![CDATA[media_id]]></MediaId>
     *     </Voice>
     * </xml>
     * }</pre>
     *
     * @param voiceOutput
     * @return
     * @Title sendVoiceMessage
     * @Description 回复语音消息
     */
    public static String sendVoiceMessage(VoiceOutput voiceOutput) {
        return "<xml>" +
                "<ToUserName><![CDATA[" + voiceOutput.getToUserName() + "]]></ToUserName>" +
                "<FromUserName><![CDATA[" + voiceOutput.getFromUserName() + "]]></FromUserName>" +
                "<CreateTime>" + voiceOutput.getCreateTime() + "</CreateTime>" +
                "<MsgType><![CDATA[" + voiceOutput.getMsgType() + "]]></MsgType>" +
                "<Voice>" +
                "<MediaId><![CDATA[" + voiceOutput.getVoice().getMediaId() + "]]></MediaId>" +
                "</Voice>" +
                "</xml>";
    }

    /**
     * <pre>{@code
     * <xml>
     *     <ToUserName><![CDATA[toUser]]></ToUserName>
     *     <FromUserName><![CDATA[fromUser]]></FromUserName>
     *     <CreateTime>12345678</CreateTime>
     *     <MsgType><![CDATA[video]]></MsgType>
     *     <Video>
     *         <MediaId><![CDATA[media_id]]></MediaId>
     *         <Title><![CDATA[title]]></Title>
     *         <Description><![CDATA[description]]></Description>
     *     </Video>
     * </xml>
     * }</pre>
     *
     * @param videoOutput
     * @return
     * @Title sendVideoMessage
     * @Description 回复视频消息
     */
    public static String sendVideoMessage(VideoOutput videoOutput) {
        StringBuilder sb = new StringBuilder();
        sb.append("<xml>");
        sb.append("<ToUserName><![CDATA[").append(videoOutput.getToUserName()).append("]]></ToUserName>");
        sb.append("<FromUserName><![CDATA[").append(videoOutput.getFromUserName()).append("]]></FromUserName>");
        sb.append("<CreateTime>").append(videoOutput.getCreateTime()).append("</CreateTime>");
        sb.append("<MsgType><![CDATA[").append(videoOutput.getMsgType()).append("]]></MsgType>");
        sb.append("<Video>");
        sb.append("<MediaId><![CDATA[").append(videoOutput.getVideo().getMediaId()).append("]]></MediaId>");
        if (!"".equals(videoOutput.getVideo().getTitle())) {
            sb.append("<Title><![CDATA[").append(videoOutput.getVideo().getTitle()).append("]]></Title>");
        }
        if (!"".equals(videoOutput.getVideo().getDescription())) {
            sb.append("<Description><![CDATA[").append(videoOutput.getVideo().getDescription()).append("]]></Description>");
        }
        sb.append("</Video>");
        sb.append("</xml>");
        return sb.toString();
    }

    /**
     * <pre>{@code
     * <xml>
     *     <ToUserName><![CDATA[toUser]]></ToUserName>
     *     <FromUserName><![CDATA[fromUser]]></FromUserName>
     *     <CreateTime>12345678</CreateTime>
     *     <MsgType><![CDATA[music]]></MsgType>
     *     <Music>
     *         <Title><![CDATA[TITLE]]></Title>
     *         <Description><![CDATA[DESCRIPTION]]></Description>
     *         <MusicUrl><![CDATA[MUSIC_Url]]></MusicUrl>
     *         <HQMusicUrl><![CDATA[HQ_MUSIC_Url]]></HQMusicUrl>
     *         <ThumbMediaId><![CDATA[media_id]]></ThumbMediaId>
     *     </Music>
     * </xml>
     * }</pre>
     *
     * @param musicOutput
     * @return
     * @Title sendMusicMessage
     * @Description 回复音乐消息
     */
    public static String sendMusicMessage(MusicOutput musicOutput) {
        StringBuilder sb = new StringBuilder();
        sb.append("<xml>");
        sb.append("<ToUserName><![CDATA[").append(musicOutput.getToUserName()).append("]]></ToUserName>");
        sb.append("<FromUserName><![CDATA[").append(musicOutput.getFromUserName()).append("]]></FromUserName>");
        sb.append("<CreateTime>").append(musicOutput.getCreateTime()).append("</CreateTime>");
        sb.append("<MsgType><![CDATA[").append(musicOutput.getMsgType()).append("]]></MsgType>");
        sb.append("<Music>");
        if (!"".equals(musicOutput.getMusic().getTitle())) {
            sb.append("<Title><![CDATA[").append(musicOutput.getMusic().getTitle()).append("]]></Title>");
        }
        if (!"".equals(musicOutput.getMusic().getDescription())) {
            sb.append("<Description><![CDATA[").append(musicOutput.getMusic().getDescription()).append("]]></Description>");
        }
        if (!"".equals(musicOutput.getMusic().getMusicUrl())) {
            sb.append("<MusicUrl><![CDATA[").append(musicOutput.getMusic().getMusicUrl()).append("]]></MusicUrl>");
        }
        if (!"".equals(musicOutput.getMusic().getHQMusicUrl())) {
            sb.append("<HQMusicUrl><![CDATA[").append(musicOutput.getMusic().getHQMusicUrl()).append("]]></HQMusicUrl>");
        }
        sb.append("<ThumbMediaId><![CDATA[").append(musicOutput.getMusic().getThumbMediaId()).append("]]></ThumbMediaId>");
        sb.append("</Music>");
        sb.append("</xml>");
        return sb.toString();
    }

    /**
     * <pre>{@code
     * <xml>
     *     <ToUserName><![CDATA[toUser]]></ToUserName>
     *     <FromUserName><![CDATA[fromUser]]></FromUserName>
     *     <CreateTime>12345678</CreateTime>
     *     <MsgType><![CDATA[news]]></MsgType>
     *     <ArticleCount>1</ArticleCount>
     *     <Articles>
     *         <item>
     *             <Title><![CDATA[title1]]></Title>
     *             <Description><![CDATA[description1]]></Description>
     *             <PicUrl><![CDATA[picurl]]></PicUrl>
     *             <Url><![CDATA[url]]></Url>
     *         </item>
     *     </Articles>
     * </xml>
     * }</pre>
     *
     * @param newsOutput
     * @return
     * @Title sendImageTextMessage
     * @Description 回复图文消息
     */
    public static String sendImageTextMessage(NewsOutput newsOutput) {
        StringBuilder sb = new StringBuilder();
        sb.append("<xml>");
        sb.append("<ToUserName><![CDATA[").append(newsOutput.getToUserName()).append("]]></ToUserName>");
        sb.append("<FromUserName><![CDATA[").append(newsOutput.getFromUserName()).append("]]></FromUserName>");
        sb.append("<CreateTime>").append(newsOutput.getCreateTime()).append("</CreateTime>");
        sb.append("<MsgType><![CDATA[").append(newsOutput.getMsgType()).append("]]></MsgType>");
        sb.append("<ArticleCount>").append(newsOutput.getArticleCount()).append("</ArticleCount>");
        sb.append("<Articles> ");
        for (Article article : newsOutput.getArticles()) {
            sb.append("<item>");
            sb.append("<Title><![CDATA[").append(article.getTitle()).append("]]></Title>");
            sb.append("<Description><![CDATA[").append(article.getDescription()).append("]]></Description>");
            sb.append("<PicUrl><![CDATA[").append(article.getPicUrl()).append("]]></PicUrl>");
            sb.append("<Url><![CDATA[").append(article.getUrl()).append("]]></Url>");
            sb.append("</item>");
        }
        sb.append("</Articles>");
        sb.append("</xml>");
        return sb.toString();
    }
}