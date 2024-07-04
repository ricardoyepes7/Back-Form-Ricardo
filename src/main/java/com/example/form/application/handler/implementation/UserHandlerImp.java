package com.example.form.application.handler.implementation;

import com.example.form.application.dto.UserDto;
import com.example.form.application.dto.UserRegisterDto;
import com.example.form.application.exception.PasswordNotMachException;
import com.example.form.application.handler.interfaces.IUserHandler;
import com.example.form.application.mapper.UserDtoMapper;
import com.example.form.domain.api.IUserServicePort;
import com.example.form.domain.model.User;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserHandlerImp implements IUserHandler {
    private final IUserServicePort userServicePort;
    private final UserDtoMapper userDtoMapper;
    private final PasswordEncoder passwordEncoder;


    @Override
    @Transactional
    public void createUser(UserRegisterDto userRegisterDto) {
        if (!userRegisterDto.getPassword().equals(userRegisterDto.getConfirmPassword())) {
            throw new PasswordNotMachException();
        }
        User user = User.builder()
                .email(userRegisterDto.getEmail())
                .password(passwordEncoder.encode(userRegisterDto.getPassword()))
                .build();
        userServicePort.saveUser(user);
    }

    @Override
    public UserDto getUserInformation(String email) {
        return userDtoMapper.toDto(userServicePort.getUserByEmail(email));
    }

    @Override
    @Transactional
    public void updateUser(String email, UserDto userDto) {
        User oldUser = userServicePort.getUserByEmail(email);
        User newUser = User.builder()
                .id(oldUser.getId())
                .email(oldUser.getEmail())
                .password(oldUser.getPassword())
                .name(userDto.getName())
                .lastname(userDto.getLastname())
                .birthDate(userDto.getBirthDate())
                .currentCity(userDto.getCurrentCity())
                .phone(userDto.getPhone())
                .build();
        userServicePort.updateUser(newUser);
    }


}
