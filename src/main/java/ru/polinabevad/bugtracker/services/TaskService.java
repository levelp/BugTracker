package ru.polinabevad.bugtracker.services;

import ru.polinabevad.bugtracker.dao.TaskDao;
import ru.polinabevad.bugtracker.core.Task;

import java.util.ArrayList;

public class TaskService {

    private static TaskDao taskDao;

    public TaskService() {
        taskDao = new TaskDao();
    }

    public void persist(Task entity) {
        taskDao.openCurrentSessionWithTransaction();
        taskDao.persist(entity);
        taskDao.closeCurrentSessionWithTransaction();
    }

    public void update(Task entity) {
        taskDao.openCurrentSessionWithTransaction();
        taskDao.update(entity);
        taskDao.closeCurrentSessionWithTransaction();
    }

    public Task findById(int id) {
        taskDao.openCurrentSession();
        Task task = taskDao.findById(id);
        taskDao.closeCurrentSession();
        return task;
    }

    public void delete(Integer id) {
        taskDao.openCurrentSessionWithTransaction();
        Task task = taskDao.findById(id);
        taskDao.delete(task);
        taskDao.closeCurrentSessionWithTransaction();
    }

    public ArrayList<Task> findAll() {
        taskDao.openCurrentSession();
        ArrayList<Task> tasks = taskDao.findAll();
        taskDao.closeCurrentSession();
        return tasks;
    }

    public void deleteAll() {
        taskDao.openCurrentSessionWithTransaction();
        taskDao.deleteAll();
        taskDao.closeCurrentSessionWithTransaction();
    }
}
