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

import java.awt.GridLayout;

import javax.swing.JColorChooser;
import javax.swing.JPanel;

/**
 * Gibt Steuerelemente für die Einstellungen der Farben zurück.
 * 
 * @author René Majewski
 *
 * @version 0.1
 * 
 * @since 0.1
 */
public class LogPanelColor extends JPanel {
	/**
	 * Serial ID
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Speichern der Farbauswahl
	 */
	private JColorChooser _color;
	
	
	/**
	 * Initialisiert das Panel mit seinen Steuerelementen.
	 */
	public LogPanelColor() {
		super(false);
		setLayout(new GridLayout(1, 2));
		
		LogConfig config = LogConfig.getInstance();
	}

	/**
	 * Speichert die Einstellungen in der Konfiguration ab.
	 */
	public void writeToConfig() {
		
	}
}
