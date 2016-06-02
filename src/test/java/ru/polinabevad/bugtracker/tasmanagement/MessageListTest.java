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

        task1.createMessage("Тест1");
        task1.createMessage("Тест2");
        //вывести дату апдейта 1-ой задачи после добавления первых сообщений
        System.out.println(task1.getTaskUpdateDate());

        //задержка для проверки update date
        sleep(2000);
        task1.createMessage("Тест3");
        //задержка для проверки update date
        sleep(2000);
        task2.createMessage("Тест1");

        // В первую задачу должно добавиться 3 сообщения
        assertEquals("[Текст: Тест1, Текст: Тест2, Текст: Тест3]", task1.getTaskMessages().toString());

        // Во вторую одно сообщение
        assertEquals("[Текст: Тест1]", task2.getTaskMessages().toString());
        //вывести дату апдейта 1-ой задачи после добавления последнего сообщения
        System.out.println(task1.getTaskUpdateDate());
        //вывести дату апдейта 2-ой задачи после добавления сообщений
        System.out.println(task2.getTaskUpdateDate());

    }


}
