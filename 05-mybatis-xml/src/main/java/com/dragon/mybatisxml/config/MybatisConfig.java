package com.dragon.mybatisxml.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author lilong
 */
@MapperScan(basePackages = "com.dragon.mybatisxml.mapper")
@Configuration
public class MybatisConfig {
}
