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
 * Testet, ob die Farben richtig ermittelt werden können.
 * 
 * @author René Majewski
 *
 * @since 0.4
 */
public class TestLogColor {
	/**
	 * Testet die Methode {@link org.log.datas.LogData#getColor(short)}.
	 * 
	 * @deprecated Ersetzt durch {@link org.log.datas.LogData#getBackground(short)}
	 */
	@Test
	public void testGetColorNoOut() {
		assertThat(LogData.getColor(LogData.NO_OUT),
				is(LogData.COLOR_NONE));
	}
	
	/**
	 * Testet die Methode {@link org.log.datas.LogData#getColor(short)}.
	 * 
	 * @deprecated Ersetzt durch {@link org.log.datas.LogData#getBackground(short)}
	 */
	@Test
	public void testGetColorError() {
		assertThat(LogData.getColor(LogData.ERROR),
				is(LogData.COLOR_ERROR));
	}
	
	/**
	 * Testet die Methode {@link org.log.datas.LogData#getColor(short)}.
	 * 
	 * @deprecated Ersetzt durch {@link org.log.datas.LogData#getBackground(short)}
	 */
	@Test
	public void testGetColorWarning() {
		assertThat(LogData.getColor(LogData.WARNING),
				is(LogData.COLOR_WARNING));
	}
	
	/**
	 * Testet die Methode {@link org.log.datas.LogData#getColor(short)}.
	 * 
	 * @deprecated Ersetzt durch {@link org.log.datas.LogData#getBackground(short)}
	 */
	@Test
	public void testGetColorNone() {
		assertThat(LogData.getColor(LogData.NONE), is(LogData.COLOR_NONE));
	}
	
	/**
	 * Testet die Methode {@link org.log.datas.LogData#getColor(short)}.
	 * 
	 * @deprecated Ersetzt durch {@link org.log.datas.LogData#getBackground(short)}
	 */
	@Test
	public void testGetColorOk() {
		assertThat(LogData.getColor(LogData.OK), is(LogData.COLOR_OK));
	}
	
	/**
	 * Testet die Methode {@link org.log.datas.LogData#getColor(short)}.
	 * 
	 * @deprecated Ersetzt durch {@link org.log.datas.LogData#getBackground(short)}
	 */
	@Test
	public void testGetColorInformation() {
		assertThat(LogData.getColor(LogData.INFO),
				is(LogData.COLOR_INFO));
	}
	
	/**
	 * Testet die Methode {@link org.log.datas.LogData#getColor(short)}.
	 * 
	 * @deprecated Ersetzt durch {@link org.log.datas.LogData#getBackground(short)}
	 */
	@Test
	public void testGetColorDatabaseError() {
		assertThat(LogData.getColor(LogData.DATABASE_ERROR),
				is(LogData.COLOR_DATABASE_ERROR));
	}
	
	/**
	 * Testet die Methode {@link org.log.datas.LogData#getColor(short)}.
	 * 
	 * @deprecated Ersetzt durch {@link org.log.datas.LogData#getBackground(short)}
	 */
	@Test
	public void testGetColorDatabaseInsert() {
		assertThat(LogData.getColor(LogData.DATABASE_INSERT),
				is(LogData.COLOR_DATABASE_INSERT));
	}
	/**
	 * Testet die Methode {@link org.log.datas.LogData#getBackground(short)}.
	 */
	@Test
	public void testGetBackgroundNoOut() {
		assertThat(LogData.getBackground(LogData.NO_OUT),
				is(LogData.COLOR_NONE));
	}
	
	/**
	 * Testet die Methode {@link org.log.datas.LogData#getBackground(short)}.
	 */
	@Test
	public void testGetBackgroundError() {
		assertThat(LogData.getBackground(LogData.ERROR),
				is(LogData.COLOR_ERROR));
	}
	
	/**
	 * Testet die Methode {@link org.log.datas.LogData#getBackground(short)}.
	 */
	@Test
	public void testGetBackgroundWarning() {
		assertThat(LogData.getBackground(LogData.WARNING),
				is(LogData.COLOR_WARNING));
	}
	
	/**
	 * Testet die Methode {@link org.log.datas.LogData#getBackground(short)}.
	 */
	@Test
	public void testGetBackgroundNone() {
		assertThat(LogData.getBackground(LogData.NONE), is(LogData.COLOR_NONE));
	}
	
	/**
	 * Testet die Methode {@link org.log.datas.LogData#getBackground(short)}.
	 */
	@Test
	public void testGetBackgroundOk() {
		assertThat(LogData.getBackground(LogData.OK), is(LogData.COLOR_OK));
	}
	
	/**
	 * Testet die Methode {@link org.log.datas.LogData#getBackground(short)}.
	 */
	@Test
	public void testGetBackgroundInformation() {
		assertThat(LogData.getBackground(LogData.INFO),
				is(LogData.COLOR_INFO));
	}
	
	/**
	 * Testet die Methode {@link org.log.datas.LogData#getBackground(short)}.
	 */
	@Test
	public void testGetBackgroundDatabaseError() {
		assertThat(LogData.getBackground(LogData.DATABASE_ERROR),
				is(LogData.COLOR_DATABASE_ERROR));
	}
	
	/**
	 * Testet die Methode {@link org.log.datas.LogData#getBackground(short)}.
	 */
	@Test
	public void testGetBackgroundDatabaseInsert() {
		assertThat(LogData.getBackground(LogData.DATABASE_INSERT),
				is(LogData.COLOR_DATABASE_INSERT));
	}
	/**
	 * Testet die Methode {@link org.log.datas.LogData#getForeground(short)}.
	 */
	@Test
	public void testGetForegroundNoOut() {
		assertThat(LogData.getForeground(LogData.NO_OUT),
				is(LogData.FCOLOR_NONE));
	}
	
	/**
	 * Testet die Methode {@link org.log.datas.LogData#getForeground(short)}.
	 */
	@Test
	public void testGetForegroundError() {
		assertThat(LogData.getForeground(LogData.ERROR),
				is(LogData.FCOLOR_ERROR));
	}
	
	/**
	 * Testet die Methode {@link org.log.datas.LogData#getForeground(short)}.
	 */
	@Test
	public void testGetForegroundWarning() {
		assertThat(LogData.getForeground(LogData.WARNING),
				is(LogData.FCOLOR_WARNING));
	}
	
	/**
	 * Testet die Methode {@link org.log.datas.LogData#getForeground(short)}.
	 */
	@Test
	public void testGetForegroundNone() {
		assertThat(LogData.getForeground(LogData.NONE), is(LogData.FCOLOR_NONE));
	}
	
	/**
	 * Testet die Methode {@link org.log.datas.LogData#getForeground(short)}.
	 */
	@Test
	public void testGetForegroundOk() {
		assertThat(LogData.getForeground(LogData.OK), is(LogData.FCOLOR_OK));
	}
	
	/**
	 * Testet die Methode {@link org.log.datas.LogData#getForeground(short)}.
	 */
	@Test
	public void testGetForegroundInformation() {
		assertThat(LogData.getForeground(LogData.INFO),
				is(LogData.FCOLOR_INFO));
	}
	
	/**
	 * Testet die Methode {@link org.log.datas.LogData#getForeground(short)}.
	 */
	@Test
	public void testGetForegroundDatabaseError() {
		assertThat(LogData.getForeground(LogData.DATABASE_ERROR),
				is(LogData.FCOLOR_DATABASE_ERROR));
	}
	
	/**
	 * Testet die Methode {@link org.log.datas.LogData#getForeground(short)}.
	 */
	@Test
	public void testGetForegroundDatabaseInsert() {
		assertThat(LogData.getForeground(LogData.DATABASE_INSERT),
				is(LogData.FCOLOR_DATABASE_INSERT));
	}
}
