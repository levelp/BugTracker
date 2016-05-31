package ru.polinabevad.bugtracker;

import org.junit.Assert;
import org.junit.Test;
import ru.polinabevad.bugtracker.taskmanagement.Status.*;
import ru.polinabevad.bugtracker.taskmanagement.Message;
import ru.polinabevad.bugtracker.taskmanagement.Task;

/**
 * Created by p.bevad.spb on 31.05.2016.
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
