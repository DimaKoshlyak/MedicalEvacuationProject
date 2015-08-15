<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Создание новой заявки</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
    <form role="form" enctype="multipart/form-data" class="form-horizontal" action="/MedAutomation/add_request" method="post">
        <div class="form-group"><h3>Создание новой заявки.</h3></div>
        <div class="form-group">
            <label>Имя пострадавшего</label>
            <input type="text" class="form-control" name="firstName">
        </div>
        <div class="form-group">
            <label>Фамилия пострадавшего</label>
            <input type="text" class="form-control" name="lastName">
        </div>
        <div class="form-group">
            <label for="sex">Пол</label>
            <select class="form-control" id="sex" name="sex">
                <option>М</option>
                <option>Ж</option>
            </select>
        </div>
        <div class="form-group">
            <label>Бригада</label>
            <input type="text" class="form-control" name="brigade">
        </div>
        <div class="form-group">
            <label>Батальон</label>
            <input type="text" class="form-control" name="battalion">
        </div>
        <div class="form-group">
            <label>Группа крови</label>
            <input type="text" class="form-control" name="bloodType">
        </div>
        <div class="form-group">
            <label>Вес</label>
            <input type="text" class="form-control" name="weight">
        </div>
        <div class="form-group">
            <label>Номер жетона</label>
            <input type="text" class="form-control" name="tokenNumber">
        </div>
        <div class="form-group">
            <label for="status">Степень тяжести состояния пострадавшего</label>
            <select class="form-control" id="status" name="status">
                <option>Удовлетворительное</option>
                <option>Средней тяжести</option>
                <option>Тяжелое</option>
                <option>Крайне тяжелое</option>
                <option>Критическое</option>
            </select>
        </div>
        <div class="form-group">
            <label for="injury">Вид ранения</label>
            <select class="form-control" id="injury" name="injury">
                <option>Огнестрельное</option>
                <option>Минно-взрывное</option>
                <option>Взрывное</option>
            </select>
        </div>
        <div class="form-group">
            <label for="painReaction">Болевая реакция</label>
            <select class="form-control" id="painReaction" name="painReaction">
                <option>Сохранена</option>
                <option>Отсутствует</option>
            </select>
        </div>
        <div class="form-group">
            <label for="breath">Дыхание</label>
            <select class="form-control" id="breath" name="breath">
                <option>Нормальное</option>
                <option>Чистое</option>
                <option>Патологическое</option>
            </select>
        </div>
        <div class="form-group">
            <label for="extremityAvulsion">Отрыв конечности</label>
            <select class="form-control" id="extremityAvulsion" name="extremityAvulsion">
                <option>Присутствует</option>
                <option>Отсутствует</option>
            </select>
        </div>
        <div class="form-group">
            <label>Давление</label>
            <input type="text" class="form-control" name="bloodPressure">
        </div>
        <div class="form-group">
            <label for="careType">Этапы помощи</label>
            <select class="form-control" id="careType" name="careType">
                <option>Помощь "под огнем"</option>
                <option>Помощь в полевых условиях</option>
                <option>Мобильные, военные, гражданские госпиталя и клиники</option>
            </select>
        </div>
        <div class="form-group">
            <label>Населенный пункт эвакуации</label>
            <input type="text" class="form-control" name="departurePointName">
        </div>
        <div class="form-group">
            <label>Координаты(широта)</label>
            <input type="text" class="form-control" name="departurePointCoordinateX">
        </div>
        <div class="form-group">
            <label>Координаты(долгота)</label>
            <input type="text" class="form-control" name="departurePointCoordinateY">
        </div>
        <div class="form-group">
            <label for="destinationInstitution">Эвакуировать в</label>
            <select class="form-control" id="destinationInstitution"name="destinationInstitution">
                <c:forEach items="${institutions}" var="institution">
                    <option value="${institution.institutionName}"
                            selected=${institution == selectedInstitution ? 'selected' : ''}>${institution.institutionName}</option>
                </c:forEach>
            </select>
        </div>
        <div class="form-group">
            <label for="evacuationCrew">Экипаж для эвакуации</label>
            <select class="form-control" id="evacuationCrew" name="evacuationCrew">
                <c:forEach items="${crews}" var="crew">
                    <option value="${crew.crewName}"
                            selected=${crew == selectedCrew ? 'selected' : ''}>${crew.crewName}</option>
                </c:forEach>
            </select>
        </div>
        <div class="form-group"><input type="submit" class="btn btn-primary" value="Добавить заявку"></div>
    </form>
</div>
</body>
</html>