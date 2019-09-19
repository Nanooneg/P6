<%--
  @Date: 19/09/2019 - 00:56
  @Author: nanoo
--%>
<%@ page pageEncoding="UTF-8" %>

<%
    session = request.getSession();
    if (session.getAttribute("account") == null || session.getAttribute("account") == "")
        response.sendRedirect("/login");
%>