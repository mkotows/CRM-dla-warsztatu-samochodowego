<%--
  Created by IntelliJ IDEA.
  User: mateusz
  Date: 04.04.18
  Time: 22:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit</title>
</head>
<body>
    Edycja Klienta: <br>
    <form action="../UpdateCustomer" method="post">
        <input type="number" name="id" value="<%=request.getParameter("id")%>" readonly>
        <label>Imię: <input type="text" name="name" value="<%=request.getParameter("name")%>"></label>
        <label>Nazwisko: <input type="text" name="surname" value="<%=request.getParameter("surname")%>"></label><br>
        <label>Data urodzenia (pole nieobowiązkowe): <input type="date" name="birth_date" value="<%=request.getParameter("date")%>"></label><br>
        <input type="submit" value="Zapisz zmiany">
    </form>
    <a href="../MainCustomer"> Anuluj </a>
</body>
</html>
