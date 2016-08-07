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
	 * Speichert wann die Nachricht erstellt wurde als Timestamp.
	 */
	private long _create;
	
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
	 * Gibt an, dass die Nachricht einen Information ist.
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
	 * Speichert die Schrift-Farbe für einen Fehler.
	 */
	public static final Color FCOLOR_ERROR = Color.WHITE;
	
	/**
	 * Speichert die Schrift-Farbe für eine Warnung.
	 */
	public static final Color FCOLOR_WARNING = Color.BLACK;
	
	/**
	 * Speichert die Schrift-Farbe für eine Normale Nachricht.
	 */
	public static final Color FCOLOR_NONE = Color.BLACK;
	
	/**
	 * Speichert die Schrift-Farbe für eine Erfolgs-Nachricht.
	 */
	public static final Color FCOLOR_OK = Color.BLACK;
	
	/**
	 * Speichert die Schrift-Farbe für eine Information.
	 */
	public static final Color FCOLOR_INFO = Color.CYAN;
	
	/**
	 * Initialisiert die Nachricht ohne Daten.
	 */
	public LogData() {
		setMessage(null);
		setError(null);
		setOut(NO_OUT);
		_create = System.currentTimeMillis();
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
		_create = System.currentTimeMillis();
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
		_create = System.currentTimeMillis();
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
	 * Erstellt aus dem übergebenen Fehler eine Fehler-Nachricht.
	 * 
	 * @param error Fehler, aus dem die Fehler-Nachricht erstellt werden soll.
	 * 
	 * @return Erstellt Fehler-Nachricht.
	 */
	public static String createError(Exception error) {
		String result = error.getClass().getName();
		
		if ((error.getMessage() != null) && !error.getMessage().isEmpty())
			result += "( \"" + error.getMessage() + "\" )";
		
		result += System.lineSeparator();
		
		StackTraceElement[] trace = error.getStackTrace();
		for (int i = 0; i < trace.length; i++)
			result += "    " + trace[i].getClassName() + "." + 
				trace[i].getMethodName() + "(" + trace[i].getFileName() + ":" +
				trace[i].getLineNumber() + ")" + System.lineSeparator();
		
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
	public static LogData message(String message, Exception error) {
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
	public static LogData message(String message, Exception error, short out) {
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
	public static LogData messageNoOut(String message, Exception error) {
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
	public static LogData messageError(String message, Exception error) {
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
	public static LogData messageWarning(String message, Exception error) {
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
	public static LogData messageOk(String message, Exception error) {
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
	public static LogData messageInformation(String message, Exception error) {
		return new LogData(message, createError(error), INFO);
	}
	
	/**
	 * Ermittelt aus dem angegeben Wert die Hintergrund-Farbe.
	 * 
	 * @param out Als was soll die Nachricht dargestellt werden?
	 * 
	 * @return Ermittelte Hintergrund-Farbe.
	 * 
	 * @deprecated Ersetzt durch {@link #getBackground(short)}
	 */
	public static Color getColor(short out) {
		return getBackground(out);
	}
	
	/**
	 * Ermittelt aus dem angegeben Wert die Hintergrund-Farbe.
	 * 
	 * @param out Als was soll die Nachricht dargestellt werden?
	 * 
	 * @return Ermittelte Hintergrund-Farbe.
	 */
	public static Color getBackground(short out) {
		switch (out) {
			case LogData.ERROR:
				return LogData.COLOR_ERROR;
				
			case LogData.WARNING:
				return LogData.COLOR_WARNING;
				
			case LogData.OK:
				return LogData.COLOR_OK;
				
			case LogData.INFO:
				return LogData.COLOR_INFO;
		}
		
		return LogData.COLOR_NONE;
	}
	
	/**
	 * Ermittelt aus dem angegeben Wert die Schrift-Farbe.
	 * 
	 * @param out Als was soll die Nachricht dargestellt werden?
	 * 
	 * @return Ermittelte Schrift-Farbe.
	 */
	public static Color getForeground(short out) {
		switch (out) {
			case LogData.ERROR:
				return LogData.FCOLOR_ERROR;
				
			case LogData.WARNING:
				return LogData.FCOLOR_WARNING;
				
			case LogData.OK:
				return LogData.FCOLOR_OK;
				
			case LogData.INFO:
				return LogData.FCOLOR_INFO;
		}
		
		return LogData.FCOLOR_NONE;
	}
	
	/**
	 * Gibt den Timestamp zurück, wann die Nachricht erstellt wurde.
	 * 
	 * @return Timestamp, wann die Nachtricht erstellet wurde.
	 */
	public long getCreateTime() {
		return _create;
	}
}
