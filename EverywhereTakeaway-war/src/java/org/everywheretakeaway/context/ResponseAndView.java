/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.everywheretakeaway.context;

/**
 *
 * @author Fede
 */

public class ResponseAndView {

	protected String view;
	protected ResponseObject responseObject;

	public ResponseAndView()
	{

	}

	public ResponseAndView(ResponseObject rObj, String viewName)
	{
		this.view = viewName;
		this.responseObject = rObj;
	}

	public String getView() {
		return view;
	}

	public ResponseObject getResponseObject() {
		return responseObject;
	}

	public void setResponseObject(ResponseObject responseObject) {
		this.responseObject = responseObject;
	}

	public void setView(String view) {
		this.view = view;
	}

}
