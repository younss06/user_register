package com.register.controller;

import com.register.manager.UserManager;
import com.register.manager.mapper.dto.UserDto;
import com.register.controller.param.EndPointPath.UserResourcePath;
import com.register.controller.param.ResourceParameter.UserResourceParameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(UserResourcePath.USER)
public class UserResource {
    private final UserManager userManager;

    @Autowired
    public UserResource(UserManager userManager) {
        this.userManager = userManager;
    }

    @PostMapping
    public ResponseEntity<String> create(@RequestBody UserDto userDto,
                                       @RequestParam(value = "extra",
                                               required = false,
                                               defaultValue = "extra") String extra) {
        String id = userManager.createUser(userDto, extra);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @GetMapping(value = UserResourceParameter.ID, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDto> get(@PathVariable("id") String id) {
        UserDto result = userManager.findById(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
