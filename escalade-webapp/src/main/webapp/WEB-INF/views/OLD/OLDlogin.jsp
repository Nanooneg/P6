<%--
  @Date: 06/09/2019 - 22:15
  @Author: nanoo
--%>
<%@page pageEncoding="UTF-8" %>
<%@include file="../common/OLDheader.jsp" %>

<section class="container-fluid">
    <div id="login" class="form-box center-box">
        <form:form action="/user/user-area" method="post" modelAttribute="account">
            <div>
                <h1 class="text-center">Connexion</h1>
            </div>
            <div>
                <c:if test="${empty registration.result}"><br/></c:if>
                <h4 class="text-center ${empty registration.errors ? 'success' : 'error'}">${registration.result}</h4>
            </div>
            <div class="textbox">
                <em class="fas fa-at"></em>
                <form:input path="mail" type="email" placeholder="Adresse e-mail" autofocus="autofocus"/>
                <c:if test="${!empty registration.errors['mail']}">
                    <span class="error">${registration.errors['mail']}</span>
                </c:if>
            </div>
            <div class="textbox">
                <em class="fas fa-lock"></em>
                <form:input path="password" type="password" placeholder="Mot de passe"/>
                <c:if test="${!empty registration.errors['password']}">
                    <span class="error">${registration.errors['password']}</span>
                </c:if>
            </div>
            <div>
                <input type="submit" name="submit" class="btn-form text-center" value="C'est parti!">
            </div>
            <div>
                <a href="<c:out value="javascript:history.go(-1)"/>">
                    <input type="button" class="btn-form text-center" value="Annuler">
                </a>
            </div>
            <div class="text-right">
                <a href="<c:url value="/register"/>" class="text-info-link">Je crée un compte</a>
            </div>
        </form:form>
    </div>
</section>

<%@include file="../common/footer.jsp" %>
