package ru.polinabevad.bugtracker.taskmanagement;

/**
 * Задача. В ней могут содержаться сообщения, есть статус, даты создания, обновления и закрытия. Обновление - любое изменение
 * с помощью сообщений. Прямое редактирование запрещено.
 */
public class Task {
    private int taskNumber;
    private String taskName;
    private String taskDescription;
    private Status taskStatus;
    private Message taskMessages;
    private ru.polinabevad.bugtracker.profile.User taskAuthor;
    private ru.polinabevad.bugtracker.profile.User taskAppointer;
    private java.util.Date taskCreateDate;
    private java.util.Date taskUpdateDate;
    private java.util.Date taskCloseDate;
    private boolean isDeleted;

    public void createTask() {
    }

    public void viewTask() {
    }

    public void deleteTask() {
    }
}
