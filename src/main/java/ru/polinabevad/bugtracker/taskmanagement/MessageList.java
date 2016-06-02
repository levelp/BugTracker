package ru.polinabevad.bugtracker.taskmanagement;

import com.sun.xml.internal.ws.api.message.MessageWritable;

import java.util.ArrayList;

/**
 * список сообщений задачи   , не доделан, не работает!!
 */
public class MessageList extends ArrayList{
    Task task;
    public MessageList(Task task) {

    }

    public void createMessage(String messageText) {
        Message message = new Message(task);
        message.createMessage(messageText);
        add(message);
    }
}
