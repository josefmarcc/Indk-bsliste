<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: josef
  Date: 01-03-2020
  Time: 15:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin</title>
</head>
<body>

Her kan du administerer brugere.
<br>
<br>

${besked}

<form action="AdminServlet" method="post">
    <label for="fname">Slet bruger:</label><br>
    <input type="text" id="fname" name="navn"><br>
    <input type="submit" value="Slet">
</form>

<br>
<br>



<c:forEach var="element" items="${applicationScope.brugerMap}">

    ${element}
    <br>

</c:forEach>

</body>
</html>
