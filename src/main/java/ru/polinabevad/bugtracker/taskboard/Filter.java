package ru.polinabevad.bugtracker.taskboard;

/**
 * Created by p.bevad.spb on 25.05.2016.
 */
public class Filter extends TaskList {

    private java.util.Date tasksCreateDateFrom;
    private java.util.Date tasksCloseDateFrom;
    private java.util.Date tasksUpdateDateFrom;
    private ru.polinabevad.bugtracker.taskmanagement.Status taskStatus;
    private ru.polinabevad.bugtracker.profile.User userAuthor;
    private ru.polinabevad.bugtracker.profile.User userAppointer;

    public void filterTasks() {
    }
}
