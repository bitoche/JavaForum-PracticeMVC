<!DOCTYPE html>
<html lang="RU">
<head>

    <title>Forum</title>

</head>
<body>
<h1>Форум</h1><hr>
<h2>Сообщения:</h2>
<#list messages as message>
    <strong>ID: ${message.ID}</strong> Сообщение: ${message.content} <br> Отправитель: <a href="/user/${message.sender.ID}">${message.sender.username}</a>
</#list>

<h3>Добавить сообщение</h3>
<form action="/createMessage" method="POST">
    Content: <input type="text", name="content" required><br><br>
    <input type="submit" value="Добавить сообщение"/>
</form>
</body>
</html>