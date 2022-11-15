package com.example.boardgamescontainer.entityModelFactories;

import com.example.boardgamescontainer.entities.User;
import com.example.boardgamescontainer.models.UserModel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.hibernate.cfg.NotYetImplementedException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserEntityModelFactory implements EntityModelFactory<User, UserModel> {

    @NonNull
    PasswordEncoder passwordEncoder;

    @Override
    public User createEntityFromModel(UserModel userModel) {
        return User.builder()
                .username(userModel.getUsername())
                .password(passwordEncoder.encode(userModel.getPassword()))
                .email(userModel.getEmail())
                .build();
    }

    @Override
    public UserModel createModelFromEntity(User user) {
        try {
            throw new NotYetImplementedException();
        } catch (NotYetImplementedException e){
            System.err.println("Method not yet implemented");
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public UserModel createModelFromEntityId(Long id) {
        try {
            throw new NotYetImplementedException();
        } catch (NotYetImplementedException e){
            System.err.println("Method not yet implemented");
            e.printStackTrace();
        }
        return null;
    }

}
