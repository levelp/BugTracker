package ru.polinabevad.bugtracker.taskboard;


import ru.polinabevad.bugtracker.profile.*;
import ru.polinabevad.bugtracker.services.DateService;
import ru.polinabevad.bugtracker.taskmanagement.*;

import java.util.Date;
/**
 * Фильтр списка задач. Может быть нужно будет убрать и заменить представлением.
 */
public class Filter {
    private DateService tasksCreateDateFrom;
    private DateService tasksCloseDateFrom;
    private DateService tasksUpdateDateFrom;
    private DateService tasksCreateDateTo;
    private DateService tasksCloseDateTo;
    private DateService tasksUpdateDateTo;
    private Status taskStatus;
    private User userAuthor;
    private User userAppointer;

    //TODO: реализовать фильтрацию по автору, исполнителю, датам, статусу
    public void filterTasks(Status taskStatus) {
        TaskList.tasks.getTasksList();
    }
}
