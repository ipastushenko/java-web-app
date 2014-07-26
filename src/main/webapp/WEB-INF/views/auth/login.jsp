<%@ include file="../share/libs.jsp" %>
<%@ include file="../share/header.jsp" %>
<div class="container">
    <div class="col-md-4 col-md-offset-4">
        <form role="form" name="loginForm" action="<c:url value='j_spring_security_check' />" method="POST">
            <c:if test="${authErrorMessage != null}">
                <p id="auth-error-message" class="bg-danger">
                    ${authErrorMessage}
                    <button id="close-auth-error-message" type="button" class="close pull-right">
                        <span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
                    </button>
                </p>
            </c:if>
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
        <a href="<c:url value='registration'/>" class="btn btn-default btn-block">Sing Up</a>
    </div>
</div>
<script src="resources/js/lib/jquery-2.1.1.min.js"></script>
<script src="resources/js/login.js"></script>
<%@ include file="../share/footer.jsp" %>