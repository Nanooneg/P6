<%--
  @Date: 03/10/2019 - 22:43
  @Author: nanoo
--%>
<%@ page pageEncoding="UTF-8" %>
<%@include file="common/header.jsp" %>

<section class="container-fluid">
    <div id="commentary-box">
        <div>
            <h1 class="text-center">Espace commentaire</h1>
        </div>
        <div>
            <a href="<c:url value="/addComment/${publicationId}"/>">
                <input type="button" class="btn-search text-center" value="Ajouter un commentaire">
            </a>
        </div>
        <div>
            <c:forEach items="${listCommentaries}" var="commentary">
                <div class="commentary">
                    <div class="commentary-header">
                        <p>${commentary.key.title} - écrit par ${commentary.value.firstName} <span class="commentary-date">
                                <fmt:formatDate value="${commentary.key.dateOfPublication}" pattern="dd/MM/yyyy HH:mm:ss"/>
                                    <c:if test="${commentary.key.dateOfPublication != commentary.key.dateOfModification}">
                                        - Modifié le <fmt:formatDate value="${commentary.key.dateOfModification}" pattern="dd/MM/yyyy HH:mm:ss"/>
                                    </c:if>
                        </span></p>
                    </div>
                    <div class="commentary-text">
                        <p>${commentary.key.text}</p>
                    </div>
                    <div class="button-display-bar pull-right">
                        <c:if test="${sessionScope.account.id == commentary.key.idAccount
                                    || sessionScope.account.roleName == 'Member'
                                    || sessionScope.account.roleName == 'Administrator'}">
                            <em class="fas fa-pen"></em>
                            <a href="<c:url value="/updateCommentary/${publicationId}/${commentary.key.id}"/>" class="text-info-link">Modifier le commentaire</a>
                        </c:if>
                        <c:if test="${sessionScope.account.id == commentary.key.idAccount
                                    || sessionScope.account.roleName == 'Member'
                                    || sessionScope.account.roleName == 'Administrator'}">
                            <em class="fas fa-minus-circle"></em>
                            <a href="<c:url value="/deleteCommentary/${publicationId}/${commentary.key.id}"/>" class="text-info-link">Supprimer le commentaire</a>
                        </c:if>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
</section>

<%@include file="common/footer.jsp" %>