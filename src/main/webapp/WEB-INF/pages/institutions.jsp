<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Лечебные заведения</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
</head>

<body>
<div class="container">
  <h3>Лечебные заведения</h3>
  <table class="table table-striped">
    <thead>
    <tr>
      <td><b>Название лечебного заведения</b></td>
      <td><b>Тип</b></td>
      <td><b>Населенный пункт</b></td>
      <td><b>Координаты</b></td>
    </tr>
    </thead>
    <c:forEach items="${institutions}" var="institution">
      <tr>
        <td>${institution.institutionName}</td>
        <td>${institution.institutionType}</td>
        <td>${institution.city}</td>
        <td>${institution.coordinateX}, ${institution.coordinateY}</td>
      </tr>
    </c:forEach>
  </table>
</div>
</body>
</html>