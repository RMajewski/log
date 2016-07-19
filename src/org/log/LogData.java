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
	
	private static String createError(StackTraceElement[] trace) {
		String result = new String();
		
		for (int i = 0; i < trace.length; i++)
			result += trace[i].getClassName() + "." + trace[i].getMethodName() +
				"(" + trace[i].getFileName() + ":" + trace[i].getLineNumber() +
				")" + System.lineSeparator();
		
		return result;
	}
	
	/**
	 * Erzeugt eine neue Nachricht und markiert sie als normale Nachricht.
	 * 
	 * @param message Nachricht, die gespeichert werden soll.
	 * 
	 * @param error Fehlerbeschreibung, die gespeichert werden soll.
	 * 
	 * @return Erzeugte Nachricht mit den angegebenen Angaben.
	 */
	public static LogData message(String message, String error) {
		return new LogData(message, error, NONE);
	}
	
	/**
	 * Erzeugt eine neue Nachricht und markiert sie als normale Nachricht.
	 * 
	 * @param message Nachricht, die gespeichert werden soll.
	 * 
	 * @param error Trace-Array, um die Fehlermeldung zu erzeugen.
	 * 
	 * @return Erzeugte Nachricht mit den angegebenen Angaben.
	 */
	public static LogData message(String message, StackTraceElement[] error) {
		return new LogData(message, createError(error), NONE);
	}
	
	/**
	 * Erzeugt eine neue Nachricht und markiert sie mit dem übergebenen Wert.
	 * 
	 * @param message Nachricht, die gespeichert werden soll.
	 * 
	 * @param error Fehlerbeschreibung, die gespeichert werden soll.
	 * 
	 * @param out Markierung der Nachricht.
	 * 
	 * @return Erzeugte Nachricht mit den angegebenen Angaben.
	 */
	public static LogData message(String message, String error, short out) {
		return new LogData(message, error, out);
	}
	
	/**
	 * Erzeugt eine neue Nachricht und markiert sie mit dem übergebenen Wert.
	 * 
	 * @param message Nachricht, die gespeichert werden soll.
	 * 
	 * @param error Trace-Array, um die Fehlermeldung zu erzeugen.
	 * 
	 * @param out Markierung der Nachricht.
	 * 
	 * @return Erzeugte Nachricht mit den angegebenen Angaben.
	 */
	public static LogData message(String message, StackTraceElement[] error, short out) {
		return new LogData(message, createError(error), out);
	}
	
	/**
	 * Erzeugt eine neue Nachricht und markiert sie, dass sie nicht angezeigt
	 * werden soll.
	 * 
	 * @param message Nachricht, die gespeichert werden soll.
	 * 
	 * @param error Fehlerbeschreibung, die gespeichert werden soll.
	 * 
	 * @return Erzeugte Nachricht mit den angegebenen Angaben.
	 */
	public static LogData messageNoOut(String message, String error) {
		return new LogData(message, error, NO_OUT);
	}
	
	/**
	 * Erzeugt eine neue Nachricht und markiert sie, dass sie nicht angezeigt
	 * werden soll.
	 * 
	 * @param message Nachricht, die gespeichert werden soll.
	 * 
	 * @param error Trace-Array, um die Fehlermeldung zu erzeugen.
	 * 
	 * @return Erzeugte Nachricht mit den angegebenen Angaben.
	 */
	public static LogData messageNoOut(String message, StackTraceElement[] error) {
		return new LogData(message, createError(error), NO_OUT);
	}
	
	/**
	 * Erzeugt eine neue Nachricht und markiert als Fehler.
	 * 
	 * @param message Nachricht, die gespeichert werden soll.
	 * 
	 * @param error Fehlerbeschreibung, die gespeichert werden soll.
	 * 
	 * @return Erzeugte Nachricht mit den angegebenen Daten.
	 */
	public static LogData messageError(String message, String error) {
		return new LogData(message, error, ERROR);
	}
	
	/**
	 * Erzeugt eine neue Nachricht und markiert als Fehler.
	 * 
	 * @param message Nachricht, die gespeichert werden soll.
	 * 
	 * @param error Trace-Array, um die Fehlermeldung zu erzeugen.
	 * 
	 * @return Erzeugte Nachricht mit den angegebenen Daten.
	 */
	public static LogData messageError(String message, StackTraceElement[] error) {
		return new LogData(message, createError(error), ERROR);
	}
	
	/**
	 * Erzeugt eine neue NAchricht und markiert sie als Warnung.
	 * 
	 * @param message Nachricht, die gespeichert werden soll.
	 * 
	 * @param error Fehlerbeschreibung, die gespeichert werden soll.
	 * 
	 * @return Erzeugte Nachricht mit den angegebenen Daten.
	 */
	public static LogData messageWarning(String message, String error) {
		return new LogData(message, error, WARNING);
	}
	
	/**
	 * Erzeugt eine neue NAchricht und markiert sie als Warnung.
	 * 
	 * @param message Nachricht, die gespeichert werden soll.
	 * 
	 * @param error Trace-Array, um die Fehlermeldung zu erzeugen.
	 * 
	 * @return Erzeugte Nachricht mit den angegebenen Daten.
	 */
	public static LogData messageWarning(String message, StackTraceElement[] error) {
		return new LogData(message, createError(error), WARNING);
	}
	
	/**
	 * Erzeugt eine neue Nachricht und markiert sie als erfolgreich.
	 * 
	 * @param message Nachricht, die gespeichert werden soll.
	 * 
	 * @param error Fehlerbeschreibung, die gespeichert werden soll.
	 * 
	 * @return Erzeugte Nachricht mit den angegebenen Daten.
	 */
	public static LogData messageOk(String message, String error) {
		return new LogData(message, error, OK);
	}
	
	/**
	 * Erzeugt eine neue Nachricht und markiert sie als erfolgreich.
	 * 
	 * @param message Nachricht, die gespeichert werden soll.
	 * 
	 * @param error Trace-Array, um die Fehlermeldung zu erzeugen.
	 * 
	 * @return Erzeugte Nachricht mit den angegebenen Daten.
	 */
	public static LogData messageOk(String message, StackTraceElement[] error) {
		return new LogData(message, createError(error), OK);
	}
	
	/**
	 * Erzeugt eine neue Nachricht und markiert sie als Information.
	 * 
	 * @param message Nachricht, die gespeichert werden soll.
	 * 
	 * @param error Fehlerbeschreibung, die gespeichert werden soll.
	 * 
	 * @return Erzeugte Nachricht mit den angegebenen Daten.
	 */
	public static LogData messageInformation(String message, String error) {
		return new LogData(message, error, INFO);
	}
	
	/**
	 * Erzeugt eine neue Nachricht und markiert sie als Information.
	 * 
	 * @param message Nachricht, die gespeichert werden soll.
	 * 
	 * @param error Trace-Array, um die Fehlermeldung zu erzeugen.
	 * 
	 * @return Erzeugte Nachricht mit den angegebenen Daten.
	 */
	public static LogData messageInformation(String message, StackTraceElement[] error) {
		return new LogData(message, createError(error), INFO);
	}
}
