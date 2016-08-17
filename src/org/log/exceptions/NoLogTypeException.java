/* 
* Copyright 2016 René Majewski
*  
* Lizenziert unter der EUPL, Version 1.1 oder - sobald diese von der
* Europäischen Kommission genehmigt wurden - Folgeversionen der EUPL
* ("Lizenz"); Sie dürfen dieses Werk ausschließlich gemäß dieser Lizenz
* nutzen. 
* 
* Eine Kopie der Lizenz finden Sie hier: 
* https://joinup.ec.europa.eu/software/page/eupl
*  
* Sofern nicht durch anwendbare Rechtsvorschriften gefordert oder in 
* schriftlicher Form vereinbart, wird die unter der Lizenz verbreitete 
* Software "so wie sie ist", OHNE JEGLICHE GEWÄHRLEISTUNG ODER BEDINGUNGEN -
* ausdrücklich oder stillschweigend - verbreitet.
* Die sprachspezifischen Genehmigungen und Beschränkungen unter der Lizenz
* sind dem Lizenztext zu entnehmen.
*/ 

package org.log.exceptions;

/**
 * Tritt auf, wenn ein Typ kein Nachrichten-Type ist.
 * 
 * @author René Majewski
 *
 * @since 0.4
 */
public class NoLogTypeException extends IllegalArgumentException {
	/**
	 * Serial ID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Initialisiert die Fehler-Klasse
	 */
	public NoLogTypeException() {
		super();
	}
	
	/**
	 * Initialisiert die Fehler-Klasse mit der übergebenen Nachricht.
	 * 
	 * @param message Nachricht, die mit ausgegeben werden soll.
	 */
	public NoLogTypeException(String message) {
		super(message);
	}
}
