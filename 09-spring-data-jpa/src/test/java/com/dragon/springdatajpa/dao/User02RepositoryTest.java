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


@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class User02RepositoryTest {

    @Resource
    User02Repository user02Repository;


    @Test
    //排序
    public void testList(){
        Sort sort = Sort.by("id").descending();
        Iterable<User> iterable = user02Repository.findAll(sort);
        iterable.forEach(System.out :: println);
    }


    @Test
    //分页
    public void testPage(){
        Sort sort = Sort.by("id").descending();
        PageRequest pageRequest = PageRequest.of(0,10,sort);
        Page<User> page = user02Repository.findAll(pageRequest);
        log.info("page: {}", page.getTotalElements());
        log.info("content:{}", page.getContent());
    }

}