package ru.polinabevad.bugtracker.profile;

/**
 * Тип пользователя: админский или нет, у админского будут права на удаление задач\сообщений
 */
public class UserType extends User {
    private boolean isAdmin;
}
