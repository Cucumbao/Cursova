<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Планер задач</title>
    <link rel="stylesheet" href="index.css">
</head>
<body>
<header>
    <h1>Заплануйте задачу</h1>
    <br/>
    <a href="TasksPage.jsp">Переглянути список завдань</a>
</header>
<div id="форма">
<img src="img/notepad.png" alt="" width="400px" >
<form action="list-of-tasks" method="post">
    <label>Введіть назву задачі:
        <input type="text" name="title" /> <br>
    </label>
    <label>Введіть опис задачі:<br>
        <textarea name="description" placeholder="Введіть опис до завданнячка)"></textarea><br>
    </label>
    <label>Зазначте пріоритетність задачі:
        <select name="priority">
            <option name="1"> 1 </option>
            <option name="2"> 2 </option>
            <option name="3"> 3 </option>
            <option name="4"> 4 </option>
            <option name="5"> 5 </option>
        </select>
    </label>   <br>

    <label>Поставте дедлайн задачі
        <input type="date" name="date">
    </label>   <br>
    <input type="submit" value="Додати задачу" >
</form>
</div>
</body>
</html>
