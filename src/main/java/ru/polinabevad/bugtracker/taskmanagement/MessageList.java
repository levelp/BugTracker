package ru.polinabevad.bugtracker.taskmanagement;


import ru.polinabevad.bugtracker.core.Task;

import javax.persistence.Entity;
import java.util.ArrayList;

/**
 * список сообщений задачи   , не доделан, не работает!!
 */

public class MessageList<T> extends ArrayList<T> {
    public static Task task;

    public MessageList(Task task) {
         this.task = task;

    }
}
