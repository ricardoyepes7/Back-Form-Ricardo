package com.example.form.application.handler.interfaces;

import com.example.form.application.dto.UserDto;
import com.example.form.application.dto.UserRegisterDto;

public interface IUserHandler {
    void createUser(UserRegisterDto userRegisterDto);

    UserDto getUserInformation(String email);

    void updateUser(String email, UserDto userDto);
}
