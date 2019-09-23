<%--
  @Date: 23/09/2019 - 18:46
  @Author: nanoo
--%>
<%@ page pageEncoding="UTF-8" %>

<section class="container-fluid">
    <div id="display-box">
        <form:form id="login-form" action="/climbSpot" method="post" modelAttribute="site">
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
                        <form:option value="------------"/>
                        <form:options items="${listRegion}"/>
                    </form:select>
                </div>
                <form:form method="post" modelAttribute="sector">
                    <div class="col-md-3">
                        <label for="sectorNbr" class="text-info">Nombre de secteur par site :</label>
                        <select id="sectorNbr">
                            <option value="">------------</option>
                            <option value="">moins de 3</option>
                            <option value="">entre 3 et 5</option>
                            <option value="">plus de 5</option>
                        </select>
                    </div>
                </form:form>
                <form:form method="post" modelAttribute="way">
                <div class="col-md-2">
                    <label class="text-info">Difficulté :</label>
                    <form:select path="rating">
                        <form:option value="------------"/>
                        <form:options items="${listRating}"/>
                    </form:select>
                </div>
            </div>
            </form:form>
            <br/>
            <div class="text-center">
                <input type="submit" class="btn btn-info btn-md" value="Rechercher"/>
                <input type="submit" class="btn btn-info btn-md" value="Afficher tout"/>
            </div>
            </form:form>
        </div>
</section>