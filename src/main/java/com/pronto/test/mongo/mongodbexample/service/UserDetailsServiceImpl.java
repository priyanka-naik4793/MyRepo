package com.pronto.test.mongo.mongodbexample.service;

import com.pronto.test.mongo.mongodbexample.document.MemberUser;
import com.pronto.test.mongo.mongodbexample.repository.MemberUserRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;

public class UserDetailsServiceImpl implements UserDetailsService {

    private MemberUserRepository memberUserRepository;
    public UserDetailsServiceImpl(MemberUserRepository memberUserRepository) {
        this.memberUserRepository = memberUserRepository;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        MemberUser applicationUser = memberUserRepository.findByUserName(username);
        if (applicationUser == null) {
            throw new UsernameNotFoundException(username);
        }
        return new User(applicationUser.getuserName(), applicationUser.getPassword(), new ArrayList<>());
    }
}
