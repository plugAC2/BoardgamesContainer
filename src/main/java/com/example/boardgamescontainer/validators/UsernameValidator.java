package com.example.boardgamescontainer.validators;

import com.example.boardgamescontainer.models.UserModel;
import com.example.boardgamescontainer.services.UserService;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class UsernameValidator  implements Validator {

    private final UserService userService;

    public UsernameValidator(UserService userService) {
        this.userService = userService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return UserModel.class.equals(clazz);
    }

    @Override
    public void validate(Object user, Errors errors) {
        UserModel userModel = (UserModel) user;
        if (userService.checkIfUsernameExists(userModel.getUsername())) {
            errors.rejectValue("username", "UsernameExists");
        }
    }
}
