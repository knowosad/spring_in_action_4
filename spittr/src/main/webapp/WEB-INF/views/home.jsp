<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page session="false" %>

<html>

    <head>

        <title>Spittr</title>
        <link rel='stylesheet'
              href='<c:url value="/resources/css/style.css" />'
              type='text/css'
              media='all' />
    </head>

    <body>

        <h1>Witamy w serwisie Spittr</h1>
        <a href="<c:url value="/spittles" />">Spittle</a>
        <a href="<c:url value="/spitter/register" />">Rejestracja</a>

    </body>

</html>