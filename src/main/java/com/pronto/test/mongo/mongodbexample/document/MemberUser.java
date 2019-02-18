package com.pronto.test.mongo.mongodbexample.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

public class MemberUser {

    @Transient
    public static final String SEQUENCE_NAME = "users_sequence";

    @Id
    private Long memberId;
    private String userName;
    private String gender;
    private String password;

    public MemberUser(){}
    public MemberUser(Long memberId, String userName, String gender, String password) {
        this.memberId = memberId;
        this.userName = userName;
        this.gender = gender;
        this.password = password;
    }

    public MemberUser(String userName, String gender, String password) {
        this.userName = userName;
        this.gender = gender;
        this.password = password;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public String getuserName() {
        return userName;
    }

    public void setuserName(String userName) {
        this.userName = userName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
