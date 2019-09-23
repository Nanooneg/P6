<%--
  @Date: 23/09/2019 - 12:08
  @Author: nanoo
--%>
<%@ page pageEncoding="UTF-8" %>
<%@include file="common/header.jsp" %>

<section class="container-fluid">
    <div id="display-box">
        <form:form id="login-form" action="/climbSpot" method="post" modelAttribute="searchAttribut">
        <h1 class="text-center text-info">Site de grimpe</h1><br/>
        <div class="form-group">
            <div class="row form-inline">
                <div class="col-md-2">
                    <label class="text-info">Ajouter des filtres :</label>
                </div>
                <div class="col-md-2">
                    <form:checkbox path="officialLabel" cssClass="checkbox-boolean"/>
                    <label class="text-info">Label officiel</label>
                </div>
                <div class="col-md-3">
                    <label class="text-info">Région :</label>
                    <form:select path="region">
                        <form:option value="">------------</form:option>
                        <form:options items="${listRegion}"/>
                    </form:select>
                </div>
                <div class="col-md-3">
                    <label for="sectorNbr" class="text-info">Nombre de secteur par site :</label>
                    <form:select path="sectorNbr" id="sectorNbr">
                        <form:option value="">------------</form:option>
                        <form:option value="3">moins de 3</form:option>
                        <form:option value="5">entre 3 et 5</form:option>
                        <form:option value="plus">plus de 5</form:option>
                    </form:select>
                </div>
                <div class="col-md-2">
                    <label class="text-info">Difficulté :</label>
                    <form:select path="rating">
                        <form:option value="">------------</form:option>
                        <form:options items="${listRating}"/>
                    </form:select>
                </div>
            </div>
            <br/>
            <div class="text-center">
                <input type="submit" class="btn btn-info btn-md" value="Rechercher"/>
                <input type="submit" class="btn btn-info btn-md" value="Afficher tout"/>
                <div id="register-link" class="text-right">
                    <a href="<c:url value="/spotForm"/>" class="text-info">Créer un spot</a>
                </div>
            </div>
            </form:form>
        </div>
</section>

<section>
    <%--<c:forEach items="result">--%>
        <div class="result-box">
            <p>test</p>
        </div>
   <%-- </c:forEach>--%>
</section>

<%@include file="common/footer.jsp" %>