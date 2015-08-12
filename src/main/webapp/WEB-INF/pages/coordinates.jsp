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
  <h3>Координаты эвакуации</h3>
  <table class="table table-striped">
    <tr>
      <td>
      Фамилия: <c:out value="${medical_requests.unit.lastName}"/>
      </td>
    </tr>
    <tr>
      <td>
      Имя: <c:out value="${medical_requests.unit.firstName}"/>
      </td>
    </tr>
    <tr>
      <td>
      Населенный пункт: <c:out value="${medical_requests.departurePointName}"/>
      </td>
    </tr>
    <tr>
      <td>
      Координаты: <c:out value="${medical_requests.departurePointCoordinateX}"/>, <c:out value="${medical_requests.departurePointCoordinateY}"/>
      </td>
    </tr>
    </table>
</div>
</body>