/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.everywheretakeaway.business.ws;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import org.everywheretakeaway.business.beans.CategoryManager;
import org.everywheretakeaway.business.beans.ProductManager;
import org.everywheretakeaway.business.beans.RestaurantManager;
import org.everywheretakeaway.model.Category;
import org.everywheretakeaway.model.Product;
import org.everywheretakeaway.model.Restaurant;

/**
 *
 * @author Fede
 */
@WebService(serviceName = "EverywhereTakeawayWS")
@Stateless()
public class EverywhereTakeawayWS {
    
    @EJB
    private RestaurantManager ejbRestaurantRef;
    
    @EJB
    private CategoryManager ejbCategoryRef;
    
    @EJB
    private ProductManager ejbProductRef;

    
    @WebMethod(operationName = "findAvailableRestaurants")
    public List<String> findAvailableRestaurants(@WebParam(name = "latitude") Double latitude, @WebParam(name = "longitude") Double longitude) {
        
        
        List<String> result = new LinkedList();
        
        Iterator<Restaurant> iterator = ejbRestaurantRef.findAvailable(latitude, longitude).iterator();
        Restaurant current;
        
        while(iterator.hasNext()) {
        
            current = iterator.next();
            
            result.add(String.valueOf(current.getId()));
            result.add(current.getName());
            result.add(current.getPhone());
            result.add(current.getAddress().getStreet());
            result.add(current.getAddress().getCity());
            
        
        }
        
        return result;
        
    }
    
    @WebMethod(operationName = "findAvailableRestaurantsFiltered")
    public List<String> findAvailableRestaurantsFiltered(@WebParam(name = "latitude") Double latitude, @WebParam(name = "longitude") Double longitude, @WebParam(name = "categoryId") Long categoryId) {
        
        
        List<String> result = new LinkedList();
        
        Iterator<Restaurant> iterator = ejbRestaurantRef.findAvailable(latitude, longitude, ejbCategoryRef.find(categoryId)).iterator();
        Restaurant current;
        
        while(iterator.hasNext()) {
        
            current = iterator.next();
            
            result.add(String.valueOf(current.getId()));
            result.add(current.getName());
            result.add(current.getPhone());
            result.add(current.getAddress().getStreet());
            result.add(current.getAddress().getCity());
            
        
        }
        
        return result;
        
    }    
    
    @WebMethod(operationName = "getCategories")
    public List<String> getCategories() {
        
        
        List<String> result = new LinkedList();
        
        Iterator<Category> iterator = ejbCategoryRef.find().iterator();
        Category current;
        
        while(iterator.hasNext()) {
        
            current = iterator.next();
            
            result.add(String.valueOf(current.getId()));
            result.add(current.getName());
            
        
        }
        
        return result;
        
    } 
    
    @WebMethod(operationName = "findRestaurantProducts")
    public List<String> findRestaurantProducts( @WebParam(name = "restaurantId") Long restaurantId) {
        
        
        List<String> result = new LinkedList();
        
        Iterator<Product> iterator = ejbProductRef.find(ejbRestaurantRef.find(restaurantId)).iterator();
        Product current;
        
        while(iterator.hasNext()) {
        
            current = iterator.next();
            
            result.add(String.valueOf(current.getId()));
            result.add(current.getName());
            result.add(current.getCategory().getName());
            
        
        }
        
        return result;
        
    }   
    
    @WebMethod(operationName = "findRestaurantProductsFiltered")
    public List<String> findRestaurantProductsFiltered( @WebParam(name = "restaurantId") Long restaurantId, @WebParam(name = "categoryId") Long categoryId) {
        
        
        List<String> result = new LinkedList();
        
        Iterator<Product> iterator = ejbProductRef.find(ejbRestaurantRef.find(restaurantId), ejbCategoryRef.find(categoryId)).iterator();
        Product current;
        
        while(iterator.hasNext()) {
        
            current = iterator.next();
            
            result.add(String.valueOf(current.getId()));
            result.add(current.getName());
            result.add(current.getCategory().getName());
            
        
        }
        
        return result;
        
    }      
    


    /*
    @WebMethod(operationName = "findAvailable_3")
    @RequestWrapper(className = "findAvailable_3")
    @ResponseWrapper(className = "findAvailable_3Response")
    public List<Restaurant> findAvailable(@WebParam(name = "latitude") Double latitude, @WebParam(name = "longitude") Double longitude, @WebParam(name = "category") Category category) {
        return ejbRef.findAvailable(latitude, longitude, category);
    }
    */
    
}
