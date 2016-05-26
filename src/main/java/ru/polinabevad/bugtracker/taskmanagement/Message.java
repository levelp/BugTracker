package ru.polinabevad.bugtracker.taskmanagement;

/**
 * Сообщение к задаче. Может поменять статус системы, поставить нового\изменить Автора\Исполнителя
 */
class Message {
    private java.util.Date messageDate;
    private ru.polinabevad.bugtracker.profile.User messageAuthor;
    private Status messageStatus;
    private ru.polinabevad.bugtracker.profile.User messageAppointer;

    public void createMessage() {
    }

    public void deleteMessage() {
    }
}
