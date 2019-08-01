package ru.votingsystem.graduation.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import ru.votingsystem.graduation.TimingExtension;
import ru.votingsystem.graduation.UserTestData;
import ru.votingsystem.graduation.model.Role;
import ru.votingsystem.graduation.model.User;
import ru.votingsystem.graduation.util.Util;
import ru.votingsystem.graduation.util.exception.NotFoundException;

import java.util.Collections;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@SpringJUnitConfig(locations = {
    "classpath:spring/spring-app.xml",
    "classpath:spring/spring-db.xml"
})
@Sql(scripts = {"classpath:db/populateDB.sql"}, config = @SqlConfig(encoding = "UTF-8"))
@ExtendWith(TimingExtension.class)
class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    void create() {
        User newUser = new User(null, "New", "new@gmail.com", "newPass", false, new Date(), Collections.singleton(Role.ROLE_USER));
        User created = userService.create(newUser);
        newUser.setId(created.getId());

        UserTestData.assertMatch(newUser, created);
        UserTestData.assertMatch(userService.getAll(), UserTestData.ADMIN, newUser, UserTestData.USER);
    }

    @Test
    void duplicateMailCreate() {
        assertThrows(DataAccessException.class, () ->
                userService.create(new User(null, "duplicate", "user@gmail.com", "111", Role.ROLE_USER)));
    }

    @Test
    void update() {
        User updatedUser = new User(UserTestData.USER);
        updatedUser.setName("Updated user");
        updatedUser.setEmail("updatedmail@gmail.com");
        updatedUser.setRoles(Collections.singleton(Role.ROLE_ADMIN));
        userService.update(updatedUser);
        UserTestData.assertMatch(userService.get(Util.USER_ID), updatedUser);
    }

    @Test
    void get() {
        User user = userService.get(Util.ADMIN_ID);
        UserTestData.assertMatch(user, UserTestData.ADMIN);
    }

    @Test
    void getNotFound() {
        assertThrows(NotFoundException.class, () ->
                    userService.get(Integer.MAX_VALUE));
    }

    @Test
    void getByEmail() {
        User user = userService.getByEmail("admin@gmail.com");
        UserTestData.assertMatch(user, UserTestData.ADMIN);
    }

    @Test
    void delete() {
        userService.delete(Util.ADMIN_ID);
        UserTestData.assertMatch(userService.getAll(), UserTestData.USER);
    }

    @Test
    void deleteNotFound() {
        assertThrows(NotFoundException.class, () ->
                userService.delete(Integer.MAX_VALUE));
    }

    @Test
    void getAll() {
        UserTestData.assertMatch(userService.getAll(), UserTestData.ADMIN, UserTestData.USER);
    }
}