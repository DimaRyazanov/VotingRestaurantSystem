package ru.votingsystem.service;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import ru.votingsystem.model.User;
import ru.votingsystem.repository.UserRepository;
import ru.votingsystem.service.interfaces.UserService;
import ru.votingsystem.util.ValidationUtil;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository repository;

    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public User getByEmail(String email) {
        Assert.notNull(email, "email must be not null");
        return ValidationUtil.checkNotFound(repository.getByEmail(email), "email=" + email);
    }
}
