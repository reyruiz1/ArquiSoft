package com.segundoParcial.parcial.service;

import com.segundoParcial.parcial.models.User;
import com.segundoParcial.parcial.repositories.UserRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {
    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public User createUser(User user) {
        return repository.save(user);
    }

    public List<User> getAllUsers() {
        return repository.findAll();
    }

    public User getUserById(Long id) {
        return repository.findById(id).orElseThrow(() ->
                new RuntimeException("Usuario no encontrado con id: " + id));
    }

    public User updateUser(Long id, User userDetails) {
        User user = repository.findById(id).orElseThrow(() ->
                new RuntimeException("Usuario no encontrado con id: " + id));

        user.setUsername(userDetails.getUsername());
        user.setEmail(userDetails.getEmail());
        user.setPassword(userDetails.getPassword());

        return repository.save(user);
    }

    public String deleteUser(Long id) {
        repository.deleteById(id);
        return "Usuario eliminado correctamente con id: " + id;
    }
}
