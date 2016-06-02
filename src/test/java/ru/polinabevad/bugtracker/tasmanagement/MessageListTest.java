package ru.polinabevad.bugtracker.tasmanagement;

import org.junit.Assert;
import org.junit.Test;
import ru.polinabevad.bugtracker.taskmanagement.MessageList;
import ru.polinabevad.bugtracker.taskmanagement.Task;

/**
 *
 */
public class MessageListTest extends Assert{
    @Test
    public void test1() {
        Task task = new Task();
        MessageList list = new MessageList(task);

        MessageList.messages.createMessage("Тест1");
        MessageList.messages.createMessage("Тест2");
        MessageList.messages.createMessage("Тест3");
        for (Object somemessage : MessageList.messages) {
            System.out.println(somemessage.toString());
        }

    }


}
