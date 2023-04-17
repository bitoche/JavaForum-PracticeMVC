<#if user??>
    <head>

        <title>FORUM: ${user.username}</title>

    </head>
    <body>
    <h1>Страница пользователя ${user.username}</h1>
    <hr>

    <div>
        <p><b><a>ID: ${user.ID},
                    Username: ${user.username}</a></b><br>Login: ${user.login}<#-- ; RegisterDate: ${user.registerDate} НЕ ВЫВОДИТСЯ ТК ФОРМАТ В КОТОРОМ ХРАНИТСЯ ДАТА НЕ СТАНДАРТНЫЙ-->
        </p>
    </div>
    <!-- if вошедший_пользователь.ID == user.ID, то есть кнопка -->
    <form action="/user/${user.ID}/delete" method="post">
        <input type="hidden" value="${user.ID}" name="id">
        <button type="submit">Удалить пользователя</button>
    </form>
    </body>
</#if>
<!DOCTYPE html>
<html lang="RU">

<h3><a href="/">На главную</a></h3>

</body>
</html>