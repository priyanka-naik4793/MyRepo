package com.pronto.test.mongo.mongodbexample.controller;

import com.pronto.test.mongo.mongodbexample.co.MemberRegister;
import com.pronto.test.mongo.mongodbexample.dto.RestResponseDto;
import com.pronto.test.mongo.mongodbexample.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/sign-up")
    public RestResponseDto signUp(@RequestBody MemberRegister memberRegister,HttpServletResponse response) throws Exception {
         RestResponseDto restResponseDto = new RestResponseDto() ;
         restResponseDto.data=userService.create(memberRegister,response);
         return restResponseDto;
    }
    @PostMapping("/login")
    public RestResponseDto login(@RequestBody MemberRegister memberRegister, HttpServletRequest request,HttpServletResponse response) throws Exception {
        RestResponseDto restResponseDto = new RestResponseDto() ;
        restResponseDto.data = userService.getUserByUsername(memberRegister.userName,response);
        return restResponseDto;
    }
}
