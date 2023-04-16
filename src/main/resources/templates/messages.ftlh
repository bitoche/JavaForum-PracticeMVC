<!DOCTYPE html>
<html lang="RU">
<head>

    <title>Forum</title>

</head>
<body>
<h1>Форум</h1><hr>
<h2>Сообщения:</h2>
<#list messages as message>
    <strong>ID: ${message.ID}</strong> Сообщение: ${message.content} <br> Отправитель: <a href="/user/${message.sender.ID}">${message.sender.username}</a><br> Тред: ${message.thread.title}<br>
</#list>

<h3>Добавить сообщение</h3>
<form action="/addMessage" method="POST">
    Content: <input type="text", name="content" required><br>
    SenderID: <input type="number", name="senderid" required><br>
    ThreadID: <input type="number", name="threadid" required><br><br>
    <input type="submit" value="Добавить сообщение"/>
</form>
<h3><a href="/">На главную</a></h3>
</body>
</html>