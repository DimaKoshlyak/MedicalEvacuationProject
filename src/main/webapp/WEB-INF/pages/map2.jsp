<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <meta name="viewport" content="initial-scale=1.0, user-scalable=no">
  <meta charset="utf-8">
  <title>Координаты эвакуации</title>
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

  <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBR0uOtH09eMVpRR15PAMF0OQ4ypsOmlXw&signed_in=true&callback=initMap" async defer></script>
  <script>
    lat = "${medical_requests.departurePointCoordinateX}";
    lon = "${medical_requests.departurePointCoordinateY}";
    var myCenter=new google.maps.LatLng(lat, lon);

    function initialize()
    {
      var mapProp = {
        center:myCenter,
        zoom:4,
        mapTypeId:google.maps.MapTypeId.ROADMAP
      };

      var map=new google.maps.Map(document.getElementById("map"),mapProp);

      var marker=new google.maps.Marker({
        position:myCenter,
      });

      marker.setMap(map);
    }

    google.maps.event.addDomListener(window, 'load', initialize);
  </script>
</head>

<body>
<div id="map"></div>
</body>
</html>
