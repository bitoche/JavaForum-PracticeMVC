<!DOCTYPE html>
<html lang="RU">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Форум</title>
    <#--<style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f1f1f1;
        }
        .container {
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            height: 100vh;
            max-width: 800px;
            margin: 0 auto;
        }
        h1, h2, h3 {
            text-align: center;
        }
        hr {
            width: 100%;
            margin: 20px 0;
            border: none;
            border-bottom: 2px solid #333;
        }
        form {
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            margin-top: 20px;
        }
        input[type="text"], input[type="number"] {
            margin-bottom: 10px;
            padding: 5px;
            border-radius: 5px;
            border: none;
            box-shadow: 2px 2px 5px rgba(0,0,0,0.2);
            width: 100%;
            max-width: 500px;
        }
        input[type="submit"] {
            background-color: #333;
            color: #fff;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }
        input[type="submit"]:hover {
            background-color: #555;
        }
        .btn-switch {

            background-color: #333;
            color: #fff;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }
        .btn-switch:hover {
            background-color: #555;
        }
        .message-container {
            background-color: #fff;
            box-shadow: 2px 2px 5px rgba(0,0,0,0.2);
            padding: 20px;
            border-radius: 5px;
            margin-bottom: 20px;
            width: 100%;
            max-width: 500px;
        }
        .message-container strong {
            display: block;
            margin-bottom: 10px;
        }
        .message-container a {
            text-decoration: none;
            color: #396b86;
            transition: color 0.3s ease;
        }
        .message-container a:hover {
            color: #555;
        }

        /* Добавляем стили для темной темы */
        .dark-mode {
            background-color: #333;
            color: #fff;
        }
        .dark-mode .message-container {
            background-color: #555;
            color: #fff;
        }
        .dark-mode .message-container a {
            color: #9fb8d1;
        }
        .dark-mode hr {
            border-bottom: 2px solid #fff;
        }
    </style>-->
</head>
<body>
<div class="container">
    <h1>Форум</h1>
    <hr>
    <h2>Сообщения:</h2>
    <#list messages as message>
        <div class="message-container">
            <strong>ID: ${message.ID}</strong>
            Сообщение: ${message.content} <br>
            Отправитель: <a
                    href="<#if message.sender.ID != -1>/user/${message.sender.ID}</#if>">${message.sender.username}</a><br>
            Тред: <a
                    href="<#if message.thread.ID != -1>/thread/${message.thread.ID}</#if>">${message.thread.title}</a><br>
            <!-- if вошедший_пользователь.id == message.sender.ID то доступна кнопка -->
            <form action="/message/${message.ID}/delete" method="post">
                <input type="hidden" value="${message.ID}" name="id">
                <button type="submit" onclick="return confirmDelete()">Удалить сообщение</button>
                <small>доступно только вам</small>
            </form>
        </div>
        <script>
            function confirmDelete() {
                if (confirm("Вы действительно хотите удалить сообщение пользователя ${message.sender.username}?")) {
                    // Если пользователь подтвердил удаление, отправляем форму
                    document.getElementById("delete-user-form").submit();
                    return true;
                } else {
                    // Если пользователь отменил удаление, ничего не делаем
                    return false;
                }
            }
        </script>
    </#list>
    <h3>Добавить сообщение</h3>
    <form action="/addMessage" method="POST">
        Content: <input type="text" name="content" required><br>
        SenderID: <input type="number" name="senderid" required><br>
        ThreadID: <input type="number" name="threadid" required><br><br>
        <input type="submit" value="Добавить сообщение">
    </form>
    <br>
    <h3><a href="/">На главную</a></h3>

</div>

</body>
</html>
