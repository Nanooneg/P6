<%--
  @Date: 16/10/2019 - 11:23
  @Author: nanoo
--%>
<%@ page pageEncoding="UTF-8" %>
<%@include file="common/header.jsp" %>

<section>
    <div id="message-box">
        <div>
            <h1 class="text-center">On vous demande</h1>
        </div>
        <c:if test="${!empty topoBooking}">
            <div class="message-text">
                <p>Un utilisateur du site souhaite vous emprunter votre topo. Si vous accepter, nous lui donnerons
                    vos coordonnées et nous passerons le statut du topo en "non disponible".</p>
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
                </div>
                <c:if test="${tBooking.status == 'En attente'}">
                    <div class="message-validation col-md-12">
                        <a href="<c:url value="/validLendingRequest/${sessionScope.account.id}/${tBooking.id}/acceptance"/>">
                            <input type="button" class="btn-search text-center" value="j'accepte"/></a>
                        <a href="<c:url value="/validLendingRequest/${sessionScope.account.id}/${tBooking.id}/refusal"/>">
                            <input type="button" class="btn-search text-center" value="Je refuse"/></a>
                    </div>
                </c:if>
            </div>
        </c:forEach>
        <div class="message-text">
            <p>Nous vous rappelons qu'après le retour d'un topo, vous devez changer vous-même son
                statut si vous désirez le rendre de nouveau disponible pour les autres utilisateurs. Merci.</p>
        </div>
    </div>
</section>

<%@include file="common/footer.jsp" %>
