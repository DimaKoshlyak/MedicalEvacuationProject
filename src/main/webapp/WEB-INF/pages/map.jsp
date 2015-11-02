<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <script
          src="http://maps.googleapis.com/maps/api/js">
  </script>

  <script>
    lat = "${medical_requests.departurePointCoordinateX}";
    lon = "${medical_requests.departurePointCoordinateY}";
    var myCenter=new google.maps.LatLng(lat, lon);

    function initialize()
    {
      var mapProp = {
        center:myCenter,
        zoom:5,
        mapTypeId:google.maps.MapTypeId.ROADMAP
      };

      var map=new google.maps.Map(document.getElementById("googleMap"),mapProp);

      var marker=new google.maps.Marker({
        position:myCenter,
      });

      marker.setMap(map);
    }

    google.maps.event.addDomListener(window, 'load', initialize);
  </script>
</head>

<body>
<div id="googleMap" style="width:500px;height:380px;"></div>
</body>
</html>
