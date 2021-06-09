package com.register.service;

import com.register.model.UserModel;

public interface UserService {
    UserModel createUser(UserModel userModel);
    UserModel findById(String id);
}
