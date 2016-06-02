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
    private int taskId;
    private String taskDescription;
    private StatusType taskStatus;
    private Message taskMessages;
    private User taskAuthor;
    private User taskAppointer;
    private Date taskCreateDate;
    private Date taskUpdateDate;
    private Date taskCloseDate;
    private boolean isDeleted;

    public Task() {

    }

    public void createTask(String taskName, Integer taskNumber) {
        taskCreateDate = new Date();
        taskUpdateDate = taskCreateDate;
        this.taskName = taskName;
        this.taskNumber = taskNumber;
    }

    public void changeUpdateDate(Date date) {
        taskUpdateDate = date;
    }

    public void changeCloseDate(Date date) {
        taskCloseDate = date;
    }

    public int getTaskNumber() {
        return this.taskNumber;
    }

    public void deleteTask() {
    }

    public StatusType getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(StatusType statusType) {
        this.taskStatus = statusType;
    }

    public String toString() {
        return "Номер задачи: " + taskNumber + " Название задачи: " + taskName + " Дата создания задачи: "
                + taskCreateDate + " Дата обновления задачи:" + taskUpdateDate;
    }
}
