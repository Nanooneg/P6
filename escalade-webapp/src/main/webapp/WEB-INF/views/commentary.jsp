<%--
  @Date: 04/10/2019 - 22:43
  @Author: nanoo
--%>
<%@ page pageEncoding="UTF-8" %>
<%@include file="common/header.jsp" %>

<s:url value="/topo" var="topo"/>
<s:url value="/site" var="spot"/>

<div class="container-fluid">
    <div id="commentary-box" class="publication-dark background-custom">
        <div>
            <h1 class="text-center">Espace commentaire</h1>
        </div>
        <div class="form-group row">
            <div class="col-md-2 offset-md-4 col-sm-12">
                <a href="<c:url value="/user/addComment/${publicationType}/${publicationId}"/>">
                    <button type="button" class="btn btn-primary btn-block">Commenter</button>
                </a>
            </div>
            <div class="col-md-2 col-sm-12">
                <a href="<c:url value="${publicationType.equals('topo') ? topo : spot}/${publicationId}"/>">
                    <button type="button" class="btn btn-primary btn-block">Revenir au ${publicationType}</button>
                </a>
            </div>
        </div>
        <div>
            <c:forEach items="${listCommentaries}" var="commentary">
                <div class="commentary">
                    <div class="commentary-header">
                        <div>
                            ${commentary.key.title}
                        </div>
                        <div class="commentary-date">
                            ${commentary.value.firstName} le <fmt:formatDate value="${commentary.key.dateOfPublication}" pattern="dd/MM/yyyy HH:mm:ss"/>
                        </div>
                        <c:if test="${commentary.key.dateOfPublication != commentary.key.dateOfModification}">
                            <div class="commentary-date">
                                Modifié le <fmt:formatDate value="${commentary.key.dateOfModification}" pattern="dd/MM/yyyy HH:mm:ss"/>
                            </div>
                        </c:if>
                    </div>
                    <div class="commentary-text">
                        <p>${commentary.key.text}</p>
                    </div>
                    <div class="icon-bar">
                        <div class="d-none d-md-block">
                            <c:if test="${sessionScope.accountSession.id == commentary.key.idAccount
                                    || sessionScope.accountSession.roleName == 'Member'
                                    || sessionScope.accountSession.roleName == 'Administrator'}">
                                <a href="<c:url value="/user/updateCommentary/${publicationType}/${publicationId}/${commentary.key.id}"/>" class="text-info-link">
                                    <em class="fas fa-pen"></em> Modifier le commentaire</a>
                            </c:if>
                        </div>
                        <div class="d-none d-md-block">
                            <c:if test="${sessionScope.accountSession.id == commentary.key.idAccount
                                    || sessionScope.accountSession.roleName == 'Member'
                                    || sessionScope.accountSession.roleName == 'Administrator'}">
                                <a href="<c:url value="/user/deleteCommentary/${publicationType}/${publicationId}/${commentary.key.id}"/>" class="text-info-link">
                                    <em class="fas fa-minus-circle"></em> Supprimer le commentaire</a>
                            </c:if>
                        </div>
                        <div class="d-sm-block d-md-none icon-only">
                            <c:if test="${sessionScope.accountSession.id == commentary.key.idAccount
                                    || sessionScope.accountSession.roleName == 'Member'
                                    || sessionScope.accountSession.roleName == 'Administrator'}">
                                <a href="<c:url value="/user/updateCommentary/${publicationType}/${publicationId}/${commentary.key.id}"/>" class="text-info-link">
                                    <em class="fas fa-pen"></em></a>
                            </c:if>
                        </div>
                        <div class="d-sm-block d-md-none icon-only">
                            <c:if test="${sessionScope.accountSession.id == commentary.key.idAccount
                                    || sessionScope.accountSession.roleName == 'Member'
                                    || sessionScope.accountSession.roleName == 'Administrator'}">
                                <a href="<c:url value="/user/deleteCommentary/${publicationType}/${publicationId}/${commentary.key.id}"/>" class="text-info-link">
                                    <em class="fas fa-minus-circle"></em></a>
                            </c:if>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
</div>

<%@include file="common/footer.jsp" %>