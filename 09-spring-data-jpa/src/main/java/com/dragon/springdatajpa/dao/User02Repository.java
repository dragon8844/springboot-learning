package com.dragon.springdatajpa.dao;

import com.dragon.springdatajpa.entity.User;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * 排序和分页实现
 *
 * @author LiLong
 * @date 2020/12/24
 */
public interface User02Repository extends PagingAndSortingRepository<User,Integer> {

}
