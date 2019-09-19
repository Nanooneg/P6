<%--
  @Date: 07/09/2019 - 17:18
  @Author: nanoo
--%>
<%@ page pageEncoding="UTF-8" %>
<%@include file="common/header.jsp" %>

<section class="container-fluid">
    <div id="center-box">
        <form:form id="login-form" action="/login" method="post" modelAttribute="account">
            <h1 class="text-center text-info">Je crée mon compte</h1>
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
                <form:input path="lastName" type="text" cssClass="form-control" placeholder="Nom"/>
                <form:errors path="lastName" cssClass="error" required="true"/>
            </div>
            <div class="form-group">
                <form:input path="firstName" type="text" cssClass="form-control" placeholder="Prénom"/>
                <form:errors path="firstName" cssClass="error" required="true"/>
            </div>
            <div class="form-group">
                <form:input path="mail" type="email" cssClass="form-control" placeholder="Adresse mail"/>
                <form:errors path="mail" cssClass="error" required="true"/>
            </div>
            <div class="form-group">
                <form:password path="password" cssClass="form-control" placeholder="Mot de passe" required="true"
                               id="password" name="password" />
                <form:errors path="password" cssClass="error"/>
            </div>
            <div class="form-group">
                <form:password path="confirmation" cssClass="form-control" placeholder="Confirmez le mot de passe" required="true"/>
                <form:errors path="confirmation" cssClass="error" required="true"/>
            </div>
            <div class="form-group">
                <form:input path="streetName" type="text" cssClass="form-control" placeholder="Adresse"/>
            </div>
            <div class="row">
                <div class="col-md-6 form-group">
                    <form:input path="postalCode" type="text" cssClass="form-control" placeholder="Code postal"/>
                    <form:errors path="postalCode" cssClass="error" />
                </div>
                <div class="col-md-6 form-group">
                    <form:input path="city" type="text" cssClass="form-control"
                                placeholder="Ville"/>
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
</section>

<%@include file="common/footer.jsp" %>
