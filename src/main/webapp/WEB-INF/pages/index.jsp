<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Тест Example</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <h3>Активные заявки на эвакуацию</h3>

    <form class="form-inline" role="form" action="/MedAutomation/search" method="post">
        <input type="text" class="form-control" name="pattern" placeholder="Search">
        <input type="submit" class="btn btn-default" value="Search">
    </form>

    <table class="table table-striped">
        <thead>
        <tr>

            <td><b>Id пострадавшего</b></td>
            <td><b>Состояние</b></td>
            <td><b>Тип ранения</b></td>
            <td><b>Давление</b></td>
            <td><b>Отрыв конечности</b></td>
            <td><b>Информация про эвакуацию</b></td>
            <td><b>Экипаж</b></td>
            <td><b>Время фиксации</b></td>
        </tr>
        </thead>
        <c:forEach items="${medical_requests}" var="medicalrequest">
            <tr>
                <td>${medicalrequest.unit.id}</td>
                <td>${medicalrequest.status}</td>
                <td>${medicalrequest.injury}</td>
                <td>${medicalrequest.bloodPressure}</td>
                <td>${medicalrequest.extremityAvulsion}</td>
                <td><a href="/MedEvacuation/departure_point_info?id=${medicalrequest.id}">Детальнее</a></td>
                <td>${medicalrequest.evacuationCrew.crewName}</td>
                <td>${medicalrequest.timestamp}</td>
            </tr>
        </c:forEach>
    </table>
  <!--  <form class="form-inline" role="form" action="/SpringMVC/add_page" method="post">
        <input type="submit" class="btn btn-primary" value="Add new">
    </form>
    <form class="form-inline" role="form" action="/SpringMVC/trash_page" method="post">
        <input type="submit" class="btn btn-primary" value="Show Thash">
    </form>
    <form class="form-inline" role="form" action="/SpringMVC/load_xml" method="post">
        <input type="submit" class="btn btn-primary" value="Load XML File">
    </form>
-->


   <!--table class="table table-striped">
        <tr>
            <td>
                <form action="/SpringMVC/add_page" method="post">
                    <input type="submit" value="Add new"class="btn btn-primary">
                </form>
            </td>
            <td>
                <form action="/SpringMVC/trash_page" method="post">
                    <input type="submit" value="Show Thash" class="btn btn-primary">
                </form>
            <td>
                <form  enctype="multipart/form-data" class="form-horizontal" role="form" action="/SpringMVC/load_xml" method="post">
                    <table>
                        <tr>
                            <td > <input type="file" name="xmlfile"></td>
                            <td width="200"> <input type="submit" value="Load XML File"></td>
                        </tr>
                    </table>
                </form>
            </td>
        </tr>
    </table-->

</div>
</body>
</html>