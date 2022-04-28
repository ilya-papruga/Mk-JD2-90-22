<%@ page language="java"
		contentType="text/html; charset=UTF-8"
		pageEncoding="UTF-8"%>

<%@ taglib prefix = "c"  uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>

        <title>Привет</title>

</head>

<body>

        Привет, тебя зовут ${requestScope.name}
        а могли бы:
        <c:forEach items="${requestScope.allNames}" var="item">
        <p>${item}</p>
        </c:forEach>

</body>
</html>