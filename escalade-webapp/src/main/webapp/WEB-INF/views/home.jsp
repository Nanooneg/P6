<%--
  @Date: 16/09/2019 - 23:07
  @Author: nanoo
--%>
<%@ page pageEncoding="UTF-8" %>
<%@include file="common/header.jsp" %>

<section class="container-fluid">
    <div id="home-box" class="form-box center-box">
        <div>
            <h1 class="text-center">Bienvenue ches les Amis de l'escalade</h1>
        </div>
        <div class="description">
            <p>
                Nous somme une association de passionés ! Sur ce site vous trouverez des infos sur les spots de grimpe
                que les utilisateurs ont postées. Certains de ces sites ont été reconnus par nos membres et porte le label
                "officiel les amis de l'escalade" : <img class="label-icon"
                                                        src="<c:url value="/resources/pictures/label-3-white.png"/>"
                                                        alt="label">
            </p><br/>
            <p>
                Vous trouverez aussi une liste de Topos, que les utilisateur peuvent s'ils le souhaitent partager. <br/>
                Un topo disponible aura le logo :
                <img class="lendable-icon" src="<c:url value="/resources/pictures/label-lendable-green.png"/>" alt="lendable"/> <br/>
                Un topo indisponible :
                <img class="lendable-icon" src="<c:url value="/resources/pictures/label-lendable-red.png"/>" alt="lendable"/> <br/>
                Vous pouvez faire une demande auprès du propriétaire et s'il l'accepte, vous aurez accès à ses coordonnées
                pour prendre contact directement avec lui!
            </p>
            <p>
                N'hésitez pas à créer un compte pour profiter de cette fonctionalité et bien d'autre (commenter, poster
                vous-même un topo ou des infos sur un spot).
            </p>
        </div>
    </div>
</section>

<%@include file="common/footer.jsp" %>