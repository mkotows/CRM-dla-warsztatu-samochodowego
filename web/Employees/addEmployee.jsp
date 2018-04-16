<%--
  Created by IntelliJ IDEA.
  User: mateusz
  Date: 06.04.18
  Time: 16:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Nowy pracownik</title>
</head>
<body>
Dodawanie nowego pracownika

<form action="../AddEmployee" method="post">
    <label>Imię: <input type="text" name="name" required></label><br>
    <label>Nazwisko: <input type="text" name="surname" required></label><br>
    <label>Adres: <input type="text" name="adderss" required></label><br>
    <label>Numer telefonu: <input type="text" name="phone" required></label><br>
    <label>Dodatkowy opis: <input type="text" name="note" required></label><br>
    <label>"Godzinówka": <input type="number" step="0.01" min="0" name="salary_per_hour" required></label><br>

    <input type="submit" value="Dodaj">
</form>

<a href="../MainEmployee"> Anuluj </a>
</body>
</html>
