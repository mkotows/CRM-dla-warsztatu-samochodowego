<%@ page import="model.Order" %>
<%@ page import="java.util.Map" %>
<%@ page import="dao.EmployeeDAO" %>
<%@ page import="java.math.BigDecimal" %><%--
  Created by IntelliJ IDEA.
  User: mateusz
  Date: 08.04.18
  Time: 18:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Raport przepracowanych godzin</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/myStyles.css">
</head>
<body>
<jsp:include page="../header.jsp"></jsp:include>

Raport przepracowanych godzin
<br><br>

<table>
    <tr>
        <th>Nr</th>
        <th>Imie i Nazwisko</th>
        <th>Ilość przepracowanych godzin</th>
    </tr>
    <%
        int counter = 1;
        EmployeeDAO employeeDAO = EmployeeDAO.getInstance();
        Map<Integer, BigDecimal> map = (Map<Integer, BigDecimal>) request.getAttribute("map");
        for (Integer employeeId: map.keySet()) {
    %>
    <tr>
        <td><%=counter%></td>
        <td><%= employeeDAO.getEmployeeById(employeeId) %></td>
        <td><%= map.get(employeeId).toString() %></td>
    </tr>
    <%
      counter++;
        }
    %>
</table>

<jsp:include page="../footer.jsp"></jsp:include>

</body>
</html>
