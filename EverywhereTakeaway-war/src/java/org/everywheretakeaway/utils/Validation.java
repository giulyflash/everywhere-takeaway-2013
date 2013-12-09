/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.everywheretakeaway.utils;

/**
 *
 * @author Fede
 */
public class Validation {
    
    private static boolean checkEmpty(String s) {
    
        return s != null && !s.trim().equals("");
    
    }
    
    private static boolean checkPhoneNumber(String s) {
    
        return s.matches("^[0-9]+/?[0-9]+$");
    
    }
    
    private static boolean checkEmailAddress(String s) {
    
        return s.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
    
    }
    
    private static boolean checkTaxCode(String s) {
    
        return s.matches("^[a-zA-Z]{6}[a-zA-Z0-9]{2}[a-zA-Z][a-zA-Z0-9]{2}[a-zA-Z][a-zA-Z0-9]{3}[a-zA-Z]$");
    
    }
    
    private static boolean checkDate(String s) {
    
        return s.matches("^[0-9]{2}/[0-9]{2}/[0-9]{4}$");
    
    }
    
    public static boolean checkPassword(String s) {
    
        return s.matches("[a-zA-Z0-9!?()£$]{8,16}");
    
    }
    
    
    
    
    
    public static boolean validateName(String name) {
    
        return checkEmpty(name);
    
    }
    
    public static boolean validateSurname(String surname) {
    
        return checkEmpty(surname);
        
    }
    
    public static boolean validateAddress(String address) {
    
        return checkEmpty(address);
        
    }
    
    public static boolean validatePhone(String phone) {
    
        return checkPhoneNumber(phone);
    
    }
    
    public static boolean validateEmail(String email) {
    
        return checkEmailAddress(email);
    
    }
    
    public static boolean validateCF(String cf) {
    
        return checkTaxCode(cf);
        
    }
    
    public static boolean validateBirthday(String birthday) {
    
        return checkDate(birthday);
        
    }
    
    public static boolean validateType(String type) {
    
        if(type.equals("buyer") || type.equals("seller"))
            return true;
        else
            return false;
        
    
    }
    
    public static boolean validatePassword(String passwd, String confirmPasswd) {
    
        if(checkPassword(passwd) && passwd.equals(confirmPasswd))
            return true;
        else
            return false;
    
    }
}

