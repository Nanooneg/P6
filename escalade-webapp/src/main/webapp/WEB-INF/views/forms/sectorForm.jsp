<%--
  @Date: 24/09/2019 - 10:41
  @Author: nanoo
--%>
<%@ page pageEncoding="UTF-8" %>
<%@include file="../common/header.jsp" %>

<section>
    <div id="spot-form-2" class="login-dark">
        <form:form action="/saveSector/${siteId}/${sector.id}" method="post" modelAttribute="sector" cssClass="background-custom">
            <h1 class="text-center">
                <c:choose>
                    <c:when test="${empty sector.id}">Création de Secteur</c:when>
                    <c:otherwise>Modification du Secteur</c:otherwise>
                </c:choose>
            </h1>
            <div>
                <c:if test="${empty saveSpot.result}"><br/></c:if>
                <h4 class="text-center error">${saveSpot.result}</h4>
            </div>
            <div class="form-group">
                <form:input path="name" placeholder="nom" required="true" autofocus="autofocus" cssClass="form-control"/>
                <form:errors path="name" cssClass="error"/>
            </div>
            <div class="form-group">
                <form:textarea path="description" placeholder="description" required="true"
                               rows="5" cols="35" maxlength="300" cssClass="form-control"/>
                <form:errors path="description" cssClass="error"/>
            </div>
            <div class="form-group">
                <button type="submit" name="submit" class="btn btn-primary btn-block">Enregistrer</button>
                <a href="<c:out value="javascript:history.go(-1)"/>">
                    <button type="button" class="btn btn-primary btn-block">Annuler</button>
                </a>
            </div>
        </form:form>
    </div>
</section>

<%@include file="../common/footer.jsp" %>