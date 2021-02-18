package com.dragon.tkmybatis.mapper;

import com.dragon.tkmybatis.entity.User;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


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

    @Test // 更多使用，可以参考 https://github.com/pagehelper/Mybatis-PageHelper/blob/master/wikis/zh/HowToUse.md
    public void testSelectPageByCreateTime() {
        // 设置分页
        PageHelper.startPage(1, 10);
        Date createTime = new Date(2018 - 1990, Calendar.FEBRUARY, 24); // 临时 Demo ，实际不建议这么写
        // 执行列表查询
        // PageHelper 会自动发起分页的数量查询，设置到 PageHelper 中
        List<User> users = userMapper.selectByCreateTime(createTime); // 实际返回的是 com.github.pagehelper.Page 代理对象
        // 转换成 PageInfo 对象，并输出分页
        PageInfo<User> page = new PageInfo<>(users);
        System.out.println(page.getTotal());
    }
}