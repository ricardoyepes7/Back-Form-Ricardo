package com.example.form.infraestructure.output.jpa.adapter;

import com.example.form.domain.exception.UserAlreadyRegistered;
import com.example.form.domain.exception.UserNotFoundException;
import com.example.form.domain.model.User;
import com.example.form.domain.spi.IUserProviderPort;
import com.example.form.infraestructure.output.jpa.mapper.UserEntityMapper;
import com.example.form.infraestructure.output.jpa.repository.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@RequiredArgsConstructor
public class UserJpaAdapter implements IUserProviderPort {
    private final IUserRepository userRepository;
    private final UserEntityMapper userEntityMapper;

    @Override
    public void saveUser(User user) {
        userRepository.findByEmail(user.getEmail())
                .ifPresent(userEntity -> {
                    throw new UserAlreadyRegistered(userEntity.getId());
                });
        userRepository.save(userEntityMapper.toEntity(user));
    }

    @Override
    public void updateUser(User user) {
        userRepository.save(userEntityMapper.toEntity(user));
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email)
                .map(userEntityMapper::toModel)
                .orElseThrow(() -> new UserNotFoundException(email));
    }
}
