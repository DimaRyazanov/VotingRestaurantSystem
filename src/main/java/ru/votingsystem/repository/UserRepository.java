package ru.votingsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.votingsystem.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
    User getByEmail(String email);
}
