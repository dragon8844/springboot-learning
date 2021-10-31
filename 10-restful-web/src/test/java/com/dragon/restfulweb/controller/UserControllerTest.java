package com.dragon.restfulweb.controller;

import com.dragon.restfulweb.vo.UserReqVO;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.nio.charset.Charset;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@Slf4j
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void insert() throws Exception {

        UserReqVO userReqVO = new UserReqVO();
        userReqVO.setPassword("123456");
        userReqVO.setUsername("张三");
        //设置值
        ObjectMapper mapper = new ObjectMapper();
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson = ow.writeValueAsString(userReqVO);

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/v1/user")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestJson))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        log.info("mvcResult:{}", mvcResult.getResponse().getContentAsString(Charset.forName("UTF-8")));
    }

    @Test
    public void selectById() throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/v1/user/1"))
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andDo(MockMvcResultHandlers.print())
                    .andReturn();
        log.info("mvcResult:{}", mvcResult.getResponse().getContentAsString(Charset.forName("UTF-8")));
    }

    @Test
    public void updateById() throws Exception{
        UserReqVO userReqVO = new UserReqVO();
        userReqVO.setPassword("123456");
        userReqVO.setUsername("张三");
        //设置值
        ObjectMapper mapper = new ObjectMapper();
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson = ow.writeValueAsString(userReqVO);

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.put("/v1/user/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestJson))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        log.info("mvcResult:{}", mvcResult.getResponse().getContentAsString(Charset.forName("UTF-8")));

    }

    @Test
    public void deleteById()throws Exception{
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.delete("/v1/user/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        log.info("mvcResult:{}", mvcResult.getResponse().getContentAsString(Charset.forName("UTF-8")));
    }
}