package ru.polinabevad.bugtracker.dao;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.polinabevad.bugtracker.core.Task;

import java.util.ArrayList;
import java.util.Collection;

// DAO - Data Access Object
@Service("TaskDao")
@Transactional
public class TaskDao<T> extends DAO<Task, Integer> {

    public Task findById(Integer id) {
        return getCurrentSession().get(Task.class, id);
    }

    @SuppressWarnings("unchecked")
    public ArrayList<Task> findAll() {
        return (ArrayList<Task>) getCurrentSession().createQuery("FROM Task").list();
    }

    public void deleteAllBulk() {
        getCurrentSession().createQuery("DELETE FROM Task").executeUpdate();
    }

    public void deleteFromTo(Integer from, Integer to) {
        getCurrentSession().createQuery("DELETE FROM Task " +
                "WHERE id >= :from AND id <= :to")
                .setParameter("from", from)
                .setParameter("to", to)
                .executeUpdate();
    }

    private void deleteById(Integer id) {
        getCurrentSession().createQuery("DELETE FROM Task  " +
                "WHERE id = :id")
                .setParameter("id", id)
                .executeUpdate();
    }

    public void deleteCollection(Collection<Integer> list) {
        list.forEach(this::deleteById);
    }
}