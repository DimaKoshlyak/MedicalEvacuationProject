<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Активные заявки на эвакуацию</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <h3>Активные заявки на эвакуацию</h3>

    <form class="form-inline" role="form" action="/MedAutomation/search" method="post">
        <input type="text" class="form-control" name="pattern" placeholder="Search">
        <input type="submit" class="btn btn-default" value="Search">
    </form>

    <table class="table table-striped">
        <thead>
        <tr>

            <td><b>Id пострадавшего</b></td>
            <td><b>Состояние</b></td>
            <td><b>Тип ранения</b></td>
            <td><b>Давление</b></td>
            <td><b>Отрыв конечности</b></td>
            <td><b>Информация про эвакуацию</b></td>
            <td><b>Экипаж</b></td>
            <td><b>Время фиксации</b></td>
            <td><b>Операции</b></td>
        </tr>
        </thead>
        <c:forEach items="${medical_requests}" var="medicalrequest">
            <tr>
                <td>${medicalrequest.unit.lastName}</td>
                <td>${medicalrequest.status}</td>
                <td>${medicalrequest.injury}</td>
                <td>${medicalrequest.bloodPressure}</td>
                <td>${medicalrequest.extremityAvulsion}</td>
                <td><a href="/MedAutomation/departure_point_info?id=${medicalrequest.id}" target="_blank">Детальнее</a>
                </td>
                <td>${medicalrequest.evacuationCrew.crewName}</td>
                <td>${medicalrequest.timestamp}</td>
                <td>
                    <a href="/MedAutomation/close_request?id=${medicalrequest.id}">Завершить</a>
                </td>
            </tr>
        </c:forEach>
    </table>

    <div class="btn-group btn-group-justified" role="group" aria-label="...">
        <div class="btn-group" role="group">
            <button type="button" class="btn btn-default"><a href="/MedAutomation/show_archive">Показать архивные
                заявки</a></button>
        </div>
        <div class="btn-group" role="group">
            <button type="button" class="btn btn-default"><a href="/MedAutomation/show_crews" target="_blank">Экипажи</a></button>
        </div>
        <div class="btn-group" role="group">
            <button type="button" class="btn btn-default"><a href="/MedAutomation/show_institutions" target="_blank">Лечебные заведения</a></button>
        </div>
        <div class="btn-group" role="group">
            <button type="button" class="btn btn-default"><a href="/MedAutomation/show_all_units" target="_blank">Показать
                всех раненых</a></button>
        </div>
    </div>
    <br>
    <div>
        <form class="form-inline" role="form" action="/MedAutomation/open_add_request_page" method="post">
            <input type="submit" class="btn btn-primary" value="Добавить заявку">
        </form>
    </div>

</div>
</body>
</html>