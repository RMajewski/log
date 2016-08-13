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

package org.log;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.border.BevelBorder;

/**
 * Zeigt die StatusBar an.
 * 
 * Der letzte Log-Eintrag wird in der Status-Bar angezeigt, sofern er nicht als
 * "nicht ausgeben" markiert wurde.
 * 
 * Version 0.2: Es kann wahlweise das Label mit den Nachrichten angezeigt werden
 * oder eine Fortschrittsanzeige.
 * 
 * @author René Majewski
 *
 * @version 0.2
 */
public class StatusBar extends JPanel {

	/**
	 * Serilisation ID
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Speichert das Label für die Nachrichten.
	 */
	private JLabel _label;
	
	/**
	 * Speichert die Fortschrittsanzeige.
	 */
	private JProgressBar _progress;
	
	/**
	 * Speichert den Wert, um die den Fortschrittsanzeige bei jeden Aufruf
	 * erhöht werden soll.
	 */
	private int _progressIncrease;

	/**
	 * Speichert die Instanz der Status-Bar.
	 */
	private static StatusBar _status;
	
	/**
	 * Speichert die Liste der in der Status-Bar angezeigten Log-Einträge.
	 */
	private List<LogData> _list;
	
	/**
	 * Initialisieren der Status-Bar.
	 */
	private StatusBar() {
		// Panel initialisieren
		super();
		setPreferredSize(new Dimension(200, 20));
		setBorder(new BevelBorder(BevelBorder.LOWERED));
		
		// Liste initialisieren
		_list = new ArrayList<LogData>();
		
		// Layout-Manager
		setLayout(new BorderLayout());
		
		// Label initialisieren und anzeigen
		_label = new JLabel();
		_label.setForeground(Color.WHITE);
		add(_label, BorderLayout.CENTER);
		
		// Fortschrittsanzeige initialisieren
		_progress = new JProgressBar();
		_progress.setPreferredSize(new Dimension(100, 20));
		_progress.setBorderPainted(true);
		_progress.setStringPainted(true);
		initProgressBar(0, 0, 1);
		add(_progress, BorderLayout.EAST);
	}
	
	/**
	 * Gibt die Instanz der Status-Bar zurück.
	 * 
	 *  Sollte die Instanz nicht initialisiert sein, so wird sie vor der
	 *  Rückgabe initialisiert.
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
	 * in der Liste der Log-Einträge gespeichert wird.
	 * 
	 * @param message Text, der angezeigt werden soll.
	 */
	public void setMessage(String message) {
		_list.add(new LogData(message, null));
		setLabelText(message, LogData.NONE);
	}
	
	/**
	 * Zeigt den angegebenen Text an.
	 * 
	 * Bevor der Text ausgegeben wird, wird noch ein Log-Eintrag erzeugt, der
	 * in der Liste der Log-Einträge gespeichert wird.
	 * 
	 *  @param message Text, der angezeigt werden soll.
	 *  
	 *  @param error Fehlerbeschreibung, die dem Eintrag hinzugefügt werden soll
	 */
	public void setMessage(String message, String error) {
		_list.add(new LogData(message, error));
		setLabelText(message, LogData.NONE);
	}
	
	/**
	 * Zeigt den angegebenen Text an.
	 * 
	 * Bevor der Text ausgegeben wird, wird noch ein Log-Eintrag erzeugt, der
	 * in der Liste der Log-Einträge gespeichert wird.
	 * 
	 * @param message Text, der angezeigt werden soll
	 * 
	 * @param error Fehler, aus dem die Fehlerbeschreibung erstellt werden
	 * soll.
	 */
	public void setMessage(String message, Exception error) {
		_list.add(LogData.message(message, error));
		setLabelText(message, LogData.NONE);
	}
	
	/**
	 * Zeigt den angegebenen Text an.
	 * 
	 * Bevor der Text ausgegeben wird, wird noch ein Log-Eintrag erzeugt, der
	 * in der Liste der Log-Einträge gespeichert wird.
	 * 
	 *  @param message Text, der angezeigt werden soll.
	 *  
	 *  @param error Fehlerbeschreibung, die dem Eintrag hinzugefügt werden soll
	 *  
	 *  @param out Als was soll die Nachricht markiert werden? Siehe
	 *  {@link org.log.LogData}.
	 */
	public void setMessage(String message, String error, short out) {
		_list.add(new LogData(message, error, out));
		setLabelText(message, out);
	}
	
	/**
	 * Zeigt den angegebenen Text an.
	 * 
	 * Bevor der Text ausgegeben wird, wird noch ein Log-Eintrag erzeugt, der
	 * in der Liste der Log-Einträge gespeichert wird.
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
		_list.add(LogData.message(message, error, out));
		setLabelText(message, out);
	}
	
	/**
	 * Zeigt den angegeben Text an.
	 * 
	 * Es wird der Nachrichten-Text des übergebenen Log-Eintrages angezeigt.
	 * Der Log-Eintrag wird in der List der Log-Einträge gespeichert.
	 * 
	 * @param log Log-Eintrag, der gespeichert und ausgegeben werden soll.
	 */
	public void setMessage(LogData log) {
		_list.add(log);
		setLabelText(log.getMessage(), log.getOut());
	}
	
	/**
	 * Leert die Liste mit den Log-Einträgen.
	 */
	public void clear() {
		_label.setText(new String());
		setBackground(LogData.getBackground(LogData.NONE));
		_label.setForeground(LogData.getForeground(LogData.NONE));
		_list.clear();
		_progress.setValue(0);
	}
	
	/**
	 * Gibt die Liste mit den Log-Einträgen zurück.
	 * 
	 * @return Liste mit den Log-Einträgen.
	 */
	public List<LogData> getLog() {
		return _list;
	}
	
	/**
	 * Minimalen und maximalen Wert der Fortschrittsanzeige einstellen.
	 * 
	 * @param min Minimaler Wert der Fortschrittsanzeige.
	 * 
	 * @param max Maximaler Wert der Fortschrittsanzeige.
	 * 
	 * @param increase Wert, um den erhöht werden soll.
	 */
	public void initProgressBar(int min, int max, int increase) {
		_progress.setValue(0);
		_progress.setMinimum(min);
		_progress.setMaximum(max);
		_progressIncrease = increase;
	}
	
	/**
	 * Wert der Fortschrittsanzeige erhöhen. Erhöht den Wert den
	 * Fortschrittsanzeige, um den den eingestellten Wert.
	 */
	public void progressBarIncrease() {
		_progress.setValue(_progress.getValue() + _progressIncrease);
	}
	
	/**
	 * Ermittelt den Wert der Fortschrittsanzeige.
	 * 
	 * @return Aktueller Wert der Fortschrittsanzeige.
	 */
	public int getProgressBarValue() {
		return _progress.getValue();
	}
	
	/**
	 * Setzt den Wert der Fortschrittsanzeige auf den übergebenen Wert.
	 * 
	 * @param value Neuer Wert der Fortschrittsanzeige.
	 */
	public void setProgressBarValue(int value) {
		_progress.setValue(value);
	}
	
	/**
	 * Ermittelt den Text den angezeigten Text und gibt diesen zurück.
	 * 
	 * @return Aktuell angezeigter Text.
	 */
	public String getText() {
		return _label.getText();
	}
	
	/**
	 * Speichert die Log-Einträge in eine Datei
	 * 
	 * @param file Ausgewählte Datei.
	 */
	public void writeToFile(File file) {
		LogView.writeToFile(file);
	}
	
	/**
	 * Speichert die Log-Einträge in eine Datei
	 * 
	 * @param name Name der Datei.
	 */
	public void writeToFile(String name) {
		writeToFile(new File(name));
	}
	
	/**
	 * Schreibt die Message in das Label der StatusBar. Bevor der Text angezeigt
	 * wird, wird geprüft, ob der Nachrichten-Type überhaupt ausgegeben werden
	 * soll.
	 * 
	 * @param message Nachricht, die im Label angezeigt werden soll.
	 * 
	 * @param type Type der Nachricht.
	 */
	private void setLabelText(String message, short type) {
		if (LogConfig.getInstance().getMessageTypeOut(type)) {
			_label.setText(message);
			setBackground(LogData.getBackground(type));
			_label.setForeground(LogData.getForeground(type));
		}
	}
}
