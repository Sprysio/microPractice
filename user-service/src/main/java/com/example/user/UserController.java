package com.example.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping
    public List<UserEntity> getAll() {
        return service.getAll();
    }

    @PostMapping
    public UserEntity create(@RequestBody UserEntity user) {
        return service.save(user);
    }
}
