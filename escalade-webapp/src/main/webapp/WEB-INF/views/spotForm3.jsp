<%--
  @Date: 24/09/2019 - 10:42
  @Author: nanoo
--%>
<%@ page pageEncoding="UTF-8" %>
<%@include file="common/header.jsp" %>

<section>
    <div id="spot-form-3" class="center-box form-box">
        <form:form action="/saveWay/${sectorId}/${way.id}" method="post" modelAttribute="way">
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
            <div class="textbox">
                <label>Nom de la voie :</label>
                <form:input path="name" placeholder="nom" required="true" autofocus="autofocus"/>
                <form:errors path="name" cssClass="error"/>
            </div>
            <label id="way-form">Cotations :</label>
            <div class="select-style">
                <form:select path="rating">
                    <form:option value="">*****</form:option>
                    <form:options items="${listRating}"/>
                </form:select>
                <form:errors path="rating" cssClass="error"/>
            </div>
            <div class="textbox">
                <label>Hauteur (en m) :</label>
                <form:input path="height" type="number" required="true"/>
            </div>
            <div class="textbox">
                <label>Nombre de longueur :</label>
                <form:input path="pitchNbr" type="number" required="true"/>
            </div>
            <div class="textbox">
                <label>nombre de point d'ancrage :</label>
                <form:input path="anchorNbr" type="number" required="true"/>
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

<%@include file="common/footer.jsp" %>