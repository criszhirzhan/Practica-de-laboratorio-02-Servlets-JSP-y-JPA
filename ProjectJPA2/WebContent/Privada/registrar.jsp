<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
<head>
<title>RegistrarContacto</title>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=no" />
<link rel="stylesheet" href="/ProjectJPA2/config/styles/main.css" />

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="/ProjectJPA2/config/styles/stylesRT.css">
<script type="text/javascript" src="/ProjectJPA2/config/JS/validaciones.js"></script>

</head>
<body class="is-preload">
	<c:set var="p1" value="${requestScope['usuario']}" />
	<c:set var="p2" value="${requestScope['idc']}" />

	<!-- Header -->
	<div id="header">

		<div class="top">

			<!-- Logo -->
			<div id="logo">
				<span class="image avatar48"><img
					src="/ProjectJPA2/config/images/avatar.jpg" alt="" /></span>
				<h1 id="title">${p1.nombres} ${p1.apellidos} </h1>
				<p>${p1.correo}</p>
			</div>

			<!-- Nav -->
			<nav id="nav">
				<ul>
					<li><a href="/ProjectJPA2/IndexController?id=2&idU=${p1.cedula}"
						id="contact-link"><span class="icon solid fa-envelope">Contactos</span></a></li>
					<li><a href="/ProjectJPA2/CerrarSesion" id="top-link"><span
							class="icon solid fa-home">Cerrar sesion</span></a></li>
				</ul>
			</nav>

		</div>

		<div class="bottom">

			<!-- Social Icons -->
			<ul class="icons">
				<li><a href="#" class="icon brands fa-twitter"><span
						class="label">Twitter</span></a></li>
				<li><a href="#" class="icon brands fa-facebook-f"><span
						class="label">Facebook</span></a></li>
				<li><a href="#" class="icon brands fa-github"><span
						class="label">Github</span></a></li>
				<li><a href="#" class="icon brands fa-dribbble"><span
						class="label">Dribbble</span></a></li>
				<li><a href="#" class="icon solid fa-envelope"><span
						class="label">Email</span></a></li>
			</ul>

		</div>

	</div>

	<!-- Main -->
	<div id="main">


		<!-- Contact -->
		<section id="contact" class="four">
			<div class="container">

				<div class="contenido">

					<div class="contenedor">

						<form action="/ProjectJPA2/RegistrarContacto?ced=${p2}" method="POST" onsubmit="return validarCamposObligatorios()">
							<div class="container">
								<h1>Registrar contacto:</h1>
								<hr>

								<label for="tipo"><b>Tipo</b></label>
								<div class="container mt-3">
									<select name="tip" id="seleccion" class="custom-select mb-3">
										<option selected>Seleccionar</option>
										<option value="Celular">Celular</option>
										<option value="Telefono">Telefono</option>
									</select>
								</div>


								<label for="numero"><b>Numero</b></label> <input id="numerosID" type="text"
									placeholder="Ingresar el numero" name="numerotxt" onkeypress="ValidarTelefono(event, 'mensajeTelefono', this)" required><span id="mensajeTelefono"></span>


								<label for="operadora"><b>Operadora</b></label> <input
									type="text" id="operadoraID" placeholder="Ingresar operadora"
									name="operadoratxt" onkeypress="ValidarLetras(event, 'operadoramss', this)" required><span id="operadoramss"></span>

								<hr>

								<button type="submit" value="registrarTelf" name="registrartelf"
									class="registerbtn">Registrar</button>
							</div>

						</form>

					</div>

				</div>

			</div>
		</section>

	</div>




</body>
</html>