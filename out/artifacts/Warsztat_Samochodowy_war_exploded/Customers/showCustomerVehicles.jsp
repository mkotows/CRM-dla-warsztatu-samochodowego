<%@ page import="model.Vehicle" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: mateusz
  Date: 07.04.18
  Time: 21:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Samochody klienta</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/myStyles.css">

</head>
<body>
<jsp:include page="../WEB-INF/header.jsp"></jsp:include>

Pojazdy użytkownika: <%=request.getAttribute("customer")%>
<br><br>
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
        <th colspan="3"> Opcje</th>
    </tr>
    <%
        List <Vehicle> vehicles = (List<Vehicle>) request.getAttribute("vehiclesList");
        for (Vehicle vehicle : vehicles) {
    %>
    <tr>
        <td><%= vehicle.getId() %></td>
        <td><%= vehicle.getBrand() %></td>
        <td><%= vehicle.getModel() %></td>
        <td><%= vehicle.getProduction_year() %></td>
        <td><%= vehicle.getNumber() %></td>
        <td><%= vehicle.getNext_service() %></td>
        <td><a href="UpdateVehicle?id=<%=vehicle.getId()%>&brand=<%=vehicle.getBrand()%>&model=<%=vehicle.getModel()%>
                                       &production_year=<%=vehicle.getProduction_year()%>&number=<%=vehicle.getNumber()%>
                                       &next_service=<%=vehicle.getNext_service()%>&client_id=<%=vehicle.getClient_id()%>"> edytuj </a></td>
        <td><a href="DeleteVehicle?id=<%=vehicle.getId()%>"> usuń </a></td>
        <td><a href=""> zlecenia </a></td>
    </tr>
    <%
        }
    %>
</table>

<jsp:include page="../WEB-INF/footer.jsp"></jsp:include>
</body>
</html>
