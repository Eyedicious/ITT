<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="Pagestyler.css">
        <title>JSP Page</title>
    </head>
    <body>
    <c:choose>
        <c:when test="${sessionScope.currentUser != null}">
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
                        Welkom <c:out value="${sessionScope.currentUser.voornaam}"/>
                        <form method="POST" action="uitloggen">
                            <input type="hidden" name="action" value="uitloggen">
                            <input type="submit" value="uitloggen" />
                        </form>
                    </div>
                </div>
                <div class="content">
                        <%= session.getAttribute("productList") %>
                </div>
            </div>
        </c:when>
        <c:otherwise>
            <c:redirect url="index.jsp" />
        </c:otherwise>
    </c:choose>
    </body>
</html>
