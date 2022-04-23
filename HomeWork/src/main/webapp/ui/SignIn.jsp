<%@ page language="java"
		contentType="text/html; charset=UTF-8"
		pageEncoding="UTF-8"%>

<html>
<head>
        <title>Авторизация</title>
        <meta charset="utf-8">
</head>

<body>
       Введите пожалуйста ваши данные для авторизации
       <form action="${pageContext.request.contextPath}/api/login" method="POST">
       <p>Логин: <input type="text" name ="login" /><p>
       <p>Пароль: <input type="password" name="password" /><p>
       <input type="submit" value="Авторизация"></p>
       </form>
</body>
</html>