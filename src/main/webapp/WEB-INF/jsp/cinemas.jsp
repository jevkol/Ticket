<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ServiceCinema</title>
</head>
<body>
<marquee><center> <h1> Hello man!! Choose a cinema </h1></center></marquee>

<p>
  <ul>
   <c:forEach items="${cinemasList}" var="cinema">

      <hr color="green">

         <br>
            <li>
            Name of cinema: <a href="/schedule">${cinema.name}</a> <p>Adres of movie: ${cinema.location}</p> <p>Number of seats: ${cinema.numberOfSeats}</p>
             </li>
   </c:forEach>
  </ul>
</p>