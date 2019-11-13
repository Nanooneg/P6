<%--
  @Date: 05/10/2019 - 12:27
  @Author: nanoo
--%>
<%@ page pageEncoding="UTF-8" %>
<%@include file="../common/header.jsp" %>

<div id="commentary-form" class="login-dark">
    <form:form action="/user/saveComment/${publicationType}/${publicationId}/${commentaryId}" method="post"
               modelAttribute="commentary" cssClass="background-custom">
        <div>
            <h2 class="text-center">
                <c:choose>
                    <c:when test="${empty commentary.id}">Ajouter un commentaire</c:when>
                    <c:otherwise>Modifier un commentaire</c:otherwise>
                </c:choose>
            </h2>
        </div>
        <div>
            <c:if test="${empty message}"><br/></c:if>
            <h4 class="text-center error">${message}</h4>
        </div>
        <div class="form-group">
            <form:input path="title" placeholder="Titre" required="true" maxlength="30" autofocus="autofocus" cssClass="form-control"/>
            <form:errors path="title" cssClass="error"/>
        </div>
        <div class="form-group">
            <form:textarea path="text" placeholder="Commentaire" required="true"
                           rows="5" cols="35" maxlength="300" cssClass="form-control"/>
            <form:errors path="text" cssClass="error"/>
        </div>
        <div class="form-group">
            <button type="submit" class="btn btn-primary btn-block">Enregistrer</button>
            <a href="<c:out value="javascript:history.go(-1)"/>">
                <button type="button" class="btn btn-primary btn-block">Annuler</button>
            </a>
        </div>
    </form:form>
</div>

<%@include file="../common/footer.jsp" %>