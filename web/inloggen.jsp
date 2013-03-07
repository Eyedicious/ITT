<%-- 
    Document   : inloggen
    Created on : 3-mrt-2013, 13:48:52
    Author     : Bart
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form name="regUser" method="POST" action="registreren">
            Gebruikersnaam:         <input type="text" name="regname" value=""/></br>
            Wachtwoord:             <input type="password" name="password1" value=""/></br>
            Wachtwoord bevestigen:  <input type="password" name="password2" value=""/></br>
            <input type="submit"/>
        </form>
            
        <form name="loginUser" method="POST" action="inloggen">
            Gebruikersnaam:         <input type="text" name="loginname" value=""/></br>
            Wachtwoord:             <input type="password" name="password" value=""/></br>
            <input type="submit"/>
        </form>
        
    </body>
</html>
