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
    var map = new google.maps.Map(document.getElementById('map'), {
      zoom: 4,
      center: {lat: -33, lng: 151},
      zoomControl: false,
      scaleControl: true
    });
  }

</script>
<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBR0uOtH09eMVpRR15PAMF0OQ4ypsOmlXw&signed_in=true&callback=initMap" async defer></script>
</body>
</html>