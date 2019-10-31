<%--
  @Date: 24/10/2019 - 17:01
  @Author: nanoo
--%>

<%@ page pageEncoding="UTF-8" %>

<div>
    <nav class="navbar navbar-light navbar-expand-md navigation-clean-button background-custom" id="navbar">
        <div class="container">
            <a class="navbar-brand" href="<c:url value="/"/>">
                <img src="<c:url value="/resources/pictures/logo-transparent-blanc.png"/>" alt="logo">
            </a>
            <button data-toggle="collapse" class="navbar-toggler" data-target="#navcol-1">
                <span class="sr-only">Toggle navigation</span><span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse"
                 id="navcol-1">
                <ul class="nav navbar-nav mr-auto">
                    <li class="nav-item" role="presentation"><a class="nav-link" href="<c:url value="/topoSpot"/>">Topo</a></li>
                    <li class="nav-item" role="presentation"><a class="nav-link" href="<c:url value="/climbSpot"/>">Site de grimpe</a></li>
                </ul>
                <span class="navbar-text actions">
                    <c:choose>
                        <c:when test="${sessionScope.accountSession != null}">
                            <a class="login" href="<c:url value="/signout"/>">Déconnexion</a>
                        </c:when>
                        <c:otherwise>
                            <a class="login" href="<c:url value="/login"/>">Connexion</a>
                        </c:otherwise>
                    </c:choose>
                    <a class="btn btn-light action-button" role="button" href="<c:url value="/register"/>">Créer un compte</a>
                </span>
            </div>
        </div>
    </nav>
</div>



