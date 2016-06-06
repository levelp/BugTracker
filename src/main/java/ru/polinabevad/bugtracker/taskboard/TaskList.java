package ru.polinabevad.bugtracker.taskboard;

import ru.polinabevad.bugtracker.taskmanagement.Task;

import java.util.ArrayList;

/**
 * Список задач
 */
public class TaskList extends ArrayList {

    public static TaskList tasks = new TaskList(100);
    private static Integer lastTaskNumber = 0;

    TaskList() {

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
            for (Object task1 : tasks) {
                if (task1.getClass() == Task.class) {
                    Task task = (Task) task1;
                    if (!task.getDeletedStatus()) {
                        System.out.println(task.toString());
                    }
                }
            }
        }

    }
   /*
    public Task getTask(int taskNumber) {
        tasks.
        return task;
    }
    */

}
