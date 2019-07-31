package ru.votingsystem.graduation.util;

import static ru.votingsystem.graduation.util.Util.USER_ID;

public class SecurityUtil {
    private static int id = USER_ID;

    private SecurityUtil() {
    }

    public static int authUserId() {
        return id;
    }
}
