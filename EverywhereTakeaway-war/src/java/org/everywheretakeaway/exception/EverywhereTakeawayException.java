/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.everywheretakeaway.exception;

/**
 *
 * @author Fede
 */
public class EverywhereTakeawayException extends RuntimeException {
    
	protected int type;
	protected String extraMessage;
	protected Throwable cause;

	public static final int UNKNOW_ERROR = 0;
	public static final int ACTION_ERROR = 1;
	public static final int SERVICE_CONNECTION_ERROR = 2;

	private static final String[] messages = new String[] {
		"Errore imprevisto",		//0
		"Impossibile caricare l'action",	//1
		"Impossibile connettersi al servizio" //2
	};

	public EverywhereTakeawayException(int type) {
		this(type,null,null);
	}

	public EverywhereTakeawayException(int type, String extraMessage)
	{
		this(type,extraMessage,null);
	}

	public EverywhereTakeawayException(int type, Throwable t)
	{
		this(type,null,t);
	}

	public EverywhereTakeawayException(int type, String extraMessage, Throwable t)
	{
		super();
		this.type = type;
		this.extraMessage = extraMessage;
		this.cause = t;
	}

	public String getMessage() {

		String msg = "Eccezione in JakiWiki: "+messages[type];

		if (extraMessage != null)
			msg += " - "+extraMessage;

		if (cause != null)
			msg += ". L'eccezione originaria è "+cause.getMessage();

		return msg;
	}


}    
    
