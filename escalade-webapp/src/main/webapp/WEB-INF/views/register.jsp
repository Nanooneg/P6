<%--
  @Date: 07/09/2019 - 17:18
  @Author: nanoo
--%>
<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>

    <title>Je crée mon compte</title>

    <%-- css --%>
    <link rel="stylesheet" href="/resources/css/bootstrap.min.css">
    <link rel="stylesheet" href="/resources/css/style.css">
</head>
<body>

<%@include file="common/header.jsp" %>
<%--TODO get display for errors returned after form validation--%>
<div class="container-fluid background">
    <div id="login-box">
        <form id="login-form" class="form" action="/login" method="post">
            <h2 class="text-center text-info">Je crée mon compte</h2>
            <div class="form-group">
                <h4 class="text-center text-info">${result}</h4>
            </div>
            <div class="form-group">
                <select id="title" name="title" class="text-info">
                    <option>Civilité</option>
                    <c:forEach items="${listTitle}" var="title">
                        <option>${title}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="form-group">
                <input type="text" name="lastName" id="lastName" class="form-control" placeholder="Nom">
            </div>
            <div class="form-group">
                <input type="text" name="firstName" id="firstName" class="form-control" placeholder="Prénom">
            </div>
            <div class="form-group">
                <input type="email" name="mail" id="mail" class="form-control" placeholder="Adresse mail">
                <span class="error">${registration.errors['mail']}</span>
            </div>
            <div class="form-group">
                <input type="password" name="password" id="password" class="form-control" placeholder="Mot de passe">
                <span class="error">${registration.errors['password']}</span>
            </div>
            <div class="form-group">
                <input type="password" name="passwordConf" id="passwordConf" class="form-control"
                       placeholder="Confirmez le mot de passe">
            </div>
            <div class="form-group">
                <input type="text" name="streetName" id="streetName" class="form-control" placeholder="Adresse">
            </div>
            <div>
                <div class="col-md-6 form-group">
                    <input type="text" name="postalCode" id="postalCode" class="form-control" placeholder="Code postal">
                </div>
                <div class="col-md-6 form-group">
                    <input type="text" name="city" id="city" class="form-control" placeholder="Ville">
                </div>
            </div>
            <div class="form-group">
                <input type="submit" name="submit" class="btn btn-md btn-info" value="Je m'inscris!">
            </div>
            <div id="register-link" class="text-right">
                <a href="<c:url value="/login"/>" class="text-info">J'ai déjà un compte</a>
            </div>
        </form>
    </div>
</div>

<%@include file="common/footer.jsp" %>

</body>
</html>
