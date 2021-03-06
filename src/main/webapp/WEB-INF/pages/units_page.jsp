<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Список всех раненых</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
</head>

<body>

<nav class="navbar navbar-default">
  <div class="container">
    <div>
      <ul class="nav navbar-nav">
        <li><a href="/MedAutomation/">Активные заявки</a></li>
        <li><a href="/MedAutomation/show_crews">Экипажи</a></li>
        <li><a href="/MedAutomation/show_institutions">Лечебные учреждения</a></li>
        <li class="active"><a href="/MedAutomation/show_all_units">Раненые</a></li>
        <li><a href="/MedAutomation/show_archive">Архивные</a></li>
      </ul>
    </div>
  </div>
</nav>

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