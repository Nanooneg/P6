<%--
  @Date: 24/09/2019 - 00:16
  @Author: nanoo
--%>
<%@ page pageEncoding="UTF-8" %>
<%@include file="../common/OLDheader.jsp" %>

<section>
    <div id="spot-form-1" class="center-box form-box">
        <form:form action="/saveSite/${site.id}" method="post" modelAttribute="site" enctype="multipart/form-data">
            <h1 class="text-center">
                <c:choose>
                    <c:when test="${empty site.id}">Création de Site</c:when>
                    <c:otherwise>Modification du Site</c:otherwise>
                </c:choose>
            </h1>
            <div>
                <c:if test="${empty saveSpot.result}"><br/></c:if>
                <h4 class="text-center error">${saveSpot.result}</h4>
            </div>
            <c:if test="${sessionScope.accountSession.roleName == 'Member' || sessionScope.accountSession.roleName == 'Administrator'}">
                <div class="labelbox">
                    <form:checkbox path="officialLabel" value="true" cssClass="checkbox-boolean"/>
                    <label>Label officiel</label>
                </div>
            </c:if>
            <div class="select-style">
                <form:select path="region" autofocus="autofocus">
                    <form:option value="Région"/>
                    <form:options items="${listRegion}"/>
                </form:select>
                <form:errors path="region" cssClass="error"/>
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
            <div class="textbox">
                <form:input path="picture" type="file"/>
                <form:errors path="picture" cssClass="error"/>
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