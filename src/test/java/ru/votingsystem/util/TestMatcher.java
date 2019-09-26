package ru.votingsystem.util;

import static org.assertj.core.api.Assertions.assertThat;

public class TestMatcher {
    public static <T> void assertMatch(T expected, T actual) {
        assertThat(actual).isEqualTo(expected);
    }

    public static <T> void assertMatch(Iterable<T> expected, Iterable<T> actual) {
        assertThat(actual).usingFieldByFieldElementComparator().isEqualTo(expected);
    }
}
