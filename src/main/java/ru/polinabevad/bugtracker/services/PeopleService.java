package ru.polinabevad.bugtracker.services;

import ru.polinabevad.bugtracker.core.People;
import ru.polinabevad.bugtracker.dao.PeopleDao;

import java.util.ArrayList;

/**
 * Тип пользователя: админский или нет, у админского будут права на удаление задач\сообщений
 */
public class PeopleService {

    private static PeopleDao peopleDao;

    public PeopleService() {
        peopleDao = new PeopleDao();
    }

    public void persist(People entity) {
        peopleDao.openCurrentSessionWithTransaction();
        peopleDao.persist(entity);
        peopleDao.closeCurrentSessionWithTransaction();
    }

    public void update(People entity) {
        peopleDao.openCurrentSessionWithTransaction();
        peopleDao.update(entity);
        peopleDao.closeCurrentSessionWithTransaction();
    }

    public People findById(int id) {
        peopleDao.openCurrentSession();
        People people = peopleDao.findById(id);
        peopleDao.closeCurrentSession();
        return people;
    }

    public void delete(Integer id) {
        peopleDao.openCurrentSessionWithTransaction();
        People people = peopleDao.findById(id);
        peopleDao.delete(people);
        peopleDao.closeCurrentSessionWithTransaction();
    }

    public ArrayList<People> findAll() {
        peopleDao.openCurrentSession();
        ArrayList<People> peoples = peopleDao.findAll();
        peopleDao.closeCurrentSession();
        return peoples;
    }

    public void deleteAll() {
        peopleDao.openCurrentSessionWithTransaction();
        peopleDao.deleteAll();
        peopleDao.closeCurrentSessionWithTransaction();
    }
}

