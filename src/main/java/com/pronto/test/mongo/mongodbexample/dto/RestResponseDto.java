package com.pronto.test.mongo.mongodbexample.dto;

import org.springframework.http.HttpStatus;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public class RestResponseDto<T> {
    Integer status = HttpServletResponse.SC_OK;
    String message;
    public T data;
}
