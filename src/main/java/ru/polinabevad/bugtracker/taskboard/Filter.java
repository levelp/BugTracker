package ru.polinabevad.bugtracker.taskboard;


import ru.polinabevad.bugtracker.core.StatusType;
import ru.polinabevad.bugtracker.core.Task;
import ru.polinabevad.bugtracker.core.People;
import java.util.ArrayList;
import java.util.Calendar;
/**
 * Фильтр списка задач. Может быть нужно будет убрать и заменить представлением.
 */
class Filter extends ArrayList<Task> {

    TaskList<Task> getTasksByAuthor(People taskAuthor) {
        TaskList<Task> taskSearch = new TaskList<>();
        for (Task task : TaskList.tasks) {
            if (task.getTaskAuthor() == taskAuthor)
                taskSearch.add(task);
        }
        return taskSearch;
    }

    TaskList<Task> getTasksByAppointer(People taskAppointer) {
        TaskList<Task> taskSearch = new TaskList<>();
        for (Task task : TaskList.tasks) {
            if (task.getTaskAppointer() == taskAppointer)
                taskSearch.add(task);
        }
        return taskSearch;
    }

    TaskList<Task> getTasksByStatus(StatusType taskStatus) {
        TaskList<Task> taskSearch = new TaskList<>();
        for (Task task : TaskList.tasks) {
            if (task.getTaskStatus() == taskStatus)
                taskSearch.add(task);
        }
        return taskSearch;
    }

    TaskList<Task> getTasksByName(String taskName) {
        TaskList<Task> taskSearch = new TaskList<>();
        for (Task task : TaskList.tasks) {
            if (task.getTaskNameLowerCase().contains(taskName.toLowerCase()))
                taskSearch.add(task);
        }
        return taskSearch;
    }

    TaskList<Task> getTasksByCreateDate(Calendar from, Calendar to) {
        TaskList<Task> taskSearch = new TaskList<>();
        for (Task task : TaskList.tasks) {
            if ((task.getTaskCreateDate().after(from)) && (task.getTaskCreateDate().before(to)))
                taskSearch.add(task);
        }
        return taskSearch;
    }

    public TaskList<Task> getTasksByUpdateDate(Calendar from, Calendar to) {
        TaskList<Task> taskSearch = new TaskList<>();
        for (Task task : TaskList.tasks) {
            if ((task.getTaskUpdateDate().after(from)) && (task.getTaskUpdateDate().before(to)))
                taskSearch.add(task);
        }
        return taskSearch;
    }

    public TaskList<Task> getTasksByCloseDate(Calendar from, Calendar to) {
        TaskList<Task> taskSearch = new TaskList<>();
        for (Task task : TaskList.tasks) {
            if ((task.getTaskCloseDate().after(from)) && (task.getTaskCloseDate().before(to)))
                taskSearch.add(task);
        }
        return taskSearch;
    }
}

