<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="initial-scale=1.0, user-scalable=no">
    <meta charset="utf-8">
    <title>Adding controls to the map</title>
    <style>
        html, body {
            height: 100%;
            margin: 0;
            padding: 0;
        }

        #map {
            height: 100%;
        }
    </style>
</head>
<body>
<div id="map"></div>
<script>
    function initMap() {
        lat = <c:out value="${medical_requests.departurePointCoordinateX}"/>;
        lon = <c:out value="${medical_requests.departurePointCoordinateY}"/>;
        var myCenter = new google.maps.LatLng(lat, lon);
        var map = new google.maps.Map(document.getElementById('map'), {
            zoom: 12,
            center: myCenter,
            zoomControl: false,
            scaleControl: true
        });

        var marker = new google.maps.Marker({
            position: myCenter,
        });
        marker.setMap(map);
    }

</script>
<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBR0uOtH09eMVpRR15PAMF0OQ4ypsOmlXw&signed_in=true&callback=initMap"
        async defer></script>
</body>
</html>