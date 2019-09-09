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

<div class="container-fluid background">
    <div id="login-box" >
        <form id="login-form" class="form" action="home" method="post">
            <h2 class="text-center text-info">Je crée mon compte</h2>
            <div class="form-group">
                <%--<label for="title" class="text-info">Civilité:</label><br>--%>
                <select id="title" name="title" class="text-info">
                    <option>Civilité</option>
                    <c:forEach items="${listTitle}" var="title">
                        <option>${title}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="form-group">
                <%--<label for="lastName" class="text-info">Nom:</label><br>--%>
                <input type="text" name="lastName" id="lastName" class="form-control" placeholder="Nom">
            </div>
            <div class="form-group">
                <%--<label for="firstName" class="text-info">Prenom:</label><br>--%>
                <input type="text" name="firstName" id="firstName" class="form-control" placeholder="Prénom">
            </div>
            <div class="form-group">
                <%--<label for="mail" class="text-info">Mail:</label><br>--%>
                <input type="email" name="mail" id="mail" class="form-control" placeholder="Adresse mail">
            </div>
            <div class="form-group">
                <%--<label for="streetName" class="text-info">Adresse:</label><br>--%>
                <input type="text" name="streetName" id="streetName" class="form-control" placeholder="Adresse">
            </div>
            <div>
                <div class="col-md-6 form-group">
                    <%--<label for="postalCode" class="text-info">Code postal:</label><br>--%>
                    <input type="text" name="postalCode" id="postalCode" class="form-control" placeholder="Code postal">
                </div>
                <div class="col-md-6 form-group">
                    <%--<label for="city" class="text-info">Ville:</label><br>--%>
                    <input type="text" name="city" id="city" class="form-control" placeholder="Ville">
                </div>
            </div>
            <div class="form-group">
                <%--<label for="username" class="text-info">Pseudo:</label><br>--%>
                <input type="text" name="username" id="username" class="form-control" placeholder="Pseudonyme">
            </div>
            <div class="form-group">
                <%--<label for="password" class="text-info">Mot de passe:</label><br>--%>
                <input type="password" name="password" id="password" class="form-control" placeholder="Mot de passe">
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
