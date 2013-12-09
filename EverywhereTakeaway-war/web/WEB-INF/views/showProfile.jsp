<%-- 
    Document   : showProfile
    Created on : 7-dic-2013, 11.11.51
    Author     : Fede
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/everywheretakeaway.tld" prefix="everywheretakeaway" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Profilo</title>
    </head>
    <body>
        
        <everywheretakeaway:print_user_profile user="${user}"/>

    </body>
</html>
