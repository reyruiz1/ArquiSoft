package com.segundoParcial.parcial.controllers;

import com.segundoParcial.parcial.models.User;
import com.segundoParcial.parcial.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@Tag(name = "User API", description = "Gestión de usuarios")
public class UserController {
    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping("/add")
    @Operation(summary = "Crear usuario", description = "Registra un nuevo usuario en el sistema")
    public User createUser(@RequestBody User user) {
        return service.createUser(user);
    }

    @GetMapping("/list")
    public List<User> getAllUsers() {
        return service.getAllUsers();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener usuario por ID", description = "Devuelve los datos de un usuario específico")
    public User getUserById(@PathVariable Long id) {
        return service.getUserById(id);
    }


    @PutMapping("/update/{id}")
    @Operation(summary = "Actualizar usuario", description = "Modifica los datos de un usuario existente")
    public User updateUser(@PathVariable Long id, @RequestBody User userDetails) {
        return service.updateUser(id, userDetails);
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Eliminar usuario", description = "Elimina un usuario del sistema")
    public String deleteUser(@PathVariable Long id) {
        return service.deleteUser(id);
    }
}