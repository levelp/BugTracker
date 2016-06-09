package ru.polinabevad.bugtracker.core;

import ru.polinabevad.bugtracker.core.Status.*;

import javax.persistence.*;
import java.util.Calendar;


/**
 * Сообщение к задаче. Может поменять статус системы, поставить нового\изменить Автора\Исполнителя
 */
@Entity
@Table(name = "message")
public class Message {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column
    private int messageId;
    @OneToOne
    @JoinColumn(name = "statusId")
    private Status messageStatus;

    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private People messageAppointer;

    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private People messageAuthor;

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar messageDate;
    @Column
    private String messageText;
    @OneToOne
    @JoinColumn(name = "taskId")
    private Task taskId;
    @Transient
    private Task task;

    public Message() {
    }

    public Message(Task task) {
        this.task = task;
    }

    public void createMessage(String messageText) {
        //считываем текущую дату
        messageDate = Calendar.getInstance();

        //устанавливаем дату апдейта задачи датой сообщения
        task.setUpdateDate(messageDate);
        //добавляем текст сообщения
        this.messageText = messageText;
    }

    public String toString() {
        return "Текст: " + messageText;
    }

    public void deleteMessage() {
    }

    public StatusType changeTaskStatus(StatusType statusTypeTo) {
        StatusType statusTypeFrom = task.getTaskStatus();
        //разрешаем перевод из открыт в работу
        if ((statusTypeFrom == StatusType.OPEN) && (statusTypeTo == StatusType.WORK)) {
            task.setTaskStatus(statusTypeTo);
            return task.getTaskStatus();
        }
        //разрешаем перевод из работы в проверку
        if ((statusTypeFrom == StatusType.WORK) && (statusTypeTo == StatusType.CHECK)) {
            task.setTaskStatus(statusTypeTo);
            return task.getTaskStatus();
        }
        //разрешаем перевод из проверки в работу
        if ((statusTypeFrom == StatusType.CHECK) && (statusTypeTo == StatusType.WORK)) {
            task.setTaskStatus(statusTypeTo);
            return task.getTaskStatus();
        }
        //разрешаем перевод из проверки в закрыт и обновляем дату закрытия задачи
        if ((statusTypeFrom == StatusType.CHECK) && (statusTypeTo == StatusType.CLOSE)) {
            task.setTaskStatus(statusTypeTo);
            task.setCloseDate(messageDate);
            return task.getTaskStatus();
        }
        task.setTaskStatus(statusTypeFrom);
        return task.getTaskStatus();

    }

}
