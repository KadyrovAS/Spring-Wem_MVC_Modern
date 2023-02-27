<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
    integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
<div class = "container">
    <div class="row">
        <div class="col-12">
            <a class="btn btn-primary mb-3" href="/Spring_web_MVC_modern_war/task/add">Создать задачу</a>
        </div>
    </div>
    <table class="table table-hover">
        <thead>
        <tr>
            <td>ID</td>
            <td>Name</td>
            <td>Created</td>
            <td>Priority</td>
            <td>Task</td>
            <td colspan="2">Operation</td>
        </tr>
        </thead>
        <tbody>
            <c:forEach items="${list}" var="item">
                <tr>
                    <td><c:out value="${item.id}"/></td>
                    <td><c:out value="${item.name}"/></td>
                    <td><c:out value="${item.created}"/></td>
                    <td><c:out value="${item.priority}"/></td>
                    <td><c:out value="${item.type}"/></td>
                    <td><a href="/Spring_web_MVC_modern_war/task/edit/${item.id}">Редактировать</a></td>
                    <td><a href="/Spring_web_MVC_modern_war/task/delete?id=${item.id}">Удалить</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
        integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
        integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
        crossorigin="anonymous"></script>
<%--<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"--%>
<%--        integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"--%>
<%--        crossorigin="anonymous"></script>                                                                                                                                                                                                                                                                                                                                                                                               crossorigin="anonymous"></script>--%>
</body>
</html>