<%@ page language="java"
		contentType="text/html; charset=UTF-8"
		pageEncoding="UTF-8"%>

<%@ taglib prefix = "c"  uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>

        <title>Flights</title>

</head>

<body>

<h1>Поиск рейсов</h1>


<form action="${pageContext.request.contextPath}/flights" method="POST">
       <p>Дата вылета: <input type="date" name="scheduled_departure_local" max="2017-09-14" min="2016-08-15"> </p>

       <select name="departure_airport_name">
                <option>Аэропорт вылета</option>
                <c:forEach items="${requestScope.allAirports}" var="airport">
                <option>${airport.airport_name}</option>
                </c:forEach>
       </select>

       <br></br>

       <p>Дата Прилёта: <input type="date" name="scheduled_arrival_local" max="2017-09-15" min="2016-08-15"></p>

       <select name="arrival_airport_name">
                <option>Аэропорт прилёта</option>
                <c:forEach items="${requestScope.allAirports}" var="airport">
                <option>${airport.airport_name}</option>
                </c:forEach>
       </select>

       <br></br>

       <input type="submit" value="Поиск"></p>
       </form>

       <br></br>


       <table border="1" cellspacing="0" cellpadding="2">
                         <tr>
                             <th>flight_id</th>
                              <th>flight_no</th>
                              <th>scheduled_departure</th>
                              <th>scheduled_departure_local</th>
                              <th>scheduled_arrival</th>
                              <th>scheduled_arrival_local</th>
                              <th>scheduled_duration</th>
                              <th>departure_airport</th>
                              <th>departure_airport_name</th>
                              <th>departure_city</th>
                              <th>arrival_airport</th>
                              <th>arrival_airport_name</th>
                              <th>arrival_city</th>
                              <th>status</th>
                              <th>aircraft_code</th>

                         </tr>

                         <c:forEach items="${requestScope.searchFlights}" var="flight">
                         <tr>
                              <td>${flight.flight_id}</td>
                              <td>${flight.flight_no}</td>
                              <td>${flight.scheduled_departure}</td>
                              <td>${flight.scheduled_departure_local}</td>
                              <td>${flight.scheduled_arrival}</td>
                              <td>${flight.scheduled_arrival_local}</td>
                              <td>${flight.scheduled_duration}</td>
                              <td>${flight.departure_airport}</td>
                              <td>${flight.departure_airport_name}</td>
                              <td>${flight.departure_city}</td>
                              <td>${flight.arrival_airport}</td>
                              <td>${flight.arrival_airport_name}</td>
                              <td>${flight.arrival_city}</td>
                              <td>${flight.status}</td>
                              <td>${flight.aircraft_code}</td>

                         </tr>
                         </c:forEach>
                    </table>



</body>
</html>