package com.dragon.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dragon.mybatisplus.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author lilong
 */
@Repository
public interface UserMapper extends BaseMapper<User> {

    /**
     * 根据username查询
     *
     * @param username
     * @return
     */
    default User selectByUsername(@Param("username") String username) {
        LambdaQueryWrapper<User> wrapper = new QueryWrapper<User>().lambda();
        return selectOne(wrapper.eq(User::getUsername, username));
    }

}
