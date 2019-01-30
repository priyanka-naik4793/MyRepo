package com.pronto.test.mongo.mongodbexample.validator;


import com.pronto.test.mongo.mongodbexample.document.User;
import com.pronto.test.mongo.mongodbexample.document.UserRegister;
import com.pronto.test.mongo.mongodbexample.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator {

    @Autowired
    private UserService userService;

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        UserRegister user = (UserRegister) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "NotEmpty");
        if (user.username.length() < 3) {
            errors.rejectValue("username", "Size.userForm.username");
        }
        if (userService.getUserByUsername(user.username) != null) {
            errors.rejectValue("username", "Duplicate.userForm.username");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
        if (user.password.length() < 3 ) {
            errors.rejectValue("password", "Size.userForm.password");
        }

    }
}
