<%--
  @Date: 05/10/2019 - 12:27
  @Author: nanoo
--%>
<%@ page pageEncoding="UTF-8" %>
<%@include file="../common/OLDheader.jsp" %>

<section>
    <div id="commentary-form" class="center-box form-box">
        <form:form action="/saveComment/${publicationType}/${publicationId}/${commentaryId}" method="post" modelAttribute="commentary">
            <div>
                <h1 class="text-center">
                    <c:choose>
                        <c:when test="${empty commentary.id}">Ajouter un commentaire</c:when>
                        <c:otherwise>Modifier un commentaire</c:otherwise>
                    </c:choose>
                </h1>
            </div>
            <div>
                <c:if test="${empty message}"><br/></c:if>
                <h4 class="text-center error">${message}</h4>
            </div>
            <div class="textbox">
                <form:input path="title" placeholder="Titre" required="true" maxlength="30" autofocus="autofocus"/>
                <form:errors path="title" cssClass="error"/>
            </div>
            <div class="textbox">
                <form:textarea path="text" placeholder="Commentaire" required="true"
                               rows="5" cols="35" maxlength="300"/>
                <form:errors path="text" cssClass="error"/>
            </div>
            <div>
                <input type="submit" name="submit" class="btn-form text-center" value="Enregistrer">
            </div>
            <div>
                <a href="<c:out value="javascript:history.go(-1)"/>">
                    <input type="button" class="btn-form text-center" value="Annuler">
                </a>
            </div>
        </form:form>
    </div>
</section>

<%@include file="../common/footer.jsp" %>