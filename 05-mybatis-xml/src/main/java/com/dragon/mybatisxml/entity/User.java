package com.dragon.mybatisxml.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author lilong
 */
@Data
public class User {

    /**
     * 主键
     */
    private Integer id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 创建时间
     */
    private Date createTime;

}
