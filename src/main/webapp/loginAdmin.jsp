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
    <title>admin - JP Lanches</title>
</head>
<body>
    <main>
        <header>
            <nav>
                <div class="logo"><a href="index.html"><img src="assets/img/logo/logo-ppp.png" alt="#"></a></div>
                <div class="menu-btn">
                    <i class="fa fa fa-bars fa-2x" onclick="menuShow()"></i>
                </div>
                <ul>
                    <li><a href="admin-table.jsp" class="active">CADASTRAR</a></li>
                </ul>
            </nav>
        </header>
        <div class="linha">
            <section class="home-imagem-logo login-logo">
                <picture class="container-logo-login">
                        <img src="assets/img/logo/logo-g.png" alt="logo marca da pizzaria" class="dinamic-login">
                </picture>
            </section>
            <section class="login-box">
                <h1>LOGIN ADIMINISTRADOR</h1>
                <div class="textfield">
                    <label for="usuario">Usuário</label>
                    <input type="text" name="usuario" placeholder="Usuário" required>
                </div>
                <div class="textfield">
                    <label for="senha">senha</label>
                    <input type="password" name="senha" placeholder="senha" required>
                </div>
                <div class="btn-padrao-c"><a href="index.html">CONFIRMAR</a></div>
            </section>
        </div>
    </main>
    <footer>
        <p> &copy; Desenvolvido por Weberson Costa </p>
    </footer>
    <script src="assets/js/main.js"></script>
</body>
</html>