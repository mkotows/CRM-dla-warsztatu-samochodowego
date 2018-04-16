<%@ page import="model.Vehicle" %>
<%@ page import="model.Order" %>
<%@ page import="java.util.List" %>
<%@ page import="dao.VehicleDAO" %>
<%@ page import="java.math.BigDecimal" %><%--
  Created by IntelliJ IDEA.
  User: mateusz
  Date: 08.04.18
  Time: 18:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Raport finansowy</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/myStyles.css">

</head>
<body>

<jsp:include page="../header.jsp"></jsp:include>

Raport finansowy
<br><br>

    <%
        BigDecimal totalSumElements = BigDecimal.valueOf(0);
        BigDecimal totalSumWorkingHours = BigDecimal.valueOf(0);
        BigDecimal totalSum = BigDecimal.valueOf(0);

        List<Order> orders = (List<Order>) request.getAttribute("ordersList");
        for (Order order : orders) {
            totalSumElements= totalSumElements.add(order.getElements_cost());
            BigDecimal workingCost= order.getRepair_hours().multiply(order.getHour_cost());
            totalSumWorkingHours= totalSumWorkingHours.add(workingCost);
            totalSum= totalSum.add(order.getTotal_cost());
        }
    %>
<table>
    <tr>
        <th>Koszt części</th>
        <th> Koszt roboczogodzin </th>
        <th> Suma całkowita </th>
    </tr>
    <tr>
        <td><%= totalSumElements.toString() %></td>
        <td><%= totalSumWorkingHours %></td>
        <td><%= totalSum %></td>

    </tr>

</table>

<jsp:include page="../footer.jsp"></jsp:include>

</body>
</html>
