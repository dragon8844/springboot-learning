package com.dragon.tkmybatis.mapper;

import com.dragon.tkmybatis.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;

/**
 * @author lilong
 */
@Repository
public interface UserMapper extends Mapper<User> {

    /**
     * 根据username查询
     *
     * @param username
     * @return
     */
    default User selectByUsername(@Param("username") String username){
        Example example = new Example(User.class);
        // 创建 Criteria 对象，设置 username 查询条件
        example.createCriteria().andEqualTo("username", username);
        // 执行查询
        return selectOneByExample(example);
    }

    /**
     *  根据创建时间查询
     * @param createTime
     * @return
     */
    default List<User> selectByCreateTime(@Param("createTime") Date createTime) {
        Example example = new Example(User.class);
        // 创建 Criteria 对象，设置 create_time 查询条件
        example.createCriteria().andGreaterThan("createTime", createTime);
        return selectByExample(example);
    }
}
