package com.pronto.test.mongo.mongodbexample.service;

import com.pronto.test.mongo.mongodbexample.co.MemberRegister;
import com.pronto.test.mongo.mongodbexample.document.MemberUser;
import com.pronto.test.mongo.mongodbexample.repository.MemberUserRepository;
import com.pronto.test.mongo.mongodbexample.security.JwtUtils;
import com.pronto.test.mongo.mongodbexample.vo.MemberUserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.util.Collection;

import static com.pronto.test.mongo.mongodbexample.constants.SecurityConstants.HEADER_STRING;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private MemberUserRepository memberUserRepository;


    @Autowired
    private SequenceGeneratorService sequenceGenerator;


    @Override
    public Page<MemberUser> userList(Pageable pageable) {
        return this.memberUserRepository.userList(pageable);
    }

    @Override
    public Boolean checkIfMemberExists(String userName) {

        if (this.memberUserRepository.findByUserName(userName) != null) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String getUserByUsername(String username) throws Exception{
        MemberUser memberUser= memberUserRepository.findByUserName(username);
        if(memberUser!=null){
            return JwtUtils.getAuthenticationToken(memberUser.getuserName());
        }else {
            throw new Exception("User Not Found");
        }
    }

    @Override
    public Collection<MemberUser> getAllUsers() {
        return memberUserRepository.findAll();
    }

    @Override
    public String create(MemberRegister userRegister, HttpServletResponse response) throws Exception {

        if (!checkIfMemberExists(userRegister.getUserName())) {
            MemberUser user = new MemberUser();
            user.setuserName(userRegister.getUserName());
            user.setMemberId(sequenceGenerator.generateSequence(MemberUser.SEQUENCE_NAME));
            user.setGender(userRegister.getGender());
            user.setPassword(new BCryptPasswordEncoder().encode(userRegister.getPassword()));
            memberUserRepository.save(user);
            return  "success";
        } else {
            throw new Exception("User Already Exists");
        }

    }
}
