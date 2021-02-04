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
    
    <div class="formularioUsuario bg-dark">
		<div class="container align-self-center p-6">
			<h3 class="font-weight-bold mb-3">Registro de Nuevo Usuario</h3>
			<p class="text-muted mb-5">Ingresa la siguiente información para registrar al usuario.</p>
			
			<form action="UsuarioController" method="post">
				<c:set var="usuario" value="${listarUsuario}"></c:set>
				<input type="hidden" name="opcion" value="editarUsuario">
				<input type="hidden" name="id_usuario" value="${usuario.ID_USUARIO}">
				
				<div>
					<div>
                    	<label class="font-weight-bold">Cédula <span class="text-danger">*</span></label>
                       	<input type="text" class="form-control" placeholder="Número cédula" name="text_cedula" value="${usuario.IDENTIFICACION}">
                   	</div>
				</div>
				<div class="form-row mb-2">
					<div class="form-group col-md-6">
						<label class="font-weight-bold">Nombres <span class="text-danger">*</span></label>
						<input type="text" class="form-control" placeholder="Tus nombres" name="text_nombres" value="${usuario.NOMBRES}">
					</div>
					<div class="form-group col-md-6">
						<label class="font-weight-bold">Apellidos <span class="text-danger">*</span></label>
						<input type="text" class="form-control" placeholder="Tus apellidos" name="text_apellidos" value="${usuario.APELLIDOS}">
					</div>
				</div>
				<div class="form-row mb-2">
					<div class="form-group col-md-6">
						<label class="font-weight-bold">Ciudad <span class="text-danger">*</span></label>
						<input type="text" class="form-control" placeholder="Tu ciudad" name="text_ciudad" value="${usuario.CIUDAD}">
					</div>
					<div class="form-group col-md-6">
						<label class="font-weight-bold">Dirección <span class="text-danger">*</span></label>
						<input type="text" class="form-control" placeholder="Tu dirección" name="text_direccion" value="${usuario.DIRECCION}">
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
						<label class="font-weight-bold">Rol <span class="text-danger">*</span></label>
						<select class="form-control" name="combobox_roles">
							<c:forEach var="rol" items="${listarRoles}">
								<option value="${rol.ID_ROLES }" > <c:out value="${rol.NOMBRE }"></c:out> </option>
							</c:forEach>
						</select>
					</div>
					<div class="form-group col-md-4">
						<label class="font-weight-bold">Celular <span class="text-danger">*</span></label>
						<input type="text" class="form-control" placeholder="Número celular" name="text_celular" value="${usuario.CELULAR}">
					</div>
				</div>
				<div class="form-group mb-3">
					<label class="font-weight-bold">Correo electrónico <span class="text-danger">*</span></label>
					<input type="email" class="form-control" placeholder="Ingresa tu correo electrónico" name="text_email" value="${usuario.EMAIL}">
				</div>
				<div class="form-row mb-2">
					<div class="form-group col-md-6">
						<label class="font-weight-bold">Usuario <span class="text-danger">*</span></label>
						<input type="text" class="form-control" placeholder="Nombre usuario" name="text_usuario" value="${usuario.USUARIO}">
					</div>
					<div class="form-group col-md-6">
						<label class="font-weight-bold">Contraseña <span class="text-danger">*</span></label>
						<input type="text" class="form-control" placeholder="Contraseña" name="text_clave" value="${usuario.CLAVE}">
					</div>
				</div>
                	
				<a class="btn btn-secondary width-100" href="UsuarioController?opcion=listarUsu" role="button">Regresar</a>
				<button type="submit" class="btn btn-primary width-100">Guardar</button>
  						
				<br>
				<br>
			</form>
                    
		</div>
	</div>
	<br>
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="js/script.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
  </body>
</html>