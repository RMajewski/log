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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JColorChooser;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import org.log.config.LogConfig;
import org.log.datas.LogData;

/**
 * Gibt Steuerelemente für die Einstellungen der Farben zurück.
 * 
 * @author René Majewski
 *
 * @version 0.1
 * 
 * @since 0.1
 */
public class LogPanelColor extends JPanel
		implements ChangeListener, ListSelectionListener, ActionListener {
	/**
	 * Serial ID
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Gibt das Kommando zum Zurücksetzen an.
	 */
	public static final String RESET = "Log.LogPanelColor.Reset";
	
	/**
	 * Gibt das Kommando zum Übernen an.
	 */
	public static final String OK = "Log.LogPanelColor.Ok";
	
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
		
		JSplitPane pp = new JSplitPane();
		pp.setDividerLocation(240);
		add(pp, BorderLayout.CENTER);
		
		// Liste mit den Nachrichten-Typen
		DefaultListModel<String> model = new DefaultListModel<String>();
		for (short s = 0; s <= LogData.getTypesCount(); s++)
			model.addElement(LogData.getMessageName(s));
		_list = new JList<String>(model);
		_list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		_list.addListSelectionListener(this);
		pp.setLeftComponent(new JScrollPane(_list));
		
		// Farbauswahl
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel.setBorder(BorderFactory.createTitledBorder("Farbauswahl"));
		pp.setRightComponent(panel);
		
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
		btn.setMnemonic('b');
		btn.setActionCommand(OK);
		btn.addActionListener(this);
		panel2.add(btn);
		
		btn = new JButton("Zurücksetzen");
		btn.setMnemonic('Z');
		btn.setActionCommand(RESET);
		btn.addActionListener(this);
		panel2.add(btn);
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

	/**
	 * Reagiert darauf, wenn in der Liste die Selektion geändert wird.
	 * 
	 * @param lse Daten des Ereignisses.
	 */
	@Override
	public void valueChanged(ListSelectionEvent lse) {
		if (lse.getSource() == _list) {
			setExampleColor();
		}
	}
	
	/**
	 * Setzt die Farben des Labels auf die Farben der ausgewählten Nachricht.
	 */
	private void setExampleColor() {
		_lblExample.setBackground(LogConfig.getInstance().getBackground(
				LogData.getMessageType(_list.getSelectedValue())));
		_lblExample.setForeground(LogConfig.getInstance().getForeground(
				LogData.getMessageType(_list.getSelectedValue())));
	}

	/**
	 * Reagiert auf die Klicks der Buttons.
	 * 
	 * @param ae Daten des Ereignisses.
	 */
	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getActionCommand().equals(RESET)) {
			setExampleColor();
		}
		
		else if (ae.getActionCommand().equals(OK)) {
			LogConfig.getInstance().setBackground(LogData.getMessageType(
					_list.getSelectedValue()), _lblExample.getBackground());
			LogConfig.getInstance().setForeground(LogData.getMessageType(
					_list.getSelectedValue()), _lblExample.getForeground());
		}
	}
}
