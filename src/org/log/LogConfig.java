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

import java.util.HashMap;

/**
 * In dieser Klasse werden die Einstellungen für das Logbuch gespeichert.
 * 
 * @author René Majewski
 *
 * @version 0.1
 * Folgende Einstellungen werden in dieser Version gespeichert: Auswahl der
 * Meldungen in der Status-Leiste, Anzeige des Log-Menüs und Name der
 * automatischen Log-Datei.
 * 
 * @since 0.3
 */
public class LogConfig {
	/**
	 * Speichert den Namen für die Log-Datei an.
	 */
	public static final String LOG_NAME = "log.txt";
	
	/**
	 * Speichert die Instanz dieser Klasse.
	 */
	static private LogConfig _instance;
	
	/**
	 * Speichert, welche Meldungen angezeigt werden sollen bzw. welche nicht
	 * angezeigt werden sollen.
	 */
	private HashMap<Short, Boolean> _messagesOut;
	
	/**
	 * Speichert, ob das Log-Menü angezeigt werden soll.
	 */
	private boolean _showMenu;
	
	/**
	 * Speichert den Namen der Datei, die automatisch erstellt wird.
	 */
	private String _autoName;
	
	/**
	 * Speichert, ob am Ende des Programmes das Logbuch in eine Datei
	 * gespeichert werden soll.
	 */
	private boolean _autoSave;
	
	/**
	 * Speichert das Package für die eigenen Klassen.
	 */
	private String _packageName;
	
	/**
	 * Initialisiert die Klasse. Die Einstellungen werden auf ihre
	 * Voreinstellungen gesetzt.
	 */
	private LogConfig() {
		_messagesOut = new HashMap<Short, Boolean>();
		_messagesOut.put(LogData.NO_OUT, false);
		_messagesOut.put(LogData.NONE, true);
		_messagesOut.put(LogData.ERROR, true);
		_messagesOut.put(LogData.WARNING, true);
		_messagesOut.put(LogData.OK, true);
		_messagesOut.put(LogData.INFO, true);
		
		_showMenu = true;
		
		_autoSave = true;
		_autoName = LOG_NAME;
		
		_packageName = new String();
	}
	
	/**
	 * Gibt die Instanz dieser Klasse zurück. Vorher wird überprüft, ob schon
	 * eine Instanz erstellt wurde. Ist dies nicht der Fall, so wird vor der
	 * Rückgabe eine Instanz erstellt.
	 * 
	 * @return Instanz dieser Klasse
	 */
	public static LogConfig getInstance() {
		if (_instance == null)
			_instance = new LogConfig();
		return _instance;
	}
	
	/**
	 * Gibt den Namen der Datei zurück, die automatisch beim beenden erstellt
	 * werden soll.
	 * 
	 * @return Name der automatisch generierten Logbuch-Datei.
	 */
	public String getAutoFileName() {
		return _autoName;
	}
	
	/**
	 * Speichert den Namen der Datei, die automatisch erstellt werden soll.
	 * 
	 * @param name Name der Datei, die automatisch generiert werden soll.
	 */
	public void setAutoFileName(String name) {
		_autoName = name;
	}
	
	/**
	 * Gibt zurück, ob die Logbuch-Datei beim beenden automatisch generiert
	 * werden soll.
	 * 
	 * @return Soll die Logbuch-Datei beim beenden generiert werden? Wird true
	 * zurückgegeben, so soll diese generiert werden. Bei false, nicht.
	 */
	public boolean isAutoSave() {
		return _autoSave;
	}
	
	/**
	 * Speichert, ob beim beenden eine Logbuch-Datei generiert werden soll oder
	 * nicht.
	 * 
	 * @param autoSave Soll die Logbuch-Datei beim beenden generiert werden?
	 * Wird true übergeben, so soll diese generiert werden. Bei false, nicht.
	 */
	public void setAutoSave(boolean autoSave) {
		_autoSave = autoSave;
	}
	
	/**
	 * Gibt zurück, ob das Logbuch-Menü angezeigt werden soll oder nicht.
	 * 
	 * @return Soll das Logbuch-Menü angezeigt werden? Wird true zurückgegeben,
	 * so soll es angezeigt werden. Bei false, nicht.
	 */
	public boolean showMenu() {
		return _showMenu;
	}
	
	/**
	 * Speichert, ob das Logbuch-Menü angezeigt werden soll oder nicht.
	 * 
	 * @param showMenu Soll das Logbuch-Menü angezeigt werden? Wird true
	 * übergeben, so soll es angezeigt werden. Bei false, nicht.
	 */
	public void setShowMenu(boolean showMenu) {
		_showMenu = showMenu;
	}
	
	/**
	 * Gibt zurück, ob der angegebene Nachrichten-Typ in der StatusBar
	 * ausgegeben werden soll.
	 * 
	 * @param type Nachrichten-Type
	 * 
	 * @return Soll der angegebene Nachrichten-Typ in der StatusBar ausgegeben
	 * werden? Wird true zurückgegeben, so soll die Nachricht ausgegeben werden.
	 * Bei false nicht.
	 */
	public boolean getMessageTypeOut(short type) {
		return _messagesOut.get(type);
	}
	
	/**
	 * Speichert, ob die angegebene Nachricht ausgegeben werden soll.
	 * 
	 * @param type Nachrichten-Typ
	 * 
	 * @param out Soll die Nachricht ausgegeben werden oder nicht? Wird true
	 * übergeben, so wird die Nachricht ausgegeben. Bei false, nicht.
	 */
	public void setMessageTypeOut(short type, boolean out) {
		_messagesOut.put(type, out);
	}
	
	/**
	 * Gibt den Namen des Packages für die eigenen Klassen zurück.
	 * 
	 * @return Package-Name der eigenen Klassen.
	 */
	public String getPackageName() {
		return _packageName;
	}
	
	/**
	 * Speichert den Package-Namen der eigenen Klassen.
	 * 
	 * @param name Name des Packages der eigenen Klassen.
	 */
	public void setPackageName(String name) {
		_packageName = name;
	}
}
