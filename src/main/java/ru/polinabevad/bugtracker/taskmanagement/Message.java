package ru.polinabevad.bugtracker.taskmanagement;

import ru.polinabevad.bugtracker.profile.*;
import ru.polinabevad.bugtracker.taskboard.*;


/**
 * Сообщение к задаче. Может поменять статус системы, поставить нового\изменить Автора\Исполнителя
 * TODO: предусмотреть запрос подтверждения удаления сообщения, ограничение - роль админа
 */
class Message {
    private java.util.Date messageDate;
    private User messageAuthor;
    private Status messageStatus;
    private User messageAppointer;

    public void createMessage() {
    }

    public void deleteMessage() {
    }
}
