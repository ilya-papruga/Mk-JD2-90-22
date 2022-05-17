<%@ page language="java"
contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<%@ taglib prefix = "c"  uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>

    <title>Airports</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

</head>

<body>

<h1 align="center"> Список аэропортов </h1>


<!-- простой вариант <table  border="1" cellspacing="0" cellpadding="2"> -->
<table class="table table-striped">
    <tr>
        <th>Код Аэропорта</th>
        <th>Название Аэропорта</th>
        <th>Город</th>
        <th>Координаты</th>
        <th>Часовой Пояс</th>
    </tr>

    <c:forEach items="${requestScope.allAirports}" var="airport">
        <tr>
            <td>${airport.airport_code}</td>
            <td>${airport.airport_name}</td>
            <td>${airport.city}</td>
            <td>${airport.coordinates}</td>
            <td>${airport.timezone}</td>
        </tr>
    </c:forEach>
</table>

</body>
</html>