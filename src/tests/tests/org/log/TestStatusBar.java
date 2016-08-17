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

package tests.org.log;

import static org.junit.Assert.*;

import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import org.log.datas.LogData;
import org.log.elements.StatusBar;

/**
 * @author René Majewski
 *
 */
public class TestStatusBar {
	/**
	 * Speichert die Instanz der Status-Bar.
	 */
	private StatusBar _status;
	
	/**
	 * Initialisiert die Tests.
	 */
	@Before
	public void setUp() {
		_status = StatusBar.getInstance();
		_status.clear();
	}
	
	/**
	 * Ermittelt die Anzahl der Log-Einträge.
	 * 
	 * @return Anzahl der Log-Einträge.
	 */
	public int count() {
		return _status.getLog().size();
	}

	/**
	 * Testet die Methode {@link org.log.elements.StatusBar#getInstance()}.
	 */
	@Test
	public void testGetInstance() {
		assertNotNull(StatusBar.getInstance());
		assertEquals(StatusBar.class.getName(), 
				StatusBar.getInstance().getClass().getName());
	}

	/**
	 * Testet die Methode {@link org.log.elements.StatusBar#setMessage(java.lang.String)}.
	 */
	@Test
	public void testSetMessageString() {
		String message = "Test";
		
		assertEquals(0, count());
		
		_status.setMessage(message);
		
		assertEquals(message, _status.getText());
		assertEquals(LogData.COLOR_NONE, _status.getBackground());
		assertEquals(1, count());
		assertEquals(message, _status.getLog().get(0).getMessage());
		assertEquals(new String(), _status.getLog().get(0).getError());
		assertEquals(LogData.NONE, _status.getLog().get(0).getOut());
	}

	/**
	 * Test method for {@link org.log.elements.StatusBar#setMessage(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testSetMessageStringString() {
		String message = "Test";
		String error = "Error";
		
		assertEquals(0, count());
		
		_status.setMessage(message, error);
		
		assertEquals(message, _status.getText());
		assertEquals(LogData.COLOR_NONE, _status.getBackground());
		assertEquals(1, count());
		assertEquals(message, _status.getLog().get(0).getMessage());
		assertEquals(error, _status.getLog().get(0).getError());
		assertEquals(LogData.NONE, _status.getLog().get(0).getOut());
	}

	/**
	 * Test method for {@link org.log.elements.StatusBar#setMessage(java.lang.String, java.lang.Exception)}.
	 */
	@Test
	public void testSetMessageStringException() {
		Exception exception = new Exception();
		
		String message = "Test";
		String error = LogData.createError(exception);
		assertEquals(0, count());
		
		_status.setMessage(message, exception);
		
		assertEquals(message, _status.getText());
		assertEquals(LogData.COLOR_NONE, _status.getBackground());
		assertEquals(1, count());
		assertEquals(message, _status.getLog().get(0).getMessage());
		assertEquals(error, _status.getLog().get(0).getError());
		assertEquals(LogData.NONE, _status.getLog().get(0).getOut());
	}

	/**
	 * Test method for {@link org.log.elements.StatusBar#setMessage(java.lang.String, java.lang.String, short)}.
	 */
	@Test
	public void testSetMessageStringStringShort() {
		String message = "Test";
		String error = "Error";
		
		assertEquals(0, count());
		
		_status.setMessage(message, error, LogData.WARNING);
		
		assertEquals(message, _status.getText());
		assertEquals(LogData.COLOR_WARNING, _status.getBackground());
		assertEquals(1, count());
		assertEquals(message, _status.getLog().get(0).getMessage());
		assertEquals(error, _status.getLog().get(0).getError());
		assertEquals(LogData.WARNING, _status.getLog().get(0).getOut());
	}

	/**
	 * Test method for {@link org.log.elements.StatusBar#setMessage(java.lang.String, java.lang.Exception, short)}.
	 */
	@Test
	public void testSetMessageStringExceptionShort() {
		Exception exception = new Exception();
		
		String message = "Test";
		String error = LogData.createError(exception);
		assertEquals(0, count());
		
		_status.setMessage(message, exception, LogData.WARNING);
		
		assertEquals(message, _status.getText());
		assertEquals(LogData.COLOR_WARNING, _status.getBackground());
		assertEquals(1, count());
		assertEquals(message, _status.getLog().get(0).getMessage());
		assertEquals(error, _status.getLog().get(0).getError());
		assertEquals(LogData.WARNING, _status.getLog().get(0).getOut());
	}

	/**
	 * Test method for {@link org.log.elements.StatusBar#setMessage(org.log.datas.LogData)}.
	 */
	@Test
	public void testSetMessageLogData() {
		String message = "Test";
		String error = "Error";
		short out = LogData.WARNING;
		LogData data = new LogData(message, error, out);
		
		assertEquals(0, count());
		
		_status.setMessage(data);
		
		assertEquals(message, _status.getText());
		assertEquals(LogData.COLOR_WARNING, _status.getBackground());
		assertEquals(1, count());
		assertEquals(data, _status.getLog().get(0));
	}
	
	/**
	 * Testet die Methode {@link org.log.elements.StatusBar#getLog()}.
	 */
	@Test
	public void testGetLog() {
		assertEquals(new ArrayList<LogData>(), _status.getLog());
	}

}
