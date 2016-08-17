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

package tests.org.log.config;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

import org.junit.Test;
import org.log.config.LogConfig;

/**
 * Testet die Konstanten der Klasse {@link org.log.config.LogConfig}.
 * 
 * @author René Majewski
 *
 * @since 0.4
 */
public class TestLogConfigConstants {
	/**
	 * Testet, ob der Name der Einstellungs-Datei angegeben wurde.
	 * 
	 * @see org.log.config.LogConfig#FILE_PROPERTIES
	 */
	@Test
	public void testFileProperties() {
		assertThat(LogConfig.FILE_PROPERTIES, is("log.properties.xml"));
	}
	
	/**
	 * Testet, ob der Name der automatischen Logbuch-Sicherung angegeben wurde.
	 * 
	 * @see org.log.config.LogConfig#LOG_NAME
	 */
	@Test
	public void testLogName() {
		assertThat(LogConfig.LOG_NAME, is("log.txt"));
	}

	/**
	 * Testet, ob der Name der Einstellung zur Auswahl des automatischen
	 * speichern angegeben wurde.
	 * 
	 * @see org.log.config.LogConfig#PROPERTY_AUTO_SAVE
	 */
	@Test
	public void testPropertyAutoSave() {
		assertThat(LogConfig.PROPERTY_AUTO_SAVE, is("Log.property.autoSave"));
	}
	
	/**
	 * Testet, ob der Name der Einstellung zur Angabe der Datei zur
	 * automatischen Sicherung angegeben wurde.
	 * 
	 * @see org.log.config.LogConfig#PROPERTY_AUTO_NAME
	 */
	@Test
	public void testPropertyAutoName() {
		assertThat(LogConfig.PROPERTY_AUTO_NAME, is("Log.property.autoName"));
	}
	
	/**
	 * Testet, ob der Name der Einstellung zum Anzeigen des Menüs angegeben
	 * wurde.
	 * 
	 * @see org.log.config.LogConfig#PROPERTY_SHOW_MENU
	 */
	@Test
	public void testPropertyShorMenu() {
		assertThat(LogConfig.PROPERTY_SHOW_MENU, is("Log.property.showMenu"));
	}
	
	/**
	 * Testet, ob der Name der Einstellung zur Angabe des eigenen Packages
	 * angegeben wurde.
	 * 
	 * @see org.log.config.LogConfig#PROPERTY_PACKAGE_NAME
	 */
	@Test
	public void testPropertyPackageName() {
		assertThat(LogConfig.PROPERTY_PACKAGE_NAME,
				is("Log.property.packageName"));
	}
	
	/**
	 * Testet, ob der Name der Einstellung zur Angabe des Suffixes für die
	 * Anzeige der verschiedenen Nachrichten-Typen angegeben wurde.
	 * 
	 * @see org.log.config.LogConfig#PROPERTY_SHOW_MESSAGE
	 */
	@Test
	public void testPropertyShowMessage() {
		assertThat(LogConfig.PROPERTY_SHOW_MESSAGE, 
				is("Log.property.message.show."));
	}
	
	/**
	 * Testet, ob der Name der Einstellung zur Angabe des Suffixes für die
	 * Textfarbe der verschiedenen Nachrichten-Typen angegeben wurde.
	 * 
	 * @see org.log.config.LogConfig#PROPERTY_FCOLOR_MESSAGE
	 */
	@Test
	public void testPropertyFcolorMessage() {
		assertThat(LogConfig.PROPERTY_FCOLOR_MESSAGE, 
				is("Log.property.message.fcolor."));
	}
	
	/**
	 * Testet, ob der Name der Einstellung zur Angabe des Suffixes für die
	 * Hintergrundfarbe der verschiedenen Nachrichten-Typen angegeben wurde.
	 * 
	 * @see org.log.config.LogConfig#PROPERTY_BCOLOR_MESSAGE
	 */
	@Test
	public void testPropertyBcolorMessage() {
		assertThat(LogConfig.PROPERTY_BCOLOR_MESSAGE, 
				is("Log.property.message.bcolor."));
	}
}
