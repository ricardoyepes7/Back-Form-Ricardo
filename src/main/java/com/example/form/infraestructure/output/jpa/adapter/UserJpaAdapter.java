package com.example.form.infraestructure.output.jpa.adapter;

import com.example.form.domain.model.User;
import com.example.form.domain.spi.IUserPersistencePort;
import com.example.form.infraestructure.exception.UserException;
import com.example.form.infraestructure.output.jpa.mapper.UserEntityMapper;
import com.example.form.infraestructure.output.jpa.repository.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;

@RequiredArgsConstructor
public class UserJpaAdapter implements IUserPersistencePort {
    private final IUserRepository userRepository;
    private final UserEntityMapper userEntityMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void saveUser(User user) {
        userRepository.findByEmail(user.getEmail())
                .ifPresentOrElse(userEntity -> {
                    throw new UserException("El usuario ya está registrado.",
                            "El usuario con email: " + userEntity.getEmail() + " ya se encuentra registrado.",
                            HttpStatus.CONFLICT);
                }, () -> {
                    user.setPassword(passwordEncoder.encode(user.getPassword()));
                    userRepository.save(userEntityMapper.toEntity(user));
                });
    }

    @Override
    public void updateUser(User user) {
        userRepository.save(userEntityMapper.toEntity(user));
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email)
                .map(userEntityMapper::toModel)
                .orElseThrow(() -> new UserException("Usuario no encontrado.",
                        "El usuario con email: " + email + " no se encuentra registrado.",
                        HttpStatus.NOT_FOUND));
    }
}
