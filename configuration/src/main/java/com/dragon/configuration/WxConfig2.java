package com.dragon.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 通过@ConfigurationProperties注解实现
 *
 * @author LiLong
 * @date 2020/12/20
 */
@Component
@Data
@ConfigurationProperties(prefix = "wx")
public class WxConfig2 {

    private String appId;

    private String appSecret;
}
