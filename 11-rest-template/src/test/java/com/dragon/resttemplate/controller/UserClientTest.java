package com.dragon.resttemplate.controller;

import com.dragon.resttemplate.vo.R;
import com.dragon.resttemplate.vo.UserReqVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class UserClientTest {

    @Resource
    UserClient userClient;

    @Test
    public void getForObject() {

        R r = userClient.getForObject(9991);
        log.info("result : {}", r);
    }

    @Test
    public void getForEntity() {
         R r = userClient.getForEntity(9991);
         log.info("result ： {}", r);
    }

    @Test
    public void postForObject() {
        UserReqVO userReqVO = new UserReqVO();
        userReqVO.setUsername("张三");
        userReqVO.setPassword("123456");
        R r = userClient.postForObject(userReqVO);
        log.info("result : {}", r);
    }


    @Test
    public void postForEntity() {
        UserReqVO userReqVO = new UserReqVO();
        userReqVO.setUsername("张三");
        userReqVO.setPassword("123456");
        R r = userClient.postForEntity(userReqVO);
        log.info("result : {}", r);
    }

    @Test
    public void exchange() {
        R r = userClient.exchange(9991);
        log.info("result : {}", r);
    }



}