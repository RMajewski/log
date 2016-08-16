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

package org.log.datas;

import java.awt.Color;
import java.text.DateFormat;
import java.util.Date;

/**
 * Speichert die Daten für eine Log-Nachricht.
 * 
 * @author René Majewski
 * 
 * @version 0.2
 * Die Vergleichs-Methode equals wurde hinzugefügt. Neue Nachrichten-Typen:
 * DATABASE_ERROR und DATABASE_INSERT.
 *
 * @version 0.1
 * Setzen und zurückgeben der Nachrichten. Folgende Nachrichten-Type wurde
 * hinzugefügt: NO_OUT, NONE, ERROR, WARNING, OK, INFO
 * 
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
	 * Gibt an, dass die Nachricht eine Information ist.
	 */
	public static final short INFO = 5;
	
	/**
	 * Gibt an, dass beim Zugriff auf die Datenbank ein Fehler aufgetreten ist.
	 */
	public static final short DATABASE_ERROR = 6;
	
	/**
	 * Gibt an, dass etwas in die Datenbank eingefügt wurde.
	 */
	public static final short DATABASE_INSERT = 7;
	
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
	 * Speichert die Hintergrundfarbe für einen Datenbank-Fehler.
	 */
	public static final Color COLOR_DATABASE_ERROR = Color.RED;
	
	/**
	 * Speichert die Hintergrundfarbe für die Datenbank-Nachricht
	 */
	public static final Color COLOR_DATABASE_INSERT = Color.LIGHT_GRAY;
	
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
	 * Speichert die Schrift-Farbe für ein Datenbank-Fehler.
	 */
	public static final Color FCOLOR_DATABASE_ERROR = Color.BLUE;
	
	/**
	 * Speichert die Schrift-Farbe für ein Datenbank-Nachricht.
	 */
	public static final Color FCOLOR_DATABASE_INSERT = Color.BLUE;
	
	/**
	 * Initialisiert die Nachricht ohne Daten.
	 */
	// OPT this(null, null, NO_OUT) aufrufen
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
	// OPT this(message, error, NONE) aufrufen
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
		if (error == null)
			return new String();
		
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
	 * Erzeugt eine neue Nachricht und markiert sie als Datenbank-Fehler.
	 * 
	 * @param message Nachricht, die gespeichert werden soll.
	 * 
	 * @param error Fehlerbeschreibung, die gespeichert werden soll.
	 * 
	 * @return Erzeugte Nachricht mit den angegebenen Daten.
	 */
	public static LogData messageDatabaseError(String message, String error) {
		return new LogData(message, error, DATABASE_ERROR);
	}
	
	/**
	 * Erzeugt eine neue Nachricht und markiert sie als Datenbank-Fehler.
	 * 
	 * @param message Nachricht, die gespeichert werden soll.
	 * 
	 * @param error Fehler, der aufgetreten ist.
	 * 
	 * @return Erzeugte Nachricht mit den angegebenen Daten.
	 */
	public static LogData messageDatabaseError(String message,
			Exception error) {
		return new LogData(message, createError(error), DATABASE_ERROR);
	}
	
	/**
	 * Erzeugt eine neue Nachricht und markiert sie als Datenbank-Nachricht.
	 * 
	 * @param message Nachricht, die gespeichert werden soll.
	 * 
	 * @param error Fehlerbeschreibung, die gespeichert werden soll.
	 * 
	 * @return Erzeugte Nachricht mit den angegebenen Daten.
	 */
	public static LogData messageDatabaseInsert(String message, String error) {
		return new LogData(message, error, DATABASE_INSERT);
	}
	
	/**
	 * Erzeugt eine neue Nachricht und markiert sie als Datenbank-Nachricht.
	 * 
	 * @param message Nachricht, die gespeichert werden soll.
	 * 
	 * @param error Fehler, der aufgetreten ist.
	 * 
	 * @return Erzeugte Nachricht mit den angegebenen Daten.
	 */
	public static LogData messageDatabaseInsert(String message,
			Exception error) {
		return new LogData(message, createError(error), DATABASE_INSERT);
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
				
			case LogData.DATABASE_ERROR:
				return LogData.COLOR_DATABASE_ERROR;
				
			case LogData.DATABASE_INSERT:
				return LogData.COLOR_DATABASE_INSERT;
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
				
			case LogData.DATABASE_ERROR:
				return LogData.FCOLOR_DATABASE_ERROR;
				
			case LogData.DATABASE_INSERT:
				return LogData.FCOLOR_DATABASE_INSERT;
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
	
	/**
	 * Überprüft, das übergebene Objekt, ob es gleich mit diesem ist.
	 * 
	 * Wenn obj == null ist, wird false zurückgegeben. Wenn obj == this ist,
	 * wird true zurückgegeben. Wenn obj keine Data-Klasse ist, so wird false
	 * zurückgegeben. Wenn die ID dieses Datensatzes und des übergebenen
	 * Objektes gleich ist, wird true zurückgegeben.
	 * 
	 * @param obj Objekt, was mit diesem hier verglichen werden soll.
	 * 
	 * @return Ist das übergebene Objekt gleich diesem? Wenn ja, wird true
	 * zurückgegeben. Wenn nein, false.
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		
		if (obj == this)
			return true;
		
		if (!getClass().equals(obj.getClass()))
			return false;
		
		LogData data = (LogData)obj;
		return (_message.equals(data.getMessage()) && 
				_error.equals(data.getError()) && (_out == data.getOut()));
	}
	
	/**
	 * Erstellt eine Zeichenkette, in der alle Daten dieser Klasse vorkommen.
	 * 
	 * @return Zeichenkette mit allen Daten
	 */
	@Override
	public String toString() {
		String type = new String();
		switch (_out) {
			case NO_OUT:
				type = "NO_OUT";
				break;
				
			case NONE:
				type = "NONE";
				break;
				
			case ERROR:
				type = "ERROR";
				break;
				
			case WARNING:
				type = "WARNING";
				break;
				
			case OK:
				type = "OK";
				break;
				
			case INFO:
				type = "INFO";
				break;
				
			case DATABASE_ERROR:
				type = "DATABASE_ERROR";
				break;
		}
		
		DateFormat df = DateFormat.getDateTimeInstance(DateFormat.SHORT,
				DateFormat.SHORT);
		
		return "['" + type + "', '" + _message + "', ''" + _error + "', '" + 
				df.format(new Date(_create)) + "']";
	}
}
