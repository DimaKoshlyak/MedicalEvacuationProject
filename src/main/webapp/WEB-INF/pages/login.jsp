<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Вход на сайт</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
</head>


<body>
<div class="container">
  <div class="row">
    <div class="col-md-2">
      <form class="form-horizontal" th:action='@{/login}' method="POST">
        <fieldset>
          <legend>Авторизация</legend>
          <c:if test="${param.error ne null}">
            <div>
              Invalid username and password.
            </div>
          </c:if>

          <c:if test="${param.logout ne null}">
            <div>
              You have been logged out.
            </div>
          </c:if>
          <div class="form-group">
            <!-- Username -->
            <label c for="username">Имя пользователя</label>
            <div class="controls">
              <input type="text" id="username" name="username" placeholder="" class="form-control input-xlarge ">
            </div>
          </div>
          <div class="form-group">
            <!-- Password-->
            <label for="password">Пароль</label>
            <div class="controls">
              <input type="password" id="password" name="password" placeholder="" class="form-control input-xlarge">
            </div>
          </div>
          <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
          <div class="form-group">
            <!-- Button -->
            <div class="controls">
              <button class="btn btn-success">Login</button>
            </div>
          </div>
        </fieldset>
      </form>
    </div>
  </div>
</div>
</body>