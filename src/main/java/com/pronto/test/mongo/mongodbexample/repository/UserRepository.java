package com.pronto.test.mongo.mongodbexample.repository;

import com.pronto.test.mongo.mongodbexample.document.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface UserRepository  extends MongoRepository<User,Long>, PagingAndSortingRepository<User, Long> {

    User findByUsername(String username);

    default Page<User> userList(Pageable pageable) {
        return findAll(pageable);
    }

}
