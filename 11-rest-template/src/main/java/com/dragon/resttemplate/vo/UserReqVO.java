package com.dragon.resttemplate.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author lilong
 */
@Data
public class UserReqVO implements Serializable {

    private String username;
    private String password;

}
