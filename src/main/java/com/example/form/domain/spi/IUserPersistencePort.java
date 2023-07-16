package com.example.form.domain.spi;

import com.example.form.domain.model.User;

public interface IUserPersistencePort {
    void saveUser(User user);
    void updateUser(User user);
    User getUserByEmail(String email);
}
