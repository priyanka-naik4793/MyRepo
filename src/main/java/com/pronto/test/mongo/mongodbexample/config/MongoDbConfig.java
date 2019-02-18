package com.pronto.test.mongo.mongodbexample.config;


import com.pronto.test.mongo.mongodbexample.document.MemberUser;
import com.pronto.test.mongo.mongodbexample.repository.MemberUserRepository;
import com.pronto.test.mongo.mongodbexample.service.SequenceGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.UUID;

@EnableMongoRepositories(basePackageClasses = MemberUserRepository.class)
@Configuration
public class MongoDbConfig {

    @Autowired
    SequenceGeneratorService sequenceGenerator;
    @Bean
    CommandLineRunner commandLineRunner(MemberUserRepository userRepository) {
        return strings -> {
            userRepository.deleteAll();
            userRepository.save(new MemberUser(sequenceGenerator.generateSequence(MemberUser.SEQUENCE_NAME), "priyanka", "FEMALE", UUID.randomUUID().toString()));
            userRepository.save(new MemberUser(sequenceGenerator.generateSequence(MemberUser.SEQUENCE_NAME), "vikas", "MALE", UUID.randomUUID().toString()));
            userRepository.save(new MemberUser(sequenceGenerator.generateSequence(MemberUser.SEQUENCE_NAME), "mahesh", "MALE", UUID.randomUUID().toString()));

            userRepository.save(new MemberUser(sequenceGenerator.generateSequence(MemberUser.SEQUENCE_NAME), "kriti", "FEMALE", UUID.randomUUID().toString()));

            userRepository.save(new MemberUser(sequenceGenerator.generateSequence(MemberUser.SEQUENCE_NAME), "abc", "MALE", UUID.randomUUID().toString()));

            userRepository.save(new MemberUser(sequenceGenerator.generateSequence(MemberUser.SEQUENCE_NAME), "pqr", "MALE", UUID.randomUUID().toString()));

            userRepository.save(new MemberUser(sequenceGenerator.generateSequence(MemberUser.SEQUENCE_NAME), "sanam", "MALE", UUID.randomUUID().toString()));

            userRepository.save(new MemberUser(sequenceGenerator.generateSequence(MemberUser.SEQUENCE_NAME), "sameer", "MALE", UUID.randomUUID().toString()));

            userRepository.save(new MemberUser(sequenceGenerator.generateSequence(MemberUser.SEQUENCE_NAME), "seri", "FEMALE", UUID.randomUUID().toString()));

            userRepository.save(new MemberUser(sequenceGenerator.generateSequence(MemberUser.SEQUENCE_NAME), "timi", "MALE", UUID.randomUUID().toString()));

            userRepository.save(new MemberUser(sequenceGenerator.generateSequence(MemberUser.SEQUENCE_NAME), "ati", "FEMALE", UUID.randomUUID().toString()));

            userRepository.save(new MemberUser(sequenceGenerator.generateSequence(MemberUser.SEQUENCE_NAME), "anish", "MALE", UUID.randomUUID().toString()));

            userRepository.save(new MemberUser(sequenceGenerator.generateSequence(MemberUser.SEQUENCE_NAME), "akku", "MALE", UUID.randomUUID().toString()));

            userRepository.save(new MemberUser(sequenceGenerator.generateSequence(MemberUser.SEQUENCE_NAME), "arif", "MALE", UUID.randomUUID().toString()));

            userRepository.save(new MemberUser(sequenceGenerator.generateSequence(MemberUser.SEQUENCE_NAME), "gajesh", "MALE", UUID.randomUUID().toString()));

            userRepository.save(new MemberUser(sequenceGenerator.generateSequence(MemberUser.SEQUENCE_NAME), "gargi", "FEMAKE", UUID.randomUUID().toString()));

            userRepository.save(new MemberUser(sequenceGenerator.generateSequence(MemberUser.SEQUENCE_NAME), "twinkle", "FEMALE", UUID.randomUUID().toString()));

            userRepository.save(new MemberUser(sequenceGenerator.generateSequence(MemberUser.SEQUENCE_NAME), "tameer", "MALE", UUID.randomUUID().toString()));

            userRepository.save(new MemberUser(sequenceGenerator.generateSequence(MemberUser.SEQUENCE_NAME), "rohan", "MALE", UUID.randomUUID().toString()));

            userRepository.save(new MemberUser(sequenceGenerator.generateSequence(MemberUser.SEQUENCE_NAME), "kamal", "MALE", UUID.randomUUID().toString()));

        };
    }
}
