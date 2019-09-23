<%--
  @Date: 19/09/2019 - 00:42
  @Author: nanoo
--%>
<%@ page pageEncoding="UTF-8" %>
<%--<%@include file="common/sessionChecking.jsp" %>  TODO delete this and replace header by include--%>
<!DOCTYPE html>
<html>
<head>

    <title>Escalade</title>

    <%-- css --%>
    <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css"/>">
    <link rel="stylesheet" href="<c:url value="/resources/css/style.css"/>">

</head>
<body>
<div class="wrapper">

    <header id="menu" class="page-header">
        <ul class="nav nav-pills pull-left">
            <li><a class="custom-link" href="<c:url value="/"/>" disabled="true">Home</a></li>
            <li><a class="custom-link" href="<c:url value="#"/>" disabled="true">Topo</a></li>
            <li><a class="custom-link" href="<c:url value="#"/>" disabled="true">Site de grimpe</a></li>
        </ul>
        <ul class="nav nav-pills pull-right">
            <c:choose>
                <c:when test="${sessionScope.account != null}">
                    <li><a class="custom-link" href="<c:url value="/signout"/>" disabled="true">Unlog</a></li>
                </c:when>
                <c:otherwise>
                    <li><a class="custom-link" href="<c:url value="/login"/>" disabled="true">Login</a></li>
                </c:otherwise>
            </c:choose>
            <li><a class="custom-link" href="<c:url value="/register"/>" disabled="true">Register</a></li>
        </ul>
    </header>

    <section class="container-fluid">
        <div id="center-box">
            <div class="form-group">
                <h2 class="text-center text-info">${sessionScope.account.firstName}, vous nous quittez déjà?</h2>

                <br/><br/>
                <div class="text-center">
                    <a href="<c:url value="/unlog"/>" class="form-group">
                        <button type="submit" class="btn btn-info btn-lg">Oui, je dois partir</button>
                    </a>
                </div>

                <br/>
                <div id="register-link" class="text-center">
                    <a href="<c:out value="javascript:history.go(-1)"/>" class="text-info">Non je reste encore un peu</a>
                </div>
            </div>
        </div>
    </section>

<%@include file="common/footer.jsp" %>
