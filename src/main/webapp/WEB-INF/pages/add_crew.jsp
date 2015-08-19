<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
  <meta charset="UTF-8" />
  <title>Создание нового экипажа</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
  <form role="form" enctype="multipart/form-data" class="form-horizontal" action="/MedAutomation/add_crew" method="post">
    <div class="form-group"><h3>Создание нового экипажа</h3></div>
    <div class="form-group">
      <label>Название экипажа</label>
      <input type="text" class="form-control" name="crewName">
    </div>
    <div class="form-group">
      <label>ФИО первого члена экипажа</label>
      <input type="text" class="form-control" name="member1Name">
    </div>
    <div class="form-group">
      <label>ФИО второго члена экипажа</label>
      <input type="text" class="form-control" name="member2Name">
    </div>
    <div class="form-group">
      <label>Автомобиль</label>
      <input type="text" class="form-control" name="car">
    </div>
    <div class="form-group">
      <label for="reanimation">Наличие реанимации</label>
      <select class="form-control" id="reanimation" name="reanimation">
        <option>Присутствует</option>
        <option>Отсутствует</option>
      </select>
    </div>
    <div class="form-group"><input type="submit" class="btn btn-primary" value="Добавить экипаж"></div>
    </form>
  </div>
</body>
</html>
