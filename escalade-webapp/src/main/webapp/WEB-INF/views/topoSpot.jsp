<%--
  @Date: 23/09/2019 - 12:08
  @Author: nanoo
--%>
<%@ page pageEncoding="UTF-8" %>
<%@include file="common/header.jsp" %>

<section class="container-fluid">
    <div id="search-box" class="form-box top-box">
        <form:form action="/topoSpot" method="post" modelAttribute="searchAttribut">
        <div>
            <h1 class="text-center">Topo de grimpe</h1>
        </div>
            <div>
                <c:if test="${empty message}"><br/></c:if>
                <h4 class="text-center ${empty listTopo ? 'error' : 'success'}">${message}</h4>
            </div>
        <div class="row">
            <div class="col-md-2 text-center">
                <div class="col-md-12">
                    <label>Ajouter des filtres :</label>
                </div>
                <div class="col-md-12">
                    <form:checkbox path="lendable" value="true" cssClass="checkbox-boolean"/>
                    <label>Disponible</label>
                </div>
            </div>
            <div class="col-md-10">
                <div class="col-md-4 select-style-md">
                    <label for="region">Région :</label>
                    <form:select path="region" id="region">
                        <form:option value="all">*****</form:option>
                        <form:options items="${listRegion}"/>
                    </form:select>
                </div>
                <div class="col-md-4 select-style-md">
                    <label for="publication">Date de parution :</label>
                    <form:select path="publication" id="publication">
                        <form:option value="all">*****</form:option>
                        <form:option value="HY">moins de 6 mois</form:option>
                        <form:option value="1Y">moins de 1 an</form:option>
                        <form:option value="2Y">moins de 2 ans</form:option>
                        <form:option value="5Y">moins de 5 ans</form:option>
                        <form:option value="10Y">moins de 10 ans</form:option>
                    </form:select>
                </div>
                <%--<div class="col-md-4 select-style-md">
                    <label>Cotation de voie:</label>
                    <form:select path="rating">
                        <form:option value="all">*****</form:option>
                        <form:options items="${listRating}"/>
                    </form:select>
                </div>--%>
            </div>
        </div>
        <br/>
        <div class="button-search-bar">
            <div class="pull-left">
                <input type="submit" class="btn-search text-center" value="Rechercher"/>
                <a href="<c:url value="/topoSpot"/>"><input type="button" class="btn-search text-center" value="Afficher tout"/></a>
            </div>
            <div class="pull-right">
                <em class="fas fa-plus-circle"></em>
                <a href="<c:url value="/topoForm"/>" class="text-info-link">Ajouter un topo</a>
            </div>
        </div>
        </form:form>
    </div>
</section>

<section class="container-fluid">
    <c:forEach items="${listTopo}" var="topo">
        <a href="<c:url value="/topo/${topo.id}"/>" class="title-link">
        <div class="display-box">
            <div class="row">
                <div class="col-md-2 image-small">
                    <c:choose>
                        <c:when test="${topo.picturePath != null}">
                            <img src="<c:url value="${topo.picturePath}"/>" alt="photo du topo">
                        </c:when>
                        <c:otherwise>
                            <img src="<c:url value="/resources/pictures/no-picture.jpg"/>" alt="pas d'image disponible">
                        </c:otherwise>
                    </c:choose>
                </div>
                <div class="col-md-10 contain-link">
                    <div class="title-link">
                        <p class="title">
                            ${topo.name} - ${topo.region}
                            <span>
                                <c:choose>
                                    <c:when test="${topo.lendable}">
                                        <img id="lendable-icon-result" src="<c:url value="/resources/pictures/label-lendable-green.png"/>" alt="lendable"/>
                                    </c:when>
                                    <c:when test="${!topo.lendable}">
                                        <img id="lendable-icon-result" src="<c:url value="/resources/pictures/label-lendable-red.png"/>" alt="lendable"/>
                                    </c:when>
                                </c:choose>
                            </span>
                        </p>
                    </div>
                    <div>
                        <p class="display-description">${topo.description}</p>
                    </div>
                </div>
            </div>
        </div>
        </a>
    </c:forEach>
</section>

<%@include file="common/footer.jsp" %>