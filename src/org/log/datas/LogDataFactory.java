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

/**
 * Stellt statische Methode bereit, um Nachrichten (LogData) zu erzeugen.
 * 
 * @author René Majewski
 *
 * @since 0.4
 */
public class LogDataFactory {
	
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
		return new LogData(message, error, LogData.NONE);
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
		return new LogData(message, LogData.createError(error), LogData.NONE);
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
		return new LogData(message, LogData.createError(error), out);
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
		return new LogData(message, error, LogData.NO_OUT);
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
		return new LogData(message, LogData.createError(error), LogData.NO_OUT);
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
		return new LogData(message, error, LogData.ERROR);
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
		return new LogData(message, LogData.createError(error), LogData.ERROR);
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
		return new LogData(message, error, LogData.WARNING);
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
		return new LogData(message, LogData.createError(error),
				LogData.WARNING);
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
		return new LogData(message, error, LogData.OK);
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
		return new LogData(message, LogData.createError(error), LogData.OK);
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
	public static LogData messageInfo(String message, String error) {
		return new LogData(message, error, LogData.INFO);
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
	public static LogData messageInfo(String message, Exception error) {
		return new LogData(message, LogData.createError(error), LogData.INFO);
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
		return new LogData(message, error, LogData.DATABASE_ERROR);
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
		return new LogData(message, LogData.createError(error),
				LogData.DATABASE_ERROR);
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
		return new LogData(message, error, LogData.DATABASE_INSERT);
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
		return new LogData(message, LogData.createError(error),
				LogData.DATABASE_INSERT);
	}
}
