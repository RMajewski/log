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
import org.log.datas.LogData;

/**
 * Testet die Klasse {@link org.log.datas.LogData}.
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
	 * Testet die Konstante {@link org.log.datas.LogData#NO_OUT}.
	 */
	@Test
	public void testNoOut() {
		assertEquals(0, LogData.NO_OUT);
	}
	
	/**
	 * Testet die Konstante {@link org.log.datas.LogData#ERROR}.
	 */
	@Test
	public void testError() {
		assertEquals(1, LogData.ERROR);
	}
	
	/**
	 * Testet die Konstante {@link org.log.datas.LogData#WARNING}.
	 */
	@Test
	public void testWarning() {
		assertEquals(2, LogData.WARNING);
	}
	
	/**
	 * Testet die Konstante {@link org.log.datas.LogData#NONE}.
	 */
	@Test
	public void testNone() {
		assertEquals(3, LogData.NONE);
	}
	
	/**
	 * Testet die Konstante {@link org.log.datas.LogData#OK}.
	 */
	@Test
	public void testOk() {
		assertEquals(4, LogData.OK);
	}
	
	/**
	 * Testet die Konstante {@link org.log.datas.LogData#INFO}.
	 */
	@Test
	public void testInfo() {
		assertEquals(5, LogData.INFO);
	}
	
	/**
	 * Testet die Konstante {@link org.log.datas.LogData#DATABASE_ERROR}.
	 */
	@Test
	public void testDatabase() {
		assertEquals(6, LogData.DATABASE_ERROR);
	}
	
	/**
	 * Testet die Konstante {@link org.log.datas.LogData#COLOR_ERROR}.
	 */
	@Test
	public void testColorError() {
		assertEquals(Color.RED, LogData.COLOR_ERROR);
	}
	
	/**
	 * Testet die Konstante {@link org.log.datas.LogData#COLOR_WARNING}.
	 */
	@Test
	public void testColorWarning() {
		assertEquals(Color.ORANGE, LogData.COLOR_WARNING);
	}
	
	/**
	 * Testet die Konstante {@link org.log.datas.LogData#COLOR_NONE}.
	 */
	@Test
	public void testColorNone() {
		assertEquals(Color.LIGHT_GRAY, LogData.COLOR_NONE);
	}
	
	/**
	 * Testet die Konstante {@link org.log.datas.LogData#COLOR_OK}.
	 */
	@Test
	public void testColorOk() {
		assertEquals(Color.GREEN, LogData.COLOR_OK);
	}
	
	/**
	 * Testet die Konstante {@link org.log.datas.LogData#COLOR_INFO}.
	 */
	@Test
	public void testColorInfo() {
		assertEquals(Color.BLUE, LogData.COLOR_INFO);
	}
	
	/**
	 * Testet die Methode {@link org.log.datas.LogData#LogData()}.
	 */
	@Test
	public void testLogData() {
		_data = new LogData();
		assertEquals(new String(), _data.getMessage());
		assertEquals(new String(), _data.getError());
		assertEquals(LogData.NO_OUT, _data.getOut());
	}

	/**
	 * Testet die Methode {@link org.log.datas.LogData#LogData(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testLogDataStringString() {
		assertEquals(_message, _data.getMessage());
		assertEquals(_error, _data.getError());
		assertEquals(LogData.NONE, _data.getOut());
	}

	/**
	 * Testet die Methode {@link org.log.datas.LogData#LogData(java.lang.String, java.lang.String, short)}.
	 */
	@Test
	public void testLogDataStringStringShort() {
		_data = new LogData(_message2, _error2, LogData.INFO);
		assertEquals(_message2, _data.getMessage());
		assertEquals(_error2, _data.getError());
		assertEquals(LogData.INFO, _data.getOut());
	}

	/**
	 * Testet die Methode {@link org.log.datas.LogData#getMessage()}.
	 */
	@Test
	public void testGetMessage() {
		assertEquals(_message, _data.getMessage());
	}

	/**
	 * Testet die Methode {@link org.log.datas.LogData#setMessage(java.lang.String)}.
	 */
	@Test
	public void testSetMessage() {
		_data.setMessage(_message2);
		assertEquals(_message2, _data.getMessage());
	}

	/**
	 * Testet die Methode {@link org.log.datas.LogData#getError()}.
	 */
	@Test
	public void testGetError() {
		assertEquals(_error, _data.getError());
	}

	/**
	 * Testet die Methode {@link org.log.datas.LogData#setError(java.lang.String)}.
	 */
	@Test
	public void testSetError() {
		_data.setError(_error2);
		assertEquals(_error2, _data.getError());
	}

	/**
	 * Testet die Methode {@link org.log.datas.LogData#getOut()}.
	 */
	@Test
	public void testGetOut() {
		assertEquals(LogData.NONE, _data.getOut());
	}

	/**
	 * Testet die Methode {@link org.log.datas.LogData#setOut(short)}.
	 */
	@Test
	public void testSetOut() {
		_data.setOut(LogData.WARNING);
		assertEquals(LogData.WARNING, _data.getOut());
	}

	/**
	 * Testet die Methode {@link org.log.datas.LogData#message(String, String)}.
	 */
	@Test
	public void testMessage() {
		_data = LogData.message(_message, _error);
		assertEquals(_message, _data.getMessage());
		assertEquals(_error, _data.getError());
		assertEquals(LogData.NONE, _data.getOut());
	}

	/**
	 * Testet die Methode {@link org.log.datas.LogData#message(String, String, short)}.
	 */
	@Test
	public void testMessageOut() {
		_data = LogData.message(_message, _error, LogData.WARNING);
		assertEquals(_message, _data.getMessage());
		assertEquals(_error, _data.getError());
		assertEquals(LogData.WARNING, _data.getOut());
	}

	/**
	 * Testet die Methode {@link org.log.datas.LogData#messageError(String, String)}.
	 */
	@Test
	public void testMessageError() {
		_data = LogData.messageError(_message, _error);
		assertEquals(_message, _data.getMessage());
		assertEquals(_error, _data.getError());
		assertEquals(LogData.ERROR, _data.getOut());
	}

	/**
	 * Testet die Methode {@link org.log.datas.LogData#messageWarning(String, String)}.
	 */
	@Test
	public void testMessageWarning() {
		_data = LogData.messageWarning(_message, _error);
		assertEquals(_message, _data.getMessage());
		assertEquals(_error, _data.getError());
		assertEquals(LogData.WARNING, _data.getOut());
	}

	/**
	 * Testet die Methode {@link org.log.datas.LogData#messageNoOut(String, String)}.
	 */
	@Test
	public void testMessageNoOut() {
		_data = LogData.messageNoOut(_message, _error);
		assertEquals(_message, _data.getMessage());
		assertEquals(_error, _data.getError());
		assertEquals(LogData.NO_OUT, _data.getOut());
	}

	/**
	 * Testet die Methode {@link org.log.datas.LogData#messageOk(String, String)}.
	 */
	@Test
	public void testMessageOk() {
		_data = LogData.messageOk(_message, _error);
		assertEquals(_message, _data.getMessage());
		assertEquals(_error, _data.getError());
		assertEquals(LogData.OK, _data.getOut());
	}

	/**
	 * Testet die Methode {@link org.log.datas.LogData#messageInformation(String, String)}.
	 */
	@Test
	public void testMessageInfo() {
		_data = LogData.messageInformation(_message, _error);
		assertEquals(_message, _data.getMessage());
		assertEquals(_error, _data.getError());
		assertEquals(LogData.INFO, _data.getOut());
	}
	
	/**
	 * Testet die Methode {@link org.log.datas.LogData#messageDatabase(String, Exception)}.
	 */
	@Test
	public void testMessageDatabase() {
		_data = LogData.messageDatabaseError(_message, _error);
		
		assertEquals(_message, _data.getMessage());
		assertEquals(_error, _data.getError());
		assertEquals(LogData.DATABASE_ERROR, _data.getOut());
	}
	
	/**
	 * Testet die Methode {@link org.log.datas.LogData#message(String, Exception)}.
	 */
	@Test
	public void testMessageStackTrace() {
		Exception exception = new Exception();
		
		_data = LogData.message(_message, exception);
		
		String error = LogData.createError(exception);
		
		assertEquals(_message, _data.getMessage());
		assertEquals(error, _data.getError());
		assertEquals(LogData.NONE, _data.getOut());
	}
	
	/**
	 * Testet die Methode {@link org.log.datas.LogData#message(String, Exception, short)}.
	 */
	@Test
	public void testMessageStackTraceOut() {
		Exception exception = new Exception();
		
		_data = LogData.message(_message, exception, LogData.WARNING);
		
		String error = LogData.createError(exception);
		
		assertEquals(_message, _data.getMessage());
		assertEquals(error, _data.getError());
		assertEquals(LogData.WARNING, _data.getOut());
	}
	
	/**
	 * Testet die Methode {@link org.log.datas.LogData#messageError(String, Exception)}.
	 */
	@Test
	public void testMessageErrorStackTrace() {
		Exception exception = new Exception();
		
		_data = LogData.messageError(_message, exception);
		
		String error = LogData.createError(exception);
		
		assertEquals(_message, _data.getMessage());
		assertEquals(error, _data.getError());
		assertEquals(LogData.ERROR, _data.getOut());
	}
	
	/**
	 * Testet die Methode {@link org.log.datas.LogData#messageWarning(String, Exception)}.
	 */
	@Test
	public void testMessageWarningStackTrace() {
		Exception exception = new Exception();
		
		_data = LogData.messageWarning(_message, exception);
		
		String error = LogData.createError(exception);
		
		assertEquals(_message, _data.getMessage());
		assertEquals(error, _data.getError());
		assertEquals(LogData.WARNING, _data.getOut());
	}
	
	/**
	 * Testet die Methode {@link org.log.datas.LogData#messageNoOut(String, Exception)}.
	 */
	@Test
	public void testMessageNoOutStackTrace() {
		Exception exception = new Exception();
		
		_data = LogData.messageNoOut(_message, exception);
		
		String error = LogData.createError(exception);
		
		assertEquals(_message, _data.getMessage());
		assertEquals(error, _data.getError());
		assertEquals(LogData.NO_OUT, _data.getOut());
	}
	
	/**
	 * Testet die Methode {@link org.log.datas.LogData#messageOk(String, Exception)}.
	 */
	@Test
	public void testMessageOkStackTrace() {
		Exception exception = new Exception();
		
		_data = LogData.messageOk(_message, exception);
		
		String error = LogData.createError(exception);
		
		assertEquals(_message, _data.getMessage());
		assertEquals(error, _data.getError());
		assertEquals(LogData.OK, _data.getOut());
	}
	
	/**
	 * Testet die Methode {@link org.log.datas.LogData#messageInformation(String, Exception)}.
	 */
	@Test
	public void testMessageInfoStackTrace() {
		Exception exception = new Exception();
		
		_data = LogData.messageInformation(_message, exception);
		
		String error = LogData.createError(exception);
		
		assertEquals(_message, _data.getMessage());
		assertEquals(error, _data.getError());
		assertEquals(LogData.INFO, _data.getOut());
	}
	
	/**
	 * Testet die Methode {@link org.log.datas.LogData#messageDatabase(String, Exception)}.
	 */
	@Test
	public void testMessageDatabaseStackTrace() {
		Exception exception = new Exception();
		
		_data = LogData.messageDatabaseError(_message, exception);
		
		String error = LogData.createError(exception);
		
		assertEquals(_message, _data.getMessage());
		assertEquals(error, _data.getError());
		assertEquals(LogData.DATABASE_ERROR, _data.getOut());
	}
	
	/**
	 * Testet die Methode {@link org.log.datas.LogData#createError(Exception)}.
	 */
	@Test
	public void testCreateErrorWithoutErrorMessage() {
		Exception exception = new Exception();
		
		String result = Exception.class.getName() + System.lineSeparator();
		
		for (int i = 0; i < exception.getStackTrace().length; i++)
			result += "    " + exception.getStackTrace()[i].getClassName() +
				"." + exception.getStackTrace()[i].getMethodName() + "(" +
				exception.getStackTrace()[i].getFileName() + ":" +
				String.valueOf(exception.getStackTrace()[i].getLineNumber()) +
				")" + System.lineSeparator();
		
		assertEquals(result, LogData.createError(exception));
	}
	
	/**
	 * Testet die Methode {@link org.log.datas.LogData#createError(Exception)}.
	 */
	@Test
	public void testCreateErrorWithErrorMessage() {
		Exception exception = new Exception(_message);
		
		String result = Exception.class.getName() + "( \"" +  _message +
				"\" )" + System.lineSeparator();
		
		for (int i = 0; i < exception.getStackTrace().length; i++)
			result += "    " + exception.getStackTrace()[i].getClassName() +
				"." + exception.getStackTrace()[i].getMethodName() + "(" +
				exception.getStackTrace()[i].getFileName() + ":" +
				String.valueOf(exception.getStackTrace()[i].getLineNumber()) +
				")" + System.lineSeparator();
		
		assertEquals(result, LogData.createError(exception));
	}
	
	/**
	 * Testet die Methode {@link org.log.datas.LogData#getBackground(short)}.
	 */
	@Test
	public void testGetColorNoOut() {
		assertEquals(LogData.COLOR_NONE, LogData.getBackground(LogData.NO_OUT));
	}
	
	/**
	 * Testet die Methode {@link org.log.datas.LogData#getBackground(short)}.
	 */
	@Test
	public void testGetColorError() {
		assertEquals(LogData.COLOR_ERROR, LogData.getBackground(LogData.ERROR));
	}
	
	/**
	 * Testet die Methode {@link org.log.datas.LogData#getBackground(short)}.
	 */
	@Test
	public void testGetColorWarning() {
		assertEquals(LogData.COLOR_WARNING, LogData.getBackground(LogData.WARNING));
	}
	
	/**
	 * Testet die Methode {@link org.log.datas.LogData#getBackground(short)}.
	 */
	@Test
	public void testGetColorNone() {
		assertEquals(LogData.COLOR_NONE, LogData.getBackground(LogData.NONE));
	}
	
	/**
	 * Testet die Methode {@link org.log.datas.LogData#getBackground(short)}.
	 */
	@Test
	public void testGetColorOk() {
		assertEquals(LogData.COLOR_OK, LogData.getBackground(LogData.OK));
	}
	
	/**
	 * Testet die Methode {@link org.log.datas.LogData#getBackground(short)}.
	 */
	@Test
	public void testGetColorInformation() {
		assertEquals(LogData.COLOR_INFO, LogData.getBackground(LogData.INFO));
	}
	
	/**
	 * Testet die Methode {@link org.log.datas.LogData#getBackground(short)}.
	 */
	@Test
	public void testGetColorDatabase() {
		assertEquals(LogData.COLOR_DATABASE_ERROR,
				LogData.getBackground(LogData.DATABASE_ERROR));
	}
}
