<%--
  @Date: 19/09/2019 - 00:42
  @Author: nanoo
--%>
<%@ page pageEncoding="UTF-8" %>
<%@include file="common/header.jsp" %>

<div id="signout" class="background-custom">
    <div>
        <h2 class="text-center">${sessionScope.accountSession.lastName}, ${message}</h2>
    </div>
    <div class="form-group">
        <a href="<c:url value="/user/unlog"/>" class="form-group">
            <button type="submit" class="btn btn-primary btn-block">${yes}</button>
        </a>
    </div>
    <br/>
    <div class="text-center">
        <a href="<c:out value="javascript:history.go(-1)"/>" class="forgot">${no}</a>
    </div>
</div>

<%@include file="common/footer.jsp" %>
