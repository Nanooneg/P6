<%--
  @Date: 24/09/2019 - 00:16
  @Author: nanoo
--%>
<%@ page pageEncoding="UTF-8" %>
<%@include file="../common/OLDheader.jsp" %>

<section>
    <div id="topo-form" class="center-box form-box">
        <form:form action="/saveTopo/${topo.id}" method="post" modelAttribute="topo" enctype="multipart/form-data">
            <div>
                <h1 class="text-center">
                    <c:choose>
                        <c:when test="${empty topo.id}">Création de Topo</c:when>
                        <c:otherwise>Modification du Topo</c:otherwise>
                    </c:choose>
                </h1>
            </div>
            <div>
                <c:if test="${empty saveTopo.result}"><br/></c:if>
                <h4 class="text-center error">${saveTopo.result}</h4>
            </div>
            <div class="textbox">
                <form:input path="name" placeholder="nom" required="true" autofocus="autofocus"/>
                <form:errors path="name" cssClass="error"/>
            </div>
            <div class="textbox">
                <form:textarea path="description" placeholder="description" required="true"
                               rows="3" cols="35" maxlength="300"/>
                <form:errors path="description" cssClass="error"/>
            </div>
            <div class="select-style">
                <form:select path="region">
                    <form:option value="Région"/>
                    <form:options items="${listRegion}"/>
                </form:select>
                <form:errors path="region" cssClass="error"/>
            </div>
            <div class="select-style">
                <form:select path="condition">
                    <form:option value="Etat général"/>
                    <form:options items="${listCondition}"/>
                </form:select>
                <form:errors path="condition" cssClass="error"/>
            </div>
            <div class="textbox">
                <label for="publication">Date de parution</label>
                <form:input path="dateOfPublication" type="date" id="publication"/>
                <form:errors path="dateOfPublication" cssClass="error"/>
            </div>
            <div class="lendablebox">
                <form:checkbox path="lendable" value="true" cssClass="checkbox-boolean"/>
                <label>Disponible pour être prêté</label>
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