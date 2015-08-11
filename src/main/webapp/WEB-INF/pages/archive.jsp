<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Тест Example</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <h3>Активные заявки на эвакуацию</h3>

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
                <td><a href="/MedAutomation/departure_point_info?id=${medicalrequest.id}">Детальнее</a></td>
                <td>${medicalrequest.evacuationCrew.crewName}</td>
                <td>${medicalrequest.timestamp}</td>
                <td>
                    <a href="/MedAutomation/close_request?id=${medicalrequest.id}">Завершить</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    </div>