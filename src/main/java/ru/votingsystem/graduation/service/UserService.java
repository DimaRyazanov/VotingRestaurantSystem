package ru.votingsystem.graduation.service;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import ru.votingsystem.graduation.model.User;
import ru.votingsystem.graduation.repository.UserRepository;
import ru.votingsystem.graduation.util.ValidationUtil;

import java.util.List;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User create(User user) {
        Assert.notNull(user, "user must not be null");
        return userRepository.save(user);
    }

    public void update(User user) {
        Assert.notNull(user, "user must not be null");
        ValidationUtil.checkNotFoundWithId(userRepository.save(user), user.getId());
    }

    public User get(int id) {
        return ValidationUtil.checkNotFoundWithId(userRepository.get(id), id);
    }

    public User getByEmail(String email) {
        Assert.notNull(email, "email must not be null");
        return ValidationUtil.checkNotFound(userRepository.getByEmail(email), "email=" + email);
    }

    public void delete(int id) {
        ValidationUtil.checkNotFoundWithId(userRepository.delete(id), id);
    }

    public List<User> getAll() {
        return userRepository.getAll();
    }
}
