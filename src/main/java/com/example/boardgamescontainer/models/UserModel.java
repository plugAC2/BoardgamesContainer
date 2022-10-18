package com.example.boardgamescontainer.models;

import lombok.*;

import javax.validation.constraints.Email;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserModel {

    private String username;
    private String password;
    private String repeatPassword;
    @Email
    private String email;
}
