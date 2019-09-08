<%--
  @Date: 06/09/2019 - 22:15
  @Author: nanoo
--%>
<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>

    <title>Je m'authentifie</title>

    <%-- css --%>
    <link rel="stylesheet" href="/resources/css/bootstrap.min.css">
    <link rel="stylesheet" href="/resources/css/style.css">
</head>
<body>
<jsp:include page="common/header.jsp">
<div class="container-fluid blue">
    <div id="login-box" >
        <form id="login-form" class="form" action="" method="post">
            <h3 class="text-center text-info">Je m'authentifie</h3>
            <div class="form-group">
                <label for="username" class="text-info">Pseudo:</label><br>
                <input type="text" name="username" id="username" class="form-control">
            </div>
            <div class="form-group">
                <label for="password" class="text-info">Mot de passe:</label><br>
                <input type="text" name="password" id="password" class="form-control">
            </div>
            <div class="form-group">
                <input type="submit" name="submit" class="btn btn-info btn-md" value="C'est parti!">
            </div>
            <div id="register-link" class="text-right">
                <a href="<c:url value="/register"/>" class="text-info">Je crée un compte</a>
            </div>
        </form>
    </div>
</div>
</body>
</html>
