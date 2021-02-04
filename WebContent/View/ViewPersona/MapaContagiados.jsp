<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
     <meta charset="UTF-8">
     <meta name="viewport" content="width=device-width, initial-scale=1.0">
     <meta http-equiv="X-UA-Compatible" content="ie=edge">
     <title>Maps</title>
</head>
<style>
     #map{
         height:25em;
     }
     h1{
         text-align: center;
     }
</style>
<body>
     <h1>Marcadores</h1>
     <script type="text/javascript" src="http://maps.google.com/maps/api/js?      sensor=false"></script>
	<script type="text/javascript">
           
var markers = [<c:forEach var="persona" items="${listarPersonas}">

['Farmer Name :${persona.NOMBRES}<br>Crop Type:${persona.APELLIDOS}',${persona.LATITUD},${persona.LONGUITUD}],
            </c:forEach>        
];



function initializeMaps() {
var latlng = new google.maps.LatLng(markers[0][1],markers[0][2]);
var myOptions = {
    zoom: 18,
    center: latlng,
    mapTypeId: google.maps.MapTypeId.SATELLITE,
    mapTypeControl: false
};
var map = new google.maps.Map(document.getElementById("map_canvas"),myOptions);
var infowindow = new google.maps.InfoWindow(), marker, i;
for (i = 0; i < markers.length; i++) {  
    marker = new google.maps.Marker({
        position: new google.maps.LatLng(markers[i][1], markers[i][2]),
        map: map
    });
    google.maps.event.addListener(marker, 'click', (function(marker, i) {
        return function() {
            infowindow.setContent(markers[i][0]);
            infowindow.open(map, marker);
        }
    })(marker, i));
}

}
</script>
     
</body>
</html>



