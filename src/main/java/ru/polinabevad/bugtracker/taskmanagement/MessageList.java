package ru.polinabevad.bugtracker.taskmanagement;

import java.util.ArrayList;

/**
 * список сообщений задачи
 */
public class MessageList extends ArrayList{
    public static Task task;

    public MessageList(Task task) {
        this.task = task;
    }
    public static MessageList messages = new MessageList(task);

    public void createMessage(String messageText) {
        Message message = new Message(task);
        message.createMessage(messageText);
        messages.add(message);
    }
}
