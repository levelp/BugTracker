package ru.polinabevad.bugtracker.taskboard;

import ru.polinabevad.bugtracker.core.Task;

import java.util.ArrayList;

/**
 * Список задач
 */
public class TaskList<T> extends ArrayList<T> {

    public static TaskList<Task> tasks = new TaskList<>(100);

    public TaskList() {
    }

    private TaskList(int leng) {
        this.ensureCapacity(leng);
    }

    public void createTask(String taskName) {
        //создаем объект для новой задачи
        Task task = new Task(taskName);
        //заполняем поля задачи, пока имя и номер, даты создания и обновления - автоматически
        //добавляем в список задач
        tasks.add(task);

    }
    // без удаленных (помеченных на isDeleted)
    public void printTasksList() {
        if (tasks != null) {
            for (Task task : tasks) {
                System.out.println(task.toString());
            }
        }
    }

    public Task getTaskById(int taskId) {
        for (Task task : tasks) {
            if (task.getTaskId() == taskId)
                return task;
        }
        return null;
    }


    public int getIndex(Task task) {
        return tasks.indexOf(task);
    }

}





