package com.pronto.test.mongo.mongodbexample.repository;

import com.pronto.test.mongo.mongodbexample.document.MemberUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MemberUserRepository extends MongoRepository<MemberUser,Long> {

    MemberUser findByUserName(String userName);
    default Page<MemberUser> userList(Pageable pageable) {
        return findAll(pageable);
    }
}
