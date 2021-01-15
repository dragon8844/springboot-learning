package com.dragon.tkmybatis.mapper;

import com.dragon.tkmybatis.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.Date;


/**
 * @author lilong
 */
@SpringBootTest
@Slf4j
class UserMapperTest {

    @Resource
    UserMapper userMapper;


    @Test
    void insert() {
        User user = new User();
        user.setUsername("张三");
        user.setPassword("123456");
        user.setCreateTime(new Date());
        Integer count = userMapper.insert(user);
        log.info("count:{}", count);
    }

    @Test
    void selectByPrimaryKey() {
        User user = userMapper.selectByPrimaryKey(14);
        log.info("user:{}", user.toString());
    }

    @Test
    void selectByUsername() {
        User user = userMapper.selectByUsername("李四");
        log.info("user:{}", user.toString());
    }

    @Test
    void updateByPrimaryKey() {
        User user = new User();
        user.setId(14);
        user.setUsername("李四");
        user.setPassword("111111");
        Integer count = userMapper.updateByPrimaryKey(user);
        log.info("count:{}", count);
    }

    @Test
    void deleteByPrimaryKey() {
        Integer count = userMapper.deleteByPrimaryKey(14);
        log.info("count:{}", count);
    }

}