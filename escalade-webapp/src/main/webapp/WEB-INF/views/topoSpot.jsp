<%--
  @Date: 23/09/2019 - 12:08
  @Author: nanoo
--%>
<%@ page pageEncoding="UTF-8" %>
<%@include file="common/header.jsp" %>

<div class="container-fluid">
    <div id="topo-search" class="search-dark">
        <form:form action="/topoSpot" method="post" modelAttribute="searchAttribut" cssClass="background-custom">
        <div class="intro">
            <h2 class="text-center">Topo de grimpe</h2>
        </div>
        <div>
            <c:if test="${empty message}"><br/></c:if>
            <h4 class="text-center ${empty listTopo ? 'error' : 'success'}">${message}</h4>
        </div>
        <div class="row">
            <div class="col-sm-12 col-md-6 select-style-md form-group">
                <label for="region">Région :</label>
                <form:select path="region" id="region" cssClass="form-control">
                    <form:option value="all">*****</form:option>
                    <form:options items="${listRegion}"/>
                </form:select>
            </div>
            <div class="col-sm-12 col-md-6 select-style-md form-group">
                <label for="publication">Date de parution :</label>
                <form:select path="publication" id="publication" cssClass="form-control">
                    <form:option value="all">*****</form:option>
                    <form:option value="HY">moins de 6 mois</form:option>
                    <form:option value="1Y">moins de 1 an</form:option>
                    <form:option value="2Y">moins de 2 ans</form:option>
                    <form:option value="5Y">moins de 5 ans</form:option>
                    <form:option value="10Y">moins de 10 ans</form:option>
                </form:select>
            </div>
        </div>
        <br/>
        <div class="form-group">
            <form:checkbox path="lendable" value="true" cssClass="checkbox-boolean"/>
            <label>Disponible</label>
        </div>
        <div class="form-group row">
            <div class="col-md-2 offset-md-4 col-sm-12">
                <button type="submit" class="btn btn-primary btn-block">Rechercher</button>
            </div>
            <div class="col-md-2 col-sm-12">
                <a href="<c:url value="/topoSpot"/>">
                    <button type="button" class="btn btn-primary btn-block">Afficher tout</button>
                </a>
            </div>
        </div>
        <div class="form-group text-center bottom-link">
            <a href="<c:url value="/user/topoForm"/>" class="text-info-link"><em class="fas fa-plus-circle"></em> Ajouter un topo</a>
        </div>
        </form:form>
    </div>

    <div class="article-list">
        <div class="row articles">
            <c:forEach items="${listTopo}" var="topo">
                <div id="topo-item" class="col-sm-6 col-md-4 item background-custom">
                    <div class="item-picture">
                        <c:choose>
                            <c:when test="${topo.picturePath != null}">
                                <a href="<c:url value="/topo/${topo.id}"/>">
                                    <img class="img-fluid"
                                         src="<c:url value="${topo.picturePath}"/>"
                                         alt="photo du topo">
                                </a>
                            </c:when>
                            <c:otherwise>
                                <a href="<c:url value="/topo/${topo.id}"/>">
                                    <img class="img-fluid"
                                         src="<c:url value="/resources/pictures/no-picture.jpg"/>"
                                         alt="pas d'image disponible">
                                </a>
                            </c:otherwise>
                        </c:choose>
                    </div>
                    <div class="article-info">
                        <div class="article-info-div">
                            <h3 class="name">
                            <span>
                                <c:choose>
                                    <c:when test="${topo.lendable}">
                                        <img id="lendable-icon-result"
                                             src="<c:url value="/resources/pictures/label-lendable-green.png"/>"
                                             alt="lendable"/>
                                    </c:when>
                                    <c:when test="${!topo.lendable}">
                                        <img id="lendable-icon-result"
                                             src="<c:url value="/resources/pictures/label-lendable-red.png"/>" alt="lendable"/>
                                    </c:when>
                                </c:choose>
                            </span>
                            ${topo.name} - ${topo.region}
                            </h3>
                        </div>
                        <div class="article-info-div">
                            <p class="description">${topo.description}</p>
                        </div>
                        <div class="article-info-div">
                            <p class="description">Parution : <fmt:formatDate value="${topo.dateOfPublication}"
                                                                              pattern="dd/MM/yyyy"/></p>
                        </div>
                        <div class="article-info-div">
                            <a class="action" href="<c:url value="/topo/${topo.id}"/>"><em
                                    class="fa fa-arrow-circle-right"></em></a>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
</div>

<%@include file="common/footer.jsp" %>