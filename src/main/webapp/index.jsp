<%--
  Created by IntelliJ IDEA.
  User: josef
  Date: 29-02-2020
  Time: 11:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Webshop</title>
</head>
<body>


<h1>Velkommen til webshop.</h1>

<br>
<br>
${sessionScope.besked}

<br>
<br>

${requestScope.besked}

<br>
<br>


<form action="LoginServlet" method="post">
    <label for="fname">Brugernavn:</label><br>
    <input type="text" id="fname" name="navn"><br>
    <label for="lname">Kodeord:</label><br>
    <input type="text" id="lname" name="kodeord"><br><br>
    <input type="submit" value="login">
</form>






</body>
</html>
