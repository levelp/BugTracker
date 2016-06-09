package ru.polinabevad.bugtracker.taskboard;

import ru.polinabevad.bugtracker.core.Status;
import ru.polinabevad.bugtracker.core.Task;
import ru.polinabevad.bugtracker.core.People;

import java.util.ArrayList;

/**
 * Список незакрытых задач пользователя, аля рабочая доска
 */
class UserBoard<T> extends ArrayList<T> {

    private boolean isAuthor;
    private Status isNotClose;

    public TaskList<Task> getUserBoard(People currentUser) {
        TaskList<Task> userBoard = new TaskList<>();

        for (Task task : TaskList.tasks) {
            if (task.getTaskAuthor() == currentUser) {
                userBoard.add(task);
            }
        }
        return userBoard;
    }

    public void printUserBoard(People currentUser) {

        for (Task task : getUserBoard(currentUser)) {
            System.out.println(task.toString());
        }

    }
}
