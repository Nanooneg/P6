<%--
  @Date: 06/09/2019 - 22:15
  @Author: nanoo
--%>
<%@page pageEncoding="UTF-8" %>
<%@include file="common/header.jsp" %>

<div id="login-form" class="login-dark">
    <form:form action="/user/user-area/${wantedUrI}" class="background-custom" method="post" modelAttribute="account">
        <div>
            <h2 class="text-center">Connexion</h2>
        </div>
        <div>
            <c:if test="${empty registration.result}"><br/></c:if>
            <h4 class="text-center ${empty registration.errors ? 'success' : 'error'}">${registration.result}</h4>
        </div>
        <div class="illustration"><em class="fas fa-lock"></em></div>
        <div class="form-group">
            <form:input path="mail" class="form-control" type="email" name="email" placeholder="Email"/>
            <c:if test="${!empty registration.errors['mail']}">
                <span class="error">${registration.errors['mail']}</span>
            </c:if>
        </div>
        <div class="form-group">
            <form:input path="password" class="form-control" type="password" name="password"
                        placeholder="Mot de passe"/>
            <c:if test="${!empty registration.errors['password']}">
                <span class="error">${registration.errors['password']}</span>
            </c:if>
        </div>
        <div class="form-group">
            <button class="btn btn-primary btn-block" type="submit">Connexion</button>
            <a href="<c:out value="javascript:history.go(-1)"/>">
                <button class="btn btn-primary btn-block" type="submit">Annuler</button>
            </a>
        </div>
        <div>
            <a href="<c:url value="/register"/>" class="forgot">Je n'ai pas de compte</a>
        </div>
    </form:form>
</div>

<%@include file="common/footer.jsp" %>
