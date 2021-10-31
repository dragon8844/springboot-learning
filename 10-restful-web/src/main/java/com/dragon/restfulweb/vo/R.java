package com.dragon.restfulweb.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * 定义统一响应的对象
 * @author lilong
 * @param <T>
 *
 */
@Data
public class R<T> implements Serializable {
    private static final String DEFAULT_SUCCESS_MSG = "请求成功";
    private static final int DEFAULT_SUCCESS_CODE = 0;
    public static final int SUCCESS = DEFAULT_SUCCESS_CODE;

    private Integer code;
    private String msg;
    private T data;

    public static<T> R ok(T data){
        R jsonResult = new R();
        jsonResult.setCode(DEFAULT_SUCCESS_CODE);
        jsonResult.setMsg(DEFAULT_SUCCESS_MSG);
        jsonResult.setData(data);
        return jsonResult;
    }

    public static<T> R err(int code, String msg , T data){
        R jsonResult = new R();
        jsonResult.setCode(code);
        jsonResult.setMsg(msg);
        jsonResult.setData(data);
        return jsonResult;
    }

    public static<T> R err(int code, String msg){
        R jsonResult = new R();
        jsonResult.setCode(code);
        jsonResult.setMsg(msg);
        return jsonResult;
    }

}
