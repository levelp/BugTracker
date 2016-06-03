package ru.polinabevad.bugtracker.taskmanagement;


import ru.polinabevad.bugtracker.annotations.Required;
import ru.polinabevad.bugtracker.profile.*;
import ru.polinabevad.bugtracker.services.DateService;
import ru.polinabevad.bugtracker.taskmanagement.Status.*;

import java.util.Date;

/**
 * Задача. В ней могут содержаться сообщения, есть статус, даты создания, обновления и закрытия. Обновление - любое изменение
 * с помощью сообщений. Прямое редактирование запрещено.
 * TODO: предусмотреть запрос подтверждения удаления задачи, ограничение - роль админа
 */
public class Task {
    @Required
    private int taskNumber;
    @Required
    private String taskName;
    @Required
    private int taskId;
    @Required
    private StatusType taskStatus;
    @Required
    private User taskAuthor;
    @Required
    private User taskAppointer;

    private User currentUser;
    private String taskDescription;
    private MessageList taskMessages;
    private DateService taskCreateDate;
    private DateService taskUpdateDate;
    private DateService taskCloseDate;
    private boolean isDeleted;

    public Task() {

    }

    public void createTask(String taskName, Integer taskNumber) {
        taskCreateDate = new DateService();
        taskUpdateDate = taskCreateDate;
        this.taskName = taskName;
        this.taskNumber = taskNumber;
    }

    public void changeUpdateDate(DateService date) {
        taskUpdateDate = date;
    }

    public void changeCloseDate(DateService date) {
        taskCloseDate = date;
    }

    public int getTaskNumber() {
        return this.taskNumber;
    }

    public Date getTaskUpdateDate() {
        return taskUpdateDate;
    }



    public MessageList getTaskMessages() {
        return taskMessages;
    }

    public void createMessage(String messageText){
         if (taskMessages == null) {
             taskMessages = new MessageList(this);
         }
        Message message = new Message(this);
        message.createMessage(messageText);
        taskMessages.add(message);
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

    //полной процедуры пока удаления не будет, просто помечаем как isDeleted
    public void deleteTask() {
        //проверяем, что пользователь админ
        if (currentUser.checkUserisAdmin() == true) {
            this.isDeleted = true;
        }
        //TODO: заменить на Exception
        else System.out.println("У юзера нет прав на удаление");
    }

    public boolean getDeletedStatus() {
        return isDeleted;
    }

}
