<%--
  @Date: 16/10/2019 - 11:23
  @Author: nanoo
--%>
<%@ page pageEncoding="UTF-8" %>
<%@include file="common/header.jsp" %>

<section>
    <div id="message-box">
        <div>
            <h1 class="text-center">Vous avez demandé</h1>
        </div>
        <c:if test="${!empty topoBooking}">
            <div class="message-text">
                <p>Le statut de votre demande est indiqué. Si le propriétaire n'a pas encore répondu au bout de 2 semaines,
                    la demande est automatiquement annulée. Vous pourrez la renouveler si vous le souhaitez. Vous pouvez
                annuler vous-même une demande quand vous le voulez.</p>
            </div>
        </c:if>
        <c:forEach items="${topoBooking}" var="tBooking">
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
                    <c:if test="${sessionScope.account.id == tBooking.idAccountBorrower}">
                        <em class="fas fa-minus-circle"></em>
                        <a href="<c:url value="/deleteTopoBooking/${tBooking.idAccountBorrower}/${tBooking.id}"/>" class="text-info-link">
                            Supprimer la demande
                        </a>
                    </c:if>
                </div>
            </div>
        </c:forEach>
        <div class="message-text">
            <p>Nous vous rappelons que Les amis de l'escalade s'engage <em>Seulement</em> à mettre les propriétaires et
                les demandeur en relation.</p>
        </div>
    </div>
</section>

<%@include file="common/footer.jsp" %>
