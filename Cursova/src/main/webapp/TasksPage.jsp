<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Список завдань</title>
    <link rel="stylesheet" href="taskPage.css">
</head>
<header>
    <a href="index.jsp">Додати задачу</a>
</header>
<body>
<h1>Список завдань</h1>
<c:if test="${not empty error}">
    <div id="error">
         ${error}
    </div>
</c:if>
<c:forEach var="task" items="${tasks}">
    <div>
        <form action="delete" method="post">
            <label>
                <input type="checkbox">
                <input type="hidden" name="title" value="${task.title}">
                <input type="hidden" name="description" value="${task.description}">
                <input type="hidden" name="priority" value="${task.priority}">
                <input type="hidden" name="date" value="${task.date}">
                <span>Заголовок:  ${task.title},<br> Опис задачі:  ${task.description}, <br>Пріоритетність:  ${task.priority},<br> Дедлайн:  ${task.date}</span>
                <button id="delitbutton" type="submit">Видалити</button>
            </label>
        </form>
        <form action="edit-task" method="get">
            <button type="submit" name="title" value="${task.title}">Редагувати</button>
        </form>
    </div>
</c:forEach>
</body>
</html>
