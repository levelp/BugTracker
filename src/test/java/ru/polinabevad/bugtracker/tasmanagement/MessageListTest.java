package ru.polinabevad.bugtracker.tasmanagement;

import org.junit.Assert;
import org.junit.Test;
import ru.polinabevad.bugtracker.taskmanagement.MessageList;
import ru.polinabevad.bugtracker.taskmanagement.Task;

import static java.lang.Thread.sleep;

/**
 *
 */
public class MessageListTest extends Assert{
    @Test
    public void test1() throws InterruptedException {
        Task task = new Task();
        MessageList list = new MessageList(task);

        MessageList.messages.createMessage("Тест1");
        System.out.println(task.getTaskUpdateDate());

        MessageList.messages.createMessage("Тест2");
        System.out.println(task.getTaskUpdateDate());

        //задержка для проверки update date
        sleep(5000);
        MessageList.messages.createMessage("Тест3");

        System.out.println(task.getTaskUpdateDate());
        for (Object somemessage : MessageList.messages) {
            System.out.println(somemessage.toString());
        }
        //вывести дату апдейта задачи после добавления сообщений
        System.out.println(task.getTaskUpdateDate());

    }


}
