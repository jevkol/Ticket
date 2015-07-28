<html>
<head>
    <title>Fandango</title>
</head>


<body>
<marquee><h2>Hi there!</h2></marquee>
<style type="text/css">
   .block1 {
    width: 200px;
    background: #ccc;
    padding: 5px;
    padding-right: 20px;
    border: solid 1px black;
    float: left;
   }
 </style>
<div class="block1">
  <table>
    <form:form action="/movies" >
      <p><input type="radio" name="answer" value="a1"><a href="/movies" title="List of movies">Movies</a><Br>
         <input type="radio" name="answer" value="a2"><a href="/cinemas" title="List of cinemas">Cinemas </a><Br>
         <input type="submit" value="More information">

  </table>
</div>
</body>
</html>