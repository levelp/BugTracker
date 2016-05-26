package ru.polinabevad.bugtracker.taskmanagement;

/**
 * Created by p.bevad.spb on 25.05.2016.
 */
public class Task {
    private int taskNumber;
    private String taskName;
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
