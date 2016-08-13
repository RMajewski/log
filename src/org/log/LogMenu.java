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

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JDesktopPane;
import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * Erstellt das Logbuch-Menü.
 * 
 * @author René Majewski
 *
 * @version 0.1
 * Erstellt das Logbuch-Menü mit den Einträgen "Anzeigen" und "Speichern".
 * 
 * @since 0.3
 */
public class LogMenu extends JMenu implements ActionListener {
	/**
	 * Serial ID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Speichert das Kommando zum Anzeigen des Logbuches.
	 */
	public static final String SHOW = "Log.Menu.Show";
	
	/**
	 * Speichert das Kommando zum Speichern der Logbuch-Datei.
	 */
	public static final String SAVE = "Log.Menu.Save";
	
	/**
	 * Speichert den Desktop des Hauptfensters.
	 */
	private JDesktopPane _desktop;
	
	/**
	 * Initialisiert das Logbuch-Menü
	 * 
	 * @param al Wenn null übergeben wird, wird der eigene ActionListener
	 * verwendet. Ansonsten der, der übergeben wird. 
	 * 
	 * @param desktop Desktop, in dem das Fenster des Logbuch eingefügt werden
	 * soll.
	 */
	public LogMenu(ActionListener al, JDesktopPane desktop) {
		super();
		_desktop = desktop;
		
		if (LogConfig.getInstance().showMenu()) {
			setText("Log");
			setMnemonic('L');
			
			JMenuItem item = new JMenuItem("Anzeigen");
			item.setMnemonic('A');
			item.setActionCommand(SHOW);
			if (al == null)
				item.addActionListener(this);
			else
				item.addActionListener(al);
			add(item);
			
			item = new JMenuItem("Speichern");
			item.setMnemonic('S');
			item.setActionCommand(SAVE);
			if (al == null)
				item.addActionListener(this);
			else
				item.addActionListener(al);
			add(item);
		}
	}

	/**
	 * Reagiert auf die Klicks eines der Menü-Einträge
	 */
	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getActionCommand().equals(SAVE)) {
			JFileChooser fc = new JFileChooser();
			fc.setFileFilter(new FileNameExtensionFilter("Textdatei", ".txt"));
			
			int state = fc.showSaveDialog(this);
			if (state == JFileChooser.APPROVE_OPTION) {
				File file = fc.getSelectedFile();
				StatusBar.getInstance().writeToFile(file);
			}
		}
		
		else if(ae.getActionCommand().equals(SHOW)) {
			_desktop.add(new LogView(LogConfig.getInstance().getPackageName()));
		}
	}
}
