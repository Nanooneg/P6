<%--
  @Date: 16/10/2019 - 11:23
  @Author: nanoo
--%>
<%@ page pageEncoding="UTF-8" %>
<%@include file="OLDheader.jsp" %>

<section>
    <div id="message-box">
        <div>
            <h1 class="text-center">Demande de prêt</h1>
        </div>
        <div class="topo-booking-message">
            <div class="message-header">
                <h2>Au sujet du topo "${topo.name}"</h2>
            </div>
            <div class="message-text">
                <p>Vous êtes sur le point de demander sur l'on vous prête ce topo. Les amis de l'escalade se
                   contentent de mettre en relation les passionnés. Si le propriétaire accepte, nous vous communiquerons ses
                   coordonnées pour que vous le contactiez directement.</p>
                <p>Vous pourrez voir l'avancée de votre demande dans votre espace personnel.</p>
            </div>
        </div>
        <c:if test="${!empty message}">
            <div>
                <p class="error">${message}</p>
            </div>
        </c:if>
        <div class="text-center">
            <a href="<c:url value="/validAskForLending/${sessionScope.accountSession.id}/${topo.id}"/>">
                <input type="button" class="btn-search text-center" value="Oui, j'ai compris"/></a>
            <a href="<c:url value="/topo/${topo.id}"/>">
                <input type="button" class="btn-search text-center" value="Non, je ne veux pas"/></a>
        </div>
    </div>
</section>

<%@include file="../common/footer.jsp" %>
