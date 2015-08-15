<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
  <meta charset="UTF-8" />
  <title>Добавление нового лечебного учреждения</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
  <form role="form" enctype="multipart/form-data" class="form-horizontal" action="/MedAutomation/add_institution" method="post">
    <div class="form-group"><h3>Добавление нового лечебного учреждения</h3></div>
    <div class="form-group">
      <label>Название лечебного учреждения</label>
      <input type="text" class="form-control" name="institutionName">
    </div>
    <div class="form-group">
      <label for="institutionType">Тип лечебного учреждения</label>
      <select class="form-control" id="institutionType" name="institutionType">
        <option>Медико-санитарная часть</option>
        <option>Госпиталь</option>
        <option>Полевой госпиталь</option>
        <option>Санаторий</option>
      </select>
    </div>
    <div class="form-group">
      <label>Населенный пункт</label>
      <input type="text" class="form-control" name="institutionCity">
    </div>
    <div class="form-group">
      <label>Координаты широты</label>
      <input type="text" class="form-control" name="institutionCoordinateX">
    </div>
    <div class="form-group">
      <label>Координаты долготы</label>
      <input type="text" class="form-control" name="institutionCoordinateY">
    </div>
    <div class="form-group"><input type="submit" class="btn btn-primary" value="Добавить лечебное учереждение"></div>
  </form>
</div>
</body>
</html>
