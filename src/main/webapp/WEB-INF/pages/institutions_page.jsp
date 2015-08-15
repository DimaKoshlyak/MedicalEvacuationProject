<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Лечебные учреждения</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
</head>

<body>
<div class="container">
  <h3>Лечебные учреждения</h3>
  <table class="table table-striped">
    <thead>
    <tr>
      <td><b>Название лечебного учреждения</b></td>
      <td><b>Тип</b></td>
      <td><b>Населенный пункт</b></td>
      <td><b>Координаты</b></td>
      <td><b>Операции</b></td>
    </tr>
    </thead>
    <c:forEach items="${institutions}" var="institution">
      <tr>
        <td>${institution.institutionName}</td>
        <td>${institution.institutionType}</td>
        <td>${institution.institutionCity}</td>
        <td>${institution.institutionCoordinateX}, ${institution.institutionCoordinateY}</td>
        <td>
          <a href="/MedAutomation/delete_institution?id=${institution.id}">Удалить учреждение</a>
        </td>
      </tr>
    </c:forEach>
  </table>
  <form class="form-inline" role="form" action="/MedAutomation/open_add_institution_page" method="post">
    <input type="submit" class="btn btn-primary" value="Добавить лечебной учреждение">
  </form>
</div>
</body>
</html>