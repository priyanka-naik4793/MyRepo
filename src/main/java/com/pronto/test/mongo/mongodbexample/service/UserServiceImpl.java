package com.pronto.test.mongo.mongodbexample.service;

import com.pronto.test.mongo.mongodbexample.document.User;
import com.pronto.test.mongo.mongodbexample.document.UserRegister;
import com.pronto.test.mongo.mongodbexample.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;


@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;


    @Autowired
    private SequenceGeneratorService sequenceGenerator;

    @Autowired
    public UserServiceImpl(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    @Override
    public Page<User> userList(Pageable pageable) {
        return this.userRepository.userList(pageable);
    }

    @Override
    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public Collection<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User create(UserRegister userRegister) {
        User user = new User();
        user.setUsername(userRegister.username);
        user.setUserId(sequenceGenerator.generateSequence(User.SEQUENCE_NAME));
        user.setGender(userRegister.gender);
        user.setPassword(new BCryptPasswordEncoder().encode(userRegister.password));
        return userRepository.save(user);
    }
}
