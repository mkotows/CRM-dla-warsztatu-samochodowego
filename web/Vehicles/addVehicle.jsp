<%@ page import="model.Customer" %>
<%@ page import="java.util.List" %>
<%@ page import="java.time.LocalDate" %><%--
  Created by IntelliJ IDEA.
  User: mateusz
  Date: 05.04.18
  Time: 20:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Nowy pojazd</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/myStyles.css">
</head>
<body>
Dodawanie nowego pojazdu
<%
    LocalDate today = (LocalDate) request.getAttribute("date");
%>

<form action="../AddVehicle" method="post">
    <label>Marka: <input type="text" name="brand" required></label><br>
    <label>Model: <input type="text" name="model" required></label><br>
    <label>Rok produkcji: <input type="number" name="production_year" value="2010" required></label><br>
    <label>Numer dowodu: <input type="text" name="number" required></label><br>
    <label>Numer klienta (z tabeli poniżej): <input type="text" name="client_id" required></label><br>
    <label>Data następnego przeglądu: <input type="date" name="next_service" value="<%=today%>" required></label><br>
    <input type="submit" value="Dodaj">
</form>

<a href="../MainVehicle"> Anuluj </a>

<br>
<br>

<a href="AddCustomer"> Dodaj nowego klienta </a><br>
<table>
    <tr>
        <th>Nr</th>
        <th>Imię</th>
        <th>Nazwisko</th>
    </tr>
    <%
        List<Customer> customers = (List<Customer>) request.getAttribute("list");
        for (Customer customer : customers) {
    %>
    <tr>
        <td><%= customer.getId() %></td>
        <td><%= customer.getSurname() %></td>
        <td><%= customer.getName() %></td>

    </tr>
    <%
        }
    %>
</table>

</body>
</html>
