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
        <script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAjGEQ6BF00o39sTHlrzI6ZJffi_KtSwtc&sensor=false"></script>
        <script>
            var geocoder;
            
            function initialize() {
                geocoder = new google.maps.Geocoder();
            }
        </script>
        <decorator:head />
    </head>
    <body onload="initialize()">
        <div id="login_info">
            <everywheretakeaway:print_login_info sessionName="${name}"/>
        </div>
        
        <div class="clear"></div>
        <div id="header">
            <img src="img/logo_03.png" alt="logo">
        </div>
        <!--inizio menu-->
        <everywheretakeaway:print_menu type="${type}"/>
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
        </div>
        </div>
    </body>
</html>

