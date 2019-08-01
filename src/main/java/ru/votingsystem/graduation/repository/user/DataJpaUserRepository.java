package ru.votingsystem.graduation.repository.user;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import ru.votingsystem.graduation.model.User;

import java.util.List;

@Repository
public class DataJpaUserRepository implements UserRepository {

    private final CrudUserRepository userRepository;

    public DataJpaUserRepository(CrudUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public boolean delete(int id) {
        return userRepository.delete(id) != 0;
    }

    @Override
    public User get(int id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User getByEmail(String email) {
        return userRepository.getByEmail(email);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll(new Sort(Sort.Direction.ASC, "name", "email"));
    }
}
