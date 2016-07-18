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

package org.log;

import java.awt.Color;

/**
 * Speichert die Daten für eine Log-Nachricht.
 * 
 * @author René Majewski
 *
 * @version 0.1
 * @since 0.1
 */
public class LogData {
	/**
	 * Speichert die Nachricht, die ausgegeben werden soll.
	 */
	private String _message;
	
	/**
	 * Speichert die Fehler-Beschreibung.
	 */
	private String _error;
	
	/**
	 * Speichert, wie die Nachricht dargestellt werden soll.
	 */
	private short _out;
	
	/**
	 * Gibt an, dass die Nachricht nicht ausgegeben werden soll.
	 */
	public static final short NO_OUT = 0;
	
	/**
	 * Gibt an, dass die Nachricht ein Fehler ist.
	 */
	public static final short ERROR = 1;
	
	/**
	 * Gibt an, dass die Nachricht eine Warnung ist.
	 */
	public static final short WARNING = 2;
	
	/**
	 * Gibt an, dass die Nachricht nicht speziell markiert werden soll.
	 */
	public static final short NONE = 3;
	
	/**
	 * Gibt an, dass die Nachricht einen Erfolg markiert.
	 */
	public static final short OK = 4;
	
	/**
	 * Gibt an, dass die Nachrciht einen Information ist.
	 */
	public static final short INFO = 5;
	
	/**
	 * Speichert die Farbe für eine Fehler
	 */
	public static final Color COLOR_ERROR = Color.RED;
	
	/**
	 * Speichert die Farbe für eine Warnung
	 */
	public static final Color COLOR_WARNING = Color.ORANGE;
	
	/**
	 * Speichert die Farbe für eine Normale Nachricht
	 */
	public static final Color COLOR_NONE = Color.LIGHT_GRAY;
	
	/**
	 * Speichert die Farbe für eine Erfolgs-Nachricht.
	 */
	public static final Color COLOR_OK = Color.GREEN;
	
	/**
	 * Speichert die Farbe für eine Information.
	 */
	public static final Color COLOR_INFO = Color.BLUE;
	
	/**
	 * Initialisiert die Nachricht ohne Daten.
	 */
	public LogData() {
		setMessage(null);
		setError(null);
		setOut(NO_OUT);
	}
	
	/**
	 * Initialisiert die Nachricht ohne spezielle Markierung.
	 * 
	 * @param message Nachricht, die ausgegeben werden soll.
	 * 
	 * @param error Fehlerbeschreibung, die gespeichert werden soll.
	 */
	public LogData(String message, String error) {
		setMessage(message);
		setError(error);
		setOut(NONE);
	}
	
	/**
	 * Initialisiert die Nachricht mit einer entsprechenden Markierung.
	 * 
	 * @param message Nachricht, die ausgegeben werden soll.
	 * 
	 * @param error Fehlerbeschreibung, die speichert werden soll.
	 * 
	 * @param out Wie soll die Nachricht ausgegeben werden.
	 */
	public LogData(String message, String error, short out) {
		setMessage(message);
		setError(error);
		setOut(out);
	}

	/**
	 * Gibt die gespeicherte Nachricht zurück.
	 * 
	 * @return Nchricht, die gespeichert ist.
	 */
	public String getMessage() {
		return _message;
	}

	/**
	 * Speichert die übergebene Nachricht.
	 * 
	 * @param message Nachricht, die gespeichert werden soll. 
	 */
	public void setMessage(String message) {
		if (message != null)
			_message = message;
		else
			_message = new String();
	}

	/**
	 * Gibt die gespeicherte Fehlerbeschreibung zurück.
	 * 
	 * @return Fehlerbeschreibung, die gespeichert wurde.
	 */
	public String getError() {
		return _error;
	}

	/**
	 * Speichert die übergebene Fehlerbeschreibung.
	 * 
	 * @param error Fehlerbeschreibung, die gespeichert werden soll.
	 */
	public void setError(String error) {
		if (error != null)
			_error = error;
		else
			_error = new String();
	}

	/**
	 * Gibt zurück, wie die Nachricht dargestellt werden soll.
	 * 
	 * @return Wie soll die Nachricht dargestellt werden?
	 */
	public short getOut() {
		return _out;
	}

	/**
	 * Speichert, wie die Nachricht dargestellt werden soll.
	 * 
	 * @param out Wie soll die Nachricht dargestellt werden?
	 */
	public void setOut(short out) {
		_out = out;
	}
	
	/**
	 * Speichert die übergebene Nachricht und markiert sie so, dass sie nicht
	 * ausgegeben werden soll.
	 * 
	 * @param message Nachricht, die gespeichert werden soll.
	 * 
	 * @param error Fehlerbeschreibung, die gespeichert werden soll.
	 */
	public void setMessageAsNoOut(String message, String error) {
		setMessage(message);
		setError(error);
		setOut(NO_OUT);
	}
	
	/**
	 * Speichert die übergebene Nachricht und markiert sie als Fehler.
	 * 
	 * @param message Nachricht, die gespeichert werden soll.
	 * 
	 * @param error Fehlerbeschreibung, die gespeichert werden soll.
	 */
	public void setMessageAsError(String message, String error) {
		setMessage(message);
		setError(error);
		setOut(ERROR);
	}
	
	/**
	 * Speichert die übergebene Nachricht und markiert sie als Warnung.
	 * 
	 * @param message Nachricht, die gespeichert werden soll.
	 * 
	 * @param error Fehlerbeschreibung, die gespeichert werden soll.
	 */
	public void setMessageAsWarning(String message, String error) {
		setMessage(message);
		setError(error);
		setOut(WARNING);
	}
	
	/**
	 * Speichert die übergebene Nachricht und markiert sie als erfolgreich.
	 * 
	 * @param message Nachricht, die gespeichert werden soll.
	 * 
	 * @param error Fehlerbeschreibung, die gespeichert werden soll.
	 */
	public void setMessageAsOk(String message, String error) {
		setMessage(message);
		setError(error);
		setOut(OK);
	}
	
	/**
	 * Speichert die übergebene Nachricht und markiert sie als Information.
	 * 
	 * @param message Nachricht, die gespeichert werden soll.
	 * 
	 * @param error Fehlerbeschreibung, die gespeichert werden soll.
	 */
	public void setMessageAsInformation(String message, String error) {
		setMessage(message);
		setError(error);
		setOut(INFO);
	}
}
