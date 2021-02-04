<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
     <meta charset="UTF-8">
     <meta name="viewport" content="width=device-width, initial-scale=1.0">
     <meta http-equiv="X-UA-Compatible" content="ie=edge">
     
      <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
    
    <link href="Css/styles.css" rel="stylesheet">
    
    <link href="https://fonts.googleapis.com/css2?family=Roboto&family=Titillium+Web:wght@300;400;600&display=swap" rel="stylesheet">
    <script src="https://unpkg.com/ionicons@5.2.3/dist/ionicons.js"></script>
     <title>Maps</title>
</head>
<style>
     #map{
        width: 500px;
        height: 600px;
     }
</style>
<body>
	<header>
  		<h1>Bienvenidos al <i>SISTEMA WEB COVID 19</i></h1>
  		<nav>
  			<a href="login.jsp" >CERRAR SESIÓN</a>
  		</nav>
  	</header>
  	
  	<form action="">
  		<div class="card">
  			<div class="row no-gutters">
    			<div class="col-md-5">
      				<div id="map"></div>		
    			</div>
    			<div class="col-md-7">
      				<h1>Listado de Personas con Covid19</h1>
    		<table class="table table-striped table-dark">
  				<thead>
    				<tr>
      					<th scope="col">#</th>
      					<th scope="col">Persona</th>
      					<th scope="col">Dirección</th>
      					<th scope="col"> </th>
    				</tr>
  				</thead>
  				<tbody>
    			<c:forEach var="persona" items="${listarPersonas}">
    				<tr>
      					<th scope="row"> <c:out value="${persona.ID_PERSONA }"></c:out> </th>
      					<td> <c:out value="${persona.NOMBRES }"></c:out>  <c:out value="${persona.APELLIDOS }"></c:out> </td>
      					<td> <c:out value="${persona.PROVINCIA }"></c:out>  <c:out value="${persona.CANTON }"></c:out> </td>
      					<td>
      						<a class="btn btn-primary" href="PersonaController?opcion=agregarInfo&ID_PERSONA=<c:out value="${persona.ID_PERSONA }"></c:out>" role="button">Agregar Inf.</a>
      					</td>
    				</tr>
    			</c:forEach>
  				</tbody>
			</table>
    			</div>
  			</div>
		</div>
	<br>
	<br>
	</form>
     
     
     
     <script async defer
     src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBl6mfoS8AE5woNLZSUdmVN5ZrSjM1WVn4">
     </script>
     <script type="text/javascript">
     let lugaresInfo = []
     const conseguirLugares = () =>{
     	
     	var markers = [];
     	<c:forEach var="persona" items="${listarPersonas}">
     		var lugarInfo = {
                posicion:{ lat: ${persona.LATITUD } , lng: ${persona.LONGUITUD }} ,
                name: { nombres: '${persona.NOMBRES }'+ "  "+ '${persona.APELLIDOS }'}                
            	}
        lugaresInfo.push(lugarInfo)
        </c:forEach>
     	console.log(lugaresInfo)
     	if( navigator.geolocation){
     		navigator.geolocation.getCurrentPosition(usuarioUbicacion =>{
     			let ubicacion = {
     					lat: usuarioUbicacion.coords.latitude,
     					lng: usuarioUbicacion.coords.longitude
     			}
     			dibujarMapa(ubicacion, lugaresInfo)
     		})
     	}
     }
     
     const dibujarMapa = (obj, lugaresInfo) =>{
    	 let mapa = new google.maps.Map(document.getElementById('map'),{
    	        zoom: 7,
    	        center: obj
    	    })
    	 
    	 let marcadorUsuario = new google.maps.Marker({
    	        position: obj,
    	        title: 'Tu ubicacion'
    	    })
    	 marcadorUsuario.setMap(mapa)
    	 
    	 let marcadores = lugaresInfo.map(lugar =>{
    		 return new google.maps.Marker({
    			 position: lugar.posicion,
    			 title: lugar.name.nombres,
    			 map: mapa
    		 })
    	 })
     }
     window.addEventListener('load',conseguirLugares)
     
     </script>
     <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="js/script.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
</body>
</html>