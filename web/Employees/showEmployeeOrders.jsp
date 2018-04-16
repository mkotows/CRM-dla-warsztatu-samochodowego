<%@ page import="dao.VehicleDAO" %>
<%@ page import="model.Order" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: mateusz
  Date: 08.04.18
  Time: 09:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Historia napraw pracownika</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/myStyles.css">

</head>
<body>
<jsp:include page="../WEB-INF/header.jsp"></jsp:include>

Historia zleceń pracownika <%=request.getAttribute("employee")%>
<br><br>
<a href="AddOrder"> Dodaj nowe zlecenie </a>
<br><br>

<table>
    <tr>
        <th>Nr</th>
        <th>Data przyjęcia pojazdu</th>
        <th> Opis problemu</th>
        <th> Status</th>
        <th> Pojazd </th>
        <th> Koszt całkowity</th>
        <th colspan="3"> Opcje</th>
    </tr>

    <%
        VehicleDAO vehicleDAO = VehicleDAO.getInstance();
        List<Order> orders = (List<Order>) request.getAttribute("ordersList");

        for (Order order : orders) {
    %>
    <tr>
        <td><%= order.getId() %></td>
        <td><%= order.getDate() %></td>
        <td><%= order.getProblem_description() %></td>
        <td><%= translateStatus(order.getStatus()) %></td>
        <td><%= vehicleDAO.getVehicleById(order.getVehicle_id())%> </td>
        <td><%= order.getTotal_cost() %></td>

        <td><a href="UpdateOrder?id=<%=order.getId()%>&date=<%=order.getDate()%>&planing_date=<%=order.
                getPlaning_date()%>&end_date=<%=order.getEnd_date()%>&employee_id=<%=order.getEmployee_id()%>&problem_description=<%=order.
                getProblem_description()%>&repair_description=<%=order.getRepair_description()%>&status=<%=order.
                getStatus()%>&vehicle_id=<%=order.getVehicle_id()%>&elements_cost=<%=order.getElements_cost()%>&hour_cost=<%=order.
                getHour_cost()%>&repair_hours=<%=order.getRepair_hours()%> "> edytuj </a></td>
        <td><a href="DeleteOrder?id=<%=order.getId()%>"> usuń </a></td>
        <td><a href="OrderDetails?id=<%=order.getId()%>"> szczegóły </a></td>
    </tr>
    <%
        }
    %>
</table>

<jsp:include page="../WEB-INF/footer.jsp"></jsp:include>
</body>
</html>
<%!
    private String translateStatus(String status) {
        if (status.equals("adopted"))
            return "Przyjęty";
        else if(status.equals("accepted"))
            return "Zatwiedzone koszty naprawy";
        else if(status.equals("repairing"))
            return "W naprawie";
        else if(status.equals("repaired"))
            return "Gotowy do odbioru";
        else
            return "Rezygnacja";
    }
%>