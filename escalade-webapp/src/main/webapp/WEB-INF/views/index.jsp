<%--
  @Date: 01/09/2019 - 15:35
  @Author: nanoo
--%>
<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Index - DevMode</title>
</head>
<body>
<h2>${message}</h2>
<%--<div align="center">
    <h2>Interface de test</h2>
    <form method="get" action="search">
        <input type="text" name="keyword" /> &nbsp;
        <input type="submit" value="Search" />
    </form>
    <h3><a href="/new">Ville</a></h3>
    <table border="1" cellpadding="5">
        <tr>
            <th>ID</th>
            <th>Code Postal</th>
            <th>Ville</th>
        </tr>
        <c:forEach items="${cityList}" var="customer">
            <tr>
                <td>${customer.id}</td>
                <td>${customer.postalCode}</td>
                <td>${customer.city}</td>
&lt;%&ndash;                <td>
                    <a href="/edit?id=${customer.id}">Edit</a>
                    &nbsp;&nbsp;&nbsp;
                    <a href="/delete?id=${customer.id}">Delete</a>
                </td>&ndash;%&gt;
            </tr>
        </c:forEach>
    </table>
</div>--%>
</body>
</html>
