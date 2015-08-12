<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: d.koshlyak
  Date: 11.08.2015
  Time: 13:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<div class="container">
  <h3>Координаты эвакуации</h3>
  <table class="table table-striped">
    <tr>
      <td>
      Фамилия: <c:out value="${medical_requests.unit.lastName}"/>
      </td>
    </tr>
    <tr>
      <td>
      Имя: <c:out value="${medical_requests.unit.firstName}"/>
      </td>
    </tr>
    <tr>
      <td>
      Населенный пункт: <c:out value="${medical_requests.departurePointName}"/>
      </td>
    </tr>
    <tr>
      <td>
      Координаты: <c:out value="${medical_requests.departurePointCoordinateX}"/>, <c:out value="${medical_requests.departurePointCoordinateY}"/>
      </td>
    </tr>
    </table>
</div>
</body>