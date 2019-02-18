package com.pronto.test.mongo.mongodbexample.service;

import com.pronto.test.mongo.mongodbexample.co.MemberRegister;
import com.pronto.test.mongo.mongodbexample.document.MemberUser;

import com.pronto.test.mongo.mongodbexample.vo.MemberUserVO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.servlet.http.HttpServletResponse;
import java.util.Collection;


public interface UserService {

    MemberUserVO getUserByUsername(String username,HttpServletResponse response);
    Collection<MemberUser> getAllUsers();
    MemberUserVO create(MemberRegister memberRegister, HttpServletResponse response) throws Exception ;
    Page<MemberUser> userList(Pageable pageable);
    Boolean checkIfMemberExists(String userName);

}


