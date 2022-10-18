package com.example.boardgamescontainer.services;

import com.example.boardgamescontainer.entities.User;
import com.example.boardgamescontainer.models.UserModel;
import com.example.boardgamescontainer.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.cfg.NotYetImplementedException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService implements CrudService<User, UserModel>, UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public List<UserModel> getAllModel() {
        try {
            throw new NotYetImplementedException();
        } catch (NotYetImplementedException e){
            System.err.println("Method not yet implemented");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void newRecord(UserModel userModel) {
    }

    @Override
    public void newRecordDirect(User user) {
        userRepository.save(user);
    }

    @Override
    public Optional<User> getRecordById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public void changeRecord(Long id, UserModel userModel) {
    }

    @Override
    public void deleteRecordById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return (UserDetails) userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Username: " + username + " not found"));
    }

    public Optional<User> showRecordByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public boolean checkIfUsernameExists(String username) {
        Optional<User> user = userRepository.findByUsername(username);
        return user.isPresent();
    }

}
