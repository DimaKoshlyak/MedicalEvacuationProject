<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Полная информанция о заявке</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
  <h3>Полная информанция о заявке</h3>
  <table class="table table-striped">
    <tr>
      <td>
        <b>Фамилия: </b> <c:out value="${medical_requests.unit.lastName}"/>
      </td>
    </tr>
    <tr>
      <td>
        <b>Имя: </b><c:out value="${medical_requests.unit.firstName}"/>
      </td>
    </tr>
    <tr>
      <td>
        <b>Пол: </b><c:out value="${medical_requests.unit.sex}"/>
      </td>
    </tr>
    <tr>
      <td>
        <b>Бригада: </b><c:out value="${medical_requests.unit.brigade}"/>
      </td>
    </tr>
    <tr>
      <td>
        <b>Батальон: </b><c:out value="${medical_requests.unit.battalion}"/>
      </td>
    </tr>
    <tr>
      <td>
        <b>Группа крови: </b><c:out value="${medical_requests.unit.bloodType}"/>
      </td>
    </tr>
    <tr>
      <td>
        <b>Вес: </b><c:out value="${medical_requests.unit.weight}"/>
      </td>
    </tr>
    <tr>
      <td>
        <b>Номер жетона: </b><c:out value="${medical_requests.unit.tokenNumber}"/>
      </td>
    </tr>
    <tr>
      <td>
        <b>Степень тяжести состояния пострадавшего: </b><c:out value="${medical_requests.status}"/>
      </td>
    </tr>
    <tr>
      <td>
        <b>Вид ранения: </b><c:out value="${medical_requests.injury}"/>
      </td>
    </tr>
    <tr>
      <td>
        <b>Болевая реакция: </b><c:out value="${medical_requests.painReaction}"/>
      </td>
    </tr>
    <tr>
      <td>
        <b>Дыхание: </b><c:out value="${medical_requests.breath}"/>
      </td>
    </tr>
    <tr>
      <td>
        <b>Отрыв конечности: </b><c:out value="${medical_requests.extremityAvulsion}"/>
      </td>
    </tr>
    <tr>
      <td>
        <b>Давление: </b><c:out value="${medical_requests.bloodPressure}"/>
      </td>
    </tr>
    <tr>
      <td>
        <b>Этап помощи: </b><c:out value="${medical_requests.careType}"/>
      </td>
    </tr>
    <tr>
      <td>
        <b>Населенный пункт эвакуации: </b><c:out value="${medical_requests.departurePointName}"/>
      </td>
    </tr>
    <tr>
      <td>
        <b>Эвакуировать в: </b><c:out value="${medical_requests.destinationInstitute.institutionName}"/>
      </td>
    </tr>
    <tr>
      <td>
        <b>Экипаж эвакуации: </b><c:out value="${medical_requests.evacuationCrew.crewName}"/>
      </td>
    </tr>
  </table>
</div>
</body>