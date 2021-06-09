package com.register.service.impl;

import com.register.model.UserModel;
import com.register.repository.UserRepository;
import com.register.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserModel createUser(UserModel userModel) {
        return userRepository.save(userModel);
    }

    @Override
    public UserModel findById(String id) {
        return userRepository.findById(id).orElse(null);
    }
}
