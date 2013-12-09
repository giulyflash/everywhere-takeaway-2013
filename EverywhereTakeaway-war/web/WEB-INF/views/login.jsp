<%-- 
    Document   : login
    Created on : 6-dic-2013, 16.52.43
    Author     : Fede
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <h2>Login</h2>
        <div id="bolla">
        <form action="send_login.action" method="post">
                        
            <table align="center">
                <tr><td style="text-align: left;">Indirizzo email:</td><td><input type="text" name="email"/></td></tr>
                <tr><td style="text-align: left;">Password:</td><td><input type="password" name="passwd"/></td></tr>   
            </table>
            
            <br/><input type="submit" value="Login"/>
            
            
            
            
        </form>
        </div>
    </body>
</html>
