<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page session="false" contentType="text/html; charset=UTF-8" %>

<html>

    <head>

        <title>Spittr</title>
        <link rel='stylesheet'
              href='<c:url value="/resources/css/style.css" />'
              type='text/css'
              media='all' />
    </head>

    <body>

        <h1>Twój profil:</h1>
        <c:out value="${spitter.username}" /><br/>
        <c:out value="${spitter.firstName}" />
        <c:out value="${spitter.lastName}" />

    </body>

</html>