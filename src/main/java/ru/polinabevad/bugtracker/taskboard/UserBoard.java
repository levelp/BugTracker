package ru.polinabevad.bugtracker.taskboard;

import ru.polinabevad.bugtracker.profile.*;
import ru.polinabevad.bugtracker.taskmanagement.*;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Список незакрытых задач пользователя, аля рабочая доска
 */
class UserBoard<T> extends ArrayList<T> {

    private boolean isAuthor;
    private Status isNotClose;

    TaskList<Task> getUserBoard(User currentUser) {
        TaskList<Task> userBoard = new TaskList<>();

        for (Task task : TaskList.tasks) {
            if (task.getTaskAuthor() == currentUser) {
                userBoard.add(task);
            }
        }
        return userBoard;
    }
}
