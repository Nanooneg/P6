<%--
  @Date: 24/09/2019 - 00:16
  @Author: nanoo
--%>
<%@ page pageEncoding="UTF-8" %>
<%@include file="../common/header.jsp" %>

<div id="spot-form-1" class="login-dark">
    <form:form action="/saveSite/${site.id}" cssClass="background-custom" method="post" modelAttribute="site" enctype="multipart/form-data">
        <h2 class="text-center">
            <c:choose>
                <c:when test="${empty site.id}">Création de Site</c:when>
                <c:otherwise>Modification du Site</c:otherwise>
            </c:choose>
        </h2>
        <div>
            <c:if test="${empty saveSpot.result}"><br/></c:if>
            <h4 class="text-center error">${saveSpot.result}</h4>
        </div>
        <c:if test="${sessionScope.accountSession.roleName == 'Member' || sessionScope.accountSession.roleName == 'Administrator'}">
            <div class="form-group">
                <form:checkbox path="officialLabel" cssClass="form-box"/>
                <label>Label officiel</label>
            </div>
        </c:if>
        <div class="form-group select-style">
            <form:select path="region" autofocus="autofocus" cssClass="form-control">
                <form:option value="Région"/>
                <form:options items="${listRegion}"/>
            </form:select>
            <form:errors path="region" cssClass="error"/>
        </div>
        <div class="form-group">
            <form:input path="name" placeholder="nom" required="true" cssClass="form-control"/>
            <form:errors path="name" cssClass="error"/>
        </div>
        <div class="form-group">
            <form:textarea path="description" placeholder="description" required="true"
                           rows="5" cols="35" maxlength="300" cssClass="form-control"/>
            <form:errors path="description" cssClass="error"/>
        </div>
        <div class="form-group">
            <form:input path="picture" type="file" cssClass="form-control"/>
            <form:errors path="picture" cssClass="error"/>
        </div>
        <div class="form-group">
            <button type="submit" name="submit" class="btn btn-primary btn-block">Enregistrer</button>
            <a href="<c:out value="javascript:history.go(-1)"/>">
                <button type="button" class="btn btn-primary btn-block">Annuler</button>
            </a>
        </div>
    </form:form>
</div>

<%@include file="../common/footer.jsp" %>