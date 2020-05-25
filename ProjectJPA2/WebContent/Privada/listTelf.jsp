<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
<head>
<title>Contactos</title>
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



</head>
<body class="is-preload">
	<c:set var="p1" value="${requestScope['telefono']}" />
	<c:set var="p2" value="${requestScope['usuario']}" />

	<!-- Header -->
	<div id="header">

		<div class="top">

			<!-- Logo -->
			<div id="logo">
				<span class="image avatar48"><img
					src="/ProjectJPA2/config/images/avatar.jpg" alt="" /></span>
				<h1 id="title">${p2.nombre} ${p2.apellido}</h1>
				<p>${p2.correo}</p>
			</div>

			<!-- Nav -->
			<nav id="nav">
				<ul>
					<li><a href="/ProjectJPA2/IndexController?id=2&idU=${p2.cedula}" id="contact-link"><span
							class="icon solid fa-envelope">Contactos</span></a></li>
					<li><a href="/ProjectJPA2/CerrarSesion" id="top-link"><span
							class="icon solid fa-home">Cerrar Sesion</span></a></li>
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
				<div class="container mt-3">



					<form action="/ProjectJPA2/Buscar?id=3&idU=${p2.cedula}" method="POST">
						<div class="input-group mb-3 input-group-sm">
							<div class="input-group-prepend">
								<button class="input-group-text" name="buscarCorreo"
									value="correoB" type="submit">Buscar</button>

							</div>
							<input type="text" class="form-control" name="correo"
								placeholder="Buscar por correo.....">
						</div>
					</form>




					<form action="/ProjectJPA2/Buscar?id=4&idU=${p2.cedula}" method="POST">
						<div class="input-group mb-3 input-group-sm">
							<div class="input-group-prepend">
								<button class="input-group-text" name="buscarCed"
									value="cedulaB" type="submit">Buscar</button>

							</div>
							<input type="text" class="form-control" name="cedula"
								placeholder="Buscar por cedula.....">
						</div>
					</form>






					<br>
					<table class="table table-bordered">
						<thead>
							<tr>
								<th>Nombres</th>
								<th>Email</th>
								<th>Tipo</th>
								<th>Operadora</th>
								<th>Numero</th>
							</tr>
						</thead>
						<tbody id="myTable">

							<c:forEach var="telf" items="${p1}">
								<tr>
									<td>${telf.usuario.nombre} ${telf.usuario.apellido}</td>
									<td>${telf.usuario.correo}       <a href="mailto:${telf.usuario.correo} "><img width="25px"
											height="25px"
											src="https://img.icons8.com/flat_round/64/000000/secured-letter--v1.png" /></a></td>
									<td>${telf.tipo}</td>
									<td>${telf.operadora}</td>
									<td>${telf.numero}    <a href="tel:${telf.numero} "><img width="25px"
											height="25px"
											src="https://img.icons8.com/ultraviolet/40/000000/phone.png" /></a>
									</td>
								</tr>

							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</section>

	</div>
</body>
</html>