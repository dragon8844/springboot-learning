package com.dragon.mybatisannotation.mapper;

import com.dragon.mybatisannotation.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.Date;

@Slf4j
@SpringBootTest
class UserMapperTest {

    @Resource
    private UserMapper userMapper;

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
    void selectById() {
        User user = userMapper.selectById(12);
        log.info("user:{}",user.toString());
    }

    @Test
    void selectByUsername() {
        User user = userMapper.selectByUsername("张三");
        log.info("user:{}", user.toString());
    }

    @Test
    void updateById() {
        User user = new User();
        user.setUsername("李四");
        user.setPassword("111111");
        Integer count = userMapper.updateById(user);
        log.info("count:{}",count);
    }

    @Test
    void deleteById() {
        Integer count = userMapper.deleteById(12);
        log.info("count:{}",count);
    }

}