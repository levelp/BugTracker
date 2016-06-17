package ru.polinabevad.bugtracker.dao;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.polinabevad.bugtracker.core.Message;
import ru.polinabevad.bugtracker.core.Task;

import java.util.ArrayList;
import java.util.Collection;

// DAO - Data Access Object
@Service("MessageDao")
@Transactional
public class MessageDao<T> extends DAO<Message, Integer> {
    public Message findById(Integer id) {
        return (Message) getCurrentSession().get(Message.class, id);
    }

    @SuppressWarnings("unchecked")
    public ArrayList<Message> findAll() {
        return (ArrayList<Message>) getCurrentSession().createQuery("FROM Message").list();
    }

    public ArrayList<Message> findByTaskId(Integer taskId) {
        return (ArrayList<Message>) getCurrentSession().createQuery("FROM Message " +
                " WHERE task=" + taskId)
                .list();
    }

    public void deleteAllBulk() {
        getCurrentSession().createQuery("DELETE FROM Message").executeUpdate();
    }

    public void deleteFromTo(Integer from, Integer to) {
        getCurrentSession().createQuery("DELETE FROM Message " +
                "WHERE id >= :from AND id <= :to")
                .setParameter("from", from)
                .setParameter("to", to)
                .executeUpdate();
    }

    private void deleteById(Integer id) {
        getCurrentSession().createQuery("DELETE FROM Message  " +
                "WHERE id = :id")
                .setParameter("id", id)
                .executeUpdate();
    }

    public void deleteCollection(Collection<Integer> list) {
        list.forEach(this::deleteById);
    }
}