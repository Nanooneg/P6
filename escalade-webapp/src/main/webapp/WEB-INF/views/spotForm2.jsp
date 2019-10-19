<%--
  @Date: 24/09/2019 - 10:41
  @Author: nanoo
--%>
<%@ page pageEncoding="UTF-8" %>
<%@include file="common/header.jsp" %>

<section>
    <div id="spot-form-2" class="center-box form-box">
        <form:form action="/saveSector/${siteId}/${sector.id}" method="post" modelAttribute="sector">
            <h1 class="text-center">
                <c:choose>
                    <c:when test="${empty sector.id}">Création de Secteur</c:when>
                    <c:otherwise>Update du Secteur</c:otherwise>
                </c:choose>
            </h1>
            <div>
                <c:if test="${empty saveSpot.result}"><br/></c:if>
                <h4 class="text-center error">${saveSpot.result}</h4>
            </div>
            <div class="textbox">
                <form:input path="name" placeholder="nom" required="true"/>
                <form:errors path="name" cssClass="error"/>
            </div>
            <div class="textbox">
                <form:textarea path="description" placeholder="description" required="true"
                               rows="5" cols="35" maxlength="300"/>
                <form:errors path="description" cssClass="error"/>
            </div>
            <div>
                <input type="submit" name="submit" class="btn-form text-center" value="Enregistrer">
            </div>
        </form:form>
    </div>
</section>

<%@include file="common/footer.jsp" %>