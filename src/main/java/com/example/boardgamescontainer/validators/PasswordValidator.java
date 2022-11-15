package com.example.boardgamescontainer.validators;

import com.example.boardgamescontainer.entities.User;
import com.example.boardgamescontainer.models.UserModel;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class PasswordValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return UserModel.class.equals(clazz);
    }

    @Override
    public void validate(Object user, Errors errors) {
        UserModel userModel = (UserModel) user;
        if (!userModel.getPassword().equals(userModel.getRepeatPassword())) {
            errors.rejectValue("repeatPassword", "PasswordsDontMatch");
        }
    }
}
