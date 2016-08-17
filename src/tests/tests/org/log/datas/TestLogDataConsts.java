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

import java.awt.Color;

import org.junit.Test;
import org.log.datas.LogData;

/**
 * In dieser Klasse werden alle Konstanten der Klasse
 * {@link org.log.datas.LogData} überprüft.
 * 
 * @author René Majewski
 *
 * @since 0.4
 */
public class TestLogDataConsts {
	
	/**
	 * Testet die Konstante {@link org.log.datas.LogData#NO_OUT}.
	 */
	@Test
	public void testNoOut() {
		assertThat(LogData.NO_OUT, is((short)0));
	}
	
	/**
	 * Testet die Konstante {@link org.log.datas.LogData#ERROR}.
	 */
	@Test
	public void testError() {
		assertThat(LogData.ERROR, is((short)1));
	}
	
	/**
	 * Testet die Konstante {@link org.log.datas.LogData#WARNING}.
	 */
	@Test
	public void testWarning() {
		assertThat(LogData.WARNING, is((short)2));
	}
	
	/**
	 * Testet die Konstante {@link org.log.datas.LogData#NONE}.
	 */
	@Test
	public void testNone() {
		assertThat(LogData.NONE, is((short)3));
	}
	
	/**
	 * Testet die Konstante {@link org.log.datas.LogData#OK}.
	 */
	@Test
	public void testOk() {
		assertThat(LogData.OK, is((short)4));
	}
	
	/**
	 * Testet die Konstante {@link org.log.datas.LogData#INFO}.
	 */
	@Test
	public void testInfo() {
		assertThat(LogData.INFO, is((short)5));
	}
	
	/**
	 * Testet die Konstante {@link org.log.datas.LogData#DATABASE_ERROR}.
	 */
	@Test
	public void testDatabaseError() {
		assertThat(LogData.DATABASE_ERROR, is((short)6));
	}
	
	/**
	 * Testet die Konstante {@link org.log.datas.LogData#DATABASE_INSERT}.
	 */
	@Test
	public void testDatabaseInsert() {
		assertThat(LogData.DATABASE_INSERT, is((short)7));
	}
	
	/**
	 * Testet die Konstante {@link org.log.datas.LogData#COLOR_ERROR}.
	 */
	@Test
	public void testColorError() {
		assertThat(LogData.COLOR_ERROR, is(Color.RED));
	}
	
	/**
	 * Testet die Konstante {@link org.log.datas.LogData#COLOR_WARNING}.
	 */
	@Test
	public void testColorWarning() {
		assertThat(LogData.COLOR_WARNING, is(Color.ORANGE));
	}
	
	/**
	 * Testet die Konstante {@link org.log.datas.LogData#COLOR_NONE}.
	 */
	@Test
	public void testColorNone() {
		assertThat(LogData.COLOR_NONE, is(Color.LIGHT_GRAY));
	}
	
	/**
	 * Testet die Konstante {@link org.log.datas.LogData#COLOR_OK}.
	 */
	@Test
	public void testColorOk() {
		assertThat(LogData.COLOR_OK, is(Color.GREEN));
	}
	
	/**
	 * Testet die Konstante {@link org.log.datas.LogData#COLOR_INFO}.
	 */
	@Test
	public void testColorInfo() {
		assertThat(LogData.COLOR_INFO, is(Color.BLUE));
	}
	
	/**
	 * Testet die Konstante {@link org.log.datas.LogData#COLOR_DATABASE_ERROR}.
	 */
	@Test
	public void testColorDatabaseError() {
		assertThat(LogData.COLOR_DATABASE_ERROR, is(Color.RED));
	}
	
	/**
	 * Testet die Konstante {@link org.log.datas.LogData#COLOR_DATABASE_INSERT}.
	 */
	@Test
	public void testColorDatabaseInsert() {
		assertThat(LogData.COLOR_DATABASE_INSERT, is(Color.LIGHT_GRAY));
	}
	
	/**
	 * Testet die Konstante {@link org.log.datas.LogData#FCOLOR_ERROR}.
	 */
	@Test
	public void testFcolorError() {
		assertThat(LogData.FCOLOR_ERROR, is(Color.WHITE));
	}
	
	/**
	 * Testet die Konstante {@link org.log.datas.LogData#FCOLOR_WARNING}.
	 */
	@Test
	public void testFcolorWarning() {
		assertThat(LogData.FCOLOR_WARNING, is(Color.BLACK));
	}
	
	/**
	 * Testet die Konstante {@link org.log.datas.LogData#FCOLOR_NONE}.
	 */
	@Test
	public void testFcolorNone() {
		assertThat(LogData.FCOLOR_NONE, is(Color.BLACK));
	}
	
	/**
	 * Testet die Konstante {@link org.log.datas.LogData#FCOLOR_OK}.
	 */
	@Test
	public void testFcolorOk() {
		assertThat(LogData.FCOLOR_OK, is(Color.BLACK));
	}
	
	/**
	 * Testet die Konstante {@link org.log.datas.LogData#FCOLOR_INFO}.
	 */
	@Test
	public void testFcolorInfo() {
		assertThat(LogData.FCOLOR_INFO, is(Color.CYAN));
	}
	
	/**
	 * Testet die Konstante {@link org.log.datas.LogData#FCOLOR_DATABASE_ERROR}.
	 */
	@Test
	public void testFcolorDatabaseError() {
		assertThat(LogData.FCOLOR_DATABASE_ERROR, is(Color.BLUE));
	}
	
	/**
	 * Testet die Konstante {@link org.log.datas.LogData#FCOLOR_DATABASE_INSERT}.
	 */
	@Test
	public void testFcolorDatabaseInsert() {
		assertThat(LogData.FCOLOR_DATABASE_INSERT, is(Color.BLUE));
	}
}
