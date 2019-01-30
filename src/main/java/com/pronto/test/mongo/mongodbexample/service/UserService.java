package com.pronto.test.mongo.mongodbexample.service;

import com.pronto.test.mongo.mongodbexample.document.User;
import com.pronto.test.mongo.mongodbexample.document.UserRegister;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface UserService {

     User getUserByUsername(String username);
    Collection<User> getAllUsers();
    User create(UserRegister userRegister);
    Page<User> userList(Pageable pageable);
}
