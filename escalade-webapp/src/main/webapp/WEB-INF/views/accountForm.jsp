<%--
  @Date: 07/09/2019 - 17:18
  @Author: nanoo
--%>
<%@ page pageEncoding="UTF-8" %>
<%@include file="common/header.jsp" %>

<s:url value="/saveAccount" var="save"/>
<s:url value="/updateAccount/${account.id}" var="update"/>

<section class="container-fluid">
    <div id="register" class="form-box center-box">
        <form:form action="${empty account.id ? save : update}" method="post" modelAttribute="account">
            <div>
                <h1 class="text-center">
                    <c:choose>
                        <c:when test="${empty account.id}">Register</c:when>
                        <c:otherwise>Update du Compte</c:otherwise>
                    </c:choose>
                </h1>
            </div>
            <div>
                <c:if test="${empty message}"><br/></c:if>
                <h4 class="text-center error">${message}</h4>
            </div>
            <div class="select-style">
                <form:select path="title" autofocus="autofocus">
                    <form:option value="N/C" label="Civil"/>
                    <form:options items="${listTitle}"/>
                </form:select>
            </div>
            <div class="textbox">
                <em class="fas fa-user"></em>
                <form:input path="lastName" type="text" placeholder="Nom" required="true"/>
                <form:errors path="lastName" cssClass="error"/>
            </div>
            <div class="textbox">
                <em class="fas fa-user"></em>
                <form:input path="firstName" type="text" placeholder="Prénom" required="true"/>
                <form:errors path="firstName" cssClass="error"/>
            </div>
            <div class="textbox">
                <em class="fas fa-at"></em>
                <form:input path="mail" type="email" placeholder="Adresse mail" required="true"/>
                <form:errors path="mail" cssClass="error"/>
            </div>
            <div class="textbox">
                <em class="fas fa-lock"></em>
                <form:password path="password" placeholder="Mot de passe" required="true"/>
                <form:errors path="password" cssClass="error"/>
            </div>
            <div class="textbox">
                <em class="fas fa-lock"></em>
                <form:password path="confirmation" placeholder="Confirmez le mot de passe" required="true"/>
                <form:errors path="confirmation" cssClass="error"/>
            </div>
            <div class="textbox">
                <em class="fas fa-location-arrow"></em>
                <form:input path="streetName" type="text" placeholder="Adresse"/>
            </div>
            <div class="textbox">
                <em class="fas fa-map-marker"></em>
                <form:input path="postalCode" type="text" placeholder="Code postal"/>
                <form:errors path="postalCode" cssClass="error"/>
            </div>
            <div class="textbox">
                <em class="fas fa-map"></em>
                <form:input path="city" type="text" placeholder="Ville"/>
            </div>
            <div>
                <input type="submit" name="submit" class="btn-form text-center" value="Je m'inscris!">
            </div>
            <div>
                <a href="<c:out value="javascript:history.go(-1)"/>">
                    <input type="button" class="btn-form text-center" value="Annuler">
                </a>
            </div>
            <c:if test="${empty account.id}">
                <div class="text-right">
                    <a href="<c:url value="/login"/>" class="text-info-link">J'ai déjà un compte</a>
                </div>
            </c:if>
        </form:form>
    </div>
</section>

<%@include file="common/footer.jsp" %>