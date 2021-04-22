package com.dragon.restfulweb.controller;

import com.dragon.restfulweb.vo.R;
import com.dragon.restfulweb.vo.UserReqVO;
import com.dragon.restfulweb.vo.UserRespVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * @author lilong
 */
@RestController
@RequestMapping(value = "v1")
@Slf4j
public class UserController {

    @PostMapping(value = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
    public R<Boolean> insert(@RequestBody UserReqVO userReqVO){
        log.info("接受的参数,username：{}, password:{}", userReqVO.getUsername(), userReqVO.getPassword());
        //调用Service层保存user
        return R.ok(true);
    }

    @GetMapping(value = "/user/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public R<UserRespVO> selectById(@PathVariable Integer id){
        log.info("接受的参数id:{}",id);
        //模拟生成UserRespVO对象，实际应该是调用Service获取
        UserRespVO userRespVO = new UserRespVO();
        userRespVO.setCreateTime(new Date());
        userRespVO.setId(id);
        userRespVO.setUsername("张三");
        return R.ok(userRespVO);
    }


    @PutMapping(value = "/user/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public R<Boolean> updateById(@PathVariable Integer id, @RequestBody UserReqVO userReqVO){
        log.info("接受的参数,username：{}, password:{}",userReqVO.getUsername(), userReqVO.getPassword());
        //调用Service层更新user
        return R.ok(true);
    }


    @DeleteMapping(value = "/user/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public R<Boolean> deleteById(@PathVariable Integer id){
        log.info("接受的参数id:{}",id);
        //调用Service层删除user
        return R.ok(true);
    }


}
