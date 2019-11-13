<%--
  @Date: 16/10/2019 - 11:23
  @Author: nanoo
--%>
<%@ page pageEncoding="UTF-8" %>
<%@include file="common/header.jsp" %>

<div class="container-fluid">
    <div id="message-box" class="publication-dark background-custom">
        <div>
            <h1 class="text-center">Demande de prêt</h1>
        </div>
        <div class="message">
            <div class="message-header">
                <h2>Au sujet du topo "${topo.name}"</h2>
            </div>
            <div class="message-text">
                <p>Vous êtes sur le point de demander que l'on vous prête ce topo. Notre association se
                   contente de mettre en relation les utilisateurs. Si le propriétaire accepte, nous vous communiquerons ses
                   coordonnées pour que vous le contactiez directement.</p>
                <p>Vous pourrez voir l'avancée de votre demande dans votre espace personnel.</p>
            </div>
        </div>
        <c:if test="${!empty message}">
            <div>
                <p class="error">${message}</p>
            </div>
        </c:if>
        <div class="form-group row message-button">
            <div class="col-md-2 offset-md-4 col-sm-12">
                <a href="<c:url value="/user/validAskForLending/${sessionScope.accountSession.id}/${topo.id}"/>">
                    <button type="button" class="btn btn-primary btn-block">Oui, j'ai compris</button></a>
            </div>
            <div class="col-md-2 col-sm-12">
                <a href="<c:url value="/topo/${topo.id}"/>">
                    <button type="button" class="btn btn-primary btn-block">Non, merci</button></a>
            </div>
        </div>
    </div>
</div>

<%@include file="common/footer.jsp" %>
