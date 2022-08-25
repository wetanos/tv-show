package com.tvmaze.ui.utils;

import com.tvmaze.ui.entity.User;

public class UserCreator {
    public static final String USER_NAME = "howtostartat";
    public static final String USER_PASSWORD = "dem04T$";

    public static User createDefaultUser() {
        return new User(USER_NAME, USER_PASSWORD);
    }

    public static User createUser(String name, String password) {
        return new User(name, password);
    }
}
