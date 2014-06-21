<%@ include file="../share/libs.jsp" %>
<%@ include file="../share/header.jsp" %>
<div class="container">
    <form class="col-md-4 col-md-offset-4" role="form" name="loginForm" action="<c:url value='j_spring_security_check' />" method="POST">
        <p class="bg-danger">${authErrorMessage}</p>
        <div class="form-group">
            <label for="username">Email</label>
            <input id="username" class="form-control" type="text" name="username" placeholder="Enter your email" />
        </div>
        <div class="form-group">
            <label for="password">Password</label>
            <input id="password" class="form-control" type="password" name="password" placeholder="Password" />
        </div>
        <div class="form-group">
            <input class="btn btn-primary btn-block" type="submit" name="submit" value="Sing In" />
        </div>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
    </form>
</div>
<%@ include file="../share/footer.jsp" %>