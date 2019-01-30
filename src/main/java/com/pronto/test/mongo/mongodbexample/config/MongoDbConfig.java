package com.pronto.test.mongo.mongodbexample.config;

import com.pronto.test.mongo.mongodbexample.document.User;
import com.pronto.test.mongo.mongodbexample.repository.UserRepository;
import com.pronto.test.mongo.mongodbexample.service.SequenceGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories(basePackageClasses = UserRepository.class)
@Configuration
public class MongoDbConfig {
@Autowired
    SequenceGeneratorService sequenceGenerator;

    @Bean
    CommandLineRunner commandLineRunner(UserRepository userRepository){
        return strings -> {
            userRepository.deleteAll();
            userRepository.save(new User(sequenceGenerator.generateSequence(User.SEQUENCE_NAME),"priyanka","FEMALE","xyz"));
            userRepository.save(new User(sequenceGenerator.generateSequence(User.SEQUENCE_NAME),"vikas","MALE","abc"));
            userRepository.save(new User(sequenceGenerator.generateSequence(User.SEQUENCE_NAME),"mahesh","MALE","abc"));

            userRepository.save(new User(sequenceGenerator.generateSequence(User.SEQUENCE_NAME),"kriti","FEMALE","abc"));

            userRepository.save(new User(sequenceGenerator.generateSequence(User.SEQUENCE_NAME),"abc","MALE","abc"));

            userRepository.save(new User(sequenceGenerator.generateSequence(User.SEQUENCE_NAME),"pqr","MALE","abc"));

            userRepository.save(new User(sequenceGenerator.generateSequence(User.SEQUENCE_NAME),"sanam","MALE","abc"));

            userRepository.save(new User(sequenceGenerator.generateSequence(User.SEQUENCE_NAME),"sameer","MALE","abc"));

            userRepository.save(new User(sequenceGenerator.generateSequence(User.SEQUENCE_NAME),"seri","FEMALE","abc"));

            userRepository.save(new User(sequenceGenerator.generateSequence(User.SEQUENCE_NAME),"timi","MALE","abc"));

            userRepository.save(new User(sequenceGenerator.generateSequence(User.SEQUENCE_NAME),"ati","FEMALE","abc"));

            userRepository.save(new User(sequenceGenerator.generateSequence(User.SEQUENCE_NAME),"anish","MALE","abc"));

            userRepository.save(new User(sequenceGenerator.generateSequence(User.SEQUENCE_NAME),"akku","MALE","abc"));

            userRepository.save(new User(sequenceGenerator.generateSequence(User.SEQUENCE_NAME),"arif","MALE","abc"));

            userRepository.save(new User(sequenceGenerator.generateSequence(User.SEQUENCE_NAME),"gajesh","MALE","abc"));

            userRepository.save(new User(sequenceGenerator.generateSequence(User.SEQUENCE_NAME),"gargi","FEMAKE","abc"));

            userRepository.save(new User(sequenceGenerator.generateSequence(User.SEQUENCE_NAME),"twinkle","FEMALE","abc"));

            userRepository.save(new User(sequenceGenerator.generateSequence(User.SEQUENCE_NAME),"tameer","MALE","abc"));

            userRepository.save(new User(sequenceGenerator.generateSequence(User.SEQUENCE_NAME),"rohan","MALE","abc"));

            userRepository.save(new User(sequenceGenerator.generateSequence(User.SEQUENCE_NAME),"kamal","MALE","abc"));

        };
    }
}
