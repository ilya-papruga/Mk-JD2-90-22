<%@ page language="java"
		contentType="text/html; charset=UTF-8"
		pageEncoding="UTF-8"%>

<html>
<head>
        <title>Регистрация</title>
        <meta charset="utf-8">
</head>

<body>
        <p><font size="5" color="red">${param.error}</font></p>
       Введите пожалуйста ваши данные для регистрации
       <form action="${pageContext.request.contextPath}/api/user" method="POST">
       <p>Логин: <input type="text" name ="login" /><p>
       <p>Пароль: <input type="password" name="password" /><p>
       <p>ФИО: <input type="text" name="fullName" /><p>
       <p>Дата рождения: <input type="text" name="birthDate" /></p>
       <input type="submit" value="Регистрация"></p>
       </form>
</body>
</html>