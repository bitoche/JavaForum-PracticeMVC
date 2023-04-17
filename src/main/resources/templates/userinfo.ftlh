<!DOCTYPE html>
<html lang="RU">

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
        <p>Количество сообщений на форуме: ${user.messageCounter}
            <!-- if вошедший_пользователь.ID == user.ID, то есть поле -->
            <br><small>(видно только вам)</small>Пароль: ${user.password}
        </p>


    </div>
    <!-- if вошедший_пользователь.ID == user.ID, то есть кнопка -->
    <form action="/user/${user.ID}/delete" method="post" id="delete-user-form">
        <input type="hidden" value="${user.ID}" name="id">
        <button type="submit" onclick="return confirmDelete()">Удалить пользователя</button>
    </form>
    <script>
        function confirmDelete() {
            if (confirm("Вы действительно хотите удалить пользователя ${user.username}?")) {
                // Если пользователь подтвердил удаление, отправляем форму
                document.getElementById("delete-user-form").submit();
                return true;
            } else {
                // Если пользователь отменил удаление, ничего не делаем
                return false;
            }
        }
    </script>
    </body>
</#if>


<h3><a href="/">На главную</a></h3>

</body>
</html>