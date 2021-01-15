package com.dragon.mybatisannotation.mapper;

import com.dragon.mybatisannotation.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

/**
 * @author lilong
 */
@Repository
public interface UserMapper {

    /**
     *  新增
     * @param user
     * @return
     */
    @Insert("INSERT INTO user(username, password, create_time) VALUES(#{username}, #{password}, #{createTime})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    Integer insert(User user);

    /**
     *  根据ID查询
     * @param id
     * @return
     */
    @Select("SELECT username, password, create_time FROM user WHERE id = #{id}")
    User selectById(Integer id);

    /**
     *  根据username查询
     * @param username
     * @return
     */
    @Select("SELECT username, password, create_time FROM user WHERE username = #{username}")
    User selectByUsername(String username);

    /**
     *  根据ID更新
     * @param user
     * @return
     */
    @Update(value = {
            "<script>",
            "UPDATE user",
            "<set>",
            "<if test='username != null'>, username = #{username}</if>",
            "<if test='password != null'>, password = #{password}</if>",
            "</set>",
            "</script>"
    })
    Integer updateById(User user);


    /**
     *  根据ID删除
     * @param id
     * @return
     */
    @Insert("DELETE FROM user WHERE id = #{id}")
    Integer deleteById(Integer id);


}
