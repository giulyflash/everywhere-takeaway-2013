<%-- 
    Document   : header
    Created on : 28-nov-2013, 18.30.15
    Author     : Fede
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
		<title>Il Bagaglio: <%=@title%></title>
		<%= javascript_include_tag :defaults %>
		<%= javascript_include_tag 'back' %>
		<%= javascript_include_tag 'jquery.min' %>
		<%= javascript_include_tag 'jquery.quicksearch' %>
		<script type="text/javascript"> 
			$.noConflict();
			jQuery(function () {
				jQuery('input#id_search').quicksearch('table tbody tr');
			});
		</script> 
		
		<%= stylesheet_link_tag 'back', :media => "screen" %>
		<%= stylesheet_link_tag 'printPage', :media => "print" %>
	</head>
	<body>
		<div id="container">
			<!-- Switch interface -->
			<div id="switch">
				<%= link_to image_tag("switch.png", :size => "20x14"), :controller => "front", :action => "scarica_prodotto"%>  <%= link_to "CAMBIA INTERFACCIA", :controller => "front", :action => "scarica_prodotto"%>
			</div>
			<!-- Collection -->
			<div id="collection">
				<% form_tag '/back/collezioni_default_save', :id => "coll" do -%>
					<select id="collection_id" name="collection[id]" >
					<% @app_collections.each { |c| %>
					<% if c.default then%>
						<option value="<%= c.id %>" onClick="javascript:document.getElementById('coll').submit();return false;" selected><%=c.name%></option>
					<% else %>
						<option value="<%= c.id %>" onClick="javascript:document.getElementById('coll').submit();return false;"><%=c.name%></option>
					<% end %>
					<% } %>
					</select>
				<% end -%>
			</div>
			<div class="clear"></div>
			<div id="header">
				<%= image_tag ("IlBagaglio.jpg")%>
			</div>

			<div id="content">
				<div id="bottom"><div id="top">
					<div id="data">
						<%= yield %>
					</div>
				</div></div>
			</div>
			

		</div>
	</body>
</html>
