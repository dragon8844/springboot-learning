package com.dragon.configuration;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Create By IntelliJ IDEA
 *
 * @author LiLong
 * @date 2020/12/20
 */
@RestController
public class WxConfigController {
    @Resource
    private WxConfig wxConfig;
    @Resource
    private WxConfig2 wxConfig2;

    @RequestMapping("/wx-config")
    public String wxConfig() {
        return "appId: " + wxConfig.getAppId() + ",appSecret：" + wxConfig.getAppSecret();
    }


    @RequestMapping("/wx-config2")
    public String wxConfig2() {
        return "appId: " + wxConfig2.getAppId() + ",appSecret：" + wxConfig2.getAppSecret();
    }
}
