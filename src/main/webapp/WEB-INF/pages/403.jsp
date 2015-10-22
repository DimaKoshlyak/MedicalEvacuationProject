<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <title>Доступ запрещен!</title>
</head>
<body>
<h1>У вас нет доступа к этой странице!
</h1>
<form action="/logout" method="post">
  <input type="submit" value="Зайти под другим пользователем" />
  <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
</form>
</body>
</html>
