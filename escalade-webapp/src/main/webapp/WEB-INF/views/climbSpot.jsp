<%--
  @Date: 23/09/2019 - 12:08
  @Author: nanoo
--%>
<%@ page pageEncoding="UTF-8" %>
<%@include file="common/header.jsp" %>


<div class="container-fluid">
    <div id="spot-form" class="search-dark">
        <form:form action="/climbSpot" method="post" class="background-custom" modelAttribute="searchAttribut">
            <div class="intro">
                <h2 class="text-center">Site de grimpe</h2>
            </div>
            <div>
                <c:if test="${empty message}"><br/></c:if>
                <h4 class="text-center ${empty listSite ? 'error' : 'success'}">${message}</h4>
            </div>
            <div class="row">
                <div class="col-sm-12 col-md-4 select-style-md form-group">
                    <label for="region">Région :</label>
                    <form:select path="region" id="region" cssClass="form-control">
                        <form:option value="all">*****</form:option>
                        <form:options items="${listRegion}"/>
                    </form:select>
                </div>
                <div class="col-sm-12 col-md-4 select-style-md form-group">
                    <label for="sectorNbr">Secteur par site (minimum) :</label>
                    <form:select path="sectorNbrMin" id="sectorNbr" cssClass="form-control">
                        <form:option value="0">*****</form:option>
                        <form:option value="1">1</form:option>
                        <form:option value="2">2</form:option>
                        <form:option value="3">3</form:option>
                        <form:option value="4">4</form:option>
                        <form:option value="5">5</form:option>
                    </form:select>
                </div>
                <div class="col-sm-12 col-md-4 select-style-md form-group">
                    <label>Difficulté (minimum) :</label>
                    <form:select path="rating" cssClass="form-control">
                        <form:option value="all">*****</form:option>
                        <form:options items="${listRating}"/>
                    </form:select>
                </div>
            </div>
            <br/>
            <div class="form-group">
                <form:checkbox path="officialLabel" cssClass="checkbox-boolean"/>
                <label>Label officiel</label>
            </div>
            <div class="form-group row">
                <div class="col-md-2 offset-md-4 col-sm-12">
                    <button type="submit" class="btn btn-primary btn-block">Rechercher</button>
                </div>
                <div class="col-md-2 col-sm-12">
                    <a href="<c:url value="/climbSpot"/>">
                        <button type="button" class="btn btn-primary btn-block">Afficher tout</button>
                    </a>
                </div>
            </div>
            <div class="form-group bottom-link text-center">
                <a href="<c:url value="/spotForm1"/>" class="forgot"><em class="fas fa-plus-circle"></em> Ajouter un site</a>
            </div>
        </form:form>
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



<%--<section class="container-fluid">
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
</section>--%>

<%@include file="common/footer.jsp" %>