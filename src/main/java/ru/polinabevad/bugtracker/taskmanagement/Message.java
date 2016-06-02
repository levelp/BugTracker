package ru.polinabevad.bugtracker.taskmanagement;

import ru.polinabevad.bugtracker.profile.*;
import ru.polinabevad.bugtracker.taskboard.*;
import ru.polinabevad.bugtracker.taskmanagement.Status.*;

import java.util.Date;


/**
 * Сообщение к задаче. Может поменять статус системы, поставить нового\изменить Автора\Исполнителя
 * TODO: предусмотреть запрос подтверждения удаления сообщения, ограничение - роль админа
 */
public class Message {
    private Date messageDate;
    private User messageAuthor;
    private int messageId;
    private Status messageStatus;
    private User messageAppointer;
    private String messageText;
    private Object messageAttach;
    private Task task;

    public Message(Task task) {
        this.task = task;
    }
    public void createMessage(String messageText) {
        messageDate = new Date();
        task.changeUpdateDate(messageDate);
        this.messageText = messageText;
    }

    public String toString() {
        return "Текст: " + messageText;
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
        //разрешаем перевод из проверки в закрыт и обновляем дату закрытия задачи
        if ((statusTypeFrom == StatusType.CHECK) && (statusTypeTo == StatusType.CLOSE)) {
            task.setTaskStatus(statusTypeTo);
            task.changeCloseDate(messageDate);
            return task.getTaskStatus();
        }
        task.setTaskStatus(statusTypeFrom);
        return task.getTaskStatus();

    }
}
