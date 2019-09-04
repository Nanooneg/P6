<%--
  @Date: 01/09/2019 - 15:35
  @Author: nanoo
--%>
<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Index - DevMode</title>
    <link type="text/css" rel="stylesheet" href="<c:url value="/style/style.css"/>"/>
</head>
<body>
<div align="center">
<form method="post" action="<c:url value="/"/>">
    <fieldset>
        <legend>Test entrée dans la BDD</legend>
        <p>Vous pouvez vous inscrire via ce formulaire.</p>

        <label for="city">Ville <span class="requis">*</span></label>
        <input type="text" id="city" name="city" value="" size="20" maxlength="60"/>
        <br/>

        <label for="postalCode">Code Postal <span class="requis">*</span></label>
        <input type="text" id="postalCode" name="postalCode" value="" size="20" maxlength="20"/>
        <br/>

        <%--<label for="confirmation">Confirmation du mot de passe <span class="requis">*</span></label>
        <input type="password" id="confirmation" name="confirmation" value="" size="20" maxlength="20"/>
        <span class="erreur">${form.erreur['motdepasse']}</span>
        <br/>

        <label for="nom">Nom d'utilisateur</label>
        <input type="text" id="nom" name="nom" value="<c:if test="${!empty form.erreur}"><c:out value="${utilisateur.nom}"/></c:if>" size="20" maxlength="20"/>
        <span class="erreur">${form.erreur['nom']}</span>
        <br/>--%>

        <input type="submit" value="Enregistrer" class="sansLabel"/>
        <br/>
    </fieldset>
</form>
</div>
</body>
</html>
