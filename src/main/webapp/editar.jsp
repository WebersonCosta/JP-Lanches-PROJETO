<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="assets/css/style.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="shortcut icon" href="assets/img/logo/logo-ico.ico" type="image/x-icon">
    <title>Editar - Admin</title>
</head>
<body>
    <main>
        <header>
            <nav>
                <div class="logo"><a href="loginAdmin.jsp"><img src="assets/img/logo/logo-ppp.png" alt="#"></a></div>
            </nav>
        </header>
        <div class="linha">
            <section class="home-imagem-logo login-logo">
                <picture class="container-logo-login">
                        <img src="assets/img/logo/logo-g.png" alt="logo marca da pizzaria" class="dinamic-login">
                </picture>
            </section>        
            <form class="login-box textfield" name="frmAdmin" action="update">  
            	<h1>EDITAR ADIMINISTRADOR</h1>
            	<label for="idAdministrador" class="textfield">id</label>
            	<input type="text" name="idAdministrador" id="idAdmin" readonly value="<%out.print(request.getAttribute("idAdministrador"));%>">
                <label for="nome" class="textfield">Nome</label>
                <input type="text" name="nome" required value="<%out.print(request.getAttribute("nome"));%>">
                <label for="usuario" class="textfield">Usuário</label>
                <input type="text" name="usuario" required value="<%out.print(request.getAttribute("usuario"));%>">
                <label for="senha" class="textfield">senha</label>
                <input type="password" name="senha" required value="<%out.print(request.getAttribute("senha"));%>">
                <label for="cpf" class="textfield">CPF</label>
                <input type="text" name="cpf" required value="<%out.print(request.getAttribute("cpf"));%>">
                <input id="btn-adc-admin" type="submit" value="SALVAR" onClick="validar()">
            </form>
        </div>
    </main>
    <footer>
        <a href="https://www.linkedin.com/in/weberson-costa/" rel="_blank" >
            <p> &copy; Desenvolvido por Weberson costa </p>
        </a>
    </footer>
    <script src="assets/js/validador.js"></script>    
</body>
</html>