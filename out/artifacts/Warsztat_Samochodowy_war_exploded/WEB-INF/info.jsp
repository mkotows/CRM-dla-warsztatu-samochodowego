<%--
  Created by IntelliJ IDEA.
  User: mateusz
  Date: 05.04.18
  Time: 12:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Status</title>
</head>
<body>
    <jsp:include page="header.jsp"></jsp:include>

    <%
        String info = (String) request.getAttribute("info");
    %>

    <h2> <%=info%> </h2>

    <jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
