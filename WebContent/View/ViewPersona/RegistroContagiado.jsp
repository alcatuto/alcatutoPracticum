<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
    integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
    crossorigin="anonymous">
    
    <link href="../../Css/googleMap.css" rel="stylesheet">
    
    <link href="https://fonts.googleapis.com/css2?family=Roboto&family=Titillium+Web:wght@300;400;600&display=swap" rel="stylesheet">
    <script src="https://unpkg.com/ionicons@5.2.3/dist/ionicons.js"></script>

    <title>APP WEB</title>
    <style>
      
      #map {
        width: 500px;
        height: 600px;
      }
      #coordslat{width: 200px;}
      #coordslng{width: 200px;}
    </style>
 
  <body>
	<form action="PersonaController" method="post">
	<input type="hidden" name="opcion" value="guardarPersona">
       <div class="row no-gutters bg-dark">
           <div class="col-xl-5 col-lg-12 register-bg">
            <div class="position-absolute p-4">
            	 <div id="map"></div>
    			
    			
                <p class="text-light">Arrastre el marcador para seleccionar su ubicación.</p>
            </div>
           </div>
            <div class="col-xl-7 col-lg-12 d-flex">
                <div class="container align-self-center p-6">
                    <h1>Registro de Personas con Covid19</h1>
                    <p class="text-light">Ingresa la siguiente información para registrarte.</p>

				
				<div>
					<div>
                    	<label class="font-weight-bold">Cédula <span class="text-danger">*</span></label>
                       	<input type="text" class="form-control" placeholder="Número cédula" name="text_cedula">
                   	</div>
				</div>
				<div class="form-row mb-2">
					<div class="form-group col-md-6">
						<label class="font-weight-bold">Nombres <span class="text-danger">*</span></label>
						<input type="text" class="form-control" placeholder="Tus nombres" name="text_nombres">
					</div>
					<div class="form-group col-md-6">
						<label class="font-weight-bold">Apellidos <span class="text-danger">*</span></label>
						<input type="text" class="form-control" placeholder="Tus apellidos" name="text_apellidos">
					</div>
				</div>
				<div class="form-row mb-2">
					<div class="form-group col-md-4">
						<label class="font-weight-bold">Género <span class="text-danger">*</span></label>
						<select class="form-control" name="combobox_genero">
							<option selected>MASCULINO</option>
							<option selected>FEMENINO</option>
						</select>
					</div>
					<div class="form-group col-md-4">
						<label class="font-weight-bold">Provincia <span class="text-danger">*</span></label>
						<select class="form-control" name="combobox_provincias">
							<option selected>ESMERALDA</option>
							<option selected>MANABÍ</option>
							<option selected>LOS RIOS</option>
							<option selected>SANTA ELENA</option>
							<option selected>GUAYAS</option>
							<option selected>STO. DOMINGO</option>
							<option selected>EL ORO</option>
							<option selected>AZUAY</option>
							<option selected>BOLIVAR</option>
							<option selected>CAÑAR</option>
							<option selected>CARCHI</option>
							<option selected>COTOPAXI</option>
							<option selected>CHIMBORAZO</option>
							<option selected>IMBABURA</option>
							<option selected>LOJA</option>
							<option selected>PICHINCHA</option>
							<option selected>TUNGURAHUA</option>
							<option selected>MORONA SANTIAGO</option>
							<option selected>NAPO</option>
							<option selected>ORELLANA</option>
							<option selected>PASTAZA</option>
							<option selected>SUCUMBIOS</option>
							<option selected>ZAMORA CHICHIPE</option>
							<option selected>GALAPAGOS</option>
						</select>
					</div>
                            <div class="form-group col-md-4">
                                <label class="font-weight-bold">Edad <span class="text-danger">*</span></label>
                                <input type="text" class="form-control" placeholder="tu edad" name="text_edad">
                            </div>
                        </div>
                        
                        <div class="form-row mb-2">
					<div class="form-group col-md-6">
						<label class="font-weight-bold">Cantón <span class="text-danger">*</span></label>
                                <input type="text" class="form-control" placeholder="tu canton" name="text_canton">
					</div>
					<div class="form-group col-md-6">
						<label class="font-weight-bold">Celular <span class="text-danger">*</span></label>
                                <input type="text" class="form-control" placeholder="Número celular" name="text_celular">
					</div>
                            
                        </div>
                        <div class="form-group mb-3">
                            <label class="font-weight-bold">Correo electrónico <span class="text-danger">*</span></label>
                            <input type="email" class="form-control" placeholder="Ingresa tu correo electrónico" name="text_email">
                        </div>
                        <div class="form-row mb-2">
					<div class="form-group col-md-6">
						<label class="font-weight-bold">Latitud <span class="text-danger">*</span></label>
						<input type="text" class="form-control" name="text_latitud" id="coordslat" >
					</div>
					<div class="form-group col-md-6">
						<label class="font-weight-bold">Longuitud <span class="text-danger">*</span></label>
						<input type="text" class="form-control" name="text_longuitud" id="coordslng">
					</div>
				</div>
                        <a class="btn btn-secondary width-100" href="inicio.jsp" role="button">Cancelar</a>
                        <button type="submit" class="btn btn-primary width-100" value="guardar Persona">Registrar</button>
                        
                    <small class="d-inline-block text-muted mt-5">Todos los derechos reservados | © 2020 Ana Catuto - UTPL</small>
                </div>
           </div>
       </div>
       <br>
	<br>
	</form>
	
	<script>
		var marker;          //variable del marcador
		var coords = {};    //coordenadas obtenidas con la geolocalización

		//Funcion principal
		initMap = function (){
    		//usamos la API para geolocalizar el usuario
        	navigator.geolocation.getCurrentPosition(
          		function (position){
            		coords =  {
              			lng: position.coords.longitude,
              			lat: position.coords.latitude
            		};
            		setMapa(coords);  //pasamos las coordenadas al metodo para crear el mapa
          	},function(error){console.log(error);});
		}

		function setMapa (coords){   
      		//Se crea una nueva instancia del objeto mapa
      		var map = new google.maps.Map(document.getElementById('map'),{
        		zoom: 19,
        		center:new google.maps.LatLng(coords.lat,coords.lng),
      		});
      		//Creamos el marcador en el mapa con sus propiedades
      		//para nuestro obetivo tenemos que poner el atributo draggable en true
      		//position pondremos las mismas coordenas que obtuvimos en la geolocalización
      		marker = new google.maps.Marker({
        		map: map,
        		draggable: true,
        		animation: google.maps.Animation.DROP,
        		position: new google.maps.LatLng(coords.lat,coords.lng),
      		});
      		//agregamos un evento al marcador junto con la funcion callback al igual que el evento dragend que indica 
      		//cuando el usuario a soltado el marcador
      		marker.addListener('click', toggleBounce);
      
      		marker.addListener( 'dragend', function (event){
        		//escribimos las coordenadas de la posicion actual del marcador dentro del input #coords
        		//document.getElementById("coords").value = this.getPosition().lat()+","+ this.getPosition().lng();
      			document.getElementById("coordslat").value = this.getPosition().lat();
      			document.getElementById("coordslng").value = this.getPosition().lng();
      		});
		}

		//callback al hacer clic en el marcador lo que hace es quitar y poner la animacion BOUNCE
		function toggleBounce() {
  			if (marker.getAnimation() !== null) {
    			marker.setAnimation(null);
  			} else {
    			marker.setAnimation(google.maps.Animation.BOUNCE);
  			}
		}

		// Carga de la libreria de google maps 
    	</script>
    	<script async defer src="https://maps.googleapis.com/maps/api/js?callback=initMap"></script>
    
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="js/script.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
  </body>
</html>