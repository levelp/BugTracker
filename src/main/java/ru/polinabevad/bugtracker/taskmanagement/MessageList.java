package ru.polinabevad.bugtracker.taskmanagement;


import java.util.ArrayList;

/**
 * список сообщений задачи   , не доделан, не работает!!
 */
class MessageList extends ArrayList {
    public static Task task;

    MessageList(Task task) {
         this.task = task;

    }
}
