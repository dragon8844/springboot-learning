package com.dragon.tkmybatis.config;

import org.springframework.context.annotation.Configuration;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author lilong
 */
@MapperScan(basePackages = "com.dragon.tkmybatis.mapper")
@Configuration
public class MybatisConfig {
}
