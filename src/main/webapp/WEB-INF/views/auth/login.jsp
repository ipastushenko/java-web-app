<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Login</title>

        <link href="resources/images/favicon.ico" rel="shortcut icon" type="image/x-icon"/>
        <link href="resources/css/bootstrap.min.css" rel="stylesheet" />
    </head>
    <body>
        <form name="loginForm" action="<c:url value='j_spring_security_check' />" method="POST">
            <input type="text" name="username" />
            <input type="password" name="password" />
            <input type="submit" name="submit" value="Submit" />
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
        </form>
    </body>
</html>