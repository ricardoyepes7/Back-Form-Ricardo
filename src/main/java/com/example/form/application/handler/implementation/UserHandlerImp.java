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
import org.springframework.stereotype.Service;



@Service
@RequiredArgsConstructor
public class UserHandlerImp implements IUserHandler {
    private final IUserServicePort userServicePort;
    private final UserDtoMapper userDtoMapper;

    @Transactional
    @Override
    public void createUser(UserRegisterDto userRegisterDto) {
        if (!userRegisterDto.getPassword().equals(userRegisterDto.getConfirmPassword())) {
            throw new PasswordNotMachException("Las contraseñas no coinciden",
                    "Las contraseñas no coinciden",
                    HttpStatus.CONFLICT);
        }
        userServicePort.saveUser(userDtoMapper.toModel(userRegisterDto));
    }

    @Override
    public UserDto getUserInformation(String email) {
        return userDtoMapper.toDto(userServicePort.getUserByEmail(email));
    }

    @Transactional
    @Override
    public void updateUser(String email, UserDto userDto) {
        User oldUser = userServicePort.getUserByEmail(email);
        User newUser = userDtoMapper.toModel(userDto);
        newUser.setId(oldUser.getId());
        newUser.setEmail(oldUser.getEmail());
        newUser.setPassword(oldUser.getPassword());
        userServicePort.updateUser(newUser);
    }


}
