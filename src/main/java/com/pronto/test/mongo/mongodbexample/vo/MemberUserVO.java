package com.pronto.test.mongo.mongodbexample.vo;

public class MemberUserVO {

    public String token;
    public Long memberId;

    public MemberUserVO(String token, Long memberId) {
        this.token = token;
        this.memberId = memberId;
    }
}
