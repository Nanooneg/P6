<%--
  @Date: 05/10/2019 - 12:27
  @Author: nanoo
--%>
<%@ page pageEncoding="UTF-8" %>
<%@include file="common/header.jsp" %>

<section>
    <div id="commentary-form" class="center-box form-box">
        <form:form action="/saveComment/${publicationId}/${commentaryId}" method="post" modelAttribute="commentary">
            <h1 class="text-center">Ajouter un commentaire</h1>
            <div>
                <c:if test="${empty message}"><br/></c:if>
                <h4 class="text-center error">${message}</h4>
            </div>
            <div class="textbox">
                <form:input path="title" placeholder="Titre" required="true" maxlength="30"/>
                <form:errors path="title" cssClass="error"/>
            </div>
            <div class="textbox">
                <form:textarea path="text" placeholder="Commentaire" required="true"
                               rows="5" cols="35" maxlength="300"/>
                <form:errors path="text" cssClass="error"/>
            </div>
            <div>
                <input type="submit" name="submit" class="btn-form text-center" value="Enregistrer">
            </div>
        </form:form>
    </div>
</section>

<%@include file="common/footer.jsp" %>