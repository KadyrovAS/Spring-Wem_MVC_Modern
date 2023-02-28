<%@ page import="app.services.PriorityType" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Изучаем JSP</title>
</head>
<body>
<label for="priority">Priority</label>
<select id="priority" name="priority">
<%
    for(PriorityType type: PriorityType.values()){
    }
%>
</select>
</body>
</html>
