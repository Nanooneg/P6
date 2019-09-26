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
                <c:if test="${empty registration.result}"><br/></c:if>
                <h4 class="text-center text-info error">${registration.result}</h4>
            </div>
            <div class="form-group">
                <form:input path="mail" type="email" cssClass="form-control" placeholder="Adresse e-mail"/>
                <c:if test="${!empty registration.errors}">
                    <span class="error">${registration.errors['mail']}</span>
                </c:if>
            </div>
            <div class="form-group">
                <form:input path="password" type="password" cssClass="form-control" placeholder="Mot de passe"/>
                <c:if test="${!empty registration.errors}">
                    <span class="error">${registration.errors['password']}</span>
                </c:if>
            </div>
            <div class="form-group text-center">
                <input type="submit" name="submit" class="btn btn-info btn-lg" value="C'est parti!">
            </div>
            <div id="register-link" class="text-right">
                <a href="<c:url value="/register"/>" class="text-info">Je crée un compte</a>
            </div>
        </form:form>
    </div>
</section>

<%@include file="common/footer.jsp" %>
