<!DOCTYPE html>
<html lang="RU">
<head>

    <title>Forum</title>

</head>
<body>
<h1>Форум</h1><hr>
<script>

</script>

<h3>Добавить пользователя</h3>
<form action="/createUser" method="POST">
    Username: <input type="text", name="Username" required><br><br>
    Login: <input type="text", name="Login" required><br><br>
    Password: <input type="text", name="Password" required><br><br>
    <input type="submit" value="Добавить пользователя"/>
</form>
<h3><a href="/">На главную</a></h3>
</body>
</html>