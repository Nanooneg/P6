<%--
  @Date: 19/09/2019 - 00:42
  @Author: nanoo
--%>
<%@ page pageEncoding="UTF-8" %>
<%@include file="common/header.jsp" %>

<section class="container-fluid">
    <div id="signout" class="form-box center-box">
        <div>
            <h2 class="text-center">${sessionScope.account.lastName}, ${message}</h2>
        </div>
        <div class="text-center">
            <a href="<c:url value="/unlog"/>" class="form-group">
                <button type="submit" class="btn-form">${yes}</button>
            </a>
        </div>
        <br/>
        <div class="text-center">
            <a href="<c:out value="javascript:history.go(-1)"/>" class="text-info-link">${no}</a>
        </div>

    </div>
</section>

<%@include file="common/footer.jsp" %>
