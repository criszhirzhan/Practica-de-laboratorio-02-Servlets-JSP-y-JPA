<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
<head>
<title>Inicio</title>
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
				<h1 id="title">${p2.nombres} ${p2.apellidos}</h1>
				<p>${p2.correo}</p>
			</div>

			<!-- Nav -->
			<nav id="nav">
				<ul>
					<li><a href="/ProjectJPA2/IndexController?id=2&idU=${p2.cedula}" id="contact-link"><span
							class="icon solid fa-envelope">Contactos</span></a></li>
					<li><a href="/ProjectJPA2/IndexController?id=4&idU=${p2.cedula}" id="contact-link"><span
							class="icon solid fa-envelope">Listar Contactos</span></a></li>		
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

				<div class="containe">
					<p>Registrar nuevo contacto</p>

					<a href="/ProjectJPA2/IndexController?id=1&c=${p2.cedula}"><button type="button"
							class="btn btn-secondary">Registrar</button></a>


				</div>


				<div class="container mt-3">

					<br>
					<table class="table table-bordered">
						<thead>
							<tr>
								<th>Email</th>
								<th>Tipo</th>
								<th>Operadora</th>
								<th>Numero</th>
								<th>Accion</th>
							</tr>
						</thead>
						<tbody id="myTable">

							<c:forEach var="telf" items="${p1}">
								<tr>
									<td>${p2.correo}</td>
									<td>${telf.tipo}</td>
									<td>${telf.operadora}</td>
									<td>${telf.numero}
									</td>
									<td><a
										href="/ProjectJPA2/EditarContacto?id=${telf.telf_id}&idUser=${p2.cedula}"
										class="btn btn-warning">Editar</a> <a
										href="/ProjectJPA2/EliminarContacto?id=${telf.telf_id}&idUser=${p2.cedula}"
										class="btn btn-danger">Eliminar</a></td>
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