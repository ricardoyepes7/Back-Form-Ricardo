package com.example.form.domain.usecase;

import com.example.form.domain.api.IUserServicePort;
import com.example.form.domain.model.User;
import com.example.form.domain.spi.IUserProviderPort;

public class UserUseCase implements IUserServicePort {
    private final IUserProviderPort userProviderPort;

    public UserUseCase(IUserProviderPort userPersistencePort) {
        this.userProviderPort = userPersistencePort;
    }

    @Override
    public void saveUser(User user) {
        userProviderPort.saveUser(user);
    }

    @Override
    public void updateUser(User user) {
        userProviderPort.updateUser(user);
    }

    @Override
    public User getUserByEmail(String email) {
        return userProviderPort.getUserByEmail(email);
    }
}
