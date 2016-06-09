package ru.polinabevad.bugtracker.core;

import ru.polinabevad.bugtracker.profile.PeopleService;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Пользователь системы
 */

@Entity
@Table(name = "users")
public class People extends PeopleService {
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
    private boolean isActive;
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar regDate;
    @Transient
    private People currentUser;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "taskAuthor")
    private List<Task> tasksAuthor = new ArrayList<Task>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "taskAppointer")
    private List<Task> tasksAppointer = new ArrayList<Task>();

    public People() {
    }

    public People(String login) {
        this.login = login;
        this.isActive = true;
        regDate = Calendar.getInstance();
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
}
