package ru.polinabevad.bugtracker.taskboard;

import ru.polinabevad.bugtracker.profile.User;
import ru.polinabevad.bugtracker.profile.UserType;
import ru.polinabevad.bugtracker.taskmanagement.Task;

import java.util.ArrayList;

/**
 * Список задач
 */
public class TaskList extends ArrayList {

    private static Integer lastTaskNumber = 0;

    public TaskList() {

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
     // без удаленных (помеченных на isDeleted)
    public void getTasksList() {
        if (tasks != null) {
            for (int i=0; i<tasks.size(); i++) {
                if (tasks.get(i).getClass() == Task.class) {
                    Task task = (Task)tasks.get(i);
                    if (task.getDeletedStatus()!=true) {
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
