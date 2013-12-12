/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.everywheretakeaway.model;

import java.io.Serializable;
import javax.persistence.Embeddable;

/**
 *
 * @author Fede
 */
@Embeddable
public class OpeningTimes implements Serializable {
    
    private String morningOpening;
    private String morningClosing;
    private String afternoonOpening;
    private String afternoonClosing;

    public String getMorningOpening() {
        return morningOpening;
    }

    public void setMorningOpening(String morningOpening) {
        this.morningOpening = morningOpening;
    }

    public String getMorningClosing() {
        return morningClosing;
    }

    public void setMorningClosing(String morningClosing) {
        this.morningClosing = morningClosing;
    }

    public String getAfternoonOpening() {
        return afternoonOpening;
    }

    public void setAfternoonOpening(String afternoonOpening) {
        this.afternoonOpening = afternoonOpening;
    }

    public String getAfternoonClosing() {
        return afternoonClosing;
    }

    public void setAfternoonClosing(String afternoonClosing) {
        this.afternoonClosing = afternoonClosing;
    }

    public OpeningTimes() {
    }

    public OpeningTimes(String morningOpening, String morningClosing, String afternoonOpening, String afternoonClosing) {
        this.morningOpening = morningOpening;
        this.morningClosing = morningClosing;
        this.afternoonOpening = afternoonOpening;
        this.afternoonClosing = afternoonClosing;
    }


    
    
    
}
