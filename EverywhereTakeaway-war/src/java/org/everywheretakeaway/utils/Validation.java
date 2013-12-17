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
    
    private static boolean checkNumber(String s) {
        return s.matches("^[0-9]+$");
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
    
    private static boolean checkPassword(String s) {
    
        return s.matches("[a-zA-Z0-9!?()£$]{8,16}");
    
    }
    
    private static boolean checkVat(String s) {
        return s.matches("^[0-9]{11,}$");
    }
    
    private static boolean checkTime(String s) {
        return s.matches("^[0-9]{1,2}(:[0-9]{2})?$");
    }
    
    private static boolean checkPrice(String s) {
    
        return s.matches("^[0-9]+[.]?[0-9]{0,2}$");
        
    }
    
    
    
    public static boolean validateName(String name) {
    
        return checkEmpty(name);
    
    }
    
    public static boolean validateDescription(String name) {
    
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
    
    public static boolean validateVat(String vat) {
    
        if(checkVat(vat))
            return true;
        else
            return false;
    
    }
    
    public static boolean validateMaxKm(String s) {
    
        if(checkNumber(s))
            return true;
        else
            return false;
                    
    
    }
    
    public static boolean validateOpeningTimes(String morningOpening, String morningClosing, String afternoonOpening, String afternoonClosing) {
    
        if(!(checkTime(morningOpening) && checkTime(morningClosing) && checkTime(afternoonOpening) && checkTime(afternoonClosing)))
            return false;
        else
            return true; 
    
    }
    
    public static boolean validatePrice(String price) {
    
        if(checkPrice(price))
            return true;
        else
            return false;
    
    }
    
    public static boolean validateId(String id) {
    
        if(checkNumber(id))
            return true;
        else
            return false;
    
    }
    
}


