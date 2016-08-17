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

package tests.org.log.datas;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

import org.junit.Test;
import org.log.datas.LogData;

/**
 * Teste ob aus den Namen die Nachrichten-Typen und umgekehrt ermittelt werden
 * können.
 * 
 * @author René Majewski
 *
 * @since 0.4
 */
public class TestLogDataNames {
	/**
	 * Testet, ob aus dem Nachrichten-Type "NO_OUT" der Name ermittelt werden
	 * kann.
	 * 
	 * @see org.log.datas.LogData#getMessageName(short)
	 */
	@Test
	public void testGetMessageNameWithTypeNoOut() {
		assertThat(LogData.getMessageName(LogData.NO_OUT),
				is(LogData.NAME_NO_OUT));
	}
	
	/**
	 * Testet, ob aus dem Nachrichten-Type "NONE" der Name ermittelt werden
	 * kann.
	 * 
	 * @see org.log.datas.LogData#getMessageName(short)
	 */
	@Test
	public void testGetMessageNameWithTypeNone() {
		assertThat(LogData.getMessageName(LogData.NONE), is(LogData.NAME_NONE));
	}
	
	/**
	 * Testet, ob aus dem Nachrichten-Type "ERROR" der Name ermittelt werden
	 * kann.
	 * 
	 * @see org.log.datas.LogData#getMessageName(short)
	 */
	@Test
	public void testGetMessageNameWithTypeError() {
		assertThat(LogData.getMessageName(LogData.ERROR),
				is(LogData.NAME_ERROR));
	}
	
	/**
	 * Testet, ob aus dem Nachrichten-Type "WARNING" der Name ermittelt werden
	 * kann.
	 * 
	 * @see org.log.datas.LogData#getMessageName(short)
	 */
	@Test
	public void testGetMessageNameWithTypeWarning() {
		assertThat(LogData.getMessageName(LogData.WARNING),
				is(LogData.NAME_WARNING));
	}
	
	/**
	 * Testet, ob aus dem Nachrichten-Type "OK" der Name ermittelt werden
	 * kann.
	 * 
	 * @see org.log.datas.LogData#getMessageName(short)
	 */
	@Test
	public void testGetMessageNameWithTypeOk() {
		assertThat(LogData.getMessageName(LogData.OK), is(LogData.NAME_OK));
	}
	
	/**
	 * Testet, ob aus dem Nachrichten-Type "INFO" der Name ermittelt werden
	 * kann.
	 * 
	 * @see org.log.datas.LogData#getMessageName(short)
	 */
	@Test
	public void testGetMessageNameWithTypeInfo() {
		assertThat(LogData.getMessageName(LogData.INFO), is(LogData.NAME_INFO));
	}
	
	/**
	 * Testet, ob aus dem Nachrichten-Type "DATABASE_ERROR" der Name ermittelt
	 * werden kann.
	 * 
	 * @see org.log.datas.LogData#getMessageName(short)
	 */
	@Test
	public void testGetMessageNameWithTypeDatabaseError() {
		assertThat(LogData.getMessageName(LogData.DATABASE_ERROR),
				is(LogData.NAME_DATABASE_ERROR));
	}
	
	/**
	 * Testet, ob aus dem Nachrichten-Type "DATABASE_INSERT" der Name ermittelt
	 * werden kann.
	 * 
	 * @see org.log.datas.LogData#getMessageName(short)
	 */
	@Test
	public void testGetMessageNameWithTypeDatabaseInsert() {
		assertThat(LogData.getMessageName(LogData.DATABASE_INSERT),
				is(LogData.NAME_DATABASE_INSERT));
	}
	
	/**
	 * Testet, ob aus dem Namen "NAME_NO_OUT" der Nachrichten-Type ermittelt
	 * werden kann.
	 * 
	 * @see org.log.datas.LogData#getMessageType(String)
	 */
	@Test
	public void testGetMessageTypeWithNameNoOut() {
		assertThat(LogData.getMessageType(LogData.NAME_NO_OUT),
				is(LogData.NO_OUT));
	}
	
	/**
	 * Testet, ob aus dem Namen "NAME_NONE" der Nachrichten-Type ermittelt
	 * werden kann.
	 * 
	 * @see org.log.datas.LogData#getMessageType(String)
	 */
	@Test
	public void testGetMessageTypeWithNameNone() {
		assertThat(LogData.getMessageType(LogData.NAME_NONE), is(LogData.NONE));
	}
	
	/**
	 * Testet, ob aus dem Namen "NAME_ERROR" der Nachrichten-Type ermittelt
	 * werden kann.
	 * 
	 * @see org.log.datas.LogData#getMessageType(String)
	 */
	@Test
	public void testGetMessageTypeWithNameError() {
		assertThat(LogData.getMessageType(LogData.NAME_ERROR),
				is(LogData.ERROR));
	}
	
	/**
	 * Testet, ob aus dem Namen "NAME_WARNING" der Nachrichten-Type ermittelt
	 * werden kann.
	 * 
	 * @see org.log.datas.LogData#getMessageType(String)
	 */
	@Test
	public void testGetMessageTypeWithNameWarning() {
		assertThat(LogData.getMessageType(LogData.NAME_WARNING),
				is(LogData.WARNING));
	}
	
	/**
	 * Testet, ob aus dem Namen "NAME_OK" der Nachrichten-Type ermittelt
	 * werden kann.
	 * 
	 * @see org.log.datas.LogData#getMessageType(String)
	 */
	@Test
	public void testGetMessageTypeWithNameOk() {
		assertThat(LogData.getMessageType(LogData.NAME_OK), is(LogData.OK));
	}
	
	/**
	 * Testet, ob aus dem Namen "NAME_INFO" der Nachrichten-Type ermittelt
	 * werden kann.
	 * 
	 * @see org.log.datas.LogData#getMessageType(String)
	 */
	@Test
	public void testGetMessageTypeWithNameInfo() {
		assertThat(LogData.getMessageType(LogData.NAME_INFO), is(LogData.INFO));
	}
	
	/**
	 * Testet, ob aus dem Namen "NAME_DATABASE_ERROR" der Nachrichten-Type
	 * ermittelt werden kann.
	 * 
	 * @see org.log.datas.LogData#getMessageType(String)
	 */
	@Test
	public void testGetMessageTypeWithNameDatabaseError() {
		assertThat(LogData.getMessageType(LogData.NAME_DATABASE_ERROR),
				is(LogData.DATABASE_ERROR));
	}
	
	/**
	 * Testet, ob aus dem Namen "NAME_DATABASE_INSERT" der Nachrichten-Type
	 * ermittelt werden kann.
	 * 
	 * @see org.log.datas.LogData#getMessageType(String)
	 */
	@Test
	public void testGetMessageTypeWithNameDatabaseInsert() {
		assertThat(LogData.getMessageType(LogData.NAME_DATABASE_INSERT),
				is(LogData.DATABASE_INSERT));
	}
}
