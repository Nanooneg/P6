<%--
  @Date: 13/09/2019 - 17:01
  @Author: nanoo
--%>

<%@ page pageEncoding="UTF-8" %>


<header id="menu" class="page-header">
    <ul class="nav nav-pills pull-left">
        <li><a class="custom-link" href="<c:url value="/"/>">Home</a></li>
        <li><a class="custom-link" href="<c:url value="#"/>">Topo</a></li>
        <li><a class="custom-link" href="<c:url value="#"/>">Site de grimpe</a></li>
    </ul>
    <ul class="nav nav-pills pull-right">
        <c:choose>
            <c:when test="${sessionScope.account != null}">
                <li><a class="custom-link" href="<c:url value="/signout"/>">Unlog</a></li>
            </c:when>
            <c:otherwise>
                <li><a class="custom-link" href="<c:url value="/login"/>">Login</a></li>
            </c:otherwise>
        </c:choose>
        <li><a class="custom-link" href="<c:url value="/register"/>">Register</a></li>
    </ul>
</header>


