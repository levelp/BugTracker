package ru.polinabevad.bugtracker.dao;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.polinabevad.bugtracker.core.People;

import java.util.ArrayList;
import java.util.Collection;

// DAO - Data Access Object
@Service("PeopleDao")
@Transactional
public class PeopleDao<T> extends DAO<People, Integer> {
    public People findById(Integer id) {
        return (People) getCurrentSession().get(People.class, id);
    }

    @SuppressWarnings("unchecked")
    public ArrayList<People> findAll() {
        return (ArrayList<People>) getCurrentSession().createQuery("FROM People").list();
    }

    public void deleteAllBulk() {
        getCurrentSession().createQuery("DELETE FROM People").executeUpdate();
    }

    public void deleteFromTo(Integer from, Integer to) {
        getCurrentSession().createQuery("DELETE FROM People " +
                "WHERE id >= :from AND id <= :to")
                .setParameter("from", from)
                .setParameter("to", to)
                .executeUpdate();
    }

    private void deleteById(Integer id) {
        getCurrentSession().createQuery("DELETE FROM People  " +
                "WHERE id = :id")
                .setParameter("id", id)
                .executeUpdate();
    }

    public void deleteCollection(Collection<Integer> list) {
        list.forEach(this::deleteById);
    }
}