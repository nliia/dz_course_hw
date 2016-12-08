<!DOCTYPE html>
        <html lang="en">
<head>
    <title>Signin</title>

    <link href="css/bootstrap.css" rel="stylesheet">
    <link href="css/signin.css" rel="stylesheet">
    <link href="css/login.css" rel="stylesheet">
</head>

<body>
    <div class="container">
        <#if error??>
            <div class="alert">Неверный логин или пароль</div>
        </#if>
        <form class="form-signin" action="login" method="post">
            <input type="text" name="username" class="form-control">
            <input type="password" name="password" class="form-control">
            <button id="login-btn" class="btn btn-sm" type="submit">Войти</button>
        </form>
    </div>
</body>
</html>