<%@ page language="java"
		contentType="text/html; charset=UTF-8"
		pageEncoding="UTF-8"%>

<%@ taglib prefix ="c" uri ="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
        <title>Входящие сообщения</title>
        <meta charset="utf-8">
</head>

<body>
       Ваши входящие сообщения:
        <c:forEach var="message" items="${messages}">
                     <p><c:out value="${message}"/></p>
                     </c:forEach>
</body>
</html>