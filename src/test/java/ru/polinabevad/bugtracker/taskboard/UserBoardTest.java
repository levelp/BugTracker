package ru.polinabevad.bugtracker.taskboard;


import org.junit.Assert;
import org.junit.Test;
import ru.polinabevad.bugtracker.profile.User;
import ru.polinabevad.bugtracker.taskboard.*;
import ru.polinabevad.bugtracker.taskmanagement.Task;

/**
 *
 */
public class UserBoardTest extends Assert {
    @Test
    public void test1() {
        UserBoard userBoard = new UserBoard();
        User currentUser = new User();
        //создаем 2 задачи, одну поставим автора каррент юзера, другую нет
        TaskList.tasks.createTask("Тест");
        TaskList.tasks.createTask("Тест2");
        TaskList.tasks.createTask("Тест3");
        Task task1 = TaskList.tasks.getTaskByNumber(1);
        task1.setTaskAuthor(currentUser);
        Task task3 = TaskList.tasks.getTaskByNumber(3);
        task3.setTaskAuthor(currentUser);
        //в результате должна отобразиться одна задача пока, доделать на несколько.
        //TODO: Доработать выборку нескольких задач
        System.out.println(userBoard.getUserBoard(currentUser));
    }
}
