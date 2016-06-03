package ru.polinabevad.bugtracker.profile;

import ru.polinabevad.bugtracker.annotations.Required;

/**
 * Пользователь системы
 */
public class User extends UserType{
    @Required
    private String login;

    private String name;
    private String password;
    private String email;
    private int userId;
    private boolean isActive;

    public static User createUser(String login) {
        User user = new User();
        user.login = login;
        user.isActive = true;
        return user;
    }

    public void disableUserActivity() {
        this.isActive = false;
    }

    public String getLogin() {
        return login;
    }
}
