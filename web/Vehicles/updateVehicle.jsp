<%@ page import="dao.CustomerDAO" %>
<%@ page import="model.Customer" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: mateusz
  Date: 05.04.18
  Time: 21:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="../css/myStyles.css">
</head>
<body>
Edycja Pojazdu: <br>
<form action="../UpdateVehicle" method="post">
    <label>Marka: <input type="number" name="id" value="<%=request.getParameter("id")%>" readonly></label><br>
    <label>Marka: <input type="text" name="brand" value="<%=request.getParameter("brand")%>" required></label><br>
    <label>Model: <input type="text" name="model" value="<%=request.getParameter("model")%>" required></label><br>
    <label>Rok produkcji: <input type="number" name="production_year" value="<%=request.getParameter("production_year")%>" required></label><br>
    <label>Numer dowodu: <input type="text" name="number" value="<%=request.getParameter("number")%>" required></label><br>
    <label>Numer klienta (z tabeli poniżej): <input type="text" name="client_id" value="<%=request.getParameter("client_id")%>" required></label><br>
    <label>Data następnego przeglądu: <input type="date" name="next_service" value="<%=request.getParameter("next_service")%>" required></label><br>
    <input type="submit" value="Zapisz zmiany">
</form>

<a href="../MainVehicle"> Anuluj </a>

<br><br><br>

<a href="AddCustomer"> Dodaj nowego klienta </a>
<br><br>
<table>
    <tr>
        <th>Nr</th>
        <th>Imię</th>
        <th>Nazwisko</th>
    </tr>
    <%
        CustomerDAO customerDAO = CustomerDAO.getInstance();
        List<Customer> customers = customerDAO.getAllCustomers();
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
