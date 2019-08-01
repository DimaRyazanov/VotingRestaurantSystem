package ru.votingsystem.graduation;

import ru.votingsystem.graduation.model.Role;
import ru.votingsystem.graduation.model.User;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static ru.votingsystem.graduation.util.Util.ADMIN_ID;
import static ru.votingsystem.graduation.util.Util.USER_ID;

public class UserTestData {
    public static final User USER = new User(USER_ID, "User", "user@gmail.com", "password", Role.ROLE_USER);
    public static final User ADMIN = new User(ADMIN_ID, "Admin", "admin@gmail.com", "admin", Role.ROLE_ADMIN, Role.ROLE_USER);

    public static void assertMatch(User actual, User expected) {
        assertThat(actual).isEqualToIgnoringGivenFields(expected, "registered", "votes");
    }

    public static void assertMatch(Iterable<User> actual, User... expected) {
        assertMatch(actual, List.of(expected));
    }

    public static void assertMatch(Iterable<User> actual, Iterable<User> expected) {
        assertThat(actual).usingElementComparatorIgnoringFields("registered", "votes").isEqualTo(expected);
    }
}
