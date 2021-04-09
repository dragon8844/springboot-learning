package com.dragon.springdatajpa.dao;

import com.dragon.springdatajpa.entity.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

/**
 * 基于注解查询
 *
 * @author LiLong
 * @date 2020/12/24
 */
public interface User04Repository extends PagingAndSortingRepository<User,Integer> {

    /**
     *  使用 @Query 自定义了一个 SQL 操作，并且参数使用占位符(?) + 参数位置的形式
     * @param username
     * @return
     */
    @Query("SELECT u FROM User u WHERE u.username = ?1")
    User findByUsername01(String username);

    /**
     *  使用占位符(:) + 参数名字(需要使用 @Param 声明)的形式。
     * @param username
     * @return
     */
    @Query("SELECT u FROM User u WHERE u.username = :username")
    User findByUsername02(@Param("username") String username);

    /**
     *  增加了 nativeQuery = true ，表示在 @Query 自定义的是原生SQL
     * @param username
     * @return
     */
    @Query(value = "SELECT * FROM user u WHERE u.username = :username", nativeQuery = true)
    User findByUsername03(@Param("username") String username);

    /**
     *  定义了更新操作，需要加上 @Modifying 注解
     * @param id
     * @param username
     * @return
     */
    @Query("UPDATE User  u SET u.username = :username WHERE u.id = :id")
    @Modifying
    Integer updateUsernameById(Integer id, String username);






}
