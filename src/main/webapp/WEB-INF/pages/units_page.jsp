<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Список всех раненых</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
</head>

<body>
<div class="container">
  <h3>Список всех раненых</h3>
  <table class="table table-striped">
    <thead>
    <tr>
      <td><b>Фамилия</b></td>
      <td><b>Имя</b></td>
      <td><b>Пол</b></td>
      <td><b>Бригада</b></td>
      <td><b>Батальон</b></td>
    </tr>
    </thead>
    <c:forEach items="${units}" var="unit">
      <tr>
        <td>${unit.lastName}</td>
        <td>${unit.firstName}</td>
        <td>${unit.sex}</td>
        <td>${unit.brigade}</td>
        <td>${unit.battalion}</td>
      </tr>
    </c:forEach>
  </table>
</div>
</body>
</html>