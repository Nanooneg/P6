<%--
  @Date: 26/09/2019 - 20:37
  @Author: nanoo
--%>
<%@ page pageEncoding="UTF-8" %>
<%@include file="common/header.jsp" %>

<div class="container-fluid">
    <div id="topo-box" class="publication-dark background-custom text-center">
        <div>
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
        <div class="button">
            <a href="<c:out value="javascript:history.go(-1)"/>">
                <button type="button" class="btn btn-primary btn-block">Revenir à la liste</button>
            </a>
        </div>
        <div class="topo-info">
            <p class="info-title">
                <span>
                    <c:choose>
                        <c:when test="${topo.lendable}">
                            <img id="label-icon-result" src="<c:url value="/resources/pictures/label-lendable-green.png"/>" alt="lendable">
                        </c:when>
                        <c:when test="${!topo.lendable}">
                            <img id="label-icon-result" src="<c:url value="/resources/pictures/label-lendable-red.png"/>" alt="lendable">
                        </c:when>
                    </c:choose>
                </span>
                Description du Topo (${topo.region}):
            </p>
            <p class="description">${topo.description}</p>
            <p class="info-title">Date de parution :</p>
            <p class="description"><fmt:formatDate value="${topo.dateOfPublication}" pattern="dd/MM/yyyy"/></p>
            <p class="info-title">Etat général :</p>
            <p class="description">${topo.condition}</p>
            <div class="icon-bar">
                <div class="d-none d-md-block">
                    <a href="/commentary/topo/${topo.id}" class="text-info-link">
                        <em class="fas fa-comment"></em> Commentaire</a>
                </div>
                <div class="d-none d-md-block">
                    <c:if test="${sessionScope.accountSession.id == topo.idAccount
                            || sessionScope.accountSession.roleName == 'Member'
                            || sessionScope.accountSession.roleName == 'Administrator'}">
                        <a href="<c:url value="/user/updateTopo/${topo.id}"/>" class="text-info-link">
                            <em class="fas fa-pen"></em> Modifier le topo</a>
                    </c:if>
                </div>
                <div class="d-none d-md-block">
                    <c:if test="${sessionScope.accountSession.id == topo.idAccount
                            || sessionScope.accountSession.roleName == 'Member'
                            || sessionScope.accountSession.roleName == 'Administrator'}">
                        <a href="<c:url value="/user/deleteTopo/${topo.id}"/>" class="text-info-link">
                            <em class="fas fa-minus-circle"></em> Supprimer ce topo</a>
                    </c:if>
                </div>
                <div class="d-sm-block d-md-none icon-only">
                    <a href="/commentary/topo/${topo.id}" class="text-info-link">
                        <em class="fas fa-comment"></em></a>
                </div>
                <div class="d-sm-block d-md-none icon-only">
                    <c:if test="${sessionScope.accountSession.id == topo.idAccount
                            || sessionScope.accountSession.roleName == 'Member'
                            || sessionScope.accountSession.roleName == 'Administrator'}">
                        <a href="<c:url value="/user/updateTopo/${topo.id}"/>" class="text-info-link">
                            <em class="fas fa-pen"></em></a>
                    </c:if>
                </div>
                <div class="d-sm-block d-md-none icon-only">
                    <c:if test="${sessionScope.accountSession.id == topo.idAccount
                            || sessionScope.accountSession.roleName == 'Member'
                            || sessionScope.accountSession.roleName == 'Administrator'}">
                        <a href="<c:url value="/user/deleteTopo/${topo.id}"/>" class="text-info-link">
                            <em class="fas fa-minus-circle"></em></a>
                    </c:if>
                </div>
            </div>
            <br/>
            <div class="button">
                <c:if test="${topo.lendable && topo.idAccount != sessionScope.accountSession.id}">
                    <a href="<c:url value="/user/askForLending/${topo.id}"/>">
                        <button type="button" class="btn btn-primary btn-block">Demander</button>
                    </a>
                </c:if>
            </div>
        </div>
    </div>
</div>

<%@include file="common/footer.jsp" %>