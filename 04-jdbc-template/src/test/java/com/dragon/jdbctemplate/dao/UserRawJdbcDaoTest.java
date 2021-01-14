package com.dragon.jdbctemplate.dao;

import com.dragon.jdbctemplate.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.Date;

@SpringBootTest
@Slf4j
class UserRawJdbcDaoTest {

    @Resource
    UserRawJdbcDao userRawJdbcDao;

    @Test
    void insert() {
        User user = new User();
        user.setUsername("张三");
        user.setPassword("123456");
        user.setCreateTime(new Date());
        userRawJdbcDao.insert(user);
        log.info("userId:{}",user.getId());
    }

    @Test
    void selectById() {
        User user = userRawJdbcDao.selectById(7);
        log.info("user:{}",user);
    }

    @Test
    void selectByUsername() {
        User user = userRawJdbcDao.selectByUsername("张三");
        log.info("user:{}",user);
    }

    @Test
    void updateById() {
        User user = userRawJdbcDao.selectById(7);
        user.setUsername("李四");
        Integer count = userRawJdbcDao.updateById(user);
        log.info("count:{}",count);
    }

    @Test
    void deleteById() {
        Integer count = userRawJdbcDao.deleteById(7);
        log.info("count:{}",count);
    }
}