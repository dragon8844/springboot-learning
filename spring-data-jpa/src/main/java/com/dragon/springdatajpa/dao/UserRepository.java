package com.dragon.springdatajpa.dao;

import com.dragon.springdatajpa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Create By IntelliJ IDEA
 *
 * @author LiLong
 * @date 2020/12/24
 */
public interface UserRepository extends JpaRepository<User,Long> {
}
