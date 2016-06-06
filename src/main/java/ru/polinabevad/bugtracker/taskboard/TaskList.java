package ru.polinabevad.bugtracker.taskboard;

import ru.polinabevad.bugtracker.taskmanagement.Task;

import java.util.ArrayList;

/**
 * Список задач
 */
public class TaskList<T> extends ArrayList<T> {

    public static TaskList<Task> tasks = new TaskList<Task>(100);
    private static Integer lastTaskNumber = 0;

    private TaskList() {
    }

    private TaskList(int leng) {
        this.ensureCapacity(leng);
    }

    public static Integer getLastTaskNumber() {
        return lastTaskNumber;
    }

    private Integer increaseLastTaskNumber() {
        lastTaskNumber = ++lastTaskNumber;
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

    // без удаленных (помеченных на isDeleted)
    public void getTasksList() {
        if (tasks != null) {
            for (Task task : tasks) {
                if (!task.getDeletedStatus()) {
                    System.out.println(task.toString());
                }
            }
        }
    }

    public Task getTaskByNumber(int taskNumber) {
        for (Task task : tasks) {
            if (task.getTaskNumber() == taskNumber)
                return task;
        }
        return null;
    }
}



