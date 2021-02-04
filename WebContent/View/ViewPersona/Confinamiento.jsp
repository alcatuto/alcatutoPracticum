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
  	
  	<form action="PersonaController" method="post">
  	<input type="hidden" name="opcion" value="guardarConfinamiento">
  		<div class="card">
  			<div class="row no-gutters">
    			<div class="col-md-5">
    			<h1>Seguimiento de confinamiento</h1>
    			<c:set var="persona" value="${listarPersona}"></c:set>
    			<input type="hidden" name="id_persona" value="${persona.ID_PERSONA}">
    		<h6 >
      			Paciente: <c:out value="${persona.NOMBRES }"></c:out> <c:out value="${persona.APELLIDOS }"></c:out>
      		</h6>
      					
    		<table class="table table-striped table-dark">
  				<thead>
    				<tr>
      					<th scope="col">#</th>
      					<th scope="col">Fecha</th>
      					<th scope="col">Observacion</th>
      					<th scope="col">Estado</th>
    				</tr>
  				</thead>
  				<tbody>
    			<c:forEach var="confinamiento" items="${listarConfinamiento}">
    				<tr>
      					<th scope="row"> <c:out value="${confinamiento.ID_CONFINAMIENTO }"></c:out> </th>
      					<td> <c:out value="${confinamiento.FECHA_REGISTRO }"></c:out>   </td>
      					<td> <c:out value="${confinamiento.OBSERVACIONES }"></c:out>   </td>
      					<td> <c:out value="${confinamiento.ESTADO }"></c:out>   </td>
    				</tr>
    			</c:forEach>
  				</tbody>
			</table>	
    			</div>
    			<div class="col-md-2"></div>
    			<div class="col-md-5">
    				<h4>REGISTRO NUEVO DE SEGUIMIENTO MÉDICO</h4>
    				 <div class="form-group">
    					<label for="exampleFormControlTextarea1">Observaciones</label>
    					<textarea class="form-control" name="text_observacion" rows="3"></textarea>
  					</div>
  					 <div class="form-group">
    					<label for="exampleFormControlSelect1">Estado Salud Actual</label>
    					<select class="form-control" name="combobox_estado">
      						<option>ESTABLE</option>
      						<option>CRÍTICO</option>
    					</select>
  					</div>
  					<a class="btn btn-secondary width-100" href="PersonaController?opcion=verApi" role="button">Regresar</a>
  					<button type="submit" class="btn btn-primary width-100">Registrar</button>
    			</div>
  			</div>
		</div>
	<br>
	<br>
	</form>
     
     
     
     
     <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="js/script.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
</body>
</html>