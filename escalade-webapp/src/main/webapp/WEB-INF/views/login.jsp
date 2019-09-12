<%--
  @Date: 06/09/2019 - 22:15
  @Author: nanoo
--%>
<%@ page pageEncoding="UTF-8" %>
<%@include file="common/header.jsp" %>

<div class="container-fluid background">
    <div id="login-box">
        <form id="login-form" class="form" action="/home" method="post">
            <h2 class="text-center text-info">Je m'authentifie</h2>
            <div class="form-group">
                <label for="mail" class="text-info">Adresse e-mail:</label><br>
                <input type="email" name="mail" id="mail" class="form-control">
                <span class="error">${registration.errors['mail']}</span>
            </div>
            <div class="form-group">
                <label for="password" class="text-info">Mot de passe:</label><br>
                <input type="password" name="password" id="password" class="form-control">
                <span class="error">${registration.errors['password']}</span>
            </div>
            <div class="form-group">
                <input type="submit" name="submit" class="btn btn-info btn-md" value="C'est parti!">
            </div>
            <div class="form-group text-left">
                <p class="text-info">${registration.result}</p>
            </div>
            <div id="register-link" class="text-right">
                <a href="<c:url value="/register"/>" class="text-info">Je crée un compte</a>
            </div>
        </form>
    </div>
</div>

<%@include file="common/footer.jsp" %>
