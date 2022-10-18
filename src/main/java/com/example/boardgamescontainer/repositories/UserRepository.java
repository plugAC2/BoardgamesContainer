package com.example.boardgamescontainer.repositories;

import com.example.boardgamescontainer.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);

    @Query("SELECT u.id FROM User u WHERE u.username LIKE ?1")
    Long getUserId(String username);
}
