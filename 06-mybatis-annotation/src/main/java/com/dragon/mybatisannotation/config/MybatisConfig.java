package com.dragon.mybatisannotation.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author lilong
 */
@MapperScan(basePackages = "com.dragon.mybatisannotation.mapper")
@Configuration
public class MybatisConfig {
}
