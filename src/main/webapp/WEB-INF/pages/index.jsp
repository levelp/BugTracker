<%@ page import="ru.polinabevad.bugtracker.taskboard.TaskList" %>
<%@ page import="ru.polinabevad.bugtracker.core.Task" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Стартовая страница Баг-трекера</title>

    <link href="<c:url value="/resources/clearcss.css" />"  rel="stylesheet" >
    <link href="<c:url value="/resources/index.css"/>"  rel="stylesheet" >


</head>
<body>
<div class="main">

    <div class="header"> Здесь будет заголовок с переходом на главную + кнопки:
        <button name="create">Войти\Зарегистрироваться</button>
        <button name="create">FAQ</button>
        <br>

    </div>

    <div class="center">
        <div class="leftpane">
            Здесь будут кнопки:
            <button name="create">Создать задачу</button>
            <br><br>
            <button name="taskList">Список задач</button>
            <br> <br>
            <button name="taskFilter">Фильтр задач</button>
            <br> <br>

        </div>
        <div class="content">
            Здесь будет выводиться само приложение: список задач, при клике на задаче - содержимое задачи,
            при этом кнопки поменяются - добавятся кнопки для комментариев и перехода назад. <br>
            Нужны еще страницы:<br>
            форма новой задачи, форма редактирования задачи, форма просмотра задачи.<br>
            форма списка задач, FAQ, форма логина и форма регистрации
            (возможно просто два поля в заголовке с кнопками Войти\Зарегистрироваться).<br>
            Пока для проверки добавляется при каждом обновлении страницы задача в список и выводится ее
            toString.<br><br>
            Переделать все ниже на запрос из модели.
            {$task.service
            <%
                TaskList.tasks.createTask("Новая задача");
                for (int i = 0; i < TaskList.tasks.size(); i++) {
                    if (TaskList.tasks.get(i).getClass() == Task.class) {
                        Task task = TaskList.tasks.get(i);
            %>
            <%-- Ругается на print. Что за бред?--%>
            <% out.print("Задача " + task.toString()); %> <br>
            <%
                        }
                }
            %>

        </div>

        <div class="rigthpane">
            Здесь будут блоки с названиями задач, перечисление и ссылка: <br>
            "Мои задачи (последние 5)"<br>
            "Новые задачи (последние 5)<br>
        </div>

    </div>


    <div class="footer">
        Здесь будет информация о приложении: контакты, год.
    </div>
</div>


</body>
</html>
