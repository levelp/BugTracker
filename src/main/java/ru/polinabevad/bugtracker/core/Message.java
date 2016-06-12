package ru.polinabevad.bugtracker.core;

import ru.polinabevad.bugtracker.core.Task.*;

import javax.persistence.*;
import java.util.Calendar;


/**
 * Сообщение к задаче. Может поменять статус системы, поставить нового\изменить Автора\Исполнителя
 */
@Entity
@Table(name = "message")
public class Message {
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "messageId_seq")
    @SequenceGenerator(name = "messageId_seq", sequenceName = "messageId_sequence", allocationSize = 1)
    @Id
    private int messageId;

    @Column
    private StatusType messageStatus;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "messageAppointerId", insertable = true, updatable = false)
    private People messageAppointer;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "messageAuthorId", insertable = true, updatable = false)
    private People messageAuthor;

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar messageDate;
    @Column
    private String messageText;

    @OneToOne
    @JoinColumn(name = "taskId")
    private Task task;

    public Message() {
    }

    public Message(Task task) {
        this.task = task;
    }

    public Message(Task task, People messageAppointer, String messageText) {
        this.messageAuthor = task.getTaskAuthor();
        this.messageAppointer = messageAppointer;
        messageDate = Calendar.getInstance();
        this.task = task;
        //устанавливаем дату апдейта задачи датой сообщения
        task.setTaskUpdateDate(messageDate);
        //добавляем текст сообщения
        this.messageText = messageText;
        this.messageStatus = task.getTaskStatus();
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
            this.setMessageStatus(statusTypeTo);
            return task.getTaskStatus();
        }
        //разрешаем перевод из работы в проверку
        if ((statusTypeFrom == StatusType.WORK) && (statusTypeTo == StatusType.CHECK)) {
            task.setTaskStatus(statusTypeTo);
            this.setMessageStatus(statusTypeTo);
            return task.getTaskStatus();
        }
        //разрешаем перевод из проверки в работу
        if ((statusTypeFrom == StatusType.CHECK) && (statusTypeTo == StatusType.WORK)) {
            task.setTaskStatus(statusTypeTo);
            this.setMessageStatus(statusTypeTo);
            return task.getTaskStatus();
        }
        //разрешаем перевод из проверки в закрыт и обновляем дату закрытия задачи
        if ((statusTypeFrom == StatusType.CHECK) && (statusTypeTo == StatusType.CLOSE)) {
            task.setTaskStatus(statusTypeTo);
            this.setMessageStatus(statusTypeTo);
            task.setCloseDate(messageDate);
            return task.getTaskStatus();
        }
        task.setTaskStatus(statusTypeFrom);
        System.out.println("Невозможно перевести задачу в статус " + statusTypeTo.getStatusName() +
                ", т.к. она находится в статусе " + statusTypeFrom.getStatusName());
        return task.getTaskStatus();

    }


    public StatusType getMessageStatus() {
        return messageStatus;
    }

    public void setMessageStatus(StatusType status) {
        this.messageStatus = status;
    }

}
