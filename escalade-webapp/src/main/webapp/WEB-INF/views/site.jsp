<%--
  @Date: 26/09/2019 - 20:37
  @Author: nanoo
--%>
<%@ page pageEncoding="UTF-8" %>
<%@include file="common/header.jsp" %>

<section class="container-fluid">
    <div id="site-box">
        <div>
            <div>
                <h1 class="text-center">${site.name} - ${site.region} - par ${account.firstName}</h1>
                <%--TODO get first name to replace idAccount--%>
            </div>
        </div>
        <div id="site-picture">
                <img src="<c:url value="/resources/pictures/téléchargement.jpeg"/>" alt="image"/>
        </div>
        <div class="site-info">
            <p class="title">Description du Site : </p>
            <p class="description">${site.description}</p>
            <div class="pull-right">
                <em class="fas fa-plus-circle"></em>
                <a href="<c:url value="/spotForm2/${site.id}"/>" class="text-info-link">Ajouter un secteur</a>
            </div>
        </div>
        <c:forEach items="${listSector}" var="sector" varStatus="sectorStatus">
            <div class="sector-info">
                <div>
                    <h2 class="text-center">
                        Secteur n°${sectorStatus.count} : ${sector.name} -
                            ${wayListBySectorId[sector.id].size()} voie<c:if test="${wayListBySectorId[sector.id].size() > 1}">s</c:if>
                    </h2>
                </div>
                <div>
                    <p class="title">Description du Secteur : </p>
                    <p class="description">${sector.description}</p>
                    <c:forEach items="${wayListBySectorId[sector.id].iterator()}" var="way" varStatus="wayStatus">
                        <div class="way-info">
                            <div>
                                <p>voie n°${wayStatus.count} : ${way.name} - ( ${way.rating} )</p>
                            </div>
                            <%--<div>
                                <p class="title">Description de la voie : </p>
                                <p class="description">${way.description}</p>
                            </div>--%>
                        </div>
                    </c:forEach>
                    <div class="pull-right">
                        <em class="fas fa-plus-circle"></em>
                        <a href="<c:url value="/spotForm3/${sector.id}"/>" class="text-info-link">Ajouter une voie</a>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</section>

<%@include file="common/footer.jsp" %>