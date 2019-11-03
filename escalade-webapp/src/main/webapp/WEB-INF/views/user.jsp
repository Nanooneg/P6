<%--
  @Date: 08/09/2019 - 15:43
  @Author: nanoo
--%>
<%@ page pageEncoding="UTF-8" %>
<%@include file="common/header.jsp" %>

<div class="container-fluid">
    <div id="user-box" class="publication-dark background-custom text-center">
        <div>
            <h1 class="text-center">Bienvenue ${sessionScope.accountSession.firstName} ${sessionScope.accountSession.lastName}</h1>
        </div>
        <div>
            <c:if test="${empty registration.result}"><br/></c:if>
            <h4 class="text-center ${empty registration.errors ? 'success' : 'error'}">${registration.result}</h4>
        </div>
        <div class="row form-group">
            <div class="col-md-4 offset-md-4 col-sm-12">
                <a href="<c:url value="/lendingRequestReceived/${sessionScope.accountSession.id }"/>">
                    <button type="button" class="btn btn-primary btn-block">
                        Demandes de prêt : ${topoBookingReceived + topoBookingSent}
                    </button>
                </a>
            </div>
        </div>
        <div class="icon-bar">
            <div class="d-none d-md-block">
                <a href="<c:url value="/updateAccount/${sessionScope.accountSession.id}"/>" class="text-info-link">
                    <em class="fas fa-pen"></em> Modifier mon compte</a>
            </div>
            <div class="d-sm-block d-md-none icon-only">
                <a href="<c:url value="/updateAccount/${sessionScope.accountSession.id}"/>" class="text-info-link">
                    <em class="fas fa-pen"></em></a>
            </div>
        </div>
    </div>

    <div class="publication-dark background-custom text-center">
        <h1>Mes topos</h1>
    </div>
    <div class="article-list">
        <div class="row articles">
            <c:forEach items="${listTopo}" var="topo">
                <div class="col-sm-6 col-md-4 item background-custom">
                    <div id="topo-item" class="item-picture">
                        <c:choose>
                            <c:when test="${topo.picturePath != null}">
                                <a href="<c:url value="/topo/${topo.id}"/>">
                                    <img src="<c:url value="${topo.picturePath}"/>" alt="photo du topo">
                                </a>
                            </c:when>
                            <c:otherwise>
                                <a href="<c:url value="/topo/${topo.id}"/>">
                                    <img src="<c:url value="/resources/pictures/no-picture.jpg"/>"
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

    <div class="publication-dark background-custom text-center">
        <h1>Mes sites publiés</h1>
    </div>
    <div class="article-list">
        <div class="row articles">
            <c:forEach items="${listSite}" var="site">
                <div class="col-sm-6 col-md-4 item background-custom">
                    <div class="item-picture">
                        <c:choose>
                            <c:when test="${site.picturePath != null}">
                                <a href="<c:url value="/site/${site.id}"/>">
                                    <img class="img-fluid" src="<c:url value="${site.picturePath}"/>" alt="photo du site">
                                </a>
                            </c:when>
                            <c:otherwise>
                                <a href="<c:url value="/site/${site.id}"/>"><img src="<c:url value="/resources/pictures/no-picture.jpg"/>"
                                                                                 alt="pas d'image disponible"></a>
                            </c:otherwise>
                        </c:choose>
                    </div>
                    <div class="article-info">
                        <div class="article-info-div">
                            <h3 class="name">
                            <span>
                                <c:if test="${site.officialLabel}">
                                <img id="label-icon-result"
                                     src="<c:url value="/resources/pictures/label-3-white.png"/>"
                                     alt="label">
                                </c:if>
                            </span>
                                    ${site.name} - ${site.region}
                            </h3>
                        </div>
                        <div class="article-info-div">
                            <p class="description">${site.description}</p>
                        </div>
                        <div class="article-info-div">
                            <a class="action" href="<c:url value="/site/${site.id}"/>"><em class="fa fa-arrow-circle-right"></em></a>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
</div>

<%@include file="common/footer.jsp" %>
