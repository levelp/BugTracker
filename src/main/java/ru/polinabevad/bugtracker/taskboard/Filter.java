package ru.polinabevad.bugtracker.taskboard;


import ru.polinabevad.bugtracker.profile.*;
import ru.polinabevad.bugtracker.taskmanagement.*;

import java.util.Date;
/**
 * Фильтр списка задач. Может быть нужно будет убрать и заменить представлением.
 */
public class Filter extends TaskList {

    private Date tasksCreateDateFrom;
    private Date tasksCloseDateFrom;
    private Date tasksUpdateDateFrom;
    private Status taskStatus;
    private User userAuthor;
    private User userAppointer;

    public void filterTasks() {
    }
}
