<%--
  @Date: 26/09/2019 - 20:37
  @Author: nanoo
--%>
<%@ page pageEncoding="UTF-8" %>
<%@include file="common/header.jsp" %>

<div class="container-fluid">
    <div id="site-box" class="publication-dark background-custom text-center">
        <div>
            <h1 class="text-center">${site.name}</h1>
        </div>
        <div id="site-picture">
            <c:choose>
                <c:when test="${site.picturePath != null}">
                    <img src="<c:url value="${site.picturePath}"/>" alt="photo du site">
                </c:when>
                <c:otherwise>
                    <img src="<c:url value="/resources/pictures/téléchargement.jpeg"/>" alt="image"/>
                </c:otherwise>
            </c:choose>
        </div>
        <div class="button">
            <a href="<c:out value="javascript:history.go(-1)"/>">
                <button type="button" class="btn btn-primary btn-block">Revenir à la liste</button>
            </a>
        </div>
        <div class="site-info">
            <p class="info-title">
                <span>
                    <c:if test="${site.officialLabel}">
                                <img id="label-icon-result"
                                     src="<c:url value="/resources/pictures/label-3-white.png"/>"
                                     alt="label">
                    </c:if>
                </span>
                Description du Site (${site.region}):
            </p>
            <p class="description text-justify">${site.description}</p>
            <div class="icon-bar">
                <div class="d-none d-md-block">
                    <a href="/commentary/spot/${site.id}" class="text-info-link">
                        <em class="fas fa-comment"></em> Commentaire</a>
                </div>
                <div class="d-none d-md-block">
                    <c:if test="${sessionScope.accountSession.id == site.idAccount
                            || sessionScope.accountSession.roleName == 'Member'
                            || sessionScope.accountSession.roleName == 'Administrator'}">
                        <a href="<c:url value="/updateSite/${site.id}"/>" class="text-info-link">
                            <em class="fas fa-pen"></em> Modifier le site</a>
                    </c:if>
                </div>
                <div class="d-none d-md-block">
                    <a href="<c:url value="/spotForm2/${site.id}"/>" class="text-info-link">
                        <em class="fas fa-plus-circle"></em> Ajouter un secteur</a>
                </div>
                <div class="d-none d-md-block">
                    <c:if test="${sessionScope.accountSession.id == site.idAccount
                            || sessionScope.accountSession.roleName == 'Member'
                            || sessionScope.accountSession.roleName == 'Administrator'}">
                        <a href="<c:url value="/deleteSite/${site.id}"/>" class="text-info-link">
                            <em class="fas fa-minus-circle"></em> Supprimer ce site</a>
                    </c:if>
                </div>
                <div class="d-sm-block d-md-none icon-only">
                    <a href="/commentary/spot/${site.id}" class="text-info-link">
                        <em class="fas fa-comment"></em></a>
                </div>
                <div class="d-sm-block d-md-none icon-only">
                    <c:if test="${sessionScope.accountSession.id == site.idAccount
                            || sessionScope.accountSession.roleName == 'Member'
                            || sessionScope.accountSession.roleName == 'Administrator'}">
                        <a href="<c:url value="/updateSite/${site.id}"/>" class="text-info-link">
                            <em class="fas fa-pen"></em></a>
                    </c:if>
                </div>
                <div class="d-sm-block d-md-none icon-only">
                    <a href="<c:url value="/spotForm2/${site.id}"/>" class="text-info-link">
                        <em class="fas fa-plus-circle"></em></a>
                </div>
                <div class="d-sm-block d-md-none icon-only">
                    <c:if test="${sessionScope.accountSession.id == site.idAccount
                            || sessionScope.accountSession.roleName == 'Member'
                            || sessionScope.accountSession.roleName == 'Administrator'}">
                        <a href="<c:url value="/deleteSite/${site.id}"/>" class="text-info-link">
                            <em class="fas fa-minus-circle"></em></a>
                    </c:if>
                </div>
            </div>
        </div>
        <c:forEach items="${listSector}" var="sector" varStatus="sectorStatus">
            <div class="sector-info">
                <div>
                    <h2>
                        Secteur n°${sectorStatus.count} : ${sector.name} -
                            ${wayListBySectorId[sector.id].size()} voie<c:if
                            test="${wayListBySectorId[sector.id].size() > 1}">s</c:if>
                    </h2>
                </div>
                <div>
                    <p class="info-title">Description du Secteur : </p>
                    <p class="description text-justify">${sector.description}</p>
                    <c:if test="${wayListBySectorId[sector.id].size() != 0}">
                        <p class="info-title before-loop">Liste des voies :</p>
                    </c:if>
                    <c:forEach items="${wayListBySectorId[sector.id].iterator()}" var="way" varStatus="wayStatus">
                        <div>
                            <div class="before-collapse">
                                <div>
                                    <c:if test="${sessionScope.accountSession.id == way.idAccount
                                            || sessionScope.accountSession.roleName == 'Member'
                                            || sessionScope.accountSession.roleName == 'Administrator'}">
                                        <a id="way" href="<c:url value="/updateWay/${sector.id}/${way.id}"/>"
                                           class="text-info-link">
                                            <em class="fas fa-pen"></em>
                                        </a>
                                    </c:if>
                                    <c:if test="${sessionScope.accountSession.id == way.idAccount
                                            || sessionScope.accountSession.roleName == 'Member'
                                            || sessionScope.accountSession.roleName == 'Administrator'}">
                                        <a href="<c:url value="/deleteWay/${site.id}/${way.id}"/>"
                                           class="text-info-link">
                                            <em class="fas fa-minus-circle"></em>
                                        </a>
                                    </c:if>
                                    <a href="/commentary/spot/${way.id}" class="text-info-link">
                                        <em class="fas fa-comment"></em>
                                    </a>
                                </div>
                                <div class="way-info">
                                    <a data-toggle="collapse" href="#collapse${way.id}" role="button"
                                       aria-expanded="false" aria-controls="collapseExample">
                                    N°${wayStatus.count} : ${way.name} ( ${way.rating} ) <em class="fas fa-angle-double-down"></em>
                                    </a>
                                </div>
                            </div>
                            <div class="collapse row" id="collapse${way.id}">
                                <div class="col-lg-4 col-md-12 table-style">
                                    Hauteur : ${way.height} m
                                </div>
                                <div class="col-lg-4 col-md-12 table-style">
                                    Longueurs : ${way.pitchNbr}
                                </div>
                                <div class="col-lg-4 col-md-12 table-style">
                                    Points d'ancrage : ${way.anchorNbr}
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                    <div class="sector-link icon-bar">
                        <div class="d-none d-md-block">
                            <a href="/commentary/spot/${sector.id}" class="text-info-link">
                                <em class="fas fa-comment"></em> Commentaire</a>
                        </div>
                        <div class="d-none d-md-block">
                            <c:if test="${sessionScope.accountSession.id == sector.idAccount
                                    || sessionScope.accountSession.roleName == 'Member'
                                    || sessionScope.accountSession.roleName == 'Administrator'}">
                                <a href="<c:url value="/updateSector/${site.id}/${sector.id}"/>" class="text-info-link">
                                    <em class="fas fa-pen"></em> Modifier
                                    le sector</a>
                            </c:if>
                        </div>
                        <div class="d-none d-md-block">
                            <a href="<c:url value="/spotForm3/${sector.id}"/>" class="text-info-link">
                                <em class="fas fa-plus-circle"></em> Ajouter une voie</a>
                        </div>
                        <div class="d-none d-md-block">
                            <c:if test="${sessionScope.accountSession.id == sector.idAccount
                                    || sessionScope.accountSession.roleName == 'Member'
                                    || sessionScope.accountSession.roleName == 'Administrator'}">
                                <a href="<c:url value="/deleteSector/${site.id}/${sector.id}"/>" class="text-info-link">
                                    <em class="fas fa-minus-circle"></em>Supprimer
                                    ce secteur</a>
                            </c:if>
                        </div>
                        <div class="d-sm-block d-md-none icon-only">
                            <a href="/commentary/spot/${sector.id}" class="text-info-link">
                                <em class="fas fa-comment"></em></a>
                        </div>
                        <div class="d-sm-block d-md-none icon-only">
                            <c:if test="${sessionScope.accountSession.id == sector.idAccount
                                    || sessionScope.accountSession.roleName == 'Member'
                                    || sessionScope.accountSession.roleName == 'Administrator'}">
                                <a href="<c:url value="/updateSector/${site.id}/${sector.id}"/>" class="text-info-link">
                                    <em class="fas fa-pen"></em></a>
                            </c:if>
                        </div>
                        <div class="d-sm-block d-md-none icon-only">
                            <a href="<c:url value="/spotForm3/${sector.id}"/>" class="text-info-link">
                                <em class="fas fa-plus-circle"></em></a>
                        </div>
                        <div class="d-sm-block d-md-none icon-only">
                            <c:if test="${sessionScope.accountSession.id == sector.idAccount
                                    || sessionScope.accountSession.roleName == 'Member'
                                    || sessionScope.accountSession.roleName == 'Administrator'}">
                                <a href="<c:url value="/deleteSector/${site.id}/${sector.id}"/>" class="text-info-link">
                                    <em class="fas fa-minus-circle"></em></a>
                            </c:if>
                        </div>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</div>

<%@include file="common/footer.jsp" %>
