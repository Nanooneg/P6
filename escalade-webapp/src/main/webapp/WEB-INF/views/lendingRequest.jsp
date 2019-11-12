<%--
  @Date: 16/10/2019 - 11:23
  @Author: nanoo
--%>
<%@ page pageEncoding="UTF-8" %>
<%@include file="common/header.jsp" %>

<div class="container-fluid">
    <div id="message-box" class="publication-dark background-custom">
        <div>
            <h1 class="text-center">Prêt de topo</h1><br/>
        </div><br/>
        <c:if test="${!empty topoBookingReceived}">
            <div class="lending-title">
                <c:choose>
                    <c:when test="${topoBookingReceived.size() == 1}"><h1 class="text-center">Demande reçue</h1></c:when>
                    <c:otherwise><h1 class="text-center">Demandes reçues</h1></c:otherwise>
                </c:choose>
            </div>
            <div class="message-text">
                <p>Un utilisateur du site souhaite vous emprunter votre topo. Si vous accepter, nous lui donnerons
                    vos coordonnées et nous passerons le statut du topo en "non disponible".</p>
            </div>
        </c:if>
        <c:forEach items="${topoBookingReceived}" var="tBooking">
            <c:if test="${tBooking.status == 'En attente'}">
                <div class="message row">
                    <div class="message-header col-md-12 text-center">
                        <div>
                            <h2>Demande n° ${tBooking.id}</h2>
                        </div>
                        <div>
                            <h2>Statut : <span class="
                        <c:choose>
                            <c:when test="${tBooking.status == 'Accepté'}">accepted</c:when>
                            <c:when test="${tBooking.status == 'Refusé'}">refused</c:when>
                            <c:otherwise>pending</c:otherwise>
                        </c:choose>
                        ">${tBooking.status}</span></h2>
                        </div>
                    </div>
                    <c:if test="${tBooking.status == 'En attente'}">
                        <div class="col-md-12 form-group row message-button">
                            <div class="col-md-2 offset-md-4 col-sm-12">
                                <a href="<c:url value="/user/validLendingRequest/${sessionScope.accountSession.id}/${tBooking.id}/acceptance"/>">
                                    <button type="button" class="btn btn-primary btn-block">Oui, j'ai compris</button></a>
                            </div>
                            <div class="col-md-2 col-sm-12">
                                <a href="<c:url value="/user/validLendingRequest/${sessionScope.accountSession.id}/${tBooking.id}/refusal"/>">
                                    <button type="button" class="btn btn-primary btn-block">Non, merci</button></a>
                            </div>
                        </div>
                    </c:if>
                </div>
            </c:if>
        </c:forEach>
        <div class="message-text">
            <p>Nous vous rappelons qu'après le retour d'un topo, vous devez changer vous-même son
                statut si vous désirez le rendre de nouveau disponible pour les autres utilisateurs. Merci.</p>
        </div>
        <c:if test="${!empty topoBookingSent}">
            <div class="lending-title">
                <c:choose>
                    <c:when test="${topoBookingSent.size() == 1}"><h1 class="text-center">Demande envoyée</h1></c:when>
                    <c:otherwise><h1 class="text-center">Demandes envoyées</h1></c:otherwise>
                </c:choose>
            </div>
            <div class="message-text">
                <p>Le statut de votre demande est indiqué. Si le propriétaire n'a pas encore répondu au bout de 2 semaines,
                    la demande est automatiquement annulée. Vous pourrez la renouveler si vous le souhaitez. Vous pouvez
                    annuler vous-même une demande quand vous le voulez.</p>
            </div>
        </c:if>
        <c:forEach items="${topoBookingSent}" var="tBooking">
            <div class="message row">
                <div class="message-header col-md-12">
                    <div>
                        <h2>Demande n° ${tBooking.idTopo}</h2>
                    </div>
                    <div>
                        <h2>Statut : <span class="
                            <c:choose>
                                <c:when test="${tBooking.status == 'Accepté'}">accepted</c:when>
                                <c:when test="${tBooking.status == 'Refusé'}">refused</c:when>
                                <c:otherwise>pending</c:otherwise>
                            </c:choose>
                    ">${tBooking.status}</span></h2>
                    </div>
                    <c:if test="${tBooking.status == 'Accepté'}"><div><h2>${tBooking.ownerMail}</h2></div></c:if>
                </div>
                <div class="icon-bar col-md-12">
                    <div class="d-none d-md-block">
                        <a href="<c:url value="/user/deleteTopoBooking/${tBooking.idAccountBorrower}/${tBooking.id}"/>" class="text-info-link">
                            <em class="fas fa-minus-circle"></em> Supprimer la demande
                        </a>
                    </div>
                    <div class="d-sm-block d-md-none icon-only">
                        <a href="<c:url value="/user/deleteTopoBooking/${tBooking.idAccountBorrower}/${tBooking.id}"/>" class="text-info-link">
                            <em class="fas fa-minus-circle"></em>
                        </a>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</div>

<%@include file="common/footer.jsp" %>
