package com.dragon.springdatajpa.dao;

import com.dragon.springdatajpa.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class User04RepositoryTest {

    @Resource
    User04Repository user04Repository;


    @Test
    public void testFindByUsername01(){
        User user = user04Repository.findByUsername01("张三");
        log.info("user:{}", user.getUsername());

    }


    @Test
    public void testFindByUsername02(){
        User user = user04Repository.findByUsername02("张三");
        log.info("user:{}", user.getUsername());

    }


    @Test
    public void testFindByUsername03(){
        User user = user04Repository.findByUsername03("张三");
        log.info("user:{}", user.getUsername());

    }


    @Test
    @Transactional
    public void testUpdateUsernameById(){
        Integer count = user04Repository.updateUsernameById(14,"修改");
        log.info("count:{}", count);

    }

}