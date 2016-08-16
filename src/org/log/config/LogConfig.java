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

package org.log.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

import org.log.datas.LogData;
import org.log.elements.StatusBar;

/**
 * In dieser Klasse werden die Einstellungen für das Logbuch gespeichert.
 * 
 * @author René Majewski
 * 
 * @version 0.2
 * Speichern der einzelnen Konfigurationen in Properties. {@code load()} und
 * {@code save()} hinzugefügt.
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
	 * Speichert den Namen der Datei, in der die Einstellungen gespeichert
	 * werden sollen.
	 */
	public static final String FILE_PROPERTIES = "log.properties.xml";
	
	/**
	 * Speichert den Namen der Einstellung für den Namen der automatisch
	 * genierten Logbuch-Datei.
	 */
	public static final String PROPERTY_AUTO_NAME = "Log.property.autoName";
	
	/**
	 * Speichert den Namen der Einstellung, ob automatisch am Programmende eine
	 * Logbuch-Datei generiert werden soll.
	 */
	public static final String PROPERTY_AUTO_SAVE = "Log.property.autoSave";
	
	/**
	 * Speichert den Namen der Einstellung für das Anzeigen des Menüs.
	 */
	public static final String PROPERTY_SHOW_MENU = "Log.property.showMenu";
	
	/**
	 * Speichert den Namen der Einstellung für den Namen der eigenen Packages.
	 */
	public static final String PROPERTY_PACKAGE_NAME =
			"Log.property.packageName";
	
	/**
	 * Speichert das Suffix der Einstellung, um die einzelnen Nachrichten-Typen
	 * in der Statusleiste anzuzeigen.
	 */
	public static final String PROPERTY_SHOW_MESSAGE =
			"Log.property.message.show.";
	
	/**
	 * Speichert die Instanz dieser Klasse.
	 */
	static private LogConfig _instance;
	
	/**
	 * Speichert, welche Meldungen angezeigt werden sollen bzw. welche nicht
	 * angezeigt werden sollen.
	 * 
	 * @deprecated Wird jetzt in den {@link #_properties} gespeichert.
	 */
	@SuppressWarnings("unused")
	private HashMap<Short, Boolean> _messagesOut;
	
	/**
	 * Speichert, ob das Log-Menü angezeigt werden soll.
	 * 
	 * @deprecated Wird jetzt in den {@link #_properties} gespeichert.
	 */
	@SuppressWarnings("unused")
	private boolean _showMenu;
	
	/**
	 * Speichert den Namen der Datei, die automatisch erstellt wird.
	 * 
	 * @deprecated Wird jetzt in den {@link #_properties} gespeichert.
	 */
	@SuppressWarnings("unused")
	private String _autoName;
	
	/**
	 * Speichert, ob am Ende des Programmes das Logbuch in eine Datei
	 * gespeichert werden soll.
	 * 
	 * @deprecated Wird jetzt in den {@link #_properties} gespeichert.
	 */
	@SuppressWarnings("unused")
	private boolean _autoSave;
	
	/**
	 * Speichert das Package für die eigenen Klassen.
	 * 
	 * @deprecated Wird jetzt in den {@link #_properties} gespeichert.
	 */
	@SuppressWarnings("unused")
	private String _packageName;
	
	/**
	 * Speichert die Einstellungen.
	 */
	private Properties _properties;
	
	/**
	 * Initialisiert die Klasse. Die Einstellungen werden auf ihre
	 * Voreinstellungen gesetzt.
	 */
	private LogConfig() {
//		_messagesOut = new HashMap<Short, Boolean>();
//		_messagesOut.put(LogData.NO_OUT, false);
//		_messagesOut.put(LogData.NONE, true);
//		_messagesOut.put(LogData.ERROR, true);
//		_messagesOut.put(LogData.WARNING, true);
//		_messagesOut.put(LogData.OK, true);
//		_messagesOut.put(LogData.INFO, true);
//		_messagesOut.put(LogData.DATABASE_ERROR, true);
//		_messagesOut.put(LogData.DATABASE_INSERT, true);
//		
//		_showMenu = true;
//		
//		_autoSave = true;
//		_autoName = LOG_NAME;
//		
//		_packageName = new String();
		_properties = new Properties();
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
	 * Speichert die Einstellungen in einer XML-Datei im angegebenen
	 * Verzeichnis.
	 * 
	 * @param path Verzeichnis, in dass die Einstellungs-Datei gespeichert
	 * werden soll.
	 */
	public void save(String path) {
		// Verzeichnis erstellen, wenn nötig
		File file = new File(path);
		if (!file.exists())
			file.mkdirs();
		
		// Einstellungen speichern
		String comment = "Einstellungen für das Logbuch-System \"Log\".";
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(path + File.separator + FILE_PROPERTIES);
			_properties.storeToXML(fos, comment, "UTF-8");
		} catch (IOException e) {
			StatusBar.getInstance().setMessage(LogData.messageError(
					"Fehler beim speichern der Einstellungen des " +
					"Logbuch-Systems.", e));
		} finally {
			try {
				if (fos != null)
					fos.close();
			} catch (IOException e) {
			}
		}
	}
	
	/**
	 * Lädt die Einstellungen aus einer XML-Datei im angegebenen Verzeichnis.
	 * 
	 * @param path Verzeichnis, in der die Einstellungs-Datei gespeichert wurde.
	 */
	public void load(String path) {
		System.out.println(path);
		
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(path + File.separator + FILE_PROPERTIES);
			_properties.loadFromXML(fis);
		} catch (IOException e) {
			StatusBar.getInstance().setMessage(LogData.messageError(
					"Fehler beim laden der Einstellungen des Logbuch-System.",
					e));
		} finally {
			try {
				if (fis != null)
					fis.close();
			} catch (IOException e) {
			}
		}
	}
	
	/**
	 * Gibt den Namen der Datei zurück, die automatisch beim beenden erstellt
	 * werden soll.
	 * 
	 * @return Name der automatisch generierten Logbuch-Datei.
	 */
	public String getAutoFileName() {
		return _properties.getProperty(PROPERTY_AUTO_NAME, LOG_NAME);
	}
	
	/**
	 * Speichert den Namen der Datei, die automatisch erstellt werden soll.
	 * 
	 * @param name Name der Datei, die automatisch generiert werden soll.
	 */
	public void setAutoFileName(String name) {
		_properties.setProperty(PROPERTY_AUTO_NAME, name);
	}
	
	/**
	 * Gibt zurück, ob die Logbuch-Datei beim beenden automatisch generiert
	 * werden soll.
	 * 
	 * @return Soll die Logbuch-Datei beim beenden generiert werden? Wird true
	 * zurückgegeben, so soll diese generiert werden. Bei false, nicht.
	 */
	public boolean isAutoSave() {
		return Boolean.valueOf(_properties.getProperty(PROPERTY_AUTO_SAVE,
				"true"));
	}
	
	/**
	 * Speichert, ob beim beenden eine Logbuch-Datei generiert werden soll oder
	 * nicht.
	 * 
	 * @param autoSave Soll die Logbuch-Datei beim beenden generiert werden?
	 * Wird true übergeben, so soll diese generiert werden. Bei false, nicht.
	 */
	public void setAutoSave(boolean autoSave) {
		_properties.setProperty(PROPERTY_AUTO_SAVE, String.valueOf(autoSave));
	}
	
	/**
	 * Gibt zurück, ob das Logbuch-Menü angezeigt werden soll oder nicht.
	 * 
	 * @return Soll das Logbuch-Menü angezeigt werden? Wird true zurückgegeben,
	 * so soll es angezeigt werden. Bei false, nicht.
	 */
	public boolean showMenu() {
		return Boolean.valueOf(_properties.getProperty(PROPERTY_SHOW_MENU,
				"true"));
	}
	
	/**
	 * Speichert, ob das Logbuch-Menü angezeigt werden soll oder nicht.
	 * 
	 * @param showMenu Soll das Logbuch-Menü angezeigt werden? Wird true
	 * übergeben, so soll es angezeigt werden. Bei false, nicht.
	 */
	public void setShowMenu(boolean showMenu) {
		_properties.setProperty(PROPERTY_SHOW_MENU, String.valueOf(showMenu));
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
		return Boolean.valueOf(_properties.getProperty(PROPERTY_SHOW_MESSAGE +
				String.valueOf(type), "true"));
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
		_properties.setProperty(PROPERTY_SHOW_MESSAGE + String.valueOf(type),
				String.valueOf(out));
	}
	
	/**
	 * Gibt den Namen des Packages für die eigenen Klassen zurück.
	 * 
	 * @return Package-Name der eigenen Klassen.
	 */
	public String getPackageName() {
		return _properties.getProperty(PROPERTY_PACKAGE_NAME);
	}
	
	/**
	 * Speichert den Package-Namen der eigenen Klassen.
	 * 
	 * @param name Name des Packages der eigenen Klassen.
	 */
	public void setPackageName(String name) {
		_properties.setProperty(PROPERTY_PACKAGE_NAME, name);
	}
}
