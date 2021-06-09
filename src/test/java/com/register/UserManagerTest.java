package com.register;

import com.register.common.exceptionhandler.BusinessException;
import com.register.common.exceptionhandler.CustomErrorCode;
import com.register.common.exceptionhandler.InvalidPayloadException;
import com.register.manager.UserManager;
import com.register.manager.mapper.dto.UserDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class UserManagerTest {
    @Autowired
    private UserManager userManager;

    @Test
    public void createUser_Success() {
        UserDto userDto = UserDto.builder()
                .firstName("younuss")
                .lastName("el kassmi")
                .age(44)
                .countryCode("FR")
                .build();

        String savedUserId = userManager.createUser(userDto, "");
        Assertions.assertThat(savedUserId).isNotNull();
    }

    @Test
    public void createUser_Failure() {
        UserDto userDto = UserDto.builder()
                .firstName("younuss")
                .lastName("el kassmi")
                .age(44)
                .countryCode("MAR") // only users from france are allowed to create account
                .build();
        assertThrows(BusinessException.class, () -> userManager.createUser(userDto, ""));
    }

    @Test
    public void findUser_Success() {
        UserDto userDto = userManager.findById("60beb4828936da0679c61c8d");
        Assertions.assertThat(userDto).isNotNull();
    }

    @Test
    public void findUser_Failure() {
        BusinessException bex = assertThrows(BusinessException.class, () -> userManager.findById(""));
        Assertions.assertThat(bex.getErrorCode().equals(CustomErrorCode.NOT_FOUND));
    }


}
