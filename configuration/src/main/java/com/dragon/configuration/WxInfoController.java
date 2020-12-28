package com.dragon.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Create By IntelliJ IDEA
 *
 * @author LiLong
 * @date 2020/12/20
 */
@RestController
public class WxInfoController {
    @Value("${wx.appId}")
    private String appId;
    @Value("${wx.appSecret}")
    private String appSecret;

    @RequestMapping("/wx-info")
    public String wxInfo() {
        return "appId: " + appId + ",appSecret：" + appSecret;
    }
}
