<%--
  @Date: 23/09/2019 - 12:08
  @Author: nanoo
--%>
<%@ page pageEncoding="UTF-8" %>
<%@include file="common/header.jsp" %>

<section class="container-fluid">
    <div id="search-box" class="form-box top-box">
        <form:form action="/climbSpot" method="post" modelAttribute="searchAttribut">
        <div>
            <h1 class="text-center">Site de grimpe</h1>
        </div>
            <div>
                <br/>
                <%--<c:if test="${empty message}"><br/></c:if> TODO display error message when no result found --%>
                <%--<h4 class="text-center error">${message}</h4>--%>
            </div>
        <div class="row">
            <div class="col-md-2 text-center">
                <div class="col-md-12">
                    <label>Ajouter des filtres :</label>
                </div>
                <div class="col-md-12">
                    <form:checkbox path="officialLabel" value="true" cssClass="checkbox-boolean"/>
                    <label>Label officiel</label>
                </div>
            </div>
            <div class="col-md-10">
                <div class="col-md-4 select-style-md">
                    <label>Région :</label>
                    <form:select path="region">
                        <form:option value="">*****</form:option>
                        <form:options items="${listRegion}"/>
                    </form:select>
                </div>
                <div class="col-md-4 select-style-md">
                    <label for="sectorNbr">Secteur par site :</label>
                    <form:select path="sectorNbr" id="sectorNbr">
                        <form:option value="">*****</form:option>
                        <form:option value="3">moins de 3</form:option>
                        <form:option value="5">entre 3 et 5</form:option>
                        <form:option value="plus">plus de 5</form:option>
                    </form:select>
                </div>
                <div class="col-md-4 select-style-md">
                    <label>Difficulté minimum:</label>
                    <form:select path="rating">
                        <form:option value="">*****</form:option>
                        <form:options items="${listRating}"/>
                    </form:select>
                </div>
            </div>
        </div>
        <br/>
        <div class="button-search-bar">
            <div class="pull-left">
                <input type="submit" class="btn-search text-center" value="Rechercher"/>
                <a href="<c:url value="/climbSpot"/>"><input type="button" class="btn-search text-center" value="Afficher tout"/></a>
            </div>
            <div class="pull-right">
                <em class="fas fa-plus-circle"></em>
                <a href="<c:url value="/spotForm1"/>" class="text-info-link">Créer un spot</a>
            </div>
        </div>
        </form:form>
    </div>
</section>

<section class="container-fluid">
    <c:forEach items="${listSite}" var="result">
        <div class="display-box">
            <div class="row">
                <div class="col-md-2">
                    <img src="<c:url value="/resources/pictures/no-picture.jpg"/>" alt="pas d'image disponible">
                </div>
                <div class="col-md-10">
                    <div>
                        <p class="title">${result.name} - ${result.region}</p>
                    </div>
                    <div>
                        <p class="description">${result.description}</p>
                    </div>
                    <div class="button-display-bar">
                        <div class="pull-right">
                            <em class="fas fa-plus-circle"></em>
                            <a href="<c:url value="/spotForm2/${result.id}"/>" class="text-info-link">Ajouter un secteur</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </c:forEach>
</section>

<%@include file="common/footer.jsp" %>