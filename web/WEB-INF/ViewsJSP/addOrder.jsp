<%@ page import="java.time.LocalDate" %><%--
  Created by IntelliJ IDEA.
  User: mateusz
  Date: 06.04.18
  Time: 21:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Nowe zlecenie</title>
</head>
<body>
Dodawanie nowego zlecenia
<br><br>
<%
    LocalDate today = (LocalDate) request.getAttribute("today");
%>
<form action="../AddOrder" method="post">
    <label>Data przyjęcia samochodu: <input type="date" name="date" value="<%=today%>" required></label><br>
    <label>Data planowanego rozpoczęcia naprawy: <input type="date" name="planing_date" value="<%=today%>" required></label><br>
    <label>Data rozpoczęcia naprawy: <input type="date" name="end_date" value="<%=today%>" required></label><br>
    <label>Numer pracownika: <input type="number" name="employee_id" required></label><br>
    <textarea name="problem_description" rows="4" cols="50" placeholder="Opis problemu..." required></textarea> <br>
    <textarea name="repair_description" rows="4" cols="50" placeholder="Opis naprawy..." required></textarea> <br>
    Status:
    <select name="status">
        <option value="adopted"> Przyjęty </option>
        <option value="accepted"> Zatwiedzone koszty naprawy </option>
        <option value="repairing"> W naprawie </option>
        <option value="repaired"> Gotowy do odbioru </option>
        <option value="resigned"> Rezygnacja </option>
    </select>
    <br>
    <label>Numer pojadu: <input type="number" name="vehicle_id" required></label><br>
    <label>Koszt części: <input type="number" step="0.01" min=0 name="elements_cost" required></label><br>
    <label> Czas naprawy: <input type="number" name="repair_hours" required></label><br>
    <%--------- koszt zależny od id pracownika--%>
    <%--<label>Koszt za godzinę: <input type="number" step="0.01" min=0 name="hour_cost" required></label><br>--%>

    <%--<label>Koszt całkowity: <input type="number" step="0.01" min=0 name="total_cost" required></label><br>--%>

    <input type="submit" value="Dodaj">
</form>

<a href="../MainOrder"> Anuluj </a>

</body>
</html>
