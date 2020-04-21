<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

        <h1>Rejestracja</h1>
        <form method="post">
            Imię: <input type="text" name="firstName" /><br/>
            Nazwisko: <input type="text" name="lastName" /><br/>
            Nazwa użytkownika: <input type="text" name="username" /><br/>
            Hasło: <input type="text" name="password" /><br/>
            <input type="submit" name="Zarejestruj" /><br/>
        </form>

    </body>

</html>