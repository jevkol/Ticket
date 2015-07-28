<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ServiceMovie</title>
</head>
<body>
<marquee><center> <h1> Hello man!! Choose a movie </h1></center></marquee>

<p>
  <ul>
   <c:forEach items="${moviesList}" var="style">

      <hr color="green">

         <br>
            <li>
            Name of movie: <a href="/">${style.name}</a> <p>Description of movie: ${style.description}</p>
             </li>
   </c:forEach>
  </ul>
</p>




</body>
</html>