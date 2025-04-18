package com.segundoParcial.parcial.repositories;

import com.segundoParcial.parcial.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long>{
    Optional<User> findById(Long id);
}
