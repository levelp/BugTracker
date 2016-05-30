package ru.polinabevad.bugtracker.taskmanagement;

/**
 * Статус задачи, может использоваться сообщением для изменения
 */
public class Status {

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

        public String getStatus() {
            return statusName;
        }

        public void setStatus() {
            //TODO: соединить с StatusController
        }

        @Override
        public String toString() {
            return "Статус задачи: " + statusName;
        }
    }
}
