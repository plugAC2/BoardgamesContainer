package com.example.boardgamescontainer.controllers;

import com.example.boardgamescontainer.entities.User;
import com.example.boardgamescontainer.models.UserModel;
import com.example.boardgamescontainer.services.UserService;
import com.example.boardgamescontainer.validators.PasswordValidator;
import com.example.boardgamescontainer.validators.UsernameValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final BCryptPasswordEncoder encoder;
    private final UserService userService;

    @GetMapping("/add")
    public ModelAndView getRegisterUser(){
        return new ModelAndView("register", "userModel", new UserModel());
    }

    @PostMapping("/add")
    public String saveUser(@Valid @ModelAttribute("userModel") UserModel userModel, BindingResult bindingResult){

        new PasswordValidator().validate(userModel, bindingResult);
        new UsernameValidator(userService).validate(userModel, bindingResult);

        if(bindingResult.hasErrors()) {
            return "register";
        }

        userService.newRecord(userModel);

        return "redirect:/login?newUser";
    }
}


