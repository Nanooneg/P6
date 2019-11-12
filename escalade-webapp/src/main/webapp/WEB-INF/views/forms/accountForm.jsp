<%--
  @Date: 07/09/2019 - 17:18
  @Author: nanoo
--%>
<%@ page pageEncoding="UTF-8" %>
<%@include file="../common/header.jsp" %>

<s:url value="/user/saveAccount" var="save"/>
<s:url value="/user/updateAccount/${account.id}" var="update"/>

<div id="account-form" class="login-dark">
    <form:form action="${empty account.id ? save : update}" class="background-custom" method="post" modelAttribute="account">
        <div>
            <h2 class="text-center">
                <c:choose>
                    <c:when test="${empty account.id}">Créer un compte</c:when>
                    <c:otherwise>Modifier mon Compte</c:otherwise>
                </c:choose>
            </h2>
        </div>
        <div>
            <c:if test="${empty message}"><br/></c:if>
            <h4 class="text-center error">${message}</h4>
        </div>
        <div class="form-group select-style">
            <form:select path="title" autofocus="autofocus" cssClass="form-control">
                <form:option value="N/C" label="Civilité" cssClass="title"/>
                <form:options items="${listTitle}"/>
            </form:select>
        </div>
        <div class="form-group">
            <form:input path="lastName" cssClass="form-control" type="text" placeholder="Nom" required="true"/>
            <form:errors path="lastName" cssClass="error"/>
        </div>
        <div class="form-group">
            <form:input path="firstName" cssClass="form-control" type="text" placeholder="Prénom" required="true"/>
            <form:errors path="firstName" cssClass="error"/>
        </div>
        <div class="form-group">
            <form:input path="mail" cssClass="form-control" type="email" placeholder="Adresse mail" required="true"/>
            <form:errors path="mail" cssClass="error"/>
        </div>
        <div class="form-group">
            <form:password path="password" cssClass="form-control" placeholder="Mot de passe" required="true"/>
            <form:errors path="password" cssClass="error"/>
        </div>
        <div class="form-group">
            <form:password path="confirmation" cssClass="form-control" placeholder="Confirmez le mot de passe" required="true"/>
            <form:errors path="confirmation" cssClass="error"/>
        </div>
        <div class="form-group">
            <form:input path="streetName" cssClass="form-control" type="text" placeholder="Adresse"/>
        </div>
        <div class="form-group">
            <form:input path="postalCode" cssClass="form-control" type="text" placeholder="Code postal"/>
            <form:errors path="postalCode" cssClass="error"/>
        </div>
        <div class="form-group">
            <form:input path="city" cssClass="form-control" type="text" placeholder="Ville"/>
        </div>
        <div class="form-group">
            <c:choose>
                <c:when test="${empty account.id}">
                    <button type="submit" class="btn btn-primary btn-block">Je m'inscris!</button>
                    <a href="<c:out value="javascript:history.go(-1)"/>">
                        <button type="button" class="btn btn-primary btn-block">Annuler</button>
                    </a>
                </c:when>
                <c:otherwise>
                    <button type="submit" class="btn btn-primary btn-block">J'enregistre</button>
                    <a href="<c:out value="/user/user-area"/>">
                        <button type="button" class="btn btn-primary btn-block">Annuler</button>
                    </a>
                </c:otherwise>
            </c:choose>
        </div>
        <c:if test="${empty account.id}">
            <div>
                <a href="<c:url value="/login"/>" class="forgot">J'ai déjà un compte</a>
            </div>
        </c:if>
    </form:form>
</div>

<%@include file="../common/footer.jsp" %>