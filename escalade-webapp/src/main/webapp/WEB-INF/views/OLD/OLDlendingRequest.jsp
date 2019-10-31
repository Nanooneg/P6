<%--
  @Date: 16/10/2019 - 11:23
  @Author: nanoo
--%>
<%@ page pageEncoding="UTF-8" %>
<%@include file="OLDheader.jsp" %>

<section>
    <div id="message-box">
        <div class="big-title">
            <h1 class="text-center">Prêt de topo</h1><br/>
        </div><br/>
        <c:if test="${!empty topoBookingReceived}">
            <div>
                <h1 class="text-center">On vous demande</h1>
            </div>
            <div class="message-text">
                <p>Un utilisateur du site souhaite vous emprunter votre topo. Si vous accepter, nous lui donnerons
                    vos coordonnées et nous passerons le statut du topo en "non disponible".</p>
            </div>
        </c:if>
        <c:forEach items="${topoBookingReceived}" var="tBooking">
            <div class="topo-booking-answer row test">
                <div class="message-text col-md-12">
                    <h2>Au sujet du topo "${tBooking.idTopo}" - Statut : <span class="
                        <c:choose>
                            <c:when test="${tBooking.status == 'Accepté'}">accepted</c:when>
                            <c:when test="${tBooking.status == 'Refusé'}">refused</c:when>
                            <c:otherwise>pending</c:otherwise>
                        </c:choose>
               ">${tBooking.status}</span>
                </div>
                <c:if test="${tBooking.status == 'En attente'}">
                    <div class="message-validation col-md-12">
                        <a href="<c:url value="/validLendingRequest/${sessionScope.accountSession.id}/${tBooking.id}/acceptance"/>">
                            <input type="button" class="btn-search text-center" value="j'accepte"/></a>
                        <a href="<c:url value="/validLendingRequest/${sessionScope.accountSession.id}/${tBooking.id}/refusal"/>">
                            <input type="button" class="btn-search text-center" value="Je refuse"/></a>
                    </div>
                </c:if>
            </div>
        </c:forEach>
        <div class="message-text">
            <p>Nous vous rappelons qu'après le retour d'un topo, vous devez changer vous-même son
                statut si vous désirez le rendre de nouveau disponible pour les autres utilisateurs. Merci.</p>
        </div>
        <c:if test="${!empty topoBookingSent}">
            <div>
                <h1 class="text-center">Vous avez demandé</h1>
            </div>
            <div class="message-text">
                <p>Le statut de votre demande est indiqué. Si le propriétaire n'a pas encore répondu au bout de 2 semaines,
                    la demande est automatiquement annulée. Vous pourrez la renouveler si vous le souhaitez. Vous pouvez
                    annuler vous-même une demande quand vous le voulez.</p>
            </div>
        </c:if>
        <c:forEach items="${topoBookingSent}" var="tBooking">
            <div class="topo-booking-answer row test">
                <div class="message-text col-md-12">
                    <h2>Au sujet du topo "${tBooking.idTopo}" - Statut : <span class="
                            <c:choose>
                                <c:when test="${tBooking.status == 'Accepté'}">accepted</c:when>
                                <c:when test="${tBooking.status == 'Refusé'}">refused</c:when>
                                <c:otherwise>pending</c:otherwise>
                            </c:choose>
                    ">${tBooking.status}</span>
                        <c:if test="${tBooking.status == 'Accepté'}">- ${tBooking.ownerMail}</c:if> </h2>
                </div>
                <div class="button-display-bar pull-right">
                    <c:if test="${sessionScope.accountSession.id == tBooking.idAccountBorrower}">
                        <em class="fas fa-minus-circle"></em>
                        <a href="<c:url value="/deleteTopoBooking/${tBooking.idAccountBorrower}/${tBooking.id}"/>" class="text-info-link">
                            Supprimer la demande
                        </a>
                    </c:if>
                </div>
            </div>
        </c:forEach>
    </div>
</section>

<%@include file="../common/footer.jsp" %>
