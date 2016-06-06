package ru.polinabevad.bugtracker.taskmanagement;

import org.junit.Assert;
import org.junit.Test;

import ru.polinabevad.bugtracker.taskboard.TaskList;

/**
 *
 */
public class TaskListTest extends Assert{
    @Test
    public void test1() {
        TaskList.tasks.createTask("Первая задача");
        TaskList.tasks.createTask("Вторая задача");
        TaskList.tasks.createTask("Третья задача");
        Task task3 = (Task)TaskList.tasks.get(2);
        assertEquals("Номер задачи должен быть три", 3, task3.getTaskNumber());

        //проверяем что с таким же названием как предыдущая запишется с новым номером
        TaskList.tasks.createTask("Третья задача");
        Task task4 = (Task)TaskList.tasks.get(3);
        assertEquals("Номер задачи должен быть четыре", 4, task4.getTaskNumber());
        TaskList.tasks.getTasksList();

        //TODO: проверка удаленных
        System.out.println("===============");
        Task taskfindbyNumber = TaskList.tasks.getTaskByNumber(2);
        System.out.println("Задача найдена по номеру:2 " + taskfindbyNumber);

    }

}
