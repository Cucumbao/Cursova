<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Відредагуйте Задачу</title>
    <link rel="stylesheet" href="EditTask.css">
</head>
<body>
<header>
    <h1>Редагування задачі</h1>
    <a class="baton" href="index.jsp">На головну</a>
    <a class="baton" href="TasksPage.jsp">Назад до списку завдань</a>
</header> <br>
<c:if test="${not empty task}">
    <form action="edit-task" method="post" class="editor">
        <label>
            Назва задачі
            <input type="text" name="title" value="${task.title}" readonly/><br>
        </label>
        <label>
            Опис задачі:
            <textarea name="description" placeholder="Введіть завдання">${task.description}</textarea>
        </label>
        <label>
            Дедлайн задачі
            <input type="date" name="date" value="${task.date}"/>
        </label>
        <label>
            Пріоритетність задачі
            <select name="priority">
                <option value="1" ${task.priority == '1' ? 'selected' : ''}>1</option>
                <option value="2" ${task.priority == '2' ? 'selected' : ''}>2</option>
                <option value="3" ${task.priority == '3' ? 'selected' : ''}>3</option>
                <option value="4" ${task.priority == '4' ? 'selected' : ''}>4</option>
                <option value="5" ${task.priority == '5' ? 'selected' : ''}>5</option>
            </select>
        </label>
        <div>
            <button class="buttons" type="submit">Зберегти зміни</button>
            <button class="buttons" type="reset">Відмінити</button>
        </div>
    </form>
</c:if>
</body>
</html>
