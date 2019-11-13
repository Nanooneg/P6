<%--
  @Date: 16/09/2019 - 23:07
  @Author: nanoo
--%>
<%@ page pageEncoding="UTF-8" %>
<%@include file="common/header.jsp" %>

<div class="container-fluid">
    <div id="home-box" class="background-custom text-center">
        <div>
            <h1 class="text-center">Bienvenue ches les Amis de l'escalade</h1>
        </div>
        <div class="row">
            <div class="col-md-5 col-sm-12 logo-box">
                <img src="<c:url value="/resources/pictures/climbing-logo-blanc-1.png"/>" alt="logo de l'association">
            </div>
            <div class="col-md-7 col-sm-12 home-text">
                <div class="home-description">
                    Nous sommes une association de passionnés ! Sur ce site vous trouverez des infos sur les spots de grimpe
                    que les utilisateurs ont postés. Certains de ces sites ont été reconnus par nos membres et portent le label
                    "officiel les amis de l'escalade" : <img id="label-icon-result"
                                                             src="<c:url value="/resources/pictures/label-3-white.png"/>"
                                                             alt="label">
                </div>
                <div class="home-description">
                    Vous trouverez aussi une liste de Topos, que les utilisateur peuvent s'ils le souhaitent partager. <br/>
                    Un topo disponible aura le logo :
                    <img class="lendable-icon-result" src="<c:url value="/resources/pictures/label-lendable-green.png"/>" alt="lendable"/> <br/>
                    Un topo indisponible :
                    <img class="lendable-icon-result" src="<c:url value="/resources/pictures/label-lendable-red.png"/>" alt="lendable"/> <br/>
                    Vous pouvez faire une demande auprès du propriétaire et si il accepte, vous aurez accès à ses coordonnées
                    pour prendre contact directement avec lui!
                </div>
                <div class="home-description">
                    N'hésitez pas à créer un compte pour profiter de cette fonctionnalité et bien d'autres (commenter, poster
                    vous-même un topo ou des infos sur un spot).
                </div>
                <div class="home-description button">
                    <a href="<c:out value="/login"/>">
                        <button type="button" class="btn btn-primary btn-block">Je me connecte</button>
                    </a>
                </div>
            </div>
        </div>
    </div>
</div>

<%@include file="common/footer.jsp" %>