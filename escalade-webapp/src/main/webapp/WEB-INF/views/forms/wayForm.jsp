<%--
  @Date: 24/09/2019 - 10:42
  @Author: nanoo
--%>
<%@ page pageEncoding="UTF-8" %>
<%@include file="../common/header.jsp" %>

<section>
    <div id="spot-form-3" class="login-dark">
        <form:form action="/saveWay/${sectorId}/${way.id}" method="post" modelAttribute="way" cssClass="background-custom">
            <h1 class="text-center">
                <c:choose>
                    <c:when test="${empty way.id}">Création de Voie</c:when>
                    <c:otherwise>Modification de la Voie</c:otherwise>
                </c:choose>
            </h1>
            <div>
                <c:if test="${empty saveSpot.result}"><br/></c:if>
                <h4 class="text-center error">${saveSpot.result}</h4>
            </div>
            <div class="form-group">
                <form:input path="name" placeholder="Nom" required="true" autofocus="autofocus" cssClass="form-control"/>
                <form:errors path="name" cssClass="error"/>
            </div>
            <div class="form-group select-style">
                <form:select path="rating" cssClass="form-control">
                    <form:option value="">Cotations</form:option>
                    <form:options items="${listRating}"/>
                </form:select>
                <form:errors path="rating" cssClass="error"/>
            </div>
            <div class="form-group">
                <label>Hauteur (en m) :</label>
                <form:input path="height" type="number" required="true" cssClass="form-control"/>
            </div>
            <div class="form-group">
                <label>Nombre de longueur :</label>
                <form:input path="pitchNbr" type="number" required="true" cssClass="form-control"/>
            </div>
            <div class="form-group">
                <label>Point d'ancrage :</label>
                <form:input path="anchorNbr" type="number" required="true" cssClass="form-control"/>
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