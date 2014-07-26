<%@ include file="../share/libs.jsp" %>
<%@ include file="../share/header.jsp" %>
<div class="container">
    <p class="text-center"><a href="<c:url value='/' />">Go to home page</a></p>
    <p class="text-danger text-center">Your email is not confirmed. Please check your email or send confirm information.</p>
    <form class="col-md-4 col-md-offset-4" role="form" name="sendConfirmInfoForm" action="<c:url value='send-confirm-info' />" method="POST">
        <p class="bg-danger">${sendConfirmErrorMessage}</p>
        <div class="form-group">
            <label for="username">Email</label>
            <input id="username" class="form-control" type="text" name="username" placeholder="Enter your email" value="${username}" />
        </div>
        <div class="form-group">
            <input class="btn btn-primary btn-block" type="submit" name="submit" value="Send" />
        </div>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
    </from>
</div>
<%@ include file="../share/footer.jsp" %>