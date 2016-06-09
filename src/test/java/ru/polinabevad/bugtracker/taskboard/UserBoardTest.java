package ru.polinabevad.bugtracker.taskboard;


import org.junit.Assert;
import org.junit.Test;
import ru.polinabevad.bugtracker.core.People;
import ru.polinabevad.bugtracker.core.Task;

/**
 *
 */
public class UserBoardTest extends Assert {
    @Test
    public void test1() {
        UserBoard userBoard = new UserBoard();
        People currentUser = new People();
        //создаем 2 задачи, одну поставим автора каррент юзера, другую нет
        TaskList.tasks.createTask("Тест");
        TaskList.tasks.createTask("Тест2");
        TaskList.tasks.createTask("Тест3");
        Task task1 = TaskList.tasks.get(0);
        task1.setTaskAuthor(currentUser);
        Task task3 = TaskList.tasks.get(2);
        task3.setTaskAuthor(currentUser);

        System.out.println("Выдача доски пользователя: ");
        userBoard.getUserBoard(currentUser);  // это запрос для получения доски как объекта
        userBoard.printUserBoard(currentUser); // это печать задач доски


    }
}
