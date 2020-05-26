<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>	
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="/ProjectJPA2/config/styles/stylesCrUser.css">
<script type="text/javascript" src="/ProjectJPA2/config/JS/validaciones.js"></script>
</head>
<body>
<c:set var="p1" value="${requestScope['usuario']}" />
<c:set var="p2" value="${requestScope['mensaje']}" />
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
						placeholder="Ingresar cedula" value="${p1.cedula}" name="cedula" onkeypress="ValidarNumeros(event, 'mensajeCedula', this)" required> <span  id="mensajeCedula"></span> <label
						for="nombres"><b>Nombres</b></label> <input id="nombresID" type="text"
						placeholder="Ingresar nombres" value="${p1.nombre}" name="nombres" onkeypress="ValidarLetras(event, 'mensajeNombres', this)" required><span id="mensajeNombres"></span> <label
						for="apellidos"><b>Apellidos</b></label> <input id="apellidosID" type="text"
						placeholder="Ingresar apellidos" value="${p1.apellido}" name="apellidos"  onkeypress="ValidarLetras(event, 'mensajeApellidos', this)" required><span id="mensajeApellidos"></span>

					<label for="email"><b>Email</b></label> <input id="emailID" type="text"
						placeholder="Ingresar email" value="${p1.correo}" name="email" required><span style="border: 1px red solid; color: red"  id="mensajeCorreo">${p2}</span><br>
						 <label
						for="psw"><b>Contraseña</b></label> <input id="passID" type="password"
						placeholder="Ingresar contraseña" value="${p1.pwd}" name="psw" required> 
					<hr>

					<button type="submit" class="registerbtn" name="registrarUsr"
						value="RegistrarUsr">Registrar</button>
				</div>

			</form>

		</div>

	</div>

</body>
</html>