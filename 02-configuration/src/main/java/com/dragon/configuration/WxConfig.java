package com.dragon.configuration;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 通过配置类基于 @Value注解实现
 *
 * @author LiLong
 * @date 2020/12/20
 */
@Component
@Data
public class WxConfig {

    @Value("${wx.appId}")
    private String appId;

    @Value("${wx.appSecret}")
    private String appSecret;

}
