package com.dragon.mybatisplus.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author lilong
 */
@MapperScan("com.dragon.mybatisplus.mapper")
@Configuration
public class MybatisPlusConfig {
}
