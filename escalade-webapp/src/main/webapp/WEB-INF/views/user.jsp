<%--
  @Date: 08/09/2019 - 15:43
  @Author: nanoo
--%>
<%@ page pageEncoding="UTF-8" %>
<%@include file="common/header.jsp" %>

<section class="container-fluid">
    <div id="user-box" class="form-box top-box">
        <div>
            <h1 class="text-center">Bienvenue ${sessionScope.account.firstName} ${sessionScope.account.lastName}</h1>
        </div>
        <div>
            <c:if test="${empty registration.result}"><br/></c:if>
            <h4 class="text-center ${empty registration.errors ? 'success' : 'error'}">${registration.result}</h4>
        </div>
        <div class="account-info">
            <div>
                <p class="title">
                    Demandes de prêt recue :
                    <span><a href="<c:url value="/lendingRequestReceived/${sessionScope.account.id }"/>">
                    <input type="button" class="btn-search text-center" value="${topoBookingReceived}"/></a></span>
                </p>
                <p class="title">
                    Demande de prêt envoyée :
                    <span><a href="<c:url value="/lendingRequestSent/${sessionScope.account.id }"/>">
                    <input type="button" class="btn-search text-center" value="${topoBookingSent}"/></a></span>
                </p>
            </div>
            <div class="pull-right">
                <em class="fas fa-pen"></em>
                <a href="<c:url value="/updateAccount/${sessionScope.account.id}"/>" class="text-info-link">Modifier mon
                    compte</a>
            </div>
        </div>
    </div>
</section>

<section class="container-fluid">
    <div class="user-title text-center">
        <h1>Mes topos</h1>
    </div>
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

<br/><br/>

<section class="container-fluid">
    <div class="user-title text-center">
        <h1>Mes sites publiés</h1>
    </div>
    <c:forEach items="${listSite}" var="site">
        <a href="<c:url value="/site/${site.id}"/>" class="title-link">
            <div class="display-box">
                <div class="row">
                    <div class="col-md-2 image-small">
                        <c:choose>
                            <c:when test="${site.picturePath != null}">
                                <img src="<c:url value="${site.picturePath}"/>" alt="photo du site">
                            </c:when>
                            <c:otherwise>
                                <img src="<c:url value="/resources/pictures/no-picture.jpg"/>" alt="pas d'image disponible">
                            </c:otherwise>
                        </c:choose>
                    </div>
                    <div class="col-md-10 contain-link">
                        <div class="title-link">
                            <p class="title">
                                    ${site.name} - ${site.region}
                                <span>
                                <c:if test="${site.officialLabel}">
                                <img id="label-icon-result"
                                     src="<c:url value="/resources/pictures/label-3-white.png"/>"
                                     alt="label">
                                </c:if>
                            </span>
                            </p>
                        </div>
                        <div>
                            <p class="display-description">${site.description}</p>
                        </div>
                    </div>
                </div>
            </div>
        </a>
    </c:forEach>
</section>

<%@include file="common/footer.jsp" %>
