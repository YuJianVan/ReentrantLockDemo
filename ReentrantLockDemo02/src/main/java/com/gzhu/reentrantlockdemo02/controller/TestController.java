package com.gzhu.reentrantlockdemo02.controller;

import com.gzhu.reentrantlockdemo02.service.TestService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/")
public class TestController {
    @Resource
    private TestService testService;
    @GetMapping("/test/{code}")
    public String test(@PathVariable("code") String code){
        return testService.test(code);
    }
}