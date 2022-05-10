<%@ page language="java"
		contentType="text/html; charset=UTF-8"
		pageEncoding="UTF-8"%>

<%@ taglib prefix = "c"  uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>

        <title>Airports</title>

</head>

<body>

        <h1> Список аэропортов </h1>


        <table border="1" cellspacing="0" cellpadding="2">
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