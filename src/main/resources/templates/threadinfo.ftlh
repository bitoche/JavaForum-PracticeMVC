<!DOCTYPE html>
<html lang="RU">

<#if thread??>
    <head>

        <title>FORUM: ${thread.title}</title>

    </head>
    <body>
    <h1>Тред: ${thread.title}</h1>
    <p>Описание треда: ${thread.description}</p>
    <hr>
    <!-- тут должны выводиться все сообщения -->
    </body>
</#if>
<h3><a href="/">На главную</a></h3>
</body>
</html>