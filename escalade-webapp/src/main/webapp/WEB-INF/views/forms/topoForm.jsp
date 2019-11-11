<%--
  @Date: 24/09/2019 - 00:16
  @Author: nanoo
--%>
<%@ page pageEncoding="UTF-8" %>
<%@include file="../common/header.jsp" %>

<div id="topo-form" class="login-dark">
    <form:form action="/saveTopo/${topo.id}" method="post" modelAttribute="topo" enctype="multipart/form-data" cssClass="background-custom">
        <h2 class="text-center">
            <c:choose>
                <c:when test="${empty topo.id}">Création de Topo</c:when>
                <c:otherwise>Modification du Topo</c:otherwise>
            </c:choose>
        </h2>
        <div>
            <c:if test="${empty saveTopo.result}"><br/></c:if>
            <h4 class="text-center error">${saveTopo.result}</h4>
        </div>
        <div class="form-group">
            <form:input path="name" placeholder="nom" required="true" autofocus="autofocus" cssClass="form-control"/>
            <form:errors path="name" cssClass="error"/>
        </div>
        <div class="form-group">
            <form:textarea path="description" placeholder="description" required="true"
                           rows="3" cols="35" maxlength="300" cssClass="form-control"/>
            <form:errors path="description" cssClass="error"/>
        </div>
        <div class="form-group select-style">
            <form:select path="region" cssClass="form-control">
                <form:option value="Région"/>
                <form:options items="${listRegion}"/>
            </form:select>
            <form:errors path="region" cssClass="error"/>
        </div>
        <div class="form-group select-style">
            <form:select path="condition" cssClass="form-control">
                <form:option value="Etat général"/>
                <form:options items="${listCondition}"/>
            </form:select>
            <form:errors path="condition" cssClass="error"/>
        </div>
        <div class="form-group">
            <label for="publication">Date de parution</label>
            <form:input path="dateOfPublication" type="date" id="publication" cssClass="form-control"/>
            <form:errors path="dateOfPublication" cssClass="error"/>
        </div>
        <div class="form-group">
            <form:checkbox path="lendable" value="true" cssClass="form-box"/>
            <label>Disponible pour être prêté</label>
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