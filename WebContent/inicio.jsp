<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
    <script src="https://unpkg.com/ionicons@5.0.0/dist/ionicons.js"></script>

    <title>APP WEB</title>
  </head>
  <body>
  	<header>
  		<h1>Bienvenidos al <i>SISTEMA WEB COVID 19</i></h1>
  		<nav>
  			<a href="PersonaController?opcion=verMapa" > INICIO </a>
  			<a href="PersonaController?opcion=nuevoRegistro">REGISTRATE</a>
  			<a href="login.jsp" >LOGIN</a>
  		</nav>
  	</header>
    
    <div class="wrapper">
    	<section style="background-color:#000000">
    		
    		<img src="images/ima20.jpg" class="img-fluid" alt="Responsive image">
    		<h2>PROPÓSITO DEL SISTEMA</h2>
    		<p>El propósito del desarrollo del sistema web es ayudar a las entidades dedicadas a la salud de la población
    		ecuatoriana a determinar la ubicación exacta de las personas contagiadas de COVID19, evitando que el paciente(persona)
    		asista a un centro de salud exponiendo la salud de los habitantes, dando un seguimiento desde su hogar de los síntomas que posee.</p>
    		
    		<img src="images/ima19.jpg" class="img-fluid" alt="Responsive image">
    		
    		
    	</section>
    </div>
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="js/script.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
  </body>
</html>