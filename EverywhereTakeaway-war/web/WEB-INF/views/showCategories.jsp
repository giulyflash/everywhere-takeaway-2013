<%-- 
    Document   : showCategories
    Created on : 11-dic-2013, 19.02.26
    Author     : Fede
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/everywheretakeaway.tld" prefix="everywheretakeaway" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Categorie</title>
    </head>
    <body>
        <everywheretakeaway:print_categories categories="${categories}"/>
    </body>
</html>
