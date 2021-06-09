package com.register.manager.impl;

import com.register.common.exceptionhandler.BusinessException;
import com.register.common.exceptionhandler.CustomErrorCode;
import com.register.model.UserModel;
import com.register.manager.UserManager;
import com.register.manager.mapper.converter.UserConverter;
import com.register.manager.mapper.dto.UserDto;
import com.register.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class UserManagerImpl implements UserManager {
    private final UserService userService;
    private final UserConverter userConverter;


    /**
     * Constructor,
     */
    @Autowired
    public UserManagerImpl(UserService userService, UserConverter userConverter) {
        this.userService = userService;
        this.userConverter = userConverter;
    }

    /**
     * Return UserDto,
     *
     * @param id the id of the user that we are looking for
     * @return UserDto
     */
    @Override
    public UserDto findById(String id) {
        UserModel userModel = userService.findById(id);
        if (userModel == null) {
            throw new BusinessException(CustomErrorCode.NOT_FOUND, HttpStatus.NOT_FOUND);
        }
        return userConverter.convertTo(userModel);
    }

    /**
     * Create a new User
     *
     * @param userDto the user data we want to create
     * @return user id
     */
    @Override
    public String createUser(UserDto userDto, String extra) {
        // todo: use the extra param
        userDto.validate();
        UserModel userModel = userConverter.convertFrom(userDto);
        return userService.createUser(userModel).getId();
    }
}
