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

package org.log.elements;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.log.config.LogConfig;
import org.log.datas.LogData;

/**
 * Gibt die Steuerelemente für die Einstellungen des Logbuch zurück.
 * 
 * @author René Majewski
 *
 * @version 0.1
 * Steuerelemente für die Eingabe der Daten: Auswahl der Meldungen, die in der
 * Statusleiste angezeigt werden, Anzeige des Logbuch-Menüs und Automatische
 * Generierung der Logbuch-Datei beim Beenden.
 * 
 * @since 0.3
 */
public class LogPanel extends JPanel {
	/**
	 * Serial ID
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Ausgabe der Meldung {@link LogData#NONE} in der StatusBar?
	 */
	private JCheckBox _cbNone;
	
	/**
	 * Ausgabe der Meldung {@link LogData#NO_OUT} in der SatusBar?
	 */
	private JCheckBox _cbNoOut;
	
	/**
	 * Ausgabe der Meldung {@link LogData#WARNING} in der StatusBar?
	 */
	private JCheckBox _cbWarning;
	
	/**
	 * Ausgabe der Meldung {@link LogData#ERROR} in der StatusBar?
	 */
	private JCheckBox _cbError;
	
	/**
	 * Ausgabe der Meldung {@link LogData#OK} in der StatusBar?
	 */
	private JCheckBox _cbOk;
	
	/**
	 * Ausgabe der Meldung {@link LogData#INFO} in der StatusBar?
	 */
	private JCheckBox _cbInformation;
	
	/**
	 * Ausgabe der Meldung {@link LogData#DATABASE_ERROR} in der StatusBar?
	 */
	private JCheckBox _cbDbError;
	
	/**
	 * Ausgabe der Meldung {@link LogData#DATABASE_INSERT} in der StatusBar?
	 */
	private JCheckBox _cbDbInsert;
	
	/**
	 * Soll das Logbuch-Menü angezeigt werden?
	 */
	private JCheckBox _cbMenu;
	
	/**
	 * Soll das Logbuch automatisch beim beenden gespeichert werden?
	 */
	private JCheckBox _cbAutoSave;
	
	/**
	 * Name der automatisch genierten Datei. Muss nur angegeben werden, wenn
	 * _cbAutoSave aktiviert ist.
	 */
	private JTextField _txtAutoName;
	
	/**
	 * Name des Packages für die eigenen Klassen.
	 */
	private JTextField _txtPackage;

	/**
	 * Initialisiert die Steuerelemente.
	 */
	public LogPanel() {
		super(false);
		setLayout(new GridLayout(1, 2));
		
		LogConfig config = LogConfig.getInstance();
		
		// Meldungen in der StatusBar anzeigen
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.setBorder(BorderFactory.createTitledBorder(
				"Meldungen in der Statusbar anzeigen?"));
		add(panel);
		
		_cbNoOut = new JCheckBox("Nicht ausgebare Nachricht");
		_cbNoOut.setSelected(config.getMessageTypeOut(LogData.NO_OUT));
		panel.add(_cbNoOut);
		
		_cbNone = new JCheckBox("Normale Nachricht");
		_cbNone.setSelected(config.getMessageTypeOut(LogData.NONE));
		panel.add(_cbNone);
		
		_cbError = new JCheckBox("Fehler");
		_cbError.setSelected(config.getMessageTypeOut(LogData.ERROR));
		panel.add(_cbError);
		
		_cbWarning = new JCheckBox("Warnung");
		_cbWarning.setSelected(config.getMessageTypeOut(LogData.WARNING));
		panel.add(_cbWarning);
		
		_cbOk = new JCheckBox("Erfolgsnachricht");
		_cbOk.setSelected(config.getMessageTypeOut(LogData.OK));
		panel.add(_cbOk);
		
		_cbInformation = new JCheckBox("Informationen");
		_cbInformation.setSelected(config.getMessageTypeOut(LogData.INFO));
		panel.add(_cbInformation);
		
		_cbDbError = new JCheckBox("Datenbank-Fehler");
		_cbDbError.setSelected(config.getMessageTypeOut(
				LogData.DATABASE_ERROR));
		panel.add(_cbDbError);
		
		_cbDbInsert = new JCheckBox("Datenbank-Nachricht");
		_cbDbInsert.setSelected(config.getMessageTypeOut(
				LogData.DATABASE_INSERT));
		panel.add(_cbDbInsert);
		
		// Panel für die Mitte
		panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		add(panel);
		
		// Menü anzeigen
		_cbMenu = new JCheckBox("Menü anzeigen?");
		_cbMenu.setSelected(config.showMenu());
		panel.add(_cbMenu);
		
		// Automatische Speicherung
		JPanel pan = new JPanel();
		pan.setLayout(new BoxLayout(pan, BoxLayout.Y_AXIS));
		pan.setBorder(BorderFactory.createTitledBorder(
				"Logbuch-Datei beim Beenden"));
		panel.add(pan);
		
		_cbAutoSave = new JCheckBox("generieren");
		_cbAutoSave.setSelected(config.isAutoSave());
		pan.add(_cbAutoSave);
		
		JPanel pan2 = new JPanel();
		pan2.setLayout(new BorderLayout());
		pan.add(new JLabel("Name der Datei"), BorderLayout.WEST);
		_txtAutoName = new JTextField();
		_txtAutoName.setText(config.getAutoFileName());
		_txtAutoName.setEnabled(_cbAutoSave.isSelected());
		pan.add(_txtAutoName, BorderLayout.CENTER);
		
		// Name des Packages der eigenen Klassen.
		pan2 = new JPanel();
		pan2.setLayout(new BorderLayout());
		panel.add(pan2);
		
		pan2.add(new JLabel("Package der eigenen Klassen"), BorderLayout.WEST);
		_txtPackage = new JTextField();
		_txtPackage.setText(config.getPackageName());
		pan2.add(_txtPackage, BorderLayout.CENTER);
	}
	
	/**
	 * Wird aufgerufen, wenn die Daten übernommen werden sollen.
	 */
	public void writeToLoadConfig() {
		LogConfig config = LogConfig.getInstance();
		
		// Meldungen in der StatusBar anzeigen
		config.setMessageTypeOut(LogData.NO_OUT, _cbNoOut.isSelected());
		config.setMessageTypeOut(LogData.NONE, _cbNone.isSelected());
		config.setMessageTypeOut(LogData.WARNING, _cbWarning.isSelected());
		config.setMessageTypeOut(LogData.ERROR, _cbError.isSelected());
		config.setMessageTypeOut(LogData.OK, _cbOk.isSelected());
		config.setMessageTypeOut(LogData.INFO, _cbInformation.isSelected());
		config.setMessageTypeOut(LogData.DATABASE_ERROR,
				_cbDbError.isSelected());
		config.setMessageTypeOut(LogData.DATABASE_INSERT,
				_cbDbInsert.isSelected());
		
		// Automatische Speicherung
		config.setAutoSave(_cbAutoSave.isSelected());
		config.setAutoFileName(_txtAutoName.getText());
		
		// Menü anzeigen
		config.setShowMenu(_cbMenu.isSelected());
		
		// Name des Packages für eigene Klassen
		config.setPackageName(_txtPackage.getText());
	}
}
