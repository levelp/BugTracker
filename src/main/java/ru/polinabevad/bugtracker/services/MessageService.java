package ru.polinabevad.bugtracker.services;

import ru.polinabevad.bugtracker.core.Message;
import ru.polinabevad.bugtracker.core.People;
import ru.polinabevad.bugtracker.dao.MessageDao;
import ru.polinabevad.bugtracker.dao.PeopleDao;

import java.util.ArrayList;

/**
 * Тип пользователя: админский или нет, у админского будут права на удаление задач\сообщений
 */
public class MessageService {

    private static MessageDao messageDao;

    public MessageService() {
        messageDao = new MessageDao();
    }

    public void persist(Message entity) {
        messageDao.openCurrentSessionWithTransaction();
        messageDao.persist(entity);
        messageDao.closeCurrentSessionWithTransaction();
    }

    public void update(Message entity) {
        messageDao.openCurrentSessionWithTransaction();
        messageDao.update(entity);
        messageDao.closeCurrentSessionWithTransaction();
    }

    public Message findById(int id) {
        messageDao.openCurrentSession();
        Message message = messageDao.findById(id);
        messageDao.closeCurrentSession();
        return message;
    }

    public void delete(Integer id) {
        messageDao.openCurrentSessionWithTransaction();
        Message message = messageDao.findById(id);
        messageDao.delete(message);
        messageDao.closeCurrentSessionWithTransaction();
    }

    public ArrayList<Message> findAll() {
        messageDao.openCurrentSession();
        ArrayList<Message> messages = messageDao.findAll();
        messageDao.closeCurrentSession();
        return messages;
    }

    public ArrayList<Message> findByTaskId(Integer taskId) {
        messageDao.openCurrentSession();
        ArrayList<Message> messages = messageDao.findByTaskId(taskId);
        messageDao.closeCurrentSession();
        return messages;
    }

    public void deleteAll() {
        messageDao.openCurrentSessionWithTransaction();
        messageDao.deleteAll();
        messageDao.closeCurrentSessionWithTransaction();
    }
}

