<%@ page import="app.services.PriorityType" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
          crossorigin="anonymous">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.7.1/css/bootstrap-datepicker.min.css"
          rel="stylesheet"/>
</head>
<body>

<div class = "container">
    <form action="/Spring_web_MVC_modern_war/task/edit" method="post" >
        <div class="form-group" hidden>
            <input type="text" value="${task.id}" class="form-control" id="id" name="id" >
        </div>
        <div class="form-group">
            <label for="name">Name</label>
            <input type="text" value="${task.name}" class="form-control" id="name" name = "name">
        </div>
        <div class="form-group">
            <label for="created">Created</label>
            <input type="text" value="${task.created}" class="form-control" id="created" name = "created">
        </div>

        <div class="form-group">
            <label for="priority">Priority</label>
            <select class="form-control" id="priority" name = "priority">
                <option value="MINOR">MINOR</option>
                <option value="MAJOR">MAJOR</option>
                <option value="CRITICAL" selected="selected">CRITICAL</option>
                <option value="BLOCKER">BLOCKER</option>
            </select>
        </div>
        <div class="form-group">
            <label for="type">Type</label>
            <select class="form-control" id="type" name = "type">
                <option value="TASK">TASK</option>
                <option value="BUG">BUG</option>
            </select>
        </div>
        <input type="submit" class="btn btn-primary" value="Сохранить">
    </form>
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
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.7.1/js/bootstrap-datepicker.min.js"></script>
<script type="text/javascript">
    $(function () {
        $('#created').datepicker();
    });
</script>

</body>
</html>