<%-- 
    Document   : menu
    Created on : 28-nov-2013, 18.31.15
    Author     : Fede
--%>

<!--inizio menu-->
<div id="navigation">
        <ul id="nav">
                <li><%= link_to "index", :controller => "back", :action => "index" %></li>
                <li><a href="#">ordine</a>
                        <ul>
                                <li id="first"><%= link_to "inserisci", :controller => "back", :action => "inserimento_start" %></li>
                        </ul>
                <li><a href="#">bolla</a>
                        <ul>
                                <li id="first"><%= link_to "spunta per ordine", :controller => "back", :action => "carica_inserimenti" %></li>
                                <li><%= link_to "spunta singolo capo", :controller => "back", :action => "load_single_code" %></li>
                                <li><%= link_to "spunta aggregata modello", :controller => "back", :action => "load_code_product" %></li>
                        </ul>
                </li>
                <li><a href="#">gestione</a>
                        <ul>
                                <li id="first"><%= link_to "marchi", :controller => "back", :action => "edit_brands" %></li>
                                <li><%= link_to "modelli", :controller => "back", :action => "edit_items" %></li>
                                <li><%= link_to "capi", :controller => "back", :action => "gestione_prodotti" %></li>							
                        </ul>
                </li>
                <li><a href="#">visualizza</a>
                        <ul>
                                <li id="first"><%= link_to "ordini", :controller => "back", :action => "inserimenti" %></li>
                                <li><%= link_to "magazzino globale", :controller => "back", :action => "magazzino_globale_scegli" %></li>
                        </ul>
                </li>
                <li><a href="#">statistiche</a>
                        <ul>
                                <li id="first"><%= link_to "vendita", :controller => "back", :action => "statistiche_vendita" %></li>
                                <li><%= link_to "acquisti", :controller => "back", :action => "statistiche_acquisti" %></li>
                                <li><%= link_to "magazzino", :controller => "back", :action => "statistiche_magazzino" %></li>
                                <li><%= link_to "margini", :controller => "back", :action => "statistiche_margini" %></li>
                                <li><%= link_to "resi fornitore", :controller => "back", :action => "statistiche_reso_selezione" %></li>
                                <li><%= link_to "autoconsumo", :controller => "back", :action => "statistiche_autoconsumo" %></li>
                        </ul>
                </li>
                <li><a href="#">impostazioni</a>
                        <ul>
                                <li id="first"><%= link_to "collezioni", :controller => "back", :action => "collezioni_default" %></li>
                                <li><%= link_to "reso fornitore", :controller => "back", :action => "reso_fornitore" %></li>
                        </ul>
                </li>
                <li><a href="#">fine stagione</a>
                        <ul>
                                <li id="first"><%= link_to "Resoconto", :controller => "back", :action => "scegli_resoconto_stockista" %></li>
                                <li><%= link_to "Scaricamento", :controller => "back", :action => "scarica_prodotto_stockista" %></li>
                                <li><%= link_to "Termina stagione", :controller => "back", :action => "termina" %></li>
                        </ul>
                </li>
                <li id="last"><%= link_to "vetrina", :controller => "back", :action => "vetrina" %></li>
                <li><a href="#">fidelity</a>
                        <ul>
                                <li id="first"><%= link_to "crea tessera", :controller => "back", :action => "inserisci_fidelity" %></li>
                                <li><%= link_to "gestisci", :controller => "back", :action => "visualizza_fidelity" %></li>
                        </ul>
                </li>
        </ul>
</div>
<!-- FINE MENU -->
