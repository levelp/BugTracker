package ru.polinabevad.bugtracker.taskmanagement;


import ru.polinabevad.bugtracker.profile.*;
import ru.polinabevad.bugtracker.taskmanagement.Status.*;

import java.util.Date;

/**
 * Задача. В ней могут содержаться сообщения, есть статус, даты создания, обновления и закрытия. Обновление - любое изменение
 * с помощью сообщений. Прямое редактирование запрещено.
 * TODO: предусмотреть запрос подтверждения удаления задачи, ограничение - роль админа
 */
public class Task {
    private int taskNumber;
    private String taskName;
    private String taskDescription;
    private StatusType taskStatus;
    private Message taskMessages;
    private User taskAuthor;
    private User taskAppointer;
    private Date taskCreateDate;
    private Date taskUpdateDate;
    private Date taskCloseDate;
    private boolean isDeleted;

    public void createTask() {
    }

    public void deleteTask() {
    }

    public StatusType getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(StatusType statusType) {
        this.taskStatus = statusType;
    }

}
