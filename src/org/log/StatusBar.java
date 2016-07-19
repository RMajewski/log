/* 
* Copyright 2016 Ren� Majewski
*  
* Lizenziert unter der EUPL, Version 1.1 oder - sobald diese von der
* Europ�ischen Kommission genehmigt wurden - Folgeversionen der EUPL
* ("Lizenz"); Sie d�rfen dieses Werk ausschlie�lich gem�� dieser Lizenz
* nutzen. 
* 
* Eine Kopie der Lizenz finden Sie hier: 
* https://joinup.ec.europa.eu/software/page/eupl
*  
* Sofern nicht durch anwendbare Rechtsvorschriften gefordert oder in 
* schriftlicher Form vereinbart, wird die unter der Lizenz verbreitete 
* Software "so wie sie ist", OHNE JEGLICHE GEW�HRLEISTUNG ODER BEDINGUNGEN -
* ausdr�cklich oder stillschweigend - verbreitet.
* Die sprachspezifischen Genehmigungen und Beschr�nkungen unter der Lizenz
* sind dem Lizenztext zu entnehmen.
*/ 

package org.log;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.border.BevelBorder;

/**
 * Zeigt die StatusBar an.
 * 
 * Der letzte Log-Eintrag wird in der Status-Bar angezeigt, sofern er nicht als
 * "nicht ausgeben" markiert wurde.
 * 
 * @author Ren� Majewski
 *
 */
public class StatusBar extends JLabel {

	/**
	 * Serilisation ID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Speichert die Instanz der Status-Bar.
	 */
	private static StatusBar _status;
	
	/**
	 * Speichert die Liste der in der Status-Bar angezeigten Log-Eintr�ge.
	 */
	private List<LogData> _list;
	
	/**
	 * Initialisieren der Status-Bar.
	 */
	private StatusBar() {
		// JLabel initialisieren
		super();
		setPreferredSize(new Dimension(100, 20));
		setBorder(new BevelBorder(BevelBorder.LOWERED));
		
		// Liste initialisieren
		_list = new ArrayList<LogData>();
	}
	
	/**
	 * Gibt die Instanz der Status-Bar zur�ck.
	 * 
	 *  Sollte die Instanz nicht initialisiert sein, so wird sie vor der
	 *  R�ckgabe initialisiert.
	 *  
	 *  @return Initialisierte Instanz der Status-Bar.
	 */
	public static StatusBar getInstance() {
		if (_status == null)
			_status = new StatusBar();
		return _status;
	}
	
	/**
	 * Zeigt den angegebenen Text an.
	 * 
	 * Bevor der Text ausgegeben wird, wird noch ein Log-Eintrag erzeugt, der
	 * in der Liste der Log-Eintr�ge gespeichert wird.
	 * 
	 * @param message Text, der angezeigt werden soll.
	 */
	public void setMessage(String message) {
		setText(message);
		setBackground(LogData.COLOR_NONE);
		_list.add(new LogData(message, null));
	}
	
	/**
	 * Zeigt den angegebenen Text an.
	 * 
	 * Bevor der Text ausgegeben wird, wird noch ein Log-Eintrag erzeugt, der
	 * in der Liste der Log-Eintr�ge gespeichert wird.
	 * 
	 *  @param message Text, der angezeigt werden soll.
	 *  
	 *  @param error Fehlerbeschreibung, die dem Eintrag hinzugef�gt werden soll
	 */
	public void setMessage(String message, String error) {
		setText(message);
		setBackground(LogData.COLOR_NONE);
		_list.add(new LogData(message, error));
	}
	
	/**
	 * Zeigt den angegebenen Text an.
	 * 
	 * Bevor der Text ausgegeben wird, wird noch ein Log-Eintrag erzeugt, der
	 * in der Liste der Log-Eintr�ge gespeichert wird.
	 * 
	 * @param message Text, der angezeigt werden soll
	 * 
	 * @param error Fehler, aus dem die Fehlerbeschreibung erstellt werden
	 * soll.
	 */
	public void setMessage(String message, Exception error) {
		setText(message);
		setBackground(LogData.COLOR_NONE);
		_list.add(LogData.message(message, error));
	}
	
	/**
	 * Zeigt den angegebenen Text an.
	 * 
	 * Bevor der Text ausgegeben wird, wird noch ein Log-Eintrag erzeugt, der
	 * in der Liste der Log-Eintr�ge gespeichert wird.
	 * 
	 *  @param message Text, der angezeigt werden soll.
	 *  
	 *  @param error Fehlerbeschreibung, die dem Eintrag hinzugef�gt werden soll
	 *  
	 *  @param out Als was soll die Nachricht markiert werden? Siehe
	 *  {@link org.log.LogData}.
	 */
	public void setMessage(String message, String error, short out) {
		if (out > LogData.NO_OUT) {
			setText(message);
			setBackground(LogData.getColor(out));
		}
		_list.add(new LogData(message, error, out));
	}
	
	/**
	 * Zeigt den angegebenen Text an.
	 * 
	 * Bevor der Text ausgegeben wird, wird noch ein Log-Eintrag erzeugt, der
	 * in der Liste der Log-Eintr�ge gespeichert wird.
	 * 
	 * @param message Text, der angezeigt werden soll
	 * 
	 * @param error Fehler, aus dem die Fehlerbeschreibung erstellt werden
	 * soll.
	 *  
	 *  @param out Als was soll die Nachricht markiert werden? Siehe
	 *  {@link org.log.LogData}.
	 */
	public void setMessage(String message, Exception error, short out) {
		if (out > LogData.NO_OUT) {
			setText(message);
			setBackground(LogData.getColor(out));
		}
		_list.add(LogData.message(message, error, out));
	}
	
	/**
	 * Zeigt den angegeben Text an.
	 * 
	 * Es wird der Nachrichten-Text des �bergebenen Log-Eintrages angezeigt.
	 * Der Log-Eintrag wird in der List der Log-Eintr�ge gespeichert.
	 * 
	 * @param log Log-Eintrag, der gespeichert und ausgegeben werden soll.
	 */
	public void setMessage(LogData log) {
		if (log.getOut() > LogData.NO_OUT) {
			setText(log.getMessage());
			setBackground(LogData.getColor(log.getOut()));
		}
		_list.add(log);
	}
	
	/**
	 * Leert die Liste mit den Log-Eintr�gen.
	 */
	public void clear() {
		setText(new String());
		setBackground(LogData.getColor(LogData.NONE));
		_list.clear();
	}
	
	/**
	 * Gibt die Liste mit den Log-Eintr�gen zur�ck.
	 * 
	 * @return Liste mit den Log-Eintr�gen.
	 */
	public List<LogData> getLog() {
		return _list;
	}
}
