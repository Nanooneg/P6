<%--
  @Date: 08/09/2019 - 15:43
  @Author: nanoo
--%>
<%@ page pageEncoding="UTF-8" %>
<%@include file="common/header.jsp" %>

<section id="center-boxes" class="container-fluid">
    <div class="row">
        <div class="homepage-box col-md-4 box">
            <div class="form-group">
                <p class="text-info">Bonjour ${sessionScope.account.firstName} ${sessionScope.account.lastName}</p>
            </div>
        </div>
        <div class="homepage-box col-md-8 box">
            <div class="form-group">
                <p class="text-info">test</p>
            </div>
            <div class="form-group">
                <p class="text-info">test</p>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="homepage-box col-md-6 box">
            <div class="form-group">
                <p class="text-info">test</p>
            </div>
            <div class="form-group">
                <p class="text-info">test</p>
            </div><div class="form-group">
            <p class="text-info">test</p>
        </div>
            <div class="form-group">
                <p class="text-info">test</p>
            </div>
        </div>
        <div class="homepage-box col-md-6 box">
            <div class="form-group">
                <p class="text-info">test</p>
            </div>
            <div class="form-group">
                <p class="text-info">test</p>
            </div>
        </div>
    </div>
</section>

<%@include file="common/footer.jsp" %>
