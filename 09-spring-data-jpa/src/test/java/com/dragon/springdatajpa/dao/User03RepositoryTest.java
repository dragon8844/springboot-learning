package com.dragon.springdatajpa.dao;

import com.dragon.springdatajpa.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Date;


@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class User03RepositoryTest {

    @Resource
    User03Repository user03Repository;

    @Test
    public void testFindByUsername(){
        User user = user03Repository.findByUsername("张三");
        log.info("user:{}", user.getUsername());
    }

    @Test
    public void findByCreateTimeAfter(){
        Sort sort = Sort.by("id").descending();
        PageRequest pageRequest = PageRequest.of(0,10,sort);
        Page<User> page = user03Repository.findByCreateTimeAfter(new Date(), pageRequest);
        log.info("page:{}",page.getTotalElements());
    }
}