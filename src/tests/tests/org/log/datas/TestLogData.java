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

import java.text.DateFormat;
import java.util.Arrays;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.log.datas.LogData;
import org.log.exceptions.NoLogTypeException;

/**
 * Testet die Klasse {@link org.log.datas.LogData}.
 * 
 * @author René Majewski
 *
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
	 * Testet die Methode {@link org.log.datas.LogData#LogData()}.
	 */
	@Test
	public void testLogData() {
		_data = new LogData();
		
		assertThat(_data.getMessage(), is(new String()));
		assertThat(_data.getError(), is(new String()));
		assertThat(_data.getOut(), is(LogData.NO_OUT));
		assertThat(_data.getCreateTime(), 
				is(lessThanOrEqualTo(new Date().getTime())));
	}

	/**
	 * Testet die Methode {@link org.log.datas.LogData#LogData(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testLogDataStringString() {
		assertThat(_data.getMessage(), is(_message));
		assertThat(_data.getError(), is(_error));
		assertThat(_data.getOut(), is(LogData.NONE));
		assertThat(_data.getCreateTime(), 
				is(lessThanOrEqualTo(new Date().getTime())));
	}

	/**
	 * Testet die Methode {@link org.log.datas.LogData#LogData(java.lang.String, java.lang.String, short)}.
	 */
	@Test
	public void testLogDataStringStringShort() {
		_data = new LogData(_message2, _error2, LogData.INFO);
		
		assertThat(_data.getMessage(), is(_message2));
		assertThat(_data.getError(), is(_error2));
		assertThat(_data.getOut(), is(LogData.INFO));
		assertThat(_data.getCreateTime(), 
				is(lessThanOrEqualTo(new Date().getTime())));
	}

	/**
	 * Testet die Methode {@link org.log.datas.LogData#getMessage()}.
	 */
	@Test
	public void testGetMessage() {
		assertThat(_data.getMessage(), is(_message));
	}

	/**
	 * Testet die Methode {@link org.log.datas.LogData#setMessage(java.lang.String)}.
	 */
	@Test
	public void testSetMessage() {
		_data.setMessage(_message2);
		
		assertThat(_data.getMessage(), is(_message2));
	}

	/**
	 * Testet die Methode {@link org.log.datas.LogData#setMessage(java.lang.String)}.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testSetMessageWithNullAsParameter() {
		_data.setMessage(null);
	}

	/**
	 * Testet die Methode {@link org.log.datas.LogData#setMessage(java.lang.String)}.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testSetMessageWithEmptyStringAsParameter() {
		_data.setMessage(new String());
	}

	/**
	 * Testet die Methode {@link org.log.datas.LogData#getError()}.
	 */
	@Test
	public void testGetError() {
		assertThat(_data.getError(), is(_error));
	}

	/**
	 * Testet die Methode {@link org.log.datas.LogData#setError(java.lang.String)}.
	 */
	@Test
	public void testSetError() {
		_data.setError(_error2);
		
		assertThat(_data.getError(), is(_error2));
	}

	/**
	 * Testet die Methode {@link org.log.datas.LogData#setError(java.lang.String)}.
	 */
	@Test
	public void testSetErrorWithNullAsParameter() {
		_data.setError(null);
		
		assertThat(_data.getError(), isEmptyString());
	}

	/**
	 * Testet die Methode {@link org.log.datas.LogData#setError(java.lang.String)}.
	 */
	@Test
	public void testSetErrorWithEmptyStringAsParameter() {
		_data.setError(new String());
		
		assertThat(_data.getError(), isEmptyString());
	}

	/**
	 * Testet die Methode {@link org.log.datas.LogData#getOut()}.
	 */
	@Test
	public void testGetOut() {
		assertThat(_data.getOut(), is(LogData.NONE));
	}

	/**
	 * Testet die Methode {@link org.log.datas.LogData#setOut(short)}.
	 */
	@Test
	public void testSetOut() {
		_data.setOut(LogData.WARNING);
		
		assertThat(_data.getOut(), is(LogData.WARNING));
	}

	/**
	 * Testet die Methode {@link org.log.datas.LogData#setOut(short)}.
	 */
	@Test(expected=NoLogTypeException.class)
	public void testSetOutWithMinusOneAsParameter() {
		_data.setOut((short)-1);
	}

	/**
	 * Testet die Methode {@link org.log.datas.LogData#setOut(short)}.
	 */
	@Test(expected=NoLogTypeException.class)
	public void testSetOutWithEightsParameter() {
		_data.setOut((short)8);
	}
	
	/**
	 * Testet die Method {@link org.log.datas.LogData#getCreateTime()}
	 */
	@Test
	public void testGetCreateTime() {
		assertThat(_data.getCreateTime(),
				is(lessThanOrEqualTo(new Date().getTime())));
	}
	
	/**
	 * Testet die Methode {@link org.log.datas.LogData#getTypesCount()}
	 */
	@Test
	public void testGetTypesCount() {
		assertThat(LogData.getTypesCount(), is(LogData.DATABASE_INSERT));
	}
	
	/**
	 * Testet die Methode {@link org.log.datas.LogData#createError(Exception)}
	 */
	@Test
	public void testCreateError() {
		Exception exception = new Exception();
		
		assertThat(LogData.createError(exception),
				stringContainsInOrder(Arrays.asList("java.lang.Exception",
						"tests.org.log.datas.TestLogData.testCreateError",
						"TestLogData.java:")));
	}
	
	/**
	 * Testet die Methode {@link org.log.datas.LogData#equals(Object)}
	 */
	@Test
	public void testEqualsTrueWithOtherÔbject() {
		LogData data = new LogData(_message, _error);
		
		assertThat(_data.equals(data), is(true));
	}
	
	/**
	 * Testet die Methode {@link org.log.datas.LogData#equals(Object)}
	 */
	@Test
	public void testEqualsTrueWithOwnObject() {
		assertThat(_data.equals(_data), is(true));
	}
	
	/**
	 * Testet die Methode {@link org.log.datas.LogData#equals(Object)}
	 */
	@Test
	public void testEqualsTrueWithNull() {
		assertThat(_data.equals(null), is(false));
	}
	
	/**
	 * Testet die Methode {@link org.log.datas.LogData#equals(Object)}
	 */
	@Test
	public void testEqualsTrueWithOwnOtherMessage() {
		LogData data = new LogData(_message2, _error);
				
		assertThat(_data.equals(data), is(false));
	}
	
	/**
	 * Testet die Methode {@link org.log.datas.LogData#equals(Object)}
	 */
	@Test
	public void testEqualsTrueWithOwnOtherError() {
		LogData data = new LogData(_message, _error2);
				
		assertThat(_data.equals(data), is(false));
	}
	
	/**
	 * Testet die Methode {@link org.log.datas.LogData#equals(Object)}
	 */
	@Test
	public void testEqualsTrueWithOwnOtherClass() {
		assertThat(_data.equals(new String()), is(false));
	}
	
	/**
	 * Testet die Methode {@link org.log.datas.LogData#toString()}.
	 */
	@Test
	public void testToString() {
		String test = "['Normale Nachricht', '" + _message + "', '" + _error +
				"', '" + DateFormat.getDateTimeInstance(DateFormat.SHORT,
						DateFormat.SHORT).format(
								new Date(_data.getCreateTime())) + "']";
		
		assertThat(_data.toString(), is(test));
	}
}
