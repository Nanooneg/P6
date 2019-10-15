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
        <div class="account-info">
            <p class="title">
                Mes demandes de prêt :
                <span><a href="<c:url value="#"/>"><input type="button" class="btn-search text-center" value="Nombre"/></a></span>
            </p>
            <p class="title"></p>
        </div>
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

<br/>

<section class="container-fluid">
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
