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
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JColorChooser;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * Gibt Steuerelemente für die Einstellungen der Farben zurück.
 * 
 * @author René Majewski
 *
 * @version 0.1
 * 
 * @since 0.1
 */
public class LogPanelColor extends JPanel implements ChangeListener {
	/**
	 * Serial ID
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Speichern der Farbauswahl
	 */
	private JColorChooser _color;
	
	/**
	 * Liste für die einzelnen Nachrichten-Typen.
	 */
	private JList<String> _list;
	
	/**
	 * Speichert das Label zur Ausgabe einer Beispiel-Nachricht
	 */
	private JLabel _lblExample;
	
	/**
	 * Speichert die Auswahlbox für die Textfarbe.
	 */
	private JCheckBox _cbTextColor;
	
	
	/**
	 * Initialisiert das Panel mit seinen Steuerelementen.
	 */
	public LogPanelColor() {
		super(false);
		setLayout(new BorderLayout());
		
		// Liste mit den Nachrichten-Typen
		_list = new JList<String>();
		add(new JScrollPane(_list), BorderLayout.WEST);
		
		// Farbauswahl
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel.setBorder(BorderFactory.createTitledBorder("Farbauswahl"));
		add(panel, BorderLayout.CENTER);
		
		_color = new JColorChooser();
		_color.setPreviewPanel(new JPanel());
		_color.getSelectionModel().addChangeListener(this);
		panel.add(_color, BorderLayout.CENTER);
		
		JPanel panel2 = new JPanel();
		panel.add(panel2, BorderLayout.SOUTH);
		
		_lblExample = new JLabel("Beispiel Nachricht", JLabel.LEFT);
		_lblExample.setBorder(BorderFactory.createBevelBorder(1));
		_lblExample.setOpaque(true);
		panel2.add(_lblExample, BorderLayout.SOUTH);
		
		_cbTextColor = new JCheckBox("Textfarbe");
		_cbTextColor.setSelected(true);
		panel2.add(_cbTextColor);
		
		JButton btn = new JButton("Übernehmen");
		panel2.add(btn);
		
		btn = new JButton("Zurücksetzen");
		panel2.add(btn);
	}

	/**
	 * Speichert die Einstellungen in der Konfiguration ab.
	 */
	public void writeToConfig() {
		
	}

	/**
	 * Reagiert darauf, wenn eine Farbe ausgewählt wird.
	 * 
	 * @param ce Daten des Ereignisses.
	 */
	@Override
	public void stateChanged(ChangeEvent ce) {
		if (_cbTextColor.isSelected())
			_lblExample.setForeground(_color.getColor());
		else
			_lblExample.setBackground(_color.getColor());
	}
}
