package ru.polinabevad.bugtracker.core;

public enum StatusType {
    //Перечисляем варианты состояний задачи и их названия
    OPEN("Открыт"),
    WORK("В работе"),
    CHECK("В проверке"),
    CLOSE("Закрыт");

    private final String statusName;

    StatusType(String statusName) {
        this.statusName = statusName;
    }

    public String getStatusName() {
        return statusName;
    }

    @Override
    public String toString() {
        return "Статус задачи: " + statusName;
    }

    public boolean equals(StatusType statusTypeTo) {
        if (this.statusName.equals(statusTypeTo.statusName))
            return true;
        if (getClass() != statusTypeTo.getClass())
            return false;
        return false;
    }
}
