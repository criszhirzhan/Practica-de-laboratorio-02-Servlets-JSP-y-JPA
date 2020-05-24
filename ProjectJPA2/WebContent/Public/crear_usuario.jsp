<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="/ProjectJPA2/config/styles/stylesCrUser.css">
<script type="text/javascript" src="/ProjectJPA2/config/JS/validaciones.js"></script>
</head>
<body>
	<div>

		<div id="header">


			<!-- Nav -->
			<nav id="nav">
				<ul>
					<li><a href="index.html">Home</a></li>
					<li><a href="/ProjectJPA2/Public/login.jsp">Iniciar Sesion</a></li>
					<li><a href="/ProjectJPA2/Public/crear_usuario.jsp">Registrarse</a></li>
					
				</ul>
			</nav>


		</div>
	</div>
	<br>
	
	

	<div class="cuerpo">
		<div class="contenedor">
			<form action="/ProjectJPA2/crearUsuario" method="POST" onsubmit="return validarCamposObligatorios()" >
				<div class="container">
					<p>Por favor complete este formulario para crear una cuenta.</p>
					<hr>

					<label for="cedula"><b>Cedula</b></label> <input id="cedulaID" type="text"
						placeholder="Ingresar cedula" name="cedula" onkeypress="ValidarNumeros(event, 'mensajeCedula', this)" required> <span id="mensajeCedula"></span> <label
						for="nombres"><b>Nombres</b></label> <input id="nombresID" type="text"
						placeholder="Ingresar nombres" name="nombres" onkeypress="ValidarLetras(event, 'mensajeNombres', this)" required><span id="mensajeNombres"></span> <label
						for="apellidos"><b>Apellidos</b></label> <input id="apellidosID" type="text"
						placeholder="Ingresar apellidos" name="apellidos"  onkeypress="ValidarLetras(event, 'mensajeApellidos', this)" required><span id="mensajeApellidos"></span>

					<label for="email"><b>Email</b></label> <input id="emailID" type="text"
						placeholder="Ingresar email" name="email" required><span id="mensajeCorreo"></span> <label
						for="psw"><b>Contraseña</b></label> <input id="passID" type="password"
						placeholder="Ingresar contraseña" name="psw" required> 
					<hr>

					<button type="submit" class="registerbtn" name="registrarUsr"
						value="RegistrarUsr">Registrar</button>
				</div>

			</form>

		</div>

	</div>

</body>
</html>