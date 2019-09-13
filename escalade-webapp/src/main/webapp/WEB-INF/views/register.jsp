<%--
  @Date: 07/09/2019 - 17:18
  @Author: nanoo
--%>
<%@ page pageEncoding="UTF-8" %>
<%@include file="common/header.jsp" %>

<div class="container-fluid">
    <div id="center-box" class="inner-div">
        <form:form id="login-form" class="form" action="/login" method="post" modelAttribute="account">
            <h2 class="text-center text-info">Je crée mon compte</h2>
            <div class="form-group">
                <h4 class="text-center text-info">${registration.result}</h4>
            </div>
            <div class="form-group">
                <form:select path="title" class="text-info">
                    <form:option value="Civil" label="Civil"/>
                    <form:options items="${listTitle}"/>
                </form:select>
            </div>
            <div class="form-group">
                <form:input path="lastName" type="text" cssClass="form-control" placeholder="Nom" required="true"/>
            </div>
            <div class="form-group">
                <form:input path="firstName" type="text" cssClass="form-control" placeholder="Prénom" required="true"/>
            </div>
            <div class="form-group">
                <form:input path="mail" type="email" cssClass="form-control" placeholder="Adresse mail" required="true"/>
                <span class="error">${registration.errors['mail']}</span>
            </div>
            <div class="form-group">
                <form:input path="password" type="password" cssClass="form-control" placeholder="Mot de passe"
                            required="true"/>
                <form:errors path="password" cssClass="error"/>
                <span class="error">${registration.errors['password']}</span>
            </div>
            <div class="form-group">
                <form:input path="confirmation" type="password" name="passwordConf" id="passwordConf" class="form-control"
                            placeholder="Confirmez le mot de passe" required="true"/>
            </div>
            <div class="form-group">
                <form:input path="streetName" type="text" name="streetName" id="streetName" class="form-control"
                            placeholder="Adresse"/>
            </div>
            <div class="row">
                <div class="col-md-6 form-group">
                    <form:input path="postalCode" type="text" name="postalCode" id="postalCode" class="form-control"
                                placeholder="Code postal"/>
                </div>
                <div class="col-md-6 form-group">
                    <form:input path="city" type="text" name="city" id="city" class="form-control" placeholder="Ville"/>
                </div>
            </div>
            <div class="form-group">
                <input type="submit" name="submit" class="btn btn-md btn-info" value="Je m'inscris!">
            </div>
            <div id="register-link" class="text-right">
                <a href="<c:url value="/login"/>" class="text-info">J'ai déjà un compte</a>
            </div>
        </form:form>
    </div>
</div>

<%@include file="common/footer.jsp" %>
