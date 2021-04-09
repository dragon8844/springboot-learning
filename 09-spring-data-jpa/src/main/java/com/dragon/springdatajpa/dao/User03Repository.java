package com.dragon.springdatajpa.dao;

import com.dragon.springdatajpa.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Date;
import java.util.List;

/**
 * 基于方法名查询
 *
 * @author LiLong
 * @date 2020/12/24
 */
public interface User03Repository extends PagingAndSortingRepository<User,Integer> {
    /**
     *  通过username查询
     * @param username
     * @return
     */
    User findByUsername(String username);

    /**
     * 分页查询指定时间后的用户
     * @param createTime
     * @param pageable
     * @return
     */
    Page<User> findByCreateTimeAfter(Date createTime, Pageable pageable);






}
