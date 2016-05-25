package ru.polinabevad.bugtracker.taskmanagement;

import org.junit.Assert;
import org.junit.Test;
import ru.polinabevad.bugtracker.core.StatusType;
import ru.polinabevad.bugtracker.core.Task.*;

/**
 *
 */
public class StatusTypeTest extends Assert {
    @Test
    public void test1() {
        //создание статусов
        StatusType statusOpen = StatusType.OPEN;
        StatusType statusOpen2 = StatusType.OPEN;
        StatusType statusWork = StatusType.WORK;
        StatusType statusCheck = StatusType.CHECK;
        StatusType statusClose = StatusType.CLOSE;
        //проверка запроса имени статуса
        assertEquals("Открыт", statusOpen.getStatusName());
        assertEquals("В работе", statusWork.getStatusName());
        assertEquals("В проверке", statusCheck.getStatusName());
        assertEquals("Закрыт", statusClose.getStatusName());
        //проверка переопределенного метода toString
        assertEquals("Статус задачи: Открыт", statusOpen.toString());
        assertEquals("Статус задачи: В работе", statusWork.toString());
        assertEquals("Статус задачи: В проверке", statusCheck.toString());
        assertEquals("Статус задачи: Закрыт", statusClose.toString());
        //проверка метода equals
        assertEquals(true, statusOpen.equals(statusOpen2));
        assertEquals(false, statusOpen.equals(statusWork));
    }
}
