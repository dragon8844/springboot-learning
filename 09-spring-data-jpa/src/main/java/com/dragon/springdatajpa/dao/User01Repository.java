package com.dragon.springdatajpa.dao;

import com.dragon.springdatajpa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Create By IntelliJ IDEA
 *
 * @author LiLong
 * @date 2020/12/24
 */
public interface User01Repository extends JpaRepository<User,Integer> {
}
