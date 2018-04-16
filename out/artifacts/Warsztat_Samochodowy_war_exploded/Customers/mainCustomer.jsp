<%@ page import="java.util.List" %>
<%@ page import="model.Customer" %><%--
  Created by IntelliJ IDEA.
  User: mateusz
  Date: 04.04.18
  Time: 22:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Klienci</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/myStyles.css">

</head>
<body>
<jsp:include page="../WEB-INF/header.jsp"></jsp:include>

<a href="AddCustomer"> Dodaj nowego klienta </a>
<br><br>

<table>
    <tr>
        <th>Nr</th>
        <th>Imie</th>
        <th>Nazwisko</th>
        <th colspan="4"> Opcje</th>
    </tr>
    <%
        List<Customer> customers = (List<Customer>) request.getAttribute("list");
        for (Customer customer : customers) {
    %>
    <tr>
        <td><%= customer.getId() %>
        </td>
        <td><%= customer.getName() %>
        </td>
        <td><%= customer.getSurname() %>
        </td>
        <%--<td> <jsp:include page="updateCustomer.jsp"> <jsp:param name="id" value="<%=customer.getId()%>"></jsp:param> </jsp:include> </td>--%>
        <%--<jsp:forward page="updateCustomer.jsp" />--%>

        <td><a href="UpdateCustomer?id=<%=customer.getId()%>&name=<%=customer.getName()%>
                                                &surname=<%=customer.getSurname()%>&date=<%=customer.getBirth_date()%>"> edytuj </a></td>
        <td><a href="DeleteCustomer?id=<%=customer.getId()%>"> usuń </a></td>
        <td><a href="ShowCustomerVehicles?id=<%=customer.getId()%>"> pojazdy klienta </a></td>
        <td><a href="ShowCustomerOrders?client_id=<%=customer.getId()%>"> zlecenia </a></td>
    </tr>
    <%
        }
    %>
</table>

<jsp:include page="../WEB-INF/footer.jsp"></jsp:include>

</body>
</html>
