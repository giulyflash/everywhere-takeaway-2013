<%-- 
    Document   : basic-theme
    Created on : 29-nov-2013, 12.17.13
    Author     : Fede
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
        <link href="style.css" rel="stylesheet" type="text/css">
    </head>
    <body>
        <div class="clear"></div>
        <div id="header">
            <img src="img/IlBagaglio.jpg" alt="logo">
        </div>
        <!--inizio menu-->
        <div id="navigation">
            <ul id="nav">
                <li><a href="#">index</a>
                <li><a href="#">ordine</a>
                    <ul>
                        <li id="first"><li><a href="#">index</a></li>
                    </ul>
                <li><a href="#">bolla</a>
                    <ul>
                        <li id="first"><li><a href="#">index</a></li>
                        <li><li><a href="#">index</a></li>
                    </ul>
                </li>
                <li><a href="#">gestione</a>
                    <ul>
                        <li id="first"><li><a href="#">index</a></li>
                        <li><li><a href="#">index</a></li>
                        <li><li><a href="#">index</a></li>							
                    </ul>
                </li>

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

