<%@ page import="model.Vehicle" %>
<%@ page import="java.util.List" %>
<%@ page import="model.Customer" %>
<%@ page import="dao.CustomerDAO" %><%--
  Created by IntelliJ IDEA.
  User: mateusz
  Date: 05.04.18
  Time: 20:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Samochody</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/myStyles.css">

</head>
<body>
<jsp:include page="../WEB-INF/header.jsp"></jsp:include>

<a href="AddVehicle"> Dodaj nowy pojazd </a>
<br><br>

<table>
    <tr>
        <th>Id</th>
        <th>Marka</th>
        <th>Model</th>
        <th>Rok produkcji</th>
        <th>Numer dowodu</th>
        <th>Następny serwis</th>
        <th>Właściciel</th>
        <th colspan="4"> Opcje</th>
    </tr>
    <%
        List<Vehicle> vehicles = (List<Vehicle>) request.getAttribute("vehiclesList");
        List<Customer> customers = (List<Customer>) request.getAttribute("customersList");
        CustomerDAO customerDAO = CustomerDAO.getInstance();

        for (Vehicle vehicle : vehicles) {
    %>
    <tr>
        <td><%= vehicle.getId() %></td>
        <td><%= vehicle.getBrand() %></td>
        <td><%= vehicle.getModel() %></td>
        <td><%= vehicle.getProduction_year() %></td>
        <td><%= vehicle.getNumber() %></td>
        <td><%= vehicle.getNext_service() %></td>
        <td><%= customerDAO.getCustomerById(vehicle.getClient_id()).getName() %> &nbsp; <%= customerDAO.getCustomerById(vehicle.getClient_id()).getSurname() %></td>
        <td><a href="UpdateVehicle?id=<%=vehicle.getId()%>&brand=<%=vehicle.getBrand()%>&model=<%=vehicle.getModel()%>
                                       &production_year=<%=vehicle.getProduction_year()%>&number=<%=vehicle.getNumber()%>
                                       &next_service=<%=vehicle.getNext_service()%>&client_id=<%=vehicle.getClient_id()%>"> edytuj </a></td>
        <td><a href="DeleteVehicle?id=<%=vehicle.getId()%>"> usuń </a></td>
        <td><a href="ShowVehicleOrders?id=<%=vehicle.getId()%>"> historia napraw </a></td>
    </tr>
    <%
        }
    %>
</table>

<jsp:include page="../WEB-INF/footer.jsp"></jsp:include>
</body>
</html>
