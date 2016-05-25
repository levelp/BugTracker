package ru.polinabevad.bugtracker.profile;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import ru.polinabevad.bugtracker.core.People;

public class AddUserTest extends Assert {
    /**
     * Добавление нового пользователя
     * При условии что все поля корректны
     */
    @Test
    public void testAddUser() {
        People user = People.createUser("sampleLogin");
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
