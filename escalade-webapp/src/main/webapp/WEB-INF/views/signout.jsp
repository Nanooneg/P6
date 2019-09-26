<%--
  @Date: 19/09/2019 - 00:42
  @Author: nanoo
--%>
<%@ page pageEncoding="UTF-8" %>
<%@include file="common/header.jsp" %>

<section class="container-fluid">
    <div id="signout" class="form-box center-box">
        <div>
            <h2 class="text-center">${sessionScope.account.firstName}, vous nous quittez déjà?</h2>
        </div>
        <div class="text-center">
            <a href="<c:url value="/unlog"/>" class="form-group">
                <button type="submit" class="btn-form">Oui, je dois partir</button>
            </a>
        </div>
        <br/>
        <div class="text-center">
            <a href="<c:out value="javascript:history.go(-1)"/>" class="text-info-link">Non je reste encore un peu</a>
        </div>

    </div>
</section>

<%@include file="common/footer.jsp" %>
