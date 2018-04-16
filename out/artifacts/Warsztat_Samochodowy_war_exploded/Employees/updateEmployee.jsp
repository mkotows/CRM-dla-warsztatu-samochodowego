<%--
  Created by IntelliJ IDEA.
  User: mateusz
  Date: 06.04.18
  Time: 16:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
Edycja Pracownika: <br>
<form action="../UpdateEmployee" method="post">
    <input type="number" name="id" value="<%=request.getParameter("id")%>" readonly>
    <label>Imię: <input type="text" name="name" value="<%=request.getParameter("name")%>"></label>
    <label>Nazwisko: <input type="text" name="surname" value="<%=request.getParameter("surname")%>"></label><br>
    <label>Adres: <input type="text" name="adderss" value="<%=request.getParameter("adderss")%>" required></label><br>
    <label>Numer telefonu: <input type="text" name="phone" value="<%=request.getParameter("phone")%>" required></label><br>
    <label>Dodatkowy opis: <input type="text" name="note" value="<%=request.getParameter("note")%>" required></label><br>
    <label>"Godzinówka": <input type="text" step="0.01" min="0" name="salary_per_hour" value="<%=request.getParameter("salary_per_hour")%>" required></label><br>

    <input type="submit" value="Zapisz zmiany">
</form>

<a href="../MainEmployee"> Anuluj </a>
</body>
</html>
