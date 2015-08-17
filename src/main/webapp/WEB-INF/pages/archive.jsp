<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Архив</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
</head>
<body>

<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div>
            <ul class="nav navbar-nav">
                <li><a href="/MedAutomation/">Активные заявки</a></li>
                <li><a href="/MedAutomation/show_crews">Экипажи</a></li>
                <li><a href="/MedAutomation/show_institutions">Лечебные учреждения</a></li>
                <li><a href="/MedAutomation/show_all_units">Раненые</a></li>
                <li class="active"><a href="/MedAutomation/show_archive">Архивные</a></li>
            </ul>
        </div>
    </div>
</nav>

<div class="container">
    <h3>Архивные заявки</h3>

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
        </tr>
        </thead>
        <c:forEach items="${medical_requests}" var="medicalrequest">
            <tr>
                <td>${medicalrequest.unit.lastName} ${medicalrequest.unit.firstName}</td>
                <td>${medicalrequest.status}</td>
                <td>${medicalrequest.injury}</td>
                <td>${medicalrequest.bloodPressure}</td>
                <td>${medicalrequest.extremityAvulsion}</td>
                <td><a href="/MedAutomation/departure_point_info?id=${medicalrequest.id}">Детальнее</a></td>
                <td>${medicalrequest.evacuationCrew.crewName}</td>
                <td>${medicalrequest.timestamp}</td>
            </tr>
        </c:forEach>
    </table>
</div>