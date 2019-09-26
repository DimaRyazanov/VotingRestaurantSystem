package ru.votingsystem.service.interfaces;

import ru.votingsystem.model.User;

public interface UserService {
    User getByEmail(String email);
}
