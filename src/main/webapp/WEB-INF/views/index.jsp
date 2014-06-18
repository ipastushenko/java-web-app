<%@ include file="share/libs.jsp" %>
<%@ include file="share/header.jsp" %>
Hello, ${username}! Your ip is ${ip}.
<form name="logoutForm" action="<c:url value='j_spring_security_logout' />" method="POST">
    <input type="submit" name="submit" value="Logout" />
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
</form>
<%@ include file="share/footer.jsp" %>