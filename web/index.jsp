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
                        <li><button onclick="location.href='newproducts.jsp'">Nieuwe Toevoegingen</button></li>
                        <li><button onclick="location.href='productpage.jsp'">Producten</button></li>
                        <li><button onclick="location.href='winkelwagen.jsp'">Winkelwagen</button></li>
                        <c:if test="${sessionScope.currentUser == null}">
                            <li><button onclick="location.href='registreren.jsp'">Registreren</button>
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
                <%= session.getAttribute("productList") %>
            </div>
        </div>
    </body>
</html>
