package ru.polinabevad.bugtracker.taskmanagement;

import ru.polinabevad.bugtracker.profile.*;
import ru.polinabevad.bugtracker.taskboard.*;
import ru.polinabevad.bugtracker.taskmanagement.Status.*;


/**
 * Сообщение к задаче. Может поменять статус системы, поставить нового\изменить Автора\Исполнителя
 * TODO: предусмотреть запрос подтверждения удаления сообщения, ограничение - роль админа
 */
public class Message {
    private java.util.Date messageDate;
    private User messageAuthor;
    private Status messageStatus;
    private User messageAppointer;
    private Task task;

    public Message(Task task) {
        this.task = task;
    }
    public void createMessage() {

    }
    public void deleteMessage() {
    }

    public StatusType changeTaskStatus(StatusType statusTypeTo) {
        StatusType statusTypeFrom = task.getTaskStatus();
        //разрешаем перевод из открыт в работу
        if ((statusTypeFrom == StatusType.OPEN) && (statusTypeTo == StatusType.WORK)) {
            task.setTaskStatus(statusTypeTo);
            return task.getTaskStatus();
        }
        //разрешаем перевод из работы в проверку
        if ((statusTypeFrom == StatusType.WORK) && (statusTypeTo == StatusType.CHECK)) {
            task.setTaskStatus(statusTypeTo);
            return task.getTaskStatus();
        }
        //разрешаем перевод из проверки в работу
        if ((statusTypeFrom == StatusType.CHECK) && (statusTypeTo == StatusType.WORK)) {
            task.setTaskStatus(statusTypeTo);
            return task.getTaskStatus();
        }
        //разрешаем перевод из проверки в закрыт
        if ((statusTypeFrom == StatusType.CHECK) && (statusTypeTo == StatusType.CLOSE)) {
            task.setTaskStatus(statusTypeTo);
            return task.getTaskStatus();
        }
        task.setTaskStatus(statusTypeFrom);
        return task.getTaskStatus();

    }
}
