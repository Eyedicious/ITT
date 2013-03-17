



<!DOCTYPE html>
<html>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="Pagestyler.css">
        <title>JSP Page</title>
    </head>
    <body>
        <div id="background">
            <div class="toprow">
                <div class="logo">
                    <a href="index.jsp"><img id="logo" border="0" src="Logo.png" alt="home"></a>
                </div>
                <div class="menu">
                    <ul>
                        <button onclick="location.href='newproducts.jsp'">Nieuwe Toevoegingen</button>
                        <button onclick="location.href='productpage.jsp'">Producten</button>
                        <button onclick="location.href='winkelwagen.jsp'">Winkelwagen</button>
                        <c:if test="${sessionScope.currentUser == null}">
                            <button onclick="location.href='registreren.jsp'">Registreren</button>
                        </c:if>
                    </ul>
                </div>
                <div id="login">
                    <c:choose>
                        <c:when test="${sessionScope.currentUser == null}">
                                <form method="POST" name="inloggen" action="inloggen">
                                    <label>Username </label><input type="text" name="loginnaam" /><br />
                                    <label>Wachtwoord </label><input type="password" name="wachtwoord" /><br />
                                    <input type="hidden" name="action" value="inloggen">
                                    <input type="submit" value="Inloggen"/><br />
                                </form>
                        </c:when>
                        <c:otherwise>
                                Welkom <c:out value="${sessionScope.currentUser.voornaam}"/>
                                <form method="POST" action="uitloggen">
                                    <input type="hidden" name="action" value="uitloggen">
                                    <input type="submit" value="uitloggen" />
                                </form>
                        </c:otherwise>
                    </c:choose>
                </div>
            </div>
            <div class="content">
                <div id="registreren">
                    <form method="POST" action="registreren">
                        <label>Voornaam </label><input type="text" name="voornaam" /><br />
                        <label>Tussenvoegsel </label><input type="text" name="tussenvoegsel" /><br />
                        <label>Achternaam </label><input type="text" name="achternaam" /><br />
                        <label>Email </label><input type="text" name="email" /><br />
                        <label>Username </label><input type="text" name="loginnaam" /><br />
                        <label>Wachtwoord </label><input type="password" name="wachtwoord" /><br />
                        <label>Wachtwoord herhalen </label><input type="password" name="wachtwoord2" /><br />
                        <input type="hidden" name="action" value="registreren" /><br />
                        <input type="submit" value="Registreren"/>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
