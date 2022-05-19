<%@ page language="java"
contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<%@ taglib prefix = "c"  uri="http://java.sun.com/jsp/jstl/core" %>

<html xmlns:c="">
<head>
    <title>Полёты</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<div>

    <form action="${pageContext.request.contextPath}/aviasales/flights" method="GET">
        <select name="arrivalAirport">
            <option value="">Выберите аэропорт вылета</option>
            <c:forEach items="${requestScope.airports}" var="item">
                <option
                <c:if test="${item.code eq requestScope.arrivalAirport}">
                    selected
                </c:if>
                value="${item.code}">${item.code} - ${item.name} </option>
            </c:forEach>
        </select>

        <select name="departureAirport">
            <option value="">Выберите аэропорт прилёта</option>
            <c:forEach items="${requestScope.airports}" var="item">
                <option
                <c:if test="${item.code eq requestScope.departureAirport}">
                    selected
                </c:if>
                value="${item.code}">${item.code} - ${item.name} </option>
            </c:forEach>
        </select>

        <input type="submit" value="Отправить"/>

        <div>

            <c:forEach var="i" begin="1" end="${requestScope.maxPage}">
                <c:if test="${
                 (requestScope.maxPage <= 5) ||
                 (requestScope.page == 1 &&  (i == (requestScope.page + 1) || i == (requestScope.page + 2))) ||
                 (requestScope.page == requestScope.maxPage && (i == (requestScope.page - 1) || i == (requestScope.page - 2))) ||
                 (i == (requestScope.page -1) || i == requestScope.page || i == (requestScope.page + 1)) ||
                 (i == requestScope.maxPage) ||
                 (i == 1)
                 }">
                    <input name="page" type="submit" value="${i}">
                </c:if>
            </c:forEach>
        </div>
    </form>
</div>


<div>

    <table class="table table-striped">

        <tr>
            <th>Flight ID</th>
            <th>Flight №</th>
            <th>Scheduled departure</th>
            <th>Scheduled departure local</th>
            <th>Scheduled arrival</th>
            <th>Scheduled arrival local</th>
            <th>Scheduled duration</th>
            <th>Departure airport</th>
            <th>Departure airport name</th>
            <th>Departure city</th>
            <th>Arrival airport</th>
            <th>Arrival airport name</th>
            <th>Arrival city</th>
            <th>Status</th>
            <th>Aircraft code</th>
            <th>Actual departure</th>
            <th>Actual departure local</th>
            <th>Actual arrival</th>
            <th>Actual arrival local</th>
            <th>Actual duration</th>

        </tr>


        <c:forEach items="${requestScope.flights}" var="item">
            <tr>
                <td>${item.flightId}</td>
                <td>${item.flightNo}</td>
                <td>${item.scheduledDeparture}</td>
                <td>${item.scheduledDepartureLocal}</td>
                <td>${item.scheduledArrival}</td>
                <td>${item.scheduledArrivalLocal}</td>
                <td>${item.scheduledDuration}</td>
                <td>${item.departureAirport}</td>
                <td>${item.departureAirportName}</td>
                <td>${item.departureCity}</td>
                <td>${item.arrivalAirport}</td>
                <td>${item.arrivalAirportName}</td>
                <td>${item.arrivalCity}</td>
                <td>${item.status}</td>
                <td>${item.aircraftCode}</td>
                <td>${item.actualDeparture}</td>
                <td>${item.actualDepartureLocal}</td>
                <td>${item.actualArrival}</td>
                <td>${item.actualArrivalLocal}</td>
                <td>${item.actualDuration}</td>
            </tr>
        </c:forEach>

    </table>
</div>
</body>
</html>
