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

import java.awt.Color;

import org.junit.Before;
import org.junit.Test;
import org.log.config.LogConfig;
import org.log.datas.LogData;
import org.log.exceptions.NoLogTypeException;

/**
 * Testet die Klasse {@link org.log.config.LogConfig} und ob die standard
 * Einstellungen richtig gesetzt wurden.
 * 
 * @author René Majewski
 *
 * @since 0.4
 */
public class TestLogConfig {
	/**
	 * Speichert die Instanz der Konfiguration
	 */
	private LogConfig _config;

	/**
	 */
	@Before
	public void setUp() {
		_config = LogConfig.getInstance();
		_config.clear();
	}

	/**
	 * Testet, ob eine Instanz von LogConfig zurückgegeben wird.
	 * 
	 * @see org.log.config.LogConfig#getInstance()
	 */
	@Test
	public void testGetInstance() {
		assertThat(LogConfig.getInstance(), not(nullValue()));
		assertThat(LogConfig.getInstance(), is(instanceOf(LogConfig.class)));
	}

	/**
	 * Testet, ob der Datei-Name für die automatische Logbuch-Speicherung
	 * gelesen werden kann.
	 * 
	 * @see org.log.config.LogConfig#getAutoFileName()
	 */
	@Test
	public void testGetAutoFileName() {
		assertThat(_config.getAutoFileName(), is(LogConfig.LOG_NAME));
	}

	/**
	 * Testet, ob der Datei-Name für die automatische Logbuch-Speicherung
	 * gesetzt werden kann.
	 * 
	 * @see org.log.config.LogConfig#setAutoFileName(java.lang.String)
	 */
	@Test
	public void testSetAutoFileName() {
		String test = "test.test";
		_config.setAutoFileName(test);
		
		assertThat(_config.getAutoFileName(), is(test));
	}

	/**
	 * Testet, ob der Fehler IllegalArgumentException ausgelöst wird, wenn null
	 * als Argument übergeben wird.
	 * 
	 * @see org.log.config.LogConfig#setAutoFileName(java.lang.String)
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testSetAutoFileNameWithNullAsParameter() {
		_config.setAutoFileName(null);
	}
	
	/**
	 * Testet, ob der Fehler IllegalArgumentException ausgelöst wird, wenn eine
	 * leere Zeichenkette als Parameter übergeben wird.
	 * 
	 * @see org.log.config.LogConfig#setAutoFileName(java.lang.String)
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testSetAutoFileNameWithEmptyStringAsParameter() {
		_config.setAutoFileName(new String());
	}

	/**
	 * Testet, ob die Einstellung, ob automatisch das Logbuch gespeichert werden
	 * soll gelesen werden kann.
	 * 
	 * @see org.log.config.LogConfig#isAutoSave()
	 */
	@Test
	public void testIsAutoSave() {
		assertThat(_config.isAutoSave(), is(true));
	}

	/**
	 * Testet, ob die Einstellung, ob automatisch das Logbuch gespeichert werden
	 * soll, gesetzt werden kann.
	 * 
	 * @see org.log.config.LogConfig#setAutoSave(boolean)
	 */
	@Test
	public void testSetAutoSave() {
		_config.setAutoSave(false);
		
		assertThat(_config.isAutoSave(), is(false));
	}

	/**
	 * Testet, ob die Einstellung zum Anzeigen des Menüs gelesen werden kann.
	 * 
	 * @see org.log.config.LogConfig#showMenu()
	 */
	@Test
	public void testShowMenu() {
		assertThat(_config.showMenu(), is(true));
	}

	/**
	 * Testet, ob die Einstellung zum Anzeigen des Menüs gesetzt werden kann.
	 * 
	 * @see org.log.config.LogConfig#setShowMenu(boolean)
	 */
	@Test
	public void testSetShowMenu() {
		_config.setShowMenu(false);
		
		assertThat(_config.showMenu(), is(false));
	}

	/**
	 * Testet, ob die Einstellung zum Anzeigen des Nachrichten-Types "NO_OUT"
	 * gelesen werden kann und die richtig Einstellung besitzt.
	 * 
	 * @see org.log.config.LogConfig#getMessageTypeOut(short)
	 */
	@Test
	public void testGetMessageTypeOutWithTypeNoOut() {
		short type = LogData.NO_OUT;
		
		assertThat(_config.getMessageTypeOut(type), is(false));
	}

	/**
	 * Testet, ob die Einstellung zum Anzeigen des Nachrichten-Types "NO_OUT"
	 * gesetzt werden kann.
	 * 
	 * @see org.log.config.LogConfig#setMessageTypeOut(short, boolean)
	 */
	@Test
	public void testSetMessageTypeOutWithTypeNoOut() {
		short type = LogData.NO_OUT;
		_config.setMessageTypeOut(type, true);
		
		assertThat(_config.getMessageTypeOut(type), is(true));
	}

	/**
	 * Testet, ob die Einstellung zum Anzeigen des Nachrichten-Types "NONE"
	 * gelesen werden kann und die richtig Einstellung besitzt.
	 * 
	 * @see org.log.config.LogConfig#getMessageTypeOut(short)
	 */
	@Test
	public void testGetMessageTypeOutWithTypeNone() {
		short type = LogData.NONE;
		
		assertThat(_config.getMessageTypeOut(type), is(true));
	}

	/**
	 * Testet, ob die Einstellung zum Anzeigen des Nachrichten-Types "NONE"
	 * gesetzt werden kann.
	 * 
	 * @see org.log.config.LogConfig#setMessageTypeOut(short, boolean)
	 */
	@Test
	public void testSetMessageTypeOutWithTypeNone() {
		short type = LogData.NONE;
		_config.setMessageTypeOut(type, false);
		
		assertThat(_config.getMessageTypeOut(type), is(false));
	}

	/**
	 * Testet, ob die Einstellung zum Anzeigen des Nachrichten-Types "ERROR"
	 * gelesen werden kann und die richtig Einstellung besitzt.
	 * 
	 * @see org.log.config.LogConfig#getMessageTypeOut(short)
	 */
	@Test
	public void testGetMessageTypeOutWithTypeError() {
		short type = LogData.ERROR;
		
		assertThat(_config.getMessageTypeOut(type), is(true));
	}

	/**
	 * Testet, ob die Einstellung zum Anzeigen des Nachrichten-Types "ERROR"
	 * gesetzt werden kann.
	 * 
	 * @see org.log.config.LogConfig#setMessageTypeOut(short, boolean)
	 */
	@Test
	public void testSetMessageTypeOutWithTypeError() {
		short type = LogData.ERROR;
		_config.setMessageTypeOut(type, false);
		
		assertThat(_config.getMessageTypeOut(type), is(false));
	}

	/**
	 * Testet, ob die Einstellung zum Anzeigen des Nachrichten-Types "WARNING"
	 * gelesen werden kann und die richtig Einstellung besitzt.
	 * 
	 * @see org.log.config.LogConfig#getMessageTypeOut(short)
	 */
	@Test
	public void testGetMessageTypeOutWithTypeWarning() {
		short type = LogData.WARNING;
		
		assertThat(_config.getMessageTypeOut(type), is(true));
	}

	/**
	 * Testet, ob die Einstellung zum Anzeigen des Nachrichten-Types "WARNING"
	 * gesetzt werden kann.
	 * 
	 * @see org.log.config.LogConfig#setMessageTypeOut(short, boolean)
	 */
	@Test
	public void testSetMessageTypeOutWithTypeWarning() {
		short type = LogData.WARNING;
		_config.setMessageTypeOut(type, false);
		
		assertThat(_config.getMessageTypeOut(type), is(false));
	}

	/**
	 * Testet, ob die Einstellung zum Anzeigen des Nachrichten-Types "OK"
	 * gelesen werden kann und die richtig Einstellung besitzt.
	 * 
	 * @see org.log.config.LogConfig#getMessageTypeOut(short)
	 */
	@Test
	public void testGetMessageTypeOutWithTypeOk() {
		short type = LogData.OK;
		
		assertThat(_config.getMessageTypeOut(type), is(true));
	}

	/**
	 * Testet, ob die Einstellung zum Anzeigen des Nachrichten-Types "OK"
	 * gesetzt werden kann.
	 * 
	 * @see org.log.config.LogConfig#setMessageTypeOut(short, boolean)
	 */
	@Test
	public void testSetMessageTypeOutWithTypeOk() {
		short type = LogData.OK;
		_config.setMessageTypeOut(type, false);
		
		assertThat(_config.getMessageTypeOut(type), is(false));
	}

	/**
	 * Testet, ob die Einstellung zum Anzeigen des Nachrichten-Types "INFO"
	 * gelesen werden kann und die richtig Einstellung besitzt.
	 * 
	 * @see org.log.config.LogConfig#getMessageTypeOut(short)
	 */
	@Test
	public void testGetMessageTypeOutWithTypeInfo() {
		short type = LogData.INFO;
		
		assertThat(_config.getMessageTypeOut(type), is(true));
	}

	/**
	 * Testet, ob die Einstellung zum Anzeigen des Nachrichten-Types "INFO"
	 * gesetzt werden kann.
	 * 
	 * @see org.log.config.LogConfig#setMessageTypeOut(short, boolean)
	 */
	@Test
	public void testSetMessageTypeOutWithTypeInfo() {
		short type = LogData.INFO;
		_config.setMessageTypeOut(type, false);
		
		assertThat(_config.getMessageTypeOut(type), is(false));
	}

	/**
	 * Testet, ob die Einstellung zum Anzeigen des Nachrichten-Types
	 * "DATABASE_ERROR" gelesen werden kann und die richtig Einstellung besitzt.
	 * 
	 * @see org.log.config.LogConfig#getMessageTypeOut(short)
	 */
	@Test
	public void testGetMessageTypeOutWithTypeDatabaseError() {
		short type = LogData.DATABASE_ERROR;
		
		assertThat(_config.getMessageTypeOut(type), is(true));
	}

	/**
	 * Testet, ob die Einstellung zum Anzeigen des Nachrichten-Types
	 * "DATABASE_ERROR" gesetzt werden kann.
	 * 
	 * @see org.log.config.LogConfig#setMessageTypeOut(short, boolean)
	 */
	@Test
	public void testSetMessageTypeOutWithTypeDatabaseError() {
		short type = LogData.DATABASE_ERROR;
		_config.setMessageTypeOut(type, false);
		
		assertThat(_config.getMessageTypeOut(type), is(false));
	}

	/**
	 * Testet, ob die Einstellung zum Anzeigen des Nachrichten-Types
	 * "DATABASE_INSERT" gelesen werden kann und die richtig Einstellung
	 * besitzt.
	 * 
	 * @see org.log.config.LogConfig#getMessageTypeOut(short)
	 */
	@Test
	public void testGetMessageTypeOutWithTypeDatabaseInsert() {
		short type = LogData.DATABASE_INSERT;
		
		assertThat(_config.getMessageTypeOut(type), is(true));
	}

	/**
	 * Testet, ob die Einstellung zum Anzeigen des Nachrichten-Types
	 * "DATABASE_INSERT" gesetzt werden kann.
	 * 
	 * @see org.log.config.LogConfig#setMessageTypeOut(short, boolean)
	 */
	@Test
	public void testSetMessageTypeOutWithTypeDatabaseInsert() {
		short type = LogData.DATABASE_INSERT;
		_config.setMessageTypeOut(type, false);
		
		assertThat(_config.getMessageTypeOut(type), is(false));
	}
	
	/**
	 * Testet, ob der Fehler NoLogTypeException auftritt, wenn -1 als
	 * Nachrichten-Type übergeben wird.
	 * 
	 * @see org.log.config.LogConfig#setForeground(short, java.awt.Color)
	 */
	@Test(expected=NoLogTypeException.class)
	public void testSetMessageTypeOutWithMinusOneAsType() {
		_config.setMessageTypeOut((short)-1, true);
	}
	
	/**
	 * Testet, ob der Fehler NoLogTypeException auftritt, wenn 8 als
	 * Nachrichten-Type übergeben wird.
	 * 
	 * @see org.log.config.LogConfig#setForeground(short, java.awt.Color)
	 */
	@Test(expected=NoLogTypeException.class)
	public void testSetMessageTypeOutWithEightAsType() {
		_config.setMessageTypeOut((short)8, true);
	}

	/**
	 * Testet, ob die Einstellung der Textfarbe des Nachrichten-Types "NO_OUT"
	 * gelesen werden kann und die richtige Einstellung besitzt.
	 * 
	 * @see org.log.config.LogConfig#getForeground(short)
	 */
	@Test
	public void testGetForegroundWithTypeNoOut() {
		short type = LogData.NO_OUT;
		Color color = LogData.getForeground(type);
		
		assertThat(_config.getForeground(type), is(color));
	}

	/**
	 * Testet, ob die Einstellung der Textfarbe des Nachrichten-Types "NO_OUT"
	 * gesetzt werden kann.
	 * 
	 * @see org.log.config.LogConfig#setForeground(short, java.awt.Color)
	 */
	@Test
	public void testSetForegroundWithTypeNoOut() {
		short type = LogData.NO_OUT;
		Color color = new Color(10, 10, 10);
		
		_config.setForeground(type, color);
		assertThat(_config.getForeground(type), is(color));
	}

	/**
	 * Testet, ob die Einstellung der Textfarbe des Nachrichten-Types "NONE"
	 * gelesen werden kann und die richtige Einstellung besitzt.
	 * 
	 * @see org.log.config.LogConfig#getForeground(short)
	 */
	@Test
	public void testGetForegroundWithTypeNone() {
		short type = LogData.NONE;
		Color color = LogData.getForeground(type);
		
		assertThat(_config.getForeground(type), is(color));
	}

	/**
	 * Testet, ob die Einstellung der Textfarbe des Nachrichten-Types "NONE"
	 * gesetzt werden kann.
	 * 
	 * @see org.log.config.LogConfig#setForeground(short, java.awt.Color)
	 */
	@Test
	public void testSetForegroundWithTypeNone() {
		short type = LogData.NONE;
		Color color = new Color(10, 10, 10);
		
		_config.setForeground(type, color);
		assertThat(_config.getForeground(type), is(color));
	}

	/**
	 * Testet, ob die Einstellung der Textfarbe des Nachrichten-Types "ERROR"
	 * gelesen werden kann und die richtige Einstellung besitzt.
	 * 
	 * @see org.log.config.LogConfig#getForeground(short)
	 */
	@Test
	public void testGetForegroundWithTypeError() {
		short type = LogData.ERROR;
		Color color = LogData.getForeground(type);
		
		assertThat(_config.getForeground(type), is(color));
	}

	/**
	 * Testet, ob die Einstellung der Textfarbe des Nachrichten-Types "ERROR"
	 * gesetzt werden kann.
	 * 
	 * @see org.log.config.LogConfig#setForeground(short, java.awt.Color)
	 */
	@Test
	public void testSetForegroundWithTypeError() {
		short type = LogData.ERROR;
		Color color = new Color(10, 10, 10);
		
		_config.setForeground(type, color);
		assertThat(_config.getForeground(type), is(color));
	}

	/**
	 * Testet, ob die Einstellung der Textfarbe des Nachrichten-Types "WARNING"
	 * gelesen werden kann und die richtige Einstellung besitzt.
	 * 
	 * @see org.log.config.LogConfig#getForeground(short)
	 */
	@Test
	public void testGetForegroundWithTypeWarning() {
		short type = LogData.WARNING;
		Color color = LogData.getForeground(type);
		
		assertThat(_config.getForeground(type), is(color));
	}

	/**
	 * Testet, ob die Einstellung der Textfarbe des Nachrichten-Types "WARNING"
	 * gesetzt werden kann.
	 * 
	 * @see org.log.config.LogConfig#setForeground(short, java.awt.Color)
	 */
	@Test
	public void testSetForegroundWithTypeWarning() {
		short type = LogData.WARNING;
		Color color = new Color(10, 10, 10);
		
		_config.setForeground(type, color);
		assertThat(_config.getForeground(type), is(color));
	}

	/**
	 * Testet, ob die Einstellung der Textfarbe des Nachrichten-Types "OK"
	 * gelesen werden kann und die richtige Einstellung besitzt.
	 * 
	 * @see org.log.config.LogConfig#getForeground(short)
	 */
	@Test
	public void testGetForegroundWithTypeOk() {
		short type = LogData.OK;
		Color color = LogData.getForeground(type);
		
		assertThat(_config.getForeground(type), is(color));
	}

	/**
	 * Testet, ob die Einstellung der Textfarbe des Nachrichten-Types "OK"
	 * gesetzt werden kann.
	 * 
	 * @see org.log.config.LogConfig#setForeground(short, java.awt.Color)
	 */
	@Test
	public void testSetForegroundWithTypeOk() {
		short type = LogData.OK;
		Color color = new Color(10, 10, 10);
		
		_config.setForeground(type, color);
		assertThat(_config.getForeground(type), is(color));
	}

	/**
	 * Testet, ob die Einstellung der Textfarbe des Nachrichten-Types "INFO"
	 * gelesen werden kann und die richtige Einstellung besitzt.
	 * 
	 * @see org.log.config.LogConfig#getForeground(short)
	 */
	@Test
	public void testGetForegroundWithTypeInfo() {
		short type = LogData.INFO;
		Color color = LogData.getForeground(type);
		
		assertThat(_config.getForeground(type), is(color));
	}

	/**
	 * Testet, ob die Einstellung der Textfarbe des Nachrichten-Types "INFO"
	 * gesetzt werden kann.
	 * 
	 * @see org.log.config.LogConfig#setForeground(short, java.awt.Color)
	 */
	@Test
	public void testSetForegroundWithTypeInfo() {
		short type = LogData.INFO;
		Color color = new Color(10, 10, 10);
		
		_config.setForeground(type, color);
		assertThat(_config.getForeground(type), is(color));
	}

	/**
	 * Testet, ob die Einstellung der Textfarbe des Nachrichten-Types
	 * "DATABASE_ERROR" gelesen werden kann und die richtige Einstellung
	 * besitzt.
	 * 
	 * @see org.log.config.LogConfig#getForeground(short)
	 */
	@Test
	public void testGetForegroundWithTypeDatabaseError() {
		short type = LogData.DATABASE_ERROR;
		Color color = LogData.getForeground(type);
		
		assertThat(_config.getForeground(type), is(color));
	}

	/**
	 * Testet, ob die Einstellung der Textfarbe des Nachrichten-Types
	 * "DATABASE_ERROR" gesetzt werden kann.
	 * 
	 * @see org.log.config.LogConfig#setForeground(short, java.awt.Color)
	 */
	@Test
	public void testSetForegroundWithTypeDatabaseError() {
		short type = LogData.DATABASE_ERROR;
		Color color = new Color(10, 10, 10);
		
		_config.setForeground(type, color);
		assertThat(_config.getForeground(type), is(color));
	}

	/**
	 * Testet, ob die Einstellung der Textfarbe des Nachrichten-Types
	 * "DATABASE_INSERT" gelesen werden kann und die richtige Einstellung
	 * besitzt.
	 * 
	 * @see org.log.config.LogConfig#getForeground(short)
	 */
	@Test
	public void testGetForegroundWithTypeDatabaseInsert() {
		short type = LogData.DATABASE_INSERT;
		Color color = LogData.getForeground(type);
		
		assertThat(_config.getForeground(type), is(color));
	}

	/**
	 * Testet, ob die Einstellung der Textfarbe des Nachrichten-Types
	 * "DATABASE_INSERT" gesetzt werden kann.
	 * 
	 * @see org.log.config.LogConfig#setForeground(short, java.awt.Color)
	 */
	@Test
	public void testSetForegroundWithTypeDatabaseInsert() {
		short type = LogData.DATABASE_INSERT;
		Color color = new Color(10, 10, 10);
		
		_config.setForeground(type, color);
		assertThat(_config.getForeground(type), is(color));
	}
	
	/**
	 * Testet, ob der Fehler IllegalArgumentException auftritt, wenn null als
	 * Farbe übergeben wird.
	 * 
	 * @see org.log.config.LogConfig#setForeground(short, java.awt.Color)
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testSetForegroundWithNullAsColor() {
		_config.setForeground(LogData.NO_OUT, null);
	}
	
	/**
	 * Testet, ob der Fehler NoLogTypeException auftritt, wenn -1 als
	 * Nachrichten-Type übergeben wird.
	 * 
	 * @see org.log.config.LogConfig#setForeground(short, java.awt.Color)
	 */
	@Test(expected=NoLogTypeException.class)
	public void testSetForegroundWithMinusOneAsType() {
		_config.setForeground((short)-1, Color.BLACK);
	}
	
	/**
	 * Testet, ob der Fehler NoLogTypeException auftritt, wenn 8 als
	 * Nachrichten-Type übergeben wird.
	 * 
	 * @see org.log.config.LogConfig#setForeground(short, java.awt.Color)
	 */
	@Test(expected=NoLogTypeException.class)
	public void testSetForegroundWithEightAsType() {
		_config.setForeground((short)8, Color.BLACK);
	}

	/**
	 * Testet, ob die Einstellung für den Hintergrund des Nachrichten-Types
	 * "NO_OUT" gelesen werden kann und die richtige Einstellung besitzt.
	 * 
	 * @see org.log.config.LogConfig#getBackground(short)
	 */
	@Test
	public void testGetBackgroundWithTypeNoOut() {
		short type = LogData.NO_OUT;
		Color color = LogData.getBackground(type);
		
		assertThat(_config.getBackground(type), is(color));
	}

	/**
	 * Testet, ob die Einstellung für den Hintergrund des Nachrichten-Types
	 * "NO_OUT" gesetzt werden kann.
	 * 
	 * @see org.log.config.LogConfig#setBackground(short, java.awt.Color)
	 */
	@Test
	public void testSetBackgroundWithTypeNoOut() {
		short type = LogData.NO_OUT;
		Color color = new Color(20, 20, 20);
		
		_config.setBackground(type, color);
		assertThat(_config.getBackground(type), is(color));
	}

	/**
	 * Testet, ob die Einstellung für den Hintergrund des Nachrichten-Types
	 * "NONE" gelesen werden kann und die richtige Einstellung besitzt.
	 * 
	 * @see org.log.config.LogConfig#getBackground(short)
	 */
	@Test
	public void testGetBackgroundWithTypeNone() {
		short type = LogData.NONE;
		Color color = LogData.getBackground(type);
		
		assertThat(_config.getBackground(type), is(color));
	}

	/**
	 * Testet, ob die Einstellung für den Hintergrund des Nachrichten-Types
	 * "NONE" gesetzt werden kann.
	 * 
	 * @see org.log.config.LogConfig#setBackground(short, java.awt.Color)
	 */
	@Test
	public void testSetBackgroundWithTypeNone() {
		short type = LogData.NONE;
		Color color = new Color(20, 20, 20);
		
		_config.setBackground(type, color);
		assertThat(_config.getBackground(type), is(color));
	}

	/**
	 * Testet, ob die Einstellung für den Hintergrund des Nachrichten-Types
	 * "ERROR" gelesen werden kann und die richtige Einstellung besitzt.
	 * 
	 * @see org.log.config.LogConfig#getBackground(short)
	 */
	@Test
	public void testGetBackgroundWithTypeError() {
		short type = LogData.ERROR;
		Color color = LogData.getBackground(type);
		
		assertThat(_config.getBackground(type), is(color));
	}

	/**
	 * Testet, ob die Einstellung für den Hintergrund des Nachrichten-Types
	 * "ERROR" gesetzt werden kann.
	 * 
	 * @see org.log.config.LogConfig#setBackground(short, java.awt.Color)
	 */
	@Test
	public void testSetBackgroundWithTypeError() {
		short type = LogData.ERROR;
		Color color = new Color(20, 20, 20);
		
		_config.setBackground(type, color);
		assertThat(_config.getBackground(type), is(color));
	}

	/**
	 * Testet, ob die Einstellung für den Hintergrund des Nachrichten-Types
	 * "WARNING" gelesen werden kann und die richtige Einstellung besitzt.
	 * 
	 * @see org.log.config.LogConfig#getBackground(short)
	 */
	@Test
	public void testGetBackgroundWithTypeWarning() {
		short type = LogData.WARNING;
		Color color = LogData.getBackground(type);
		
		assertThat(_config.getBackground(type), is(color));
	}

	/**
	 * Testet, ob die Einstellung für den Hintergrund des Nachrichten-Types
	 * "WARNING" gesetzt werden kann.
	 * 
	 * @see org.log.config.LogConfig#setBackground(short, java.awt.Color)
	 */
	@Test
	public void testSetBackgroundWithTypeWarning() {
		short type = LogData.WARNING;
		Color color = new Color(20, 20, 20);
		
		_config.setBackground(type, color);
		assertThat(_config.getBackground(type), is(color));
	}

	/**
	 * Testet, ob die Einstellung für den Hintergrund des Nachrichten-Types
	 * "OK" gelesen werden kann und die richtige Einstellung besitzt.
	 * 
	 * @see org.log.config.LogConfig#getBackground(short)
	 */
	@Test
	public void testGetBackgroundWithTypeOk() {
		short type = LogData.OK;
		Color color = LogData.getBackground(type);
		
		assertThat(_config.getBackground(type), is(color));
	}

	/**
	 * Testet, ob die Einstellung für den Hintergrund des Nachrichten-Types
	 * "OK" gesetzt werden kann.
	 * 
	 * @see org.log.config.LogConfig#setBackground(short, java.awt.Color)
	 */
	@Test
	public void testSetBackgroundWithTypeOk() {
		short type = LogData.OK;
		Color color = new Color(20, 20, 20);
		
		_config.setBackground(type, color);
		assertThat(_config.getBackground(type), is(color));
	}

	/**
	 * Testet, ob die Einstellung für den Hintergrund des Nachrichten-Types
	 * "INFO" gelesen werden kann und die richtige Einstellung besitzt.
	 * 
	 * @see org.log.config.LogConfig#getBackground(short)
	 */
	@Test
	public void testGetBackgroundWithTypeInfo() {
		short type = LogData.INFO;
		Color color = LogData.getBackground(type);
		
		assertThat(_config.getBackground(type), is(color));
	}

	/**
	 * Testet, ob die Einstellung für den Hintergrund des Nachrichten-Types
	 * "INFO" gesetzt werden kann.
	 * 
	 * @see org.log.config.LogConfig#setBackground(short, java.awt.Color)
	 */
	@Test
	public void testSetBackgroundWithTypeInfo() {
		short type = LogData.INFO;
		Color color = new Color(20, 20, 20);
		
		_config.setBackground(type, color);
		assertThat(_config.getBackground(type), is(color));
	}

	/**
	 * Testet, ob die Einstellung für den Hintergrund des Nachrichten-Types
	 * "DATABASE_ERROR" gelesen werden kann und die richtige Einstellung
	 * besitzt.
	 * 
	 * @see org.log.config.LogConfig#getBackground(short)
	 */
	@Test
	public void testGetBackgroundWithTypeDatabaseError() {
		short type = LogData.DATABASE_ERROR;
		Color color = LogData.getBackground(type);
		
		assertThat(_config.getBackground(type), is(color));
	}

	/**
	 * Testet, ob die Einstellung für den Hintergrund des Nachrichten-Types
	 * "DATABASE_ERROR" gesetzt werden kann.
	 * 
	 * @see org.log.config.LogConfig#setBackground(short, java.awt.Color)
	 */
	@Test
	public void testSetBackgroundWithTypeDatabaseError() {
		short type = LogData.DATABASE_ERROR;
		Color color = new Color(20, 20, 20);
		
		_config.setBackground(type, color);
		assertThat(_config.getBackground(type), is(color));
	}

	/**
	 * Testet, ob die Einstellung für den Hintergrund des Nachrichten-Types
	 * "DATABASE_INSERT" gelesen werden kann und die richtige Einstellung
	 * besitzt.
	 * 
	 * @see org.log.config.LogConfig#getBackground(short)
	 */
	@Test
	public void testGetBackgroundWithTypeDatabaseInsert() {
		short type = LogData.DATABASE_INSERT;
		Color color = LogData.getBackground(type);
		
		assertThat(_config.getBackground(type), is(color));
	}

	/**
	 * Testet, ob die Einstellung für den Hintergrund des Nachrichten-Types
	 * "DATABASE_INSERT" gesetzt werden kann.
	 * 
	 * @see org.log.config.LogConfig#setBackground(short, java.awt.Color)
	 */
	@Test
	public void testSetBackgroundWithTypeDatabaseInsert() {
		short type = LogData.DATABASE_INSERT;
		Color color = new Color(20, 20, 20);
		
		_config.setBackground(type, color);
		assertThat(_config.getBackground(type), is(color));
	}
	
	/**
	 * Testet, ob der Fehler IllegalArgumentException auftritt, wenn null als
	 * Farbe übergeben wird.
	 * 
	 * @see org.log.config.LogConfig#setBackground(short, java.awt.Color)
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testSetBackgroundWithNullAsColor() {
		_config.setBackground(LogData.NO_OUT, null);
	}
	
	/**
	 * Testet, ob der Fehler NoLogTypeException auftritt, wenn -1 als
	 * Nachrichten-Type übergeben wird.
	 * 
	 * @see org.log.config.LogConfig#setBackground(short, java.awt.Color)
	 */
	@Test(expected=NoLogTypeException.class)
	public void testSetBackgroundWithMinusOneAsType() {
		_config.setBackground((short)-1, Color.BLACK);
	}
	
	/**
	 * Testet, ob der Fehler NoLogTypeException auftritt, wenn 8 als
	 * Nachrichten-Type übergeben wird.
	 * 
	 * @see org.log.config.LogConfig#setBackground(short, java.awt.Color)
	 */
	@Test(expected=NoLogTypeException.class)
	public void testSetBackgroundWithEightAsType() {
		_config.setBackground((short)8, Color.BLACK);
	}
	

	/**
	 * Testet, ob die Einstellung für das eigene Package gelesen werden kann.
	 * 
	 * @see org.log.config.LogConfig#getPackageName()
	 */
	@Test
	public void testGetPackageName() {
		assertThat(_config.getPackageName(), isEmptyString());
	}

	/**
	 * Testet, ob die Einstellung für das eigene Package gesetzt werden kann.
	 * 
	 * @see org.log.config.LogConfig#setPackageName(java.lang.String)
	 */
	@Test
	public void testSetPackageName() {
		String test ="test.test";
		_config.setPackageName(test);
		
		assertThat(_config.getPackageName(), is(test));
	}

	/**
	 * Testet, ob der Fehler IllegalArgumentException ausgelöst wird, wenn null
	 * als Argument übergeben wird.
	 * 
	 * @see org.log.config.LogConfig#setPackageName(java.lang.String)
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testSetPackageNameWithNullAsParameter() {
		_config.setPackageName(null);
	}
	
	/**
	 * Testet, ob der Fehler IllegalArgumentException ausgelöst wird, wenn eine
	 * leere Zeichenkette als Parameter übergeben wird.
	 * 
	 * @see org.log.config.LogConfig#setPackageName(java.lang.String)
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testSetPackageNameWithEmptyStringAsParameter() {
		_config.setPackageName(new String());
	}
}
