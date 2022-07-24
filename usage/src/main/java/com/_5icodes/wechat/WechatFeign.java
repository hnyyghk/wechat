package com._5icodes.wechat;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@FeignClient(name = "wechat", url = "https://api.weixin.qq.com", path = "/cgi-bin")
public interface WechatFeign {
    /**
     * 获取access_token的接口地址(GET) 限2000(次/天)
     *
     * @param grant_type
     * @param appid
     * @param secret
     * @return
     */
    @GetMapping("/token")
    String token(@RequestParam String grant_type, @RequestParam String appid, @RequestParam String secret);

    /**
     * 发送自定义消息
     *
     * @param access_token
     * @param map
     * @return
     */
    @PostMapping("/message/custom/send")
    String sendCustomMessage(@RequestParam String access_token, @RequestBody Map<String, Object> map);

    /**
     * 发送模板消息
     *
     * @param access_token
     * @param map
     * @return
     */
    @PostMapping("/message/template/send")
    String sendTemplateMessage(@RequestParam String access_token, @RequestBody Map<String, Object> map);

    /**
     * 创建自定义菜单
     *
     * @param access_token
     * @param map
     * @return
     */
    @PostMapping("/menu/create")
    String createMenu(@RequestParam String access_token, @RequestBody Map<String, Object> map);

    /**
     * 查询自定义菜单
     *
     * @param access_token
     * @param map
     * @return
     */
    @PostMapping("/menu/get")
    String getMenu(@RequestParam String access_token, @RequestBody Map<String, Object> map);

    /**
     * 删除自定义菜单
     *
     * @param access_token
     * @param map
     * @return
     */
    @PostMapping("/menu/delete")
    String deleteMenu(@RequestParam String access_token, @RequestBody Map<String, Object> map);

    /**
     * 获取jsapi_ticket的接口地址(GET) 限2000(次/天)
     *
     * @param access_token
     * @param type
     * @return
     */
    @GetMapping("/ticket/getticket")
    String getTicket(@RequestParam String access_token, @RequestParam String type);
}