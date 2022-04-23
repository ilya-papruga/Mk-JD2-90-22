<%@ page language="java"
		contentType="text/html; charset=UTF-8"
		pageEncoding="UTF-8"%>

<html>
 <head>
   <title>Statistics page</title>
   <meta charset="utf-8">
 </head>
 <body>
      <p>Статистика</p></br>
      <p>Количество активных сессий: ${requestScope.sessions}</p>
      <p>Количество пользвателей: ${requestScope.users}</p>
      <p>Количество отправленных сообщений: ${requestScope.messages}</p>
 </body>
</html>