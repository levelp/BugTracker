package ru.polinabevad.bugtracker.taskboard;

import ru.polinabevad.bugtracker.taskmanagement.Task;

import java.util.ArrayList;

/**
 * Список задач
 */
public class TaskList extends ArrayList {

    private static Integer lastTaskNumber = 0;

    public TaskList(){

    }
    public TaskList(int leng) {
        this.ensureCapacity(leng);
    }

    public static TaskList tasks = new TaskList(100);

    public Integer increaseLastTaskNumber() {
        lastTaskNumber = ++lastTaskNumber;
        return lastTaskNumber;
    }

    public static Integer getLastTaskNumber() {
        return lastTaskNumber;
    }

    public void createTask(String taskName) {
        //при добавлении увеличиваем номер задачи на 1
        increaseLastTaskNumber();
        //создаем объект для новой задачи
        Task task = new Task();
        //заполняем поля задачи, пока имя и номер, даты создания и обновления - автоматически
        task.createTask(taskName, lastTaskNumber);
        //добавляем в список задач
        tasks.add(task);

    }
}
