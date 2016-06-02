package ru.polinabevad.bugtracker.tasmanagement;

import org.junit.Assert;
import org.junit.Test;
import ru.polinabevad.bugtracker.taskmanagement.MessageList;
import ru.polinabevad.bugtracker.taskmanagement.Task;

import static java.lang.Thread.sleep;

/**
 * Проверка списка сообщений по конкретной задаче, еще не доделан!!!
 */
public class MessageListTest extends Assert{
    @Test
    public void test1() throws InterruptedException {
        Task task1 = new Task();
        task1.createTask("Первая задача",1);
        Task task2 = new Task();
        task2.createTask("Вторая задача",2);
        MessageList list1 = new MessageList(task1);
        MessageList list2 = new MessageList(task2);

        list1.createMessage("Тест1");
        System.out.println(task1.getTaskUpdateDate());

        list1.createMessage("Тест2");
        System.out.println(task1.getTaskUpdateDate());

        //задержка для проверки update date
        sleep(5000);
        list1.createMessage("Тест3");

        list2.createMessage("Тест1");
        System.out.println(task2.getTaskUpdateDate());

        System.out.println(task1.getTaskUpdateDate());

        for (Object somemessage : list1) {
            System.out.println(somemessage.toString());
        }

        for (Object somemessage : list2) {
            System.out.println(somemessage.toString());
        }
        //вывести дату апдейта задачи после добавления сообщений
        System.out.println(task1.getTaskUpdateDate());

    }


}
