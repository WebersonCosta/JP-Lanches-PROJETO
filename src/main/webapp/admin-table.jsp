<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.Administrador"%>
<%@ page import="java.util.ArrayList"%>
<%
ArrayList<Administrador> lista = (ArrayList<Administrador>) 
request.getAttribute("administradores");
%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="assets/css/style.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="shortcut icon" href="assets/img/logo/logo-ico.ico"
	type="image/x-icon">
<title>Tabela de Administradores</title>
</head>
<body>
	<main>
		<header>
			<nav>
				<div class="logo">
					<a href="loginAdmin.jsp"><img
						src="assets/img/logo/logo-ppp.png" alt="#"></a>
				</div>
			</nav>
		</header>
		<div>
			<div class="tabela">
				<h1>TABELA DE ADMINISTRADORES</h1>
				<a class="btn-padrao" href="cadastro-admin.html">Cadastrar Novo</a>
				<table id="tabelaAdmin">
					<thead>
						<tr>
							<th>ID</th>
							<th>NOME</th>
							<th>USUARIO</th>
							<th>SENHA</th>
							<th>CPF</th>
							<th>OPÇÕES</th>
						</tr>
					</thead>
					<tbody>
						<% for (int i = 0; i < lista.size(); i++) { %>
							<tr>
								<td><%=lista.get(i).getIdAdministrador() %></td>
								<td><%=lista.get(i).getNome() %></td>
								<td><%=lista.get(i).getLogin() %></td>
								<td><%=lista.get(i).getSenha() %></td>
								<td><%=lista.get(i).getCpf() %></td>
								<td>
									<a href="select?idAdministrador=<%=lista.get(i).getIdAdministrador() %>"
								 	class="btn-padrao">Editar</a> 
								 	<a href="javascript: confirmar(<%=lista.get(i).getIdAdministrador() %>)"
								 	class="btn-padrao2">Excluir</a>
								 </td>
							</tr>
						<% } %>
					</tbody>
				</table>
			</div>
		</div>
	</main>
	<footer>
		<a href="https://www.linkedin.com/in/weberson-costa/" rel="_blank">
			<p>&copy; Desenvolvido por Weberson costa</p>
		</a>
	</footer>
	<script src="assets/js/confirmador.js"></script>
</body>
</html>