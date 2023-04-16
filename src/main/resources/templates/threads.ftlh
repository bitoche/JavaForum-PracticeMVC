<!DOCTYPE html>
<html lang="RU">
<head>

    <title>Forum</title>

</head>
<body>
<h1>Форум</h1><hr>
<h2>Треды:</h2>
<#list threads as thread>
    <strong>ID: ${thread.ID}</strong> Название: ${thread.title} <br> Описание: ${thread.description}"<br>
</#list>

<h3>Добавить тред</h3>
<form action="/addThread" method="POST">
    Title: <input type="text", name="title" required><br>
    Description: <input type="text", name="description" required><br>
    <input type="submit" value="Добавить тред"/>
</form>
<h3><a href="/">На главную</a></h3>
</body>
</html>