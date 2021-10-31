package com.dragon.helloworld;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Create By IntelliJ IDEA
 *
 * @author LiLong
 * @date 2020/12/20
 */
@RestController
public class HelloWorldController {
    @RequestMapping("/hello")
    public String hello() {
        return "Hello World";
    }
}
