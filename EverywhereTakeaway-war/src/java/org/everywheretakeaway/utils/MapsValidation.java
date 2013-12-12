/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.everywheretakeaway.utils;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import org.everywheretakeaway.controller.ActionFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

/**
 *
 * @author Fede
 */
public class MapsValidation {
    // URL prefix to the geocoder
    private static final String GEOCODER_REQUEST_PREFIX_FOR_XML = "http://maps.google.com/maps/api/geocode/xml";

    private static final Logger logger = Logger.getLogger(ActionFactory.class.getName());

    public static boolean validateAddress(String street, String postalCode, String city, double latitude, double longitude) {
      
        String address = street + ", " + postalCode + " " + city;

        HttpURLConnection conn = null;
        
        // query address
        try {
            // prepare a URL to the geocoder
            URL url = new URL(GEOCODER_REQUEST_PREFIX_FOR_XML + "?address=" + URLEncoder.encode(address, "UTF-8") + "&sensor=false");

            // prepare an HTTP connection to the geocoder
            conn = (HttpURLConnection) url.openConnection();

            Document geocoderResultDocument = null;

            // open the connection and get results as InputSource.
            conn.connect();
            InputSource geocoderResultInputSource = new InputSource(conn.getInputStream());

            // read result and parse into XML Document
            geocoderResultDocument = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(geocoderResultInputSource);


            // prepare XPath
            XPath xpath = XPathFactory.newInstance().newXPath();

            // extract the result
            NodeList resultNodeList = null;

            // c) extract the coordinates of the first result
            resultNodeList = (NodeList) xpath.evaluate("/GeocodeResponse/result[1]/geometry/location/*", geocoderResultDocument, XPathConstants.NODESET);
            float lat = Float.NaN;
            float lng = Float.NaN;
            for(int i=0; i<resultNodeList.getLength(); ++i) {
                Node node = resultNodeList.item(i);
                if("lat".equals(node.getNodeName())) lat = Float.parseFloat(node.getTextContent());
                if("lng".equals(node.getNodeName())) lng = Float.parseFloat(node.getTextContent());
            }
            //System.out.println("lat/lng=" + lat + "," + lng);
            logger.log(Level.INFO, "lat/lng=" + lat + "," + lng);
            
            if(lat != Float.NaN && lng != Float.NaN && Math.abs(lat - latitude) < 0.1 && Math.abs(lng - longitude) < 0.1)
                return true;
            else
                return false;

        } catch(Exception e) {
            logger.log(Level.SEVERE,e.getMessage());
            return false;
        } finally {
          if(conn!= null)
              conn.disconnect();
        }
    
    
    }    
}
