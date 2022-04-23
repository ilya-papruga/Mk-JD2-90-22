<%@ page language="java"
		contentType="text/html; charset=UTF-8"
		pageEncoding="UTF-8"%>

<html>
<head>
        <title>Новое сообщение</title>
        <meta charset="utf-8">
</head>

<body>
       Для отправки сообщения заполните пожалуйста поля:
       <form action="${pageContext.request.contextPath}/api/message" method="POST">
       <p>Логин получателя: <input type="text" name ="receiver" /><p>
       <p>Текст сообщения: <textarea name="text"></textarea></p>
       <input type="submit" value="Отправить"></p>
       </form>
</body>
</html>