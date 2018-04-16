<%--
  Created by IntelliJ IDEA.
  User: mateusz
  Date: 08.04.18
  Time: 18:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Raporty</title>
</head>
<body>
<jsp:include page="../header.jsp"></jsp:include>
<br><br>
Raport przepracowanych godzin, podaj zakres dat:
<form action="WorkingHoursRaport" method="post">
    <label> <input type="date" name="startDate" required></label><br>
    <label> <input type="date" name="endDate" required></label><br>
    <input type="submit" value="Wygeneruj raport">
</form>
<br><br><br><br>

Raport zysków, podaj zakres dat:
<form action="FinanceRaport" method="post">
    <label> <input type="date" name="startDate" required></label><br>
    <label><input type="date" name="endDate" required></label><br>
    <input type="submit" value="Wygeneruj raport">
</form>

<jsp:include page="../footer.jsp"></jsp:include>

</body>
</html>
