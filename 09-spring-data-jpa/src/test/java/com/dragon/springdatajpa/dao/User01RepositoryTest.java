package com.dragon.springdatajpa.dao;

import com.dragon.springdatajpa.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class User01RepositoryTest {

    @Resource
    User01Repository user01Repository;

    @Test
    public void testInsert(){
        User user = new User();
        user.setDeleted(0);
        user.setUsername("张三");
        user.setCreateTime(new Date());
        user.setPassword("123456");
        user01Repository.save(user);
    }

    @Test
    public void testSelectById(){
        Optional<User> userOptional = user01Repository.findById(13);
        if(userOptional.isPresent()){
            User user = userOptional.get();
            log.info("user: {}", user.getId());
        }
    }

    @Test
    public void testUpdateById(){
        Optional<User> userOptional = user01Repository.findById(13);
        if(userOptional.isPresent()){
            User user = userOptional.get();
            user.setUsername("李四");
            user = user01Repository.save(user);
            log.info("user: {}", user.getUsername());
        }
    }

    @Test
    public void testDeleteBy(){
        user01Repository.deleteById(13);
    }

}