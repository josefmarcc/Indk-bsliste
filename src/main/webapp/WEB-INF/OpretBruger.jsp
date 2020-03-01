<%--
  Created by IntelliJ IDEA.
  User: josef
  Date: 01-03-2020
  Time: 13:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Opret bruger</title>
</head>
<body>

Her kan du registere dig som bruger på huskelisten
<br>
<br>
${requestScope.besked}

<br>
<br>


<form action="OpretServlet" method="post">
    <label for="fname">Brugernavn:</label><br>
    <input type="text" id="fname" name="navn"><br>
    <label for="lname">Kodeord:</label><br>
    <input type="text" id="lname" name="kodeord"><br><br>
    <input type="submit" value="Opret">
</form>




</body>
</html>
