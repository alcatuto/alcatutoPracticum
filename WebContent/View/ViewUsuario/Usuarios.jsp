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
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
    
    <link href="Css/styles.css" rel="stylesheet">
    
    <link href="https://fonts.googleapis.com/css2?family=Roboto&family=Titillium+Web:wght@300;400;600&display=swap" rel="stylesheet">
    <script src="https://unpkg.com/ionicons@5.2.3/dist/ionicons.js"></script>

    <title>APP WEB</title>
  </head>
  <body>
  	<header>
  		<h1>Bienvenidos al <i>SISTEMA WEB COVID 19</i></h1>
  		<nav>
  			<a href="login.jsp" >CERRAR SESIÓN</a>
  		</nav>
  	</header>
    
    <form class="tablaUsuarios">
    	<h4 align="center">USUARIOS REGISTRADOS EN EL SISTEMA WEB</h4>
		<div>
			<a class="btn btn-success" href="UsuarioController?opcion=nuevoUsuario" role="button">Nuevo Usuario</a>
			<br>
			<br>
			<table class="table table-striped table-dark">
  				<thead>
    				<tr>
      					<th scope="col">#</th>
      					<th scope="col">IDENTIFICACIÓN</th>
      					<th scope="col">USUARIO</th>
      					<th scope="col">ROL</th>
      					<th scope="col">ESTADO</th>
      					<th scope="col"> </th>
    				</tr>
  				</thead>
  				<tbody>
    				<c:forEach var="usuario" items="${listarUsuarios}">
    					<tr>
      						<th scope="row"> <c:out value="${usuario.ID_USUARIO }"></c:out> </th>
      						<td> <c:out value="${usuario.IDENTIFICACION }"></c:out> </td>
      						<td> <c:out value="${usuario.NOMBRES }"></c:out>  <c:out value="${usuario.APELLIDOS }"></c:out> </td>
      						<td> <c:out value="${usuario.ID_ROLES }"></c:out> </td>
      						<td> <c:out value="${usuario.ESTADO }"></c:out> </td>
      						<td>
      							<div> 
      								<a class="btn btn-primary" href="UsuarioController?opcion=editarUsuario&ID_USUARIO=<c:out value="${usuario.ID_USUARIO }"></c:out>" role="button">Editar</a>
      								<a class="btn btn-danger" href="UsuarioController?opcion=eliminarUsuario&ID_USUARIO=<c:out value="${usuario.ID_USUARIO }"></c:out>" role="button">Eliminar</a>
      				 			</div>
      						</td>
    					</tr>
    				</c:forEach>
  				</tbody>
			</table>
		</div>
	<br>
	<h6> 1: ADMINISTRADOR/A</h6>
	<h6> 2: DOCTOR/A</h6>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	</form>
    
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="js/script.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
  </body>
</html>