package ru.polinabevad.bugtracker.profile;

/**
 * Тип пользователя: админский или нет, у админского будут права на удаление задач\сообщений
 */
public class PeopleService {
    //пользователь-админ (может все)

    private boolean isAdmin;
    //пользователь - поддержка (принимают задачи в работу)
    private boolean isSupport;

    //сделать пользователя админом
    public void makeUserAdmin() {
        isAdmin = true;
    }
    // сделать пользователя саппортом
    public void makeUserSupport() {
        isSupport = true;
    }

    //TODO:здесь будет проверка прав пользователя
    public boolean checkUserisAdmin () {
        return isAdmin;
    }

    public boolean checkUserisSupport () {
        return isSupport;
    }

}
