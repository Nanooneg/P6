<%--
  @Date: 08/09/2019 - 15:43
  @Author: nanoo
--%>
<%@ page pageEncoding="UTF-8" %>
<%@include file="common/header.jsp" %>

<section class="container-fluid">
    <div id="message" class="form-box center-box">
        <h1 class="text-center">Bienvenue ${sessionScope.account.firstName}</h1>
    </div>
</section>

<%@include file="common/footer.jsp" %>
