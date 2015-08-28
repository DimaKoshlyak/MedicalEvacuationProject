<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Экипажи</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
</head>

<body>

<nav class="navbar navbar-default">
  <div class="container">
    <div>
      <ul class="nav navbar-nav">
        <li><a href="/MedAutomation/">Активные заявки</a></li>
        <li class="active"><a href="/MedAutomation/show_crews">Экипажи</a></li>
        <li><a href="/MedAutomation/show_institutions">Лечебные учреждения</a></li>
        <li><a href="/MedAutomation/show_all_units">Раненые</a></li>
        <li><a href="/MedAutomation/show_archive">Архивные</a></li>
      </ul>
    </div>
  </div>
</nav>

<div class="container">
  <h3>Экипажи</h3>
  <table class="table table-striped">
    <thead>
    <tr>
      <td><b>Название экипажа</b></td>
      <td><b>Член экипажа 1</b></td>
      <td><b>Член экипажа 2</b></td>
      <td><b>Автомобиль</b></td>
      <td><b>Реанимация</b></td>
      <td><b>Операции</b></td>
    </tr>
    </thead>
    <c:forEach items="${crews}" var="crew">
      <tr>
        <td>${crew.crewName}</td>
        <td>${crew.member1Name}</td>
        <td>${crew.member2Name}</td>
        <td>${crew.car}</td>
        <td>${crew.reanimation}</td>
        <td>
          <a href="/MedAutomation/delete_crew?id=${crew.id}">Удалить экипаж</a>
        </td>
      </tr>
    </c:forEach>
  </table>
  <form class="form-inline" role="form" action="/MedAutomation/open_add_crew_page" method="post">
    <input type="submit" class="btn btn-primary" value="Добавить экипаж">
  </form>
  </div>
</body>
</html>