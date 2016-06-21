package ru.polinabevad.bugtracker.core;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Пользователь системы
 */

@Entity
@Table(name = "users")
public class People {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;
    @Column
    private String login;
    @Column
    private String name;
    @Column
    private String password;
    @Column
    private String email;
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar regDate;
    @Transient
    private People currentUser;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "taskAuthor")
    private List<Task> tasksAuthor = new ArrayList<>();
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "taskAppointer")
    private List<Task> tasksAppointer = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "messageAuthor")
    private List<Message> messagesAuthor = new ArrayList<>();
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "messageAppointer")
    private List<Message> messagesAppointer = new ArrayList<>();

    //пользователь-админ (может все)

    @Column
    private boolean isAdmin;

    //пользователь - поддержка (принимают задачи в работу)
    @Column
    private boolean isSupport;
    //пользователь активен?
    @Column
    private boolean isActive;

    public People() {
    }

    public People(String login) {
        this.login = login;
        this.isActive = true;
        regDate = Calendar.getInstance();
        this.isAdmin = false;
        this.isSupport = false;
    }

    public static People createUser(String login) {
        People user = new People();
        user.login = login;
        user.isActive = true;
        return user;
    }

    public void disableUserActivity() {
        this.isActive = false;
    }

    public String getLogin() {
        return login;
    }

    public void changeUserType(String type) {
        if (type.equals("admin")) {
            this.makeUserAdmin();
        }
        if (type.equals("support")) {
            this.makeUserSupport();
        }

    }

    public People getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(People user) {
        this.currentUser = user;
    }

    //сделать пользователя админом
    private void makeUserAdmin() {
        isAdmin = true;
    }

    // сделать пользователя саппортом
    private void makeUserSupport() {
        isSupport = true;
    }

    //TODO:здесь будет проверка прав пользователя
    boolean checkUserisAdmin() {
        return isAdmin;
    }

    boolean checkUserisSupport() {
        return isSupport;
    }


}
