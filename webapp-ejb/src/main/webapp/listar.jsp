<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Document</title>
</head>
<body>
  <h3>${saludo}</h3>
  <h3>${saludo2}</h3>
  <ul>
    <c:forEach items="${listar}" var="prod">
        <li>${prod.nombre}</li>
    </c:forEach>
</ul>
</body>
</html>