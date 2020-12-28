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

    @RequestMapping("/wx-config")
    public String wxConfig() {
        return "appId: " + wxConfig.getAppId() + ",appSecret：" + wxConfig.getAppSecret();
    }
}
