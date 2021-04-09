package com.dragon.springdatajpa.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * @author lilong
 */
@Entity
@Table(name = "user")
@Data
public class User {

    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY,  // strategy 设置使用数据库主键自增策略；
            generator = "JDBC")
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

    /**
     * 是否删除
     */
    private Integer deleted;
}
