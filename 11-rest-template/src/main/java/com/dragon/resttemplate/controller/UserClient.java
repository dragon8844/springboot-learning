package com.dragon.resttemplate.controller;

import com.dragon.resttemplate.vo.R;
import com.dragon.resttemplate.vo.UserReqVO;
import com.dragon.resttemplate.vo.UserRespVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author lilong
 */
@Component
@Slf4j
public class UserClient {

    @Resource
    RestTemplate restTemplate;

    public R<UserRespVO> getForObject(Integer id){
        Map<String, Object> uriVariables = new HashMap<>(1);
        uriVariables.put("id", id);
        R r = restTemplate.getForObject("http://localhost:8080/v1/user/{id}", R.class, uriVariables);
        return r;
    }

    public R<UserRespVO> getForEntity(Integer id){
        Map<String, Object> uriVariables = new HashMap<>(1);
        uriVariables.put("id", id);
        ResponseEntity<R> r = restTemplate.getForEntity("http://localhost:8080/v1/user/{id}", R.class,uriVariables);
        log.info(r.getHeaders().toString());
        return r.getBody();
    }

    public R<Boolean>  postForObject(UserReqVO userReqVO){
        R r = restTemplate.postForObject("http://localhost:8080/v1/user", userReqVO, R.class);
        return r;
    }

    public R<Boolean> postForEntity(UserReqVO userReqVO){
        ResponseEntity<R> r = restTemplate.postForEntity("http://localhost:8080/v1/user", userReqVO, R.class);
        log.info(r.getHeaders().toString());
        return r.getBody();
    }

    /**
     *  exchange 是一个通用且统一的方法，它既能发送 GET 和 POST 请求，也能用于发送其他各种类型的请求。
     * @return
     */
    public R<UserRespVO> exchange(Integer id){
        Map<String, Object> uriVariables = new HashMap<>(1);
        uriVariables.put("id", id);
        ResponseEntity<R> r = restTemplate.exchange("http://localhost:8080/v1/user/{id}", HttpMethod.GET, null, R.class, uriVariables);
        log.info(r.getHeaders().toString());
        return r.getBody();
    }

    public R<Boolean> put(Integer id, UserReqVO userReqVO){
        restTemplate.put("http://localhost:8080/v1/user/{id}", userReqVO, id);
        return R.ok(true);
    }

    public R<Boolean> delete(Integer id){
        restTemplate.delete("http://localhost:8080/v1/user/{id}", id);
        return R.ok(true);
    }
}
