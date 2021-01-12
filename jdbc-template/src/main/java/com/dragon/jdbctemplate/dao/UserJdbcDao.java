package com.dragon.jdbctemplate.dao;

import com.dragon.jdbctemplate.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Types;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *  JDBC Template
 * @author lilong
 */
@Repository
public class UserJdbcDao implements UserDao{

    /**
     * 声明 INSERT 操作的 PreparedStatementCreatorFactory 对象
     */
    private static final PreparedStatementCreatorFactory INSERT_PREPARED_STATEMENT_CREATOR_FACTORY
            = new PreparedStatementCreatorFactory("INSERT INTO user(username, password, create_time) VALUES(?, ?, ?)");

    static {
        // 设置返回主键
        INSERT_PREPARED_STATEMENT_CREATOR_FACTORY.setReturnGeneratedKeys(true);
        INSERT_PREPARED_STATEMENT_CREATOR_FACTORY.setGeneratedKeysColumnNames("id");
        // 设置每个占位符的类型
        INSERT_PREPARED_STATEMENT_CREATOR_FACTORY.addParameter(new SqlParameter(Types.VARCHAR));
        INSERT_PREPARED_STATEMENT_CREATOR_FACTORY.addParameter(new SqlParameter(Types.VARCHAR));
        INSERT_PREPARED_STATEMENT_CREATOR_FACTORY.addParameter(new SqlParameter(Types.TIMESTAMP));
    }

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public Integer insert(User user){
        // 创建 KeyHolder 对象，设置返回的主键 ID
        KeyHolder keyHolder = new GeneratedKeyHolder();
        int count = jdbcTemplate.update(INSERT_PREPARED_STATEMENT_CREATOR_FACTORY.newPreparedStatementCreator(
                Arrays.asList(user.getUsername(),user.getPassword(),user.getCreateTime())),keyHolder);
        // 设置 ID 主键到 entity 实体中
        if (keyHolder.getKey() != null) {
            user.setId(keyHolder.getKey().intValue());
        }
        // 返回影响行数
        return count;
    }


    /**
     * 使用 SimpleJdbcInsert 实现插入数据
     *
     * @param user 实体
     * @return 影响行数
     */
    private Integer insert0(User user) {
        // 创建 SimpleJdbcInsert 对象
        SimpleJdbcInsert insertOp = new SimpleJdbcInsert(jdbcTemplate);
        insertOp.setTableName("users");
        insertOp.setColumnNames(Arrays.asList("username", "password", "create_time"));
        insertOp.setGeneratedKeyName("id");
        // 拼接参数
        Map<String, Object> params = new HashMap<>();
        params.put("username", user.getUsername());
        params.put("password", user.getPassword());
        params.put("create_time", user.getCreateTime());
        // 执行插入操作
        Number id = insertOp.executeAndReturnKey(params);
        // 设置 ID 主键到 entity 实体中
        user.setId(id.intValue());
        // 返回影响行数
        return 1;
    }

    @Override
    public User selectById(Integer id){
        User result = jdbcTemplate.queryForObject("SELECT id, username, password, create_time FROM user WHERE id=?",
                new BeanPropertyRowMapper<>(User.class), id);
        return result;
    }

    @Override
    public User selectByUsername(String username) {
        return jdbcTemplate.queryForObject("SELECT id, username, password, create_time FROM user WHERE username = ? LIMIT 1",
                // 结果转换成对应的对象
                new BeanPropertyRowMapper<>(User.class),
                username);
    }

    @Override
    public Integer updateById(User user) {
        return jdbcTemplate.update("UPDATE user SET username = ?, password = ? WHERE id = ?",
                user.getUsername(),user.getPassword(),user.getId());
    }

    @Override
    public Integer deleteById(Integer id){
        return jdbcTemplate.update("DELETE FROM user WHERE id = ?", id);
    }

}
