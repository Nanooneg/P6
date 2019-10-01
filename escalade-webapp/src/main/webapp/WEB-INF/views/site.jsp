<%--
  @Date: 26/09/2019 - 20:37
  @Author: nanoo
--%>
<%@ page pageEncoding="UTF-8" %>
<%@include file="common/header.jsp" %>

<section class="container-fluid">
    <div id="site-box">
        <div id="site-header" class="row">
            <div class="col-md-2 text-center">
                <c:if test="${site.officialLabel}">
                    <img id="label-icon" src="<c:url value="/resources/pictures/label-3-rouge.png"/>" alt="label">
                </c:if>
            </div>
            <div class="col-md-8 text-center">
                <h1 class="text-center">${site.name} - ${site.region} - par ${account.firstName}</h1>
            </div>
            <div class="col-md-2 text-center">
                <c:if test="${sessionScope.account.roleName == 'Member' || sessionScope.account.roleName == 'Administrator'}">
                    <a href="/changeLabel/${site.id}">
                        <button id="label">${!site.officialLabel ? 'Ajouter label' : 'Enlever label'}</button>
                    </a>
                </c:if>
            </div>
        </div>
        <div id="site-picture">
                <img src="<c:url value="/resources/pictures/téléchargement.jpeg"/>" alt="image"/>
        </div>
        <div class="site-info">
            <p class="title">Description du Site : </p>
            <p class="description">${site.description}</p>
            <div class="button-display-bar pull-right">
                <em class="fas fa-comment"></em>
                <a href="/addComment/${site.id}" class="text-info-link">${commentCount ? commentCount : 0} - Commenter</a>
                <em class="fas fa-plus-circle"></em>
                <a href="<c:url value="/spotForm2/${site.id}"/>" class="text-info-link">Ajouter un secteur</a>
                <c:if test="${sessionScope.account.id == site.idAccount
                            || sessionScope.account.roleName == 'Member'
                            || sessionScope.account.roleName == 'Administrator'}">
                    <em class="fas fa-pen"></em>
                    <a href="<c:url value="/updateSite/${site.id}"/>" class="text-info-link">Modifier le site</a>
                </c:if>
                <c:if test="${sessionScope.account.roleName == 'Member' || sessionScope.account.roleName == 'Administrator'}">
                    <em class="fas fa-minus-circle"></em>
                    <a href="<c:url value="/deleteSite/${site.id}"/>" class="text-info-link">Supprimer ce site</a>
                </c:if>
            </div>
        </div>
        <c:forEach items="${listSector}" var="sector" varStatus="sectorStatus">
            <div class="sector-info">
                <div>
                    <h2>
                        Secteur n°${sectorStatus.count} : ${sector.name} -
                            ${wayListBySectorId[sector.id].size()} voie<c:if test="${wayListBySectorId[sector.id].size() > 1}">s</c:if>
                    </h2>
                </div>
                <div>
                    <p class="title">Description du Secteur : </p>
                    <p class="description">${sector.description}</p>
                    <c:if test="${wayListBySectorId[sector.id].size() != 0}">
                        <p class="title before-loop">Liste des voies :</p>
                    </c:if>
                    <c:forEach items="${wayListBySectorId[sector.id].iterator()}" var="way" varStatus="wayStatus">
                        <div class="way-info">
                            <div>
                                <p>
                                    <c:if test="${sessionScope.account.roleName == 'Member' || sessionScope.account.roleName == 'Administrator'}">
                                    <a href="<c:url value="/deleteWay/${site.id}/${way.id}"/>" class="text-info-link">
                                        <em class="fas fa-minus-circle"></em>
                                    </a>
                                    </c:if>
                                    <c:if test="${sessionScope.account.id == way.idAccount
                                                || sessionScope.account.roleName == 'Member'
                                                || sessionScope.account.roleName == 'Administrator'}">
                                        <a id="way" href="<c:url value="/updateWay/${way.id}"/>" class="text-info-link">
                                            <em class="fas fa-pen"></em>
                                        </a>
                                    </c:if>
                                    <a href="/addComment/${way.id}" class="text-info-link">
                                        <em class="fas fa-comment"></em>${commentCount ? commentCount : 0}
                                    </a>
                                     - voie n°${wayStatus.count} : ${way.name} - Hauteur : ${way.height} m - ${way.pitchNbr}
                                    longueurs et ${way.anchorNbr} points d'ancrage ( ${way.rating} )
                                </p>
                            </div>
                        </div>
                    </c:forEach>
                    <div class="button-display-bar pull-right">
                        <em class="fas fa-comment"></em>
                        <a href="/addComment/${sector.id}" class="text-info-link">${commentCount ? commentCount : 0} - Commenter</a>
                        <em class="fas fa-plus-circle"></em>
                        <a href="<c:url value="/spotForm3/${sector.id}"/>" class="text-info-link">Ajouter une voie</a>
                        <c:if test="${sessionScope.account.id == sector.idAccount
                                    || sessionScope.account.roleName == 'Member'
                                    || sessionScope.account.roleName == 'Administrator'}">
                            <em class="fas fa-pen"></em>
                            <a href="<c:url value="/updateSector/${sector.id}"/>" class="text-info-link">Modifier le sector</a>
                        </c:if>
                        <c:if test="${sessionScope.account.roleName == 'Member' || sessionScope.account.roleName == 'Administrator'}">
                            <em class="fas fa-minus-circle"></em>
                            <a href="<c:url value="/deleteSector/${site.id}/${sector.id}"/>" class="text-info-link">Supprimer ce secteur</a>
                        </c:if>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</section>

<%@include file="common/footer.jsp" %>