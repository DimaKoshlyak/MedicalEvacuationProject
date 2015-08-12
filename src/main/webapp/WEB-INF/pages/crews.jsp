<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Экипажи</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
</head>

<body>
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
    </tr>
    </thead>
    <c:forEach items="${crews}" var="crew">
      <tr>
        <td>${crew.crewName}</td>
        <td>${crew.member1Name}</td>
        <td>${crew.member2Name}</td>
        <td>${crew.car}</td>
        <td>${crew.reanimation}</td>
      </tr>
    </c:forEach>
  </table>
  </div>
</body>
</html>