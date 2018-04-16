<%@ page import="model.Employee" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: mateusz
  Date: 06.04.18
  Time: 16:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Pracownicy</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/myStyles.css">
</head>
<body>
<jsp:include page="../WEB-INF/header.jsp"></jsp:include>

<a href="AddEmployee"> Dodaj nowego pracownika </a>
<br><br>

<table>
    <tr>
        <th>Id</th>
        <th>Imię</th>
        <th>Nazwisko</th>
        <th>Adres</th>
        <th>Numer telefonu</th>
        <th>Ddatkowy opis</th>
        <th>"Godzinówka"</th>
        <th colspan="3"> Opcje</th>
    </tr>
    <%
        List<Employee> employees = (List<Employee>) request.getAttribute("employeesList");

        for (Employee employee : employees) {
    %>
    <tr>
        <td><%= employee.getId() %></td>
        <td><%= employee.getName() %></td>
        <td><%= employee.getSurname() %></td>
        <td><%= employee.getAddress() %></td>
        <td><%= employee.getPhone() %></td>
        <td><%= employee.getNote() %></td>
        <td><%= employee.getSalary_per_hour() %> zł</td>
        <td><a href="UpdateEmployee?id=<%=employee.getId()%>&name=<%=employee.getName()%>&surname=<%=employee.getSurname()%>
                                       &adderss=<%=employee.getAddress()%>&phone=<%=employee.getPhone()%>&note=<%=employee.getNote()%>
                                       &salary_per_hour=<%=employee.getSalary_per_hour().toString()%>"> edytuj </a></td>
        <td><a href="DeleteEmployee?id=<%=employee.getId()%>"> usuń </a></td>
        <td><a href="ShowEmployeeOrders?id=<%=employee.getId()%>"> naprawy </a></td>
    </tr>
    <%
        }
    %>
</table>

<jsp:include page="../WEB-INF/footer.jsp"></jsp:include>
</body>
</html>
