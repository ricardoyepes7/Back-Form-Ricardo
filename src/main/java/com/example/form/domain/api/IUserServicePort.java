package com.example.form.domain.api;

import com.example.form.domain.model.User;

public interface IUserServicePort {
    void saveUser(User user);
    void updateUser(User user);
    User getUserByEmail(String email);
}
