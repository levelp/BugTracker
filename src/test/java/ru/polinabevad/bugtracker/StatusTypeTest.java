package ru.polinabevad.bugtracker;

import org.junit.Assert;
import org.junit.Test;
import ru.polinabevad.bugtracker.taskmanagement.Status.*;

/**
 * Created by p.bevad.spb on 30.05.2016.
 */
public class StatusTypeTest extends Assert {
    @Test
    public void test1() {
        StatusType statusOpen = StatusType.OPEN;
        StatusType statusWork = StatusType.WORK;
        StatusType statusCheck = StatusType.CHECK;
        StatusType statusClose = StatusType.CLOSE;
        assertEquals("Открыт", statusOpen.getStatus());
        assertEquals("В работе", statusWork.getStatus());
        assertEquals("В проверке", statusCheck.getStatus());
        assertEquals("Закрыт", statusClose.getStatus());
        assertEquals("Статус задачи: Открыт", statusOpen.toString());
        assertEquals("Статус задачи: В работе", statusWork.toString());
        assertEquals("Статус задачи: В проверке", statusCheck.toString());
        assertEquals("Статус задачи: Закрыт", statusClose.toString());
    }
}
