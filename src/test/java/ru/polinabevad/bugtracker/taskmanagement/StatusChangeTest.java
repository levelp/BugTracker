package ru.polinabevad.bugtracker.taskmanagement;

import org.junit.Assert;
import org.junit.Test;
import ru.polinabevad.bugtracker.core.Message;
import ru.polinabevad.bugtracker.core.StatusType;
import ru.polinabevad.bugtracker.core.Task;
import ru.polinabevad.bugtracker.core.Task.*;


/**
 *
 */
public class StatusChangeTest extends Assert {
    @Test
    public void test2() {
        Task task = new Task();

        StatusType statusOpen = StatusType.OPEN;
        StatusType statusWork = StatusType.WORK;
        StatusType statusCheck = StatusType.CHECK;
        StatusType statusClose = StatusType.CLOSE;
        //задаем начальный статус задачи
        task.setTaskStatus(statusOpen);
        Message message = new Message(task);

        //пробуем изменить из открыто в работу
        message.changeTaskStatus(statusWork);
        assertEquals("Статус задачи: В работе", statusWork, task.getTaskStatus());
        //Нельзя перевести из в работе сразу в закрыт, оставляем в прошлом статусе
        // TODO: потом надо сообщение об ошибке в вебе сделать
        message.changeTaskStatus(statusClose);
        assertEquals("Статус задачи: В работе", statusWork, task.getTaskStatus());
        //пробуем перевести из в работу в проверку
        message.changeTaskStatus(statusCheck);
        assertEquals("Статус задачи: В проверке", statusCheck, task.getTaskStatus());
        //пробуем перевести из проверки в работу
        message.changeTaskStatus(statusWork);
        assertEquals("Статус задачи: В работе", statusWork, task.getTaskStatus());
        //Нельзя перевести из "в работу" сразу в "закрыт", оставляем в прошлом статусе
        // TODO: потом надо сообщение об ошибке в вебе сделать
        message.changeTaskStatus(statusClose);
        assertEquals("Статус задачи: В работе", statusWork, task.getTaskStatus());
        //пробуем перевести из "в работу" в "проверку"
        message.changeTaskStatus(statusCheck);
        assertEquals("Статус задачи: В проверке", statusCheck, task.getTaskStatus());
        //пробуем перевести из проверки в закрыт
        message.changeTaskStatus(statusClose);
        assertEquals("Статус задачи: Закрыт", statusClose, task.getTaskStatus());
    }
}
