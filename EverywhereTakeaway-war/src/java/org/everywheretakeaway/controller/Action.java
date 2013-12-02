/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.everywheretakeaway.controller;

import org.everywheretakeaway.context.RequestObject;
import org.everywheretakeaway.context.ResponseAndView;

/**
 *
 * @author Fede
 */
public interface Action {

    ResponseAndView createResponseAndView(RequestObject requestObject);

}
