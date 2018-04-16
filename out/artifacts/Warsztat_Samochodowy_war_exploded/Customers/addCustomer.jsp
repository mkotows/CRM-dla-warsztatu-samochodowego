<%--
  Created by IntelliJ IDEA.
  User: mateusz
  Date: 05.04.18
  Time: 12:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Nowy klient</title>
</head>
<body>
Dodawanie nowego klienta
<form action="../AddCustomer" method="post">
    <label>Imię: <input type="text" name="name" required></label><br>
    <label>Nazwisko: <input type="text" name="surname" required></label><br>
    <label>Data urodzenia (pole nieobowiązkowe): <input type="date" name="birth_date"></label><br>
    <input type="submit" value="Dodaj">
</form>

<a href="../MainCustomer"> Anuluj </a>

</body>
</html>
