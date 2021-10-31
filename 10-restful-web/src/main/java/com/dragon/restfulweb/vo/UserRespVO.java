package com.dragon.restfulweb.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author lilong
 */
@Data
public class UserRespVO implements Serializable {

    private Integer id;
    private String username;
    private Date createTime;
}
