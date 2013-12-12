/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.everywheretakeaway.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author Fede
 */
@Entity
public class Restaurant implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String name;
    
    @Embedded
    private Address address;
    
    @ManyToOne
    private User owner;
    
    private String vat;
    
    private String emailAddress;
    
    @Embedded
    private OpeningTimes openingTimes;
    
    private String phone;
        
    private int maxKm;
    
    @OneToMany(mappedBy="restaurant")
    private List<Product> products;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public String getVat() {
        return vat;
    }

    public void setVat(String vat) {
        this.vat = vat;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public OpeningTimes getOpeningTimes() {
        return openingTimes;
    }

    public void setOpeningTimes(OpeningTimes openingTimes) {
        this.openingTimes = openingTimes;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getMaxKm() {
        return maxKm;
    }

    public void setMaxKm(int maxKm) {
        this.maxKm = maxKm;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
    
    public Restaurant() {
    }
    
    public Restaurant(String name, String street, String postalCode, String city, double latitude, double longitude, User owner, String vat, String emailAddress, String morningOpening, String morningClosing, String afternoonOpening, String afternoonClosing, String phone, int maxKm) {
        this.name = name;
        this.address = new Address(street,postalCode,city,latitude,longitude);
        this.owner = owner;
        this.vat = vat;
        this.emailAddress = emailAddress;
        this.openingTimes = new OpeningTimes(morningOpening, morningClosing, afternoonOpening, afternoonClosing);
        this.phone = phone;
        this.maxKm = maxKm;
    }

    public Restaurant(String name, Address address, User owner, String vat, String emailAddress, OpeningTimes openingTimes, String phone, int maxKm) {
        this.name = name;
        this.address = address;
        this.owner = owner;
        this.vat = vat;
        this.emailAddress = emailAddress;
        this.openingTimes = openingTimes;
        this.phone = phone;
        this.maxKm = maxKm;
    }
    
    
    
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Restaurant)) {
            return false;
        }
        Restaurant other = (Restaurant) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.everywheretakeaway.model.Restaurant[ id=" + id + " ]";
    }
    
}
