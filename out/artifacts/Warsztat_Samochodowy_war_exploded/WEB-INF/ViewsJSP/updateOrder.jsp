<%--
  Created by IntelliJ IDEA.
  User: mateusz
  Date: 07.04.18
  Time: 12:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edycja zamówienia</title>
</head>
<body>

<form action="../UpdateOrder" method="post">
    <label>Nr: <input type="number" name="id" value="<%=request.getParameter("id")%>" readonly></label><br>
    <label>Data przyjęcia samochodu: <input type="date" name="date" value="<%=request.getParameter("date")%>" required></label><br>
    <label>Data planowanego rozpoczęcia naprawy: <input type="date" name="planing_date" value="<%=request.getParameter("planing_date")%>" required></label><br>
    <label>Data rozpoczęcia naprawy: <input type="date" name="end_date" value="<%=request.getParameter("end_date")%>" required></label><br>
    <label>Numer pracownika: <input type="number" name="employee_id" value="<%=request.getParameter("employee_id")%>" required></label><br>

    Opis problemu: <textarea name="problem_description" rows="4" cols="50" required> <%=request.getParameter("problem_description")%>  </textarea> <br>
    Opis naprawy: <textarea name="repair_description" rows="4" cols="50" required> <%=request.getParameter("repair_description")%> </textarea> <br>
    Status:
    <select name="status">
        <option value="<%=request.getParameter("status")%>" selected="selected"><%=getStatus(request.getParameter("status"))%></option>
        <% if(!"adopted".equals(request.getParameter("status"))){
        %> <option value="adopted"> Przyjęty </option>  <% } %>
        <% if(!"accepted".equals(request.getParameter("status"))){
        %>  <option value="accepted"> Zatwiedzone koszty naprawy </option>  <% } %>
        <% if(!"repairing".equals(request.getParameter("status"))){
        %>  <option value="repairing"> W naprawie </option>   <% } %>
        <% if(!"repaired".equals(request.getParameter("status"))){
        %>  <option value="repaired"> Gotowy do odbioru </option>  <% } %>
        <% if(!"resigned".equals(request.getParameter("status"))){
        %>  <option value="resigned"> Rezygnacja </option>  <% } %>
    </select>
    <br>
    <label>Numer pojadu: <input type="number" name="vehicle_id" value="<%=request.getParameter("vehicle_id")%>" required></label><br>
    <label>Koszt części: <input type="number" step="0.01" min=0 name="elements_cost" value="<%=request.getParameter("elements_cost")%>" required></label><br>
    <label> Czas naprawy: <input type="number" name="repair_hours" value="<%=request.getParameter("repair_hours")%>" required></label><br>

<%--------- koszt zależny od id pracownika--%>
    <%--<label>Koszt za godzinę: <input type="number" step="0.01" min=0 name="hour_cost" required></label><br>--%>

    <%--<label>Koszt całkowity: <input type="number" step="0.01" min=0 name="total_cost" required></label><br>--%>

    <input type="submit" value="Zapisz">
</form>

<a href="../MainOrder"> Anuluj </a>

</body>
</html>
<%!
    private String getStatus(String status) {
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