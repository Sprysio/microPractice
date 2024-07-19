package com.example.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<UserEntity> getAll() {
        return repository.findAll();
    }

    public UserEntity save(UserEntity user) {
        return repository.save(user);
    }
}
