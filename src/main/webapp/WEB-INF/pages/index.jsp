<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Активные заявки на эвакуацию</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</head>
<body>

<nav class="navbar navbar-default">
    <div class="container">
        <div>
            <ul class="nav navbar-nav">
                <li class="active"><a href="/MedAutomation/">Активные заявки</a></li>
                <li><a href="/MedAutomation/show_crews">Экипажи</a></li>
                <li><a href="/MedAutomation/show_institutions">Лечебные учреждения</a></li>
                <li><a href="/MedAutomation/show_all_units">Раненые</a></li>
                <li><a href="/MedAutomation/show_archive">Архивные</a></li>
            </ul>
        </div>
    </div>
</nav>

<div class="container">
    <h3>Активные заявки на эвакуацию</h3>

    <form class="form-inline" role="form" action="/MedAutomation/search" method="post">
        <input type="text" class="form-control" name="pattern" placeholder="Search">
        <input type="submit" class="btn btn-default" value="Search">
    </form>

    <table class="table table-striped">
        <thead>
        <tr>

            <td><b>Пострадавший</b></td>
            <td><b>Состояние</b></td>
            <td><b>Тип ранения</b></td>
            <td><b>Информация про эвакуацию</b></td>
            <td><b>Экипаж</b></td>
            <td><b>Время фиксации</b></td>
            <td><b>Эвакуировать в</b></td>
            <td><b>Операции</b></td>
        </tr>
        </thead>
        <c:forEach items="${medical_requests}" var="medicalrequest">
            <tr>
                <td>${medicalrequest.unit.lastName} ${medicalrequest.unit.firstName}</td>
                <td>${medicalrequest.status}</td>
                <td>${medicalrequest.injury}</td>
                <td><a href="/MedAutomation/departure_point_info?id=${medicalrequest.id}" target="_blank">Детальнее</a>
                </td>
                <td>${medicalrequest.evacuationCrew.crewName}</td>
                <td>${medicalrequest.timestamp}</td>
                <td>${medicalrequest.destinationInstitute.institutionName}</td>
                <td>
                    <a href="/MedAutomation/close_request?id=${medicalrequest.id}">Завершить</a>
                    <br>
                    <a href="/MedAutomation/more__req_info?id=${medicalrequest.id}" target="_blank">Больше информации</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <div>
        <form class="form-inline" role="form" action="/MedAutomation/open_add_request_page" method="post">
            <input type="submit" class="btn btn-primary" value="Добавить заявку">
        </form>
    </div>
</div>

</body>
</html>
