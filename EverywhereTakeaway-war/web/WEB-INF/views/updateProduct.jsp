<%-- 
    Document   : updateProduct
    Created on : 16-dic-2013, 17.53.17
    Author     : Fede
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/everywheretakeaway.tld" prefix="everywheretakeaway" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modifica prodotto</title>
    </head>
    <body>
        <h2>Modifica prodotto</h2>
        <div id="bolla">
            
            <form method="post" action="send_update_product.action"> 

                <input id="product_id" type="hidden" name="product_id" value="${product.getId()}"/>

                <table align="center">
                    <tr><td style="text-align: left;">Categoria:</td><td><everywheretakeaway:print_categories_select list="${categories}" selected_id="${product.getCategory().getId()}"/></td></tr>  
                    <tr><td style="text-align: left;">Nome:</td><td><input type="text" name="name" value="${product.getName()}"/></td></tr>
                    <tr><td style="text-align: left;">Prezzo:</td><td><input type="text" name="price" value="${product.getPrice()}"/></td></tr>
                    <tr><td style="text-align: left;">Descrizione:</td><td><textarea name="description">${product.getDescription()}</textarea></td></tr> 

                </table>    


                <br/><input type="submit" value="Modifica"/>




            </form>
        </div>
                    
        <div class='clear'></div>
        
        <br/><br/>  
        
        <h2>Modifica immagine</h2>
        <div id='bolla'>
            
            <form action='upload_product_picture.action?product_id=${product.getId()}&upload_type=product&upload_name=${product.getId()}' method='post' enctype='multipart/form-data'>
                
                
                <input type='file' name='file' size='50' />
                <br/>
                <input type='submit' value='Carica' />
            </form>
        </div>
                    
                    
                    
                    
    </body>
</html>
