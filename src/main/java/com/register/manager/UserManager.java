package com.register.manager;

import com.register.manager.mapper.dto.UserDto;

public interface UserManager {
    UserDto findById(String id);
    String createUser(UserDto userDto, String extra);
}
