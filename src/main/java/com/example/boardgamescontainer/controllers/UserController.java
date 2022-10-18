package com.example.boardgamescontainer.controllers;

import com.example.boardgamescontainer.models.UserModel;
import com.example.boardgamescontainer.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/add")
    public ModelAndView getRegisterUser(){
        return new ModelAndView("register", "userModel", new UserModel());
    }
}


