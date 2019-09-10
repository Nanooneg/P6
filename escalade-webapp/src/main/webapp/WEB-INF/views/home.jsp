<%--
  @Date: 08/09/2019 - 15:43
  @Author: nanoo
--%>
<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>welcome</title>

    <%-- css --%>
    <link rel="stylesheet" href="/resources/css/bootstrap.min.css">
    <link rel="stylesheet" href="/resources/css/style.css">
</head>
<body>

<%@include file="common/header.jsp" %>

<div class="container-fluid background">
    <div id="login-box">
        <c:if test="${empty result}">
        <h3 class="text-center text-info">${message}</h3>
        </c:if>
        <h3 class="text-center text-info">${result}</h3>
    </div>
</div>

<%@include file="common/footer.jsp" %>

</body>
</html>
