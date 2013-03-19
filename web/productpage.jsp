



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
                    <a href="index.jsp"><img border="0" src="/logo.png" alt="home"></a>
                </div>
                <div class="menu">
                    <ul>
                        <a href="newproducts.jsp"><li>Nieuwe toevoegingen</li></a>
                        <a href="productpage.jsp"><li>Producten</li></a>
                        <a href="winkelwagen.jsp"><li>Winkelwagen</li></a>
                        <c:if test="${sessionScope.currentUser == null}">
                            <button onclick="location.href='registreren.jsp'">Registreren</button>
                        </c:if>
                    </ul>
                </div>
                <div id="login">
                    <form method="POST" action="inloggen">
                        Username: <input type="text" id="user" /><br />
                        Wachtwoord: <input type="password" id="pass" /><br />
                        <input type="submit" value="Inloggen" style="margin-right: 40px;"/>
                    </form>
                </div>
            </div>
            <div class="content">
                <%= session.getAttribute("productList")%>
            </div>

        </div>
    </body>
</html>
