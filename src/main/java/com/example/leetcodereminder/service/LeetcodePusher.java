package com.example.leetcodereminder.service;

import com.alibaba.fastjson.JSONObject;
import com.example.leetcodereminder.model.LCProblem;
import me.chanjar.weixin.mp.api.WxMpInMemoryConfigStorage;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateData;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateMessage;

public class LeetcodePusher {
    /**
     * 测试号的appId和secret
     */
    private static String appId = "wx3f6c3303cec0f31e";
    private static String secret = "e647eb10966820b3036e4aede9e60408";

    public static void push(String openId, String templateId, LCProblem lc) {
        //1，配置
        WxMpInMemoryConfigStorage wxStorage = new WxMpInMemoryConfigStorage();
        wxStorage.setAppId(appId);
        wxStorage.setSecret(secret);
        WxMpService wxMpService = new WxMpServiceImpl();
        wxMpService.setWxMpConfigStorage(wxStorage);
//        JSONObject lc = LCProblem.getLC();
        //2,推送消息
        WxMpTemplateMessage templateMessage = WxMpTemplateMessage.builder()
                .toUser(openId)
                .templateId(templateId)
                .url("https://leetcode.cn/problems/" + lc.getName() + "/")//点击模版消息要访问的网址
                .build();
        //3,如果是正式版发送模版消息，这里需要配置你的信息
        //        templateMessage.addData(new WxMpTemplateData("name", "value", "#FF00FF"));
        //                templateMessage.addData(new WxMpTemplateData(name2, value2, color2));
        //填写变量信息，比如天气之类的
        templateMessage.addData(new WxMpTemplateData("lcName", lc.getName(), "#FF6347"));
        templateMessage.addData(new WxMpTemplateData("lcDiff", lc.getDifficulty(), "#fac519"));
        try {
            System.out.println(templateMessage.toJson());
            System.out.println(wxMpService.getTemplateMsgService().sendTemplateMsg(templateMessage));
        } catch (Exception e) {
            System.out.println("推送失败：" + e.getMessage());
            e.printStackTrace();
        }
    }

}
