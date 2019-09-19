<%--
  @Date: 06/09/2019 - 22:15
  @Author: nanoo
--%>
<%@page pageEncoding="UTF-8" %>
<%@include file="common/header.jsp" %>

<section class="container-fluid">
    <div id="center-box">
        <form:form id="login-form" action="/user/user-area" method="post" modelAttribute="account">
            <h1 class="text-center text-info">Je m'authentifie</h1>
            <div class="form-group">
                <label class="text-info">Adresse e-mail:</label><br>
                <form:input path="mail" type="email" cssClass="form-control"/>
                <c:if test="${!empty registration.errors}">
                    <span class="error">${registration.errors['mail']}</span>
                </c:if>
            </div>
            <div class="form-group">
                <label class="text-info">Mot de passe:</label><br>
                <form:input path="password" type="password" cssClass="form-control"/>
                <c:if test="${!empty registration.errors}">
                    <span class="error">${registration.errors['password']}</span>
                </c:if>
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
        </form:form>
    </div>
</section>

<%@include file="common/footer.jsp" %>
