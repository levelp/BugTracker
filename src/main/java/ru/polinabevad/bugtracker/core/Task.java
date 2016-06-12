package ru.polinabevad.bugtracker.core;

import ru.polinabevad.bugtracker.taskboard.TaskList;
import ru.polinabevad.bugtracker.taskmanagement.MessageList;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Calendar;
import java.util.List;

/**
 * Задача. В ней могут содержаться сообщения, есть статус, даты создания, обновления и закрытия. Обновление - любое изменение
 * с помощью сообщений. Прямое редактирование запрещено.
 * TODO: предусмотреть запрос подтверждения удаления задачи, ограничение - роль админа
 */
@Entity
@Table(name = "task")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "taskId_seq")
    @SequenceGenerator(name = "taskId_seq", sequenceName = "taskId_sequence", allocationSize = 1)
    private int taskId;

    @Column
    private String taskName;

    @Enumerated(EnumType.ORDINAL)
    private StatusType taskStatus;

    @Column
    private String taskDescription;
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar taskCreateDate;
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar taskUpdateDate;
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar taskCloseDate = null;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "taskAuthorId", insertable = true, updatable = false)
    private People taskAuthor;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "taskAppointerId", insertable = true, updatable = false)
    private People taskAppointer;

    @Transient
    private List<Message> taskMessages;

    public Task() {

    }

    public Task(String taskName) {
        taskCreateDate = Calendar.getInstance();
        taskUpdateDate = taskCreateDate;
        this.taskName = taskName;
        this.taskStatus = StatusType.OPEN;

    }
    public Task(String taskName, People taskAuthor, People taskAppointer) {
        taskCreateDate = Calendar.getInstance();
        taskUpdateDate = taskCreateDate;
        this.taskName = taskName;
        this.taskStatus = StatusType.OPEN;
        this.taskAuthor = taskAuthor;
        this.taskAppointer = taskAppointer;
    }

    void setCloseDate(Calendar date) {
        taskCloseDate = date;
    }

    public int getTaskId() {
        return this.taskId;
    }

    public Calendar getTaskUpdateDate() {
        return this.taskUpdateDate;
    }

    void setTaskUpdateDate(Calendar date) {
        taskUpdateDate = date;
    }

    public Calendar getTaskCloseDate() {
        if (taskCloseDate != null) return this.taskCloseDate;
        return null;
    }

    public Calendar getTaskCreateDate() {
        return this.taskCreateDate;
    }

    public void setTaskCreateDate(Calendar date) {
        taskCreateDate = date;
    }

    public String getTaskName() {
        return this.taskName;
    }

    public String getTaskNameLowerCase() {
        return this.taskName.toLowerCase();
    }

    public String getTaskDescription() {
        return this.taskDescription;
    }

    public People getTaskAuthor() {
        return this.taskAuthor;
    }

    public void setTaskAuthor(People taskAuthor) {
        this.taskAuthor = taskAuthor;
    }

    public People getTaskAppointer() {
        return this.taskAppointer;
    }

    public void setTaskAppointer(People taskAppointer) {
        this.taskAppointer = taskAppointer;
    }

    public List<Message> getTaskMessages() {
        return taskMessages;
    }

    public StatusType getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(StatusType statusType) {
        this.taskStatus = statusType;
    }

    public String toString() {
        return "Номер задачи: " + taskId + " Название задачи: " + taskName + " Create date:" +
                taskCreateDate.getTime() + " Update date:" + taskUpdateDate.getTime();
    }

    //полной процедуры пока удаления не будет, просто помечаем как isDeleted
    public String deleteTask(People currentUser) {
        //проверяем, что пользователь админ
        if (currentUser.checkUserisAdmin()) {
            TaskList.tasks.remove(this);
            return "Задача удалена.";
        }
        //TODO: заменить на Exception
        return "У юзера нет прав на удаление";
    }

}
