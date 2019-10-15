<%--
  @Date: 26/09/2019 - 20:37
  @Author: nanoo
--%>
<%@ page pageEncoding="UTF-8" %>
<%@include file="common/header.jsp" %>

<section class="container-fluid">
    <div id="topo-box">
        <div class="topo-header">
            <h1 class="text-center">${topo.name}</h1>
        </div>
        <div id="topo-picture">
            <c:choose>
                <c:when test="${topo.picturePath != null}">
                    <img src="<c:url value="${topo.picturePath}"/>" alt="photo du topo">
                </c:when>
                <c:otherwise>
                    <img src="<c:url value="/resources/pictures/téléchargement.jpeg"/>" alt="image"/>
                </c:otherwise>
            </c:choose>
        </div>
        <div class="topo-info">
            <p class="title">
                <span>
                    <c:choose>
                        <c:when test="${topo.lendable}">
                            <img src="<c:url value="/resources/pictures/label-lendable-green.png"/>" alt="lendable"/>
                        </c:when>
                        <c:when test="${!topo.lendable}">
                            <img src="<c:url value="/resources/pictures/label-lendable-red.png"/>" alt="lendable"/>
                        </c:when>
                    </c:choose>
                </span>
                Description du Topo (${topo.region}):
            </p>
            <p class="description">${topo.description}</p>
            <p class="title">Date de parution :</p>
            <p class="description">Le ${topo.dateOfPublication.day} ${topo.dateOfPublication.month} ${topo.dateOfPublication.year}</p>
            <p class="title">Etat général :</p>
            <p class="description">${topo.condition}</p>
            <div class="button-display-bar pull-right">
                <em class="fas fa-comment"></em>
                <a href="/commentary/${topo.id}" class="text-info-link">Commentaire</a>
                <c:if test="${sessionScope.account.id == topo.idAccount
                            || sessionScope.account.roleName == 'Member'
                            || sessionScope.account.roleName == 'Administrator'}">
                    <em class="fas fa-pen"></em>
                    <a href="<c:url value="/updateTopo/${topo.id}"/>" class="text-info-link">Modifier le topo</a>
                </c:if>
                <c:if test="${sessionScope.account.id == topo.idAccount
                            || sessionScope.account.roleName == 'Member'
                            || sessionScope.account.roleName == 'Administrator'}">
                    <em class="fas fa-minus-circle"></em>
                    <a href="<c:url value="/deleteTopo/${topo.id}"/>" class="text-info-link">Supprimer ce topo</a>
                </c:if>
            </div>
        </div>
    </div>
</section>

<%@include file="common/footer.jsp" %>