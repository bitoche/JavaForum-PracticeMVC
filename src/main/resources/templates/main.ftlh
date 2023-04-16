<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Forum</title>
    <style>
        /* Стили для navbar */
        .navbar {
            display: flex;
            justify-content: space-between;
            align-items: center;
            height: 60px;
            background-color: #333;
            color: #fff;
            padding: 0 20px;
        }

        .navbar-brand {
            font-size: 24px;
            font-weight: bold;
        }

        .navbar-links {
            display: flex;
            align-items: center;
        }

        .navbar-links li {
            list-style: none;
            margin-left: 20px;
        }

        .navbar-links li:first-child {
            margin-left: 0;
        }

        .navbar-links a {
            color: #fff;
            text-decoration: none;
            font-size: 18px;
        }

        /* Стили для Container */
        .container {
            max-width: 1200px;
            margin: 0 auto;
            padding: 20px;
        }

        /* Стили для заголовка */
        .header {
            text-align: center;
            margin-bottom: 40px;
        }

        .header h1 {
            font-size: 48px;
            font-weight: bold;
            margin-bottom: 20px;
        }

        .header p {
            font-size: 24px;
        }

        /* Стили для футера */
        .footer {
            text-align: center;
            background-color: #333;
            color: #fff;
            padding: 20px;
            margin-top: 40px;
        }

        .footer p {
            margin: 0;
            font-size: 18px;
        }
    </style>
</head>
<body>
<nav class="navbar">
    <div class="navbar-brand">Форум</div>
    <ul class="navbar-links">
        <li><a href="/login">Авторизация</a></li>
        <li><a href="/register">Регистрация</a></li>
        <li><form action="/user/s/{id}" method="get">
                <input type="text" name="id" placeholder="Поиск по айди">
                <button type="submit">Найти</button>
            </form></li>
    </ul>
</nav>
<div class="container">
    <div class="header">
        <h1>Добро пожаловать на наш форум!</h1>
        <p>Здесь вы можете общаться на различные темы.</p>
    </div>
    <a href="/messages" style="text-decoration: none; font-size: 20px">Сообщения</a>
    <a style="text-decoration: none; font-size: 20px">  |  </a>
    <a href="/threads" style="text-decoration: none; font-size: 20px">Треды</a>
    <h2>Пользователи:</h2>
    <#list users as user>
        <p><b><a href="/user/${user.ID}">${user.username}</a></b><br></p>
    </#list>
</div>
<footer class="footer">
    <p>&copy; 2023 Forum. All rights reserved.</p>
</footer>
</body>
</html>
