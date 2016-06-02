package ru.polinabevad.bugtracker.taskmanagement;

import com.sun.xml.internal.ws.api.message.MessageWritable;

import java.util.ArrayList;

/**
 * список сообщений задачи   , не доделан, не работает!!
 */
public class MessageList extends ArrayList{
    public static Task task;

    public MessageList(Task task) {
         this.task = task;
    }
}
