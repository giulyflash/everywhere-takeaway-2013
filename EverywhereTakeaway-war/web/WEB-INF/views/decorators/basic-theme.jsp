<%-- 
    Document   : basic-theme
    Created on : 29-nov-2013, 12.17.13
    Author     : Fede
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>
<%@taglib uri="/WEB-INF/everywheretakeaway.tld" prefix="everywheretakeaway" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
        <link href="style.css" rel="stylesheet" type="text/css">
        <title><decorator:title/></title>
    </head>
    <body>
        <div id="login_info">
            <everywheretakeaway:print_login_info sessionName="${name}"/>
        </div>
        
        <div class="clear"></div>
        <div id="header">
            <img src="img/logo_03.png" alt="logo">
        </div>
        <!--inizio menu-->
        <div class="wrapper">
            <ul>
                <li><a href="main.action">index</a></li>
                <li><a href="#">ordine</a></li>
                <li><a href="#">bolla</a></li>
                <li><a href="#">gestione</a></li>
            </ul>
        </div>
        <!-- FINE MENU -->
        <div id="content">
            <div id="bottom"><div id="top">
                <div id="data">
                    <decorator:body />
                </div>
            </div></div>
        </div>
        <div class="clearCol"></div>
        <div id="footer">
                <p>Powered by FLYHIGHWebSolutions</p>
        </div>
        </div>
    </body>
</html>

