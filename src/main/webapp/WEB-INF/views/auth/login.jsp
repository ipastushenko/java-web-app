<%@ include file="../share/libs.jsp" %>
<%@ include file="../share/header.jsp" %>
<form name="loginForm" action="<c:url value='j_spring_security_check' />" method="POST">
    <input type="text" name="username" />
    <input type="password" name="password" />
    <input type="submit" name="submit" value="Submit" />
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
</form>
<%@ include file="../share/footer.jsp" %>