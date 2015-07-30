<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ServiceSchedule</title>
</head>
<body>
<marquee><center> <h1> Hello man!! Choose a cinema </h1></center></marquee>

<p>
  <table border="1" cols="10">
     <caption>SCHEDULE</caption>
     <tr>
      <th>&#8470;</th>
      <th>Name of cinema</th>
      <th>Name of movie</th>
      <th>Data</th>
     </tr>
<c:forEach items="${scheduleList}" var="schedule">
<tr>
<td><c:out value="${schedule.id}"/></td>
<td><c:out value="${schedule.cinemaID}"/></td>
<td><c:out value="${schedule.movieID}"/></td>
<td><c:out value="${schedule.date.getTime()}"/></td>
</tr>
</c:forEach>
</table>
 </body>
 </html>