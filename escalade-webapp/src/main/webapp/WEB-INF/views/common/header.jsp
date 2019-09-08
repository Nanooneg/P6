<%--
  @Date: 30/08/2019 - 16:49
  @Author: nanoo
--%>


<div class="navbar">
    <ul class="nav nav-pills">
        <li class="nav-item">
            <a class="nav-link active" href="<c:url value="/home"/>">Home</a>
        </li>
        <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="<c:url value="/login"/>" role="button" aria-haspopup="true" aria-expanded="false">Account</a>
            <div class="dropdown-menu">
                <a class="dropdown-item" href="<c:url value="/login"/>">S'authentifier</a>
                <a class="dropdown-item" href="<c:url value="/register"/>">S'enregistrer</a>
            </div>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="#">Link</a>
        </li>
        <li class="nav-item">
            <a class="nav-link disabled" href="#">Disabled</a>
        </li>
    </ul>
</div>

