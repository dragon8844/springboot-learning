package com.dragon.jdbctemplate.mapper;

import com.dragon.jdbctemplate.entity.User;

/**
 * @author lilong
 */
public interface UserDao {

    /**
     * 新增
     *
     * @param user
     * @return
     */
    Integer insert(User user);

    /**
     * 根据ID查询
     *
     * @param id
     * @return
     */
    User selectById(Integer id);

    /**
     * 根据username查询
     *
     * @param username
     * @return
     */
    User selectByUsername(String username);

    /**
     * 根据ID更新
     *
     * @param user
     * @return
     */
    Integer updateById(User user);


    /**
     * 根据ID删除
     *
     * @param id
     * @return
     */
    Integer deleteById(Integer id);


}
