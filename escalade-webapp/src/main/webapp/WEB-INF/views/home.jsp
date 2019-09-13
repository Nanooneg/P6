<%--
  @Date: 08/09/2019 - 15:43
  @Author: nanoo
--%>
<%@ page pageEncoding="UTF-8" %>
<%@include file="common/header.jsp" %>

<div class="container-fluid">
    <div id="center-box">
        <c:if test="${empty registration.result}">
            <h3 class="text-center text-info">${message}</h3>
        </c:if>
        <h3 class="text-center text-info">${registration.result}</h3>
    </div>
</div>

<%@include file="common/footer.jsp" %>
