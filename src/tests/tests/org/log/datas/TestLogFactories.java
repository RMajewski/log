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

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Before;
import org.junit.Test;
import org.log.datas.LogData;
import org.log.datas.LogDataFactory;

/**
 * Testet die Factory-Methoden der Klasse {@link org.log.datas.LogDataFactory}.
 * 
 * @author René Majewski
 *
 * @since 0.4
 */
public class TestLogFactories {
	/**
	 * Speichert die erstelle Nachricht.
	 */
	private LogData _data;
	
	/**
	 * Speichert den Text für die 1. Test-Nachricht.
	 */
	private String _message;
	
	/**
	 * Speichert den Text für die 1. Fehlerbeschreibung.
	 */
	private String _error;
	
	/**
	 * Initialisiert die Tests
	 */
	@Before
	public void setUp() {
		_message = new String("Test Nachricht");
		
		_error = new String("Fehlerbeschreibung");
		
		_data = new LogData(_message, _error);
	}

	/**
	 * Testet die Methode
	 * {@link org.log.datas.LogDataFactory#message(String, String)}.
	 */
	@Test
	public void testMessage() {
		_data = LogDataFactory.message(_message, _error);
		
		assertThat(_data.getMessage(), is(_message));
		assertThat(_data.getError(), is(_error));
		assertThat(_data.getOut(), is(LogData.NONE));
	}

	/**
	 * Testet die Methode
	 * {@link org.log.datas.LogDataFactory#message(String, String, short)}.
	 */
	@Test
	public void testMessageOut() {
		_data = LogDataFactory.message(_message, _error, LogData.WARNING);
		
		assertThat(_data.getMessage(), is(_message));
		assertThat(_data.getError(), is(_error));
		assertThat(_data.getOut(), is(LogData.WARNING));
	}

	/**
	 * Testet die Methode
	 * {@link org.log.datas.LogDataFactory#messageError(String, String)}.
	 */
	@Test
	public void testMessageError() {
		_data = LogDataFactory.messageError(_message, _error);
		
		assertThat(_data.getMessage(), is(_message));
		assertThat(_data.getError(), is(_error));
		assertThat(_data.getOut(), is(LogData.ERROR));
	}

	/**
	 * Testet die Methode
	 * {@link org.log.datas.LogDataFactory#messageWarning(String, String)}.
	 */
	@Test
	public void testMessageWarning() {
		_data = LogDataFactory.messageWarning(_message, _error);
		
		assertThat(_data.getMessage(), is(_message));
		assertThat(_data.getError(), is(_error));
		assertThat(_data.getOut(), is(LogData.WARNING));
	}

	/**
	 * Testet die Method
	 * {@link org.log.datas.LogDataFactory#messageNoOut(String, String)}.
	 */
	@Test
	public void testMessageNoOut() {
		_data = LogDataFactory.messageNoOut(_message, _error);
		
		assertThat(_data.getMessage(), is(_message));
		assertThat(_data.getError(), is(_error));
		assertThat(_data.getOut(), is(LogData.NO_OUT));
	}

	/**
	 * Testet die Methode
	 * {@link org.log.datas.LogDataFactory#messageOk(String, String)}.
	 */
	@Test
	public void testMessageOk() {
		_data = LogDataFactory.messageOk(_message, _error);
		
		assertThat(_data.getMessage(), is(_message));
		assertThat(_data.getError(), is(_error));
		assertThat(_data.getOut(), is(LogData.OK));
	}

	/**
	 * Testet die Methode
	 * {@link org.log.datas.LogDataFactory#messageInfo(String, String)}.
	 */
	@Test
	public void testMessageInfo() {
		_data = LogDataFactory.messageInfo(_message, _error);
		
		assertThat(_data.getMessage(), is(_message));
		assertThat(_data.getError(), is(_error));
		assertThat(_data.getOut(), is(LogData.INFO));
	}
	
	/**
	 * Testet die Methode
	 * {@link org.log.datas.LogDataFactory#messageDatabaseError(String, Exception)}.
	 */
	@Test
	public void testMessageDatabaseError() {
		_data = LogDataFactory.messageDatabaseError(_message, _error);
		
		assertThat(_data.getMessage(), is(_message));
		assertThat(_data.getError(), is(_error));
		assertThat(_data.getOut(), is(LogData.DATABASE_ERROR));
	}
	
	/**
	 * Testet die Methode
	 * {@link org.log.datas.LogDataFactory#messageDatabaseInsert(String, Exception)}.
	 */
	@Test
	public void testMessageDatabaseInsert() {
		_data = LogDataFactory.messageDatabaseInsert(_message, _error);
		
		assertThat(_data.getMessage(), is(_message));
		assertThat(_data.getError(), is(_error));
		assertThat(_data.getOut(), is(LogData.DATABASE_INSERT));
	}
	
	/**
	 * Testet die Methode
	 * {@link org.log.datas.LogDataFactory#message(String, Exception)}.
	 */
	@Test
	public void testMessageStackTrace() {
		Exception exception = new Exception();
		_data = LogDataFactory.message(_message, exception);
		
		assertThat(_data.getMessage(), is(_message));
		assertThat(_data.getError(), is(LogData.createError(exception)));
		assertThat(_data.getOut(), is(LogData.NONE));
	}
	
	/**
	 * Testet die Methode
	 * {@link org.log.datas.LogDataFactory#message(String, Exception, short)}.
	 */
	@Test
	public void testMessageStackTraceOut() {
		Exception exception = new Exception();
		
		_data = LogDataFactory.message(_message, exception, LogData.WARNING);
		
		assertThat(_data.getMessage(), is(_message));
		assertThat(_data.getError(), is(LogData.createError(exception)));
		assertThat(_data.getOut(), is(LogData.WARNING));
	}
	
	/**
	 * Testet die Methode
	 * {@link org.log.datas.LogDataFactory#messageError(String, Exception)}.
	 */
	@Test
	public void testMessageErrorStackTrace() {
		Exception exception = new Exception();
		
		_data = LogDataFactory.messageError(_message, exception);
		
		assertThat(_data.getMessage(), is(_message));
		assertThat(_data.getError(), is(LogData.createError(exception)));
		assertThat(_data.getOut(), is(LogData.ERROR));
	}
	
	/**
	 * Testet die Methode
	 * {@link org.log.datas.LogDataFactory#messageWarning(String, Exception)}.
	 */
	@Test
	public void testMessageWarningStackTrace() {
		Exception exception = new Exception();
		
		_data = LogDataFactory.messageWarning(_message, exception);
		
		assertThat(_data.getMessage(), is(_message));
		assertThat(_data.getError(), is(LogData.createError(exception)));
		assertThat(_data.getOut(), is(LogData.WARNING));
	}
	
	/**
	 * Testet die Methode
	 * {@link org.log.datas.LogDataFactory#messageNoOut(String, Exception)}.
	 */
	@Test
	public void testMessageNoOutStackTrace() {
		Exception exception = new Exception();
		
		_data = LogDataFactory.messageNoOut(_message, exception);
		
		assertThat(_data.getMessage(), is(_message));
		assertThat(_data.getError(), is(LogData.createError(exception)));
		assertThat(_data.getOut(), is(LogData.NO_OUT));
	}
	
	/**
	 * Testet die Methode
	 * {@link org.log.datas.LogDataFactory#messageOk(String, Exception)}.
	 */
	@Test
	public void testMessageOkStackTrace() {
		Exception exception = new Exception();
		
		_data = LogDataFactory.messageOk(_message, exception);
		
		assertThat(_data.getMessage(), is(_message));
		assertThat(_data.getError(), is(LogData.createError(exception)));
		assertThat(_data.getOut(), is(LogData.OK));
	}
	
	/**
	 * Testet die Methode
	 * {@link org.log.datas.LogDataFactory#messageInfo(String, Exception)}.
	 */
	@Test
	public void testMessageInfoStackTrace() {
		Exception exception = new Exception();
		
		_data = LogDataFactory.messageInfo(_message, exception);
		
		assertThat(_data.getMessage(), is(_message));
		assertThat(_data.getError(), is(LogData.createError(exception)));
		assertThat(_data.getOut(), is(LogData.INFO));
	}
	
	/**
	 * Testet die Methode
	 * {@link org.log.datas.LogDataFactory#messageDatabaseError(String, Exception)}.
	 */
	@Test
	public void testMessageDatabaseErrorStackTrace() {
		Exception exception = new Exception();
		
		_data = LogDataFactory.messageDatabaseError(_message, exception);
		
		assertThat(_data.getMessage(), is(_message));
		assertThat(_data.getError(), is(LogData.createError(exception)));
		assertThat(_data.getOut(), is(LogData.DATABASE_ERROR));
	}
	
	/**
	 * Testet die Methode 
	 * {@link org.log.datas.LogDataFactory#messageDatabaseInsert(String, Exception)}.
	 */
	@Test
	public void testMessageDatabaseInsertStackTrace() {
		Exception exception = new Exception();
		
		_data = LogDataFactory.messageDatabaseInsert(_message, exception);
		
		assertThat(_data.getMessage(), is(_message));
		assertThat(_data.getError(), is(LogData.createError(exception)));
		assertThat(_data.getOut(), is(LogData.DATABASE_INSERT));
	}
}
