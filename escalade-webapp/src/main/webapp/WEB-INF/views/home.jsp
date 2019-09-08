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

<div class="container-fluid blue">
    <div id="login-box">
        <h3 class="text-center text-info">${message}</h3>
    </div>
</div>
</body>
</html>
