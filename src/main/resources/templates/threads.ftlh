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
<button onclick="toggleDarkMode()" class="btn-switch">Переключить тему</button>
<div class="container">
    <h1>Форум</h1>
    <hr>
    <h2>Треды:</h2>
    <#list threads as thread>
        <div class="message-container">
            <strong>ID: ${thread.ID}</strong>
            <a href="/thread/${thread.ID}">${thread.title}</a><br>
            Описание: ${thread.description}<br>
        </div>
    </#list>
    <h3>Добавить тред</h3>
    <form action="/addThread" method="POST">
        Title: <input type="text", name="title" required><br>
        Description: <input type="text", name="description" required><br>
        <input type="submit" value="Добавить тред"/>
    </form>
    <br>
    <h3><a href="/">На главную</a></h3>

</div>
<script>
    function toggleDarkMode() {
        const body = document.querySelector('body');
        body.classList.toggle('dark-mode');
    }
    const body = document.querySelector("body");
    const toggleSwitch = document.querySelector('.theme-switch input[type="checkbox"]');

    function switchTheme(e) {
        if (e.target.checked) {
            body.classList.add("dark-mode");
        } else {
            body.classList.remove("dark-mode");
        }
    }

    toggleSwitch.addEventListener("change", switchTheme, false);
</script>
</body>
</html>

<#--
<!DOCTYPE html>
<html lang="RU">
<head>

    <title>Forum</title>

</head>
<body>
<h1>Форум</h1><hr>
<h2>Треды:</h2>
<#list threads as thread>
    <strong>ID: ${thread.ID}</strong> Название: <a href="/thread/${thread.ID}">${thread.title}</a> <br> Описание: ${thread.description}"<br>
</#list>

<h3>Добавить тред</h3>
<form action="/addThread" method="POST">
    Title: <input type="text", name="title" required><br>
    Description: <input type="text", name="description" required><br>
    <input type="submit" value="Добавить тред"/>
</form>
<h3><a href="/">На главную</a></h3>
</body>
</html>-->
