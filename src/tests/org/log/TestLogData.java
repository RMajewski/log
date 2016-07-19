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

import java.awt.Color;

import org.junit.Before;
import org.junit.Test;
import org.log.LogData;

/**
 * Testet die Klasse {@link org.log.LogData}.
 * 
 * @author René Majewski
 *
 * @version 0.1
 * @since 0.1
 */
public class TestLogData {
	/**
	 * Speichert die erstelle Nachricht.
	 */
	private LogData _data;
	
	/**
	 * Speichert den Text für die 1. Test-Nachricht.
	 */
	private String _message;
	
	/**
	 * Speichert den Text für die 2. Test-Nachricht.
	 */
	private String _message2;
	
	/**
	 * Speichert den Text für die 1. Fehlerbeschreibung.
	 */
	private String _error;
	
	/**
	 * Speichert den Text für die 2. Fehlerbeschreibung.
	 */
	private String _error2;
	
	/**
	 * Initialisiert die Tests
	 */
	@Before
	public void setUp() {
		_message = new String("Test Nachricht");
		_message2 = new String("Test Nachricht 2");
		
		_error = new String("Fehlerbeschreibung");
		_error2 = new String("Fehlerbeschreibung 2");
		
		_data = new LogData(_message, _error);
	}
	
	/**
	 * Testet die Konstante {@link org.log.LogData#NO_OUT}.
	 */
	@Test
	public void testNoOut() {
		assertEquals(0, LogData.NO_OUT);
	}
	
	/**
	 * Testet die Konstante {@link org.log.LogData#ERROR}.
	 */
	@Test
	public void testError() {
		assertEquals(1, LogData.ERROR);
	}
	
	/**
	 * Testet die Konstante {@link org.log.LogData#WARNING}.
	 */
	@Test
	public void testWarning() {
		assertEquals(2, LogData.WARNING);
	}
	
	/**
	 * Testet die Konstante {@link org.log.LogData#NONE}.
	 */
	@Test
	public void testNone() {
		assertEquals(3, LogData.NONE);
	}
	
	/**
	 * Testet die Konstante {@link org.log.LogData#OK}.
	 */
	@Test
	public void testOk() {
		assertEquals(4, LogData.OK);
	}
	
	/**
	 * Testet die Konstante {@link org.log.LogData#INFO}.
	 */
	@Test
	public void testInfo() {
		assertEquals(5, LogData.INFO);
	}
	
	/**
	 * Testet die Konstante {@link org.log.LogData#COLOR_ERROR}.
	 */
	@Test
	public void testColorError() {
		assertEquals(Color.RED, LogData.COLOR_ERROR);
	}
	
	/**
	 * Testet die Konstante {@link org.log.LogData#COLOR_WARNING}.
	 */
	@Test
	public void testColorWarning() {
		assertEquals(Color.ORANGE, LogData.COLOR_WARNING);
	}
	
	/**
	 * Testet die Konstante {@link org.log.LogData#COLOR_NONE}.
	 */
	@Test
	public void testColorNone() {
		assertEquals(Color.LIGHT_GRAY, LogData.COLOR_NONE);
	}
	
	/**
	 * Testet die Konstante {@link org.log.LogData#COLOR_OK}.
	 */
	@Test
	public void testColorOk() {
		assertEquals(Color.GREEN, LogData.COLOR_OK);
	}
	
	/**
	 * Testet die Konstante {@link org.log.LogData#COLOR_INFO}.
	 */
	@Test
	public void testColorInfo() {
		assertEquals(Color.BLUE, LogData.COLOR_INFO);
	}
	
	/**
	 * Testet die Methode {@link org.log.LogData#LogData()}.
	 */
	@Test
	public void testLogData() {
		_data = new LogData();
		assertEquals(new String(), _data.getMessage());
		assertEquals(new String(), _data.getError());
		assertEquals(LogData.NO_OUT, _data.getOut());
	}

	/**
	 * Testet die Methode {@link org.log.LogData#LogData(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testLogDataStringString() {
		assertEquals(_message, _data.getMessage());
		assertEquals(_error, _data.getError());
		assertEquals(LogData.NONE, _data.getOut());
	}

	/**
	 * Testet die Methode {@link org.log.LogData#LogData(java.lang.String, java.lang.String, short)}.
	 */
	@Test
	public void testLogDataStringStringShort() {
		_data = new LogData(_message2, _error2, LogData.INFO);
		assertEquals(_message2, _data.getMessage());
		assertEquals(_error2, _data.getError());
		assertEquals(LogData.INFO, _data.getOut());
	}

	/**
	 * Testet die Methode {@link org.log.LogData#getMessage()}.
	 */
	@Test
	public void testGetMessage() {
		assertEquals(_message, _data.getMessage());
	}

	/**
	 * Testet die Methode {@link org.log.LogData#setMessage(java.lang.String)}.
	 */
	@Test
	public void testSetMessage() {
		_data.setMessage(_message2);
		assertEquals(_message2, _data.getMessage());
	}

	/**
	 * Testet die Methode {@link org.log.LogData#getError()}.
	 */
	@Test
	public void testGetError() {
		assertEquals(_error, _data.getError());
	}

	/**
	 * Testet die Methode {@link org.log.LogData#setError(java.lang.String)}.
	 */
	@Test
	public void testSetError() {
		_data.setError(_error2);
		assertEquals(_error2, _data.getError());
	}

	/**
	 * Testet die Methode {@link org.log.LogData#getOut()}.
	 */
	@Test
	public void testGetOut() {
		assertEquals(LogData.NONE, _data.getOut());
	}

	/**
	 * Testet die Methode {@link org.log.LogData#setOut(short)}.
	 */
	@Test
	public void testSetOut() {
		_data.setOut(LogData.WARNING);
		assertEquals(LogData.WARNING, _data.getOut());
	}

	/**
	 * Testet die Methode {@link org.log.LogData#message(String, String)}.
	 */
	@Test
	public void testMessage() {
		_data = LogData.message(_message, _error);
		assertEquals(_message, _data.getMessage());
		assertEquals(_error, _data.getError());
		assertEquals(LogData.NONE, _data.getOut());
	}

	/**
	 * Testet die Methode {@link org.log.LogData#message(String, String, short)}.
	 */
	@Test
	public void testMessageOut() {
		_data = LogData.message(_message, _error, LogData.WARNING);
		assertEquals(_message, _data.getMessage());
		assertEquals(_error, _data.getError());
		assertEquals(LogData.WARNING, _data.getOut());
	}

	/**
	 * Testet die Methode {@link org.log.LogData#messageError(String, String)}.
	 */
	@Test
	public void testMessageError() {
		_data = LogData.messageError(_message, _error);
		assertEquals(_message, _data.getMessage());
		assertEquals(_error, _data.getError());
		assertEquals(LogData.ERROR, _data.getOut());
	}

	/**
	 * Testet die Methode {@link org.log.LogData#messageWarning(String, String)}.
	 */
	@Test
	public void testMessageWarning() {
		_data = LogData.messageWarning(_message, _error);
		assertEquals(_message, _data.getMessage());
		assertEquals(_error, _data.getError());
		assertEquals(LogData.WARNING, _data.getOut());
	}

	/**
	 * Testet die Methode {@link org.log.LogData#messageNoOut(String, String)}.
	 */
	@Test
	public void testMessageNoOut() {
		_data = LogData.messageNoOut(_message, _error);
		assertEquals(_message, _data.getMessage());
		assertEquals(_error, _data.getError());
		assertEquals(LogData.NO_OUT, _data.getOut());
	}

	/**
	 * Testet die Methode {@link org.log.LogData#messageOk(String, String)}.
	 */
	@Test
	public void testMessageOk() {
		_data = LogData.messageOk(_message, _error);
		assertEquals(_message, _data.getMessage());
		assertEquals(_error, _data.getError());
		assertEquals(LogData.OK, _data.getOut());
	}

	/**
	 * Testet die Methode {@link org.log.LogData#messageInformation(String, String)}.
	 */
	@Test
	public void testMessageInfo() {
		_data = LogData.messageInformation(_message, _error);
		assertEquals(_message, _data.getMessage());
		assertEquals(_error, _data.getError());
		assertEquals(LogData.INFO, _data.getOut());
	}
	
	/**
	 * Testet die Method {@link org.log.LogData#message(String, StackTraceElement[])}.
	 */
	@Test
	public void testMessageStackTrace() {
		String class1 = "Test1";
		String class2 = "Test2";
		String method1 = "test1";
		String method2 = "test2";
		String file1 = "Test1.java";
		String file2 = "Test2.java";
		int line1 = 100;
		int line2 = 200;
		
		StackTraceElement ste1 = new StackTraceElement(class1, method1, file1,
				line1);
		StackTraceElement ste2 = new StackTraceElement(class2, method2, file2, 
				line2);
		
		_data = LogData.message(_message, 
				new StackTraceElement[]{ste1, ste2});
		
		String error = class1 + "." + method1 + "(" + file1 + ":" + line1 + 
				")" + System.lineSeparator() + class2 + "." + method2 + "(" + 
				file2 + ":" + line2 + ")" + System.lineSeparator();
		
		assertEquals(_message, _data.getMessage());
		assertEquals(error, _data.getError());
		assertEquals(LogData.NONE, _data.getOut());
	}
	
	/**
	 * Testet die Method {@link org.log.LogData#message(String, StackTraceElement[], short)}.
	 */
	@Test
	public void testMessageStackTraceOut() {
		String class1 = "Test1";
		String class2 = "Test2";
		String method1 = "test1";
		String method2 = "test2";
		String file1 = "Test1.java";
		String file2 = "Test2.java";
		int line1 = 100;
		int line2 = 200;
		
		StackTraceElement ste1 = new StackTraceElement(class1, method1, file1,
				line1);
		StackTraceElement ste2 = new StackTraceElement(class2, method2, file2, 
				line2);
		
		_data = LogData.message(_message, 
				new StackTraceElement[]{ste1, ste2}, LogData.WARNING);
		
		String error = class1 + "." + method1 + "(" + file1 + ":" + line1 + 
				")" + System.lineSeparator() + class2 + "." + method2 + "(" + 
				file2 + ":" + line2 + ")" + System.lineSeparator();
		
		assertEquals(_message, _data.getMessage());
		assertEquals(error, _data.getError());
		assertEquals(LogData.WARNING, _data.getOut());
	}
	
	/**
	 * Testet die Method {@link org.log.LogData#messageError(String, StackTraceElement[])}.
	 */
	@Test
	public void testMessageErrorStackTrace() {
		String class1 = "Test1";
		String class2 = "Test2";
		String method1 = "test1";
		String method2 = "test2";
		String file1 = "Test1.java";
		String file2 = "Test2.java";
		int line1 = 100;
		int line2 = 200;
		
		StackTraceElement ste1 = new StackTraceElement(class1, method1, file1,
				line1);
		StackTraceElement ste2 = new StackTraceElement(class2, method2, file2, 
				line2);
		
		_data = LogData.messageError(_message, 
				new StackTraceElement[]{ste1, ste2});
		
		String error = class1 + "." + method1 + "(" + file1 + ":" + line1 + 
				")" + System.lineSeparator() + class2 + "." + method2 + "(" + 
				file2 + ":" + line2 + ")" + System.lineSeparator();
		
		assertEquals(_message, _data.getMessage());
		assertEquals(error, _data.getError());
		assertEquals(LogData.ERROR, _data.getOut());
	}
	
	/**
	 * Testet die Method {@link org.log.LogData#messageWarning(String, StackTraceElement[])}.
	 */
	@Test
	public void testMessageWarningStackTrace() {
		String class1 = "Test1";
		String class2 = "Test2";
		String method1 = "test1";
		String method2 = "test2";
		String file1 = "Test1.java";
		String file2 = "Test2.java";
		int line1 = 100;
		int line2 = 200;
		
		StackTraceElement ste1 = new StackTraceElement(class1, method1, file1,
				line1);
		StackTraceElement ste2 = new StackTraceElement(class2, method2, file2, 
				line2);
		
		_data = LogData.messageWarning(_message, 
				new StackTraceElement[]{ste1, ste2});
		
		String error = class1 + "." + method1 + "(" + file1 + ":" + line1 + 
				")" + System.lineSeparator() + class2 + "." + method2 + "(" + 
				file2 + ":" + line2 + ")" + System.lineSeparator();
		
		assertEquals(_message, _data.getMessage());
		assertEquals(error, _data.getError());
		assertEquals(LogData.WARNING, _data.getOut());
	}
	
	/**
	 * Testet die Method {@link org.log.LogData#messageNoOut(String, StackTraceElement[])}.
	 */
	@Test
	public void testMessageNoOutStackTrace() {
		String class1 = "Test1";
		String class2 = "Test2";
		String method1 = "test1";
		String method2 = "test2";
		String file1 = "Test1.java";
		String file2 = "Test2.java";
		int line1 = 100;
		int line2 = 200;
		
		StackTraceElement ste1 = new StackTraceElement(class1, method1, file1,
				line1);
		StackTraceElement ste2 = new StackTraceElement(class2, method2, file2, 
				line2);
		
		_data = LogData.messageNoOut(_message, 
				new StackTraceElement[]{ste1, ste2});
		
		String error = class1 + "." + method1 + "(" + file1 + ":" + line1 + 
				")" + System.lineSeparator() + class2 + "." + method2 + "(" + 
				file2 + ":" + line2 + ")" + System.lineSeparator();
		
		assertEquals(_message, _data.getMessage());
		assertEquals(error, _data.getError());
		assertEquals(LogData.NO_OUT, _data.getOut());
	}
	
	/**
	 * Testet die Method {@link org.log.LogData#messageOk(String, StackTraceElement[])}.
	 */
	@Test
	public void testMessageOkStackTrace() {
		String class1 = "Test1";
		String class2 = "Test2";
		String method1 = "test1";
		String method2 = "test2";
		String file1 = "Test1.java";
		String file2 = "Test2.java";
		int line1 = 100;
		int line2 = 200;
		
		StackTraceElement ste1 = new StackTraceElement(class1, method1, file1,
				line1);
		StackTraceElement ste2 = new StackTraceElement(class2, method2, file2, 
				line2);
		
		_data = LogData.messageOk(_message, 
				new StackTraceElement[]{ste1, ste2});
		
		String error = class1 + "." + method1 + "(" + file1 + ":" + line1 + 
				")" + System.lineSeparator() + class2 + "." + method2 + "(" + 
				file2 + ":" + line2 + ")" + System.lineSeparator();
		
		assertEquals(_message, _data.getMessage());
		assertEquals(error, _data.getError());
		assertEquals(LogData.OK, _data.getOut());
	}
	
	/**
	 * Testet die Method {@link org.log.LogData#messageInformation(String, StackTraceElement[])}.
	 */
	@Test
	public void testMessageInfoStackTrace() {
		String class1 = "Test1";
		String class2 = "Test2";
		String method1 = "test1";
		String method2 = "test2";
		String file1 = "Test1.java";
		String file2 = "Test2.java";
		int line1 = 100;
		int line2 = 200;
		
		StackTraceElement ste1 = new StackTraceElement(class1, method1, file1,
				line1);
		StackTraceElement ste2 = new StackTraceElement(class2, method2, file2, 
				line2);
		
		_data = LogData.messageInformation(_message, 
				new StackTraceElement[]{ste1, ste2});
		
		String error = class1 + "." + method1 + "(" + file1 + ":" + line1 + 
				")" + System.lineSeparator() + class2 + "." + method2 + "(" + 
				file2 + ":" + line2 + ")" + System.lineSeparator();
		
		assertEquals(_message, _data.getMessage());
		assertEquals(error, _data.getError());
		assertEquals(LogData.INFO, _data.getOut());
	}
}
