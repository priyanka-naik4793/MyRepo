package com.pronto.test.mongo.mongodbexample.controller;

import com.pronto.test.mongo.mongodbexample.co.MemberRegister;
import com.pronto.test.mongo.mongodbexample.dto.RestResponseDto;
import com.pronto.test.mongo.mongodbexample.security.JwtUtils;
import com.pronto.test.mongo.mongodbexample.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.pronto.test.mongo.mongodbexample.constants.SecurityConstants.HEADER_STRING;
import static com.pronto.test.mongo.mongodbexample.constants.SecurityConstants.TOKEN_PREFIX;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/sign-up")
    public ResponseEntity<?> signUp(@RequestBody MemberRegister memberRegister,HttpServletResponse response) throws Exception {
         RestResponseDto restResponseDto = new RestResponseDto() ;
         restResponseDto.data=userService.create(memberRegister,response);
         return ResponseEntity.ok(restResponseDto);
    }
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody MemberRegister memberRegister, HttpServletResponse response) throws Exception {
        RestResponseDto restResponseDto = new RestResponseDto() ;
        restResponseDto.data = userService.getUserByUsername(memberRegister.getUserName());
        return ResponseEntity.ok(restResponseDto);
    }

    @GetMapping("/userList")
    public ResponseEntity<?> userList(){
        RestResponseDto restResponseDto = new RestResponseDto() ;
        restResponseDto.data = userService.getAllUsers();
        return ResponseEntity.ok(restResponseDto);
    }
}
