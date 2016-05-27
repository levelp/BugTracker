package ru.polinabevad.bugtracker;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import ru.polinabevad.bugtracker.profile.User;

public class AddUserTest extends Assert {
    /**
     * Добавление нового пользователя
     * При условии что все поля корректны
     */
    @Test
    public void testAddUser() {
        User user = User.createUser("sampleLogin");
        assertEquals("sampleLogin", user.getLogin());
    }

    /**
     * Проверка корректности полей при добавлении
     */
    @Test
    @Ignore // TODO: реализовать
    public void testAddUserChecks() {

    }
}
