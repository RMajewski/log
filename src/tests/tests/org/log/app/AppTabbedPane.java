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

package tests.org.log.app;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

import org.log.elements.LogPanel;
import org.log.elements.LogPanelColor;

/**
 * Zeigt die einzelnen Panels im Tabbed-Pane an.
 * 
 * @author René Majewski
 *
 * @since 0.4
 */
public class AppTabbedPane extends JFrame {
	/**
	 * Serial ID
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Initialisiert die Test-Anwendung.
	 */
	public AppTabbedPane() {
		super();
		setSize(800, 600);
		setTitle("Tabbed-Pane Test");		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JTabbedPane pane = new JTabbedPane();
		add(pane, BorderLayout.CENTER);
		
		pane.addTab("Logbuch", new LogPanel());
		pane.addTab("Nachrichten", new LogPanelColor());
		
		setVisible(true);
	}

	/**
	 * Zeigt die die Test-App an.
	 * 
	 * @param args Kommandozeilen-Parameter
	 */
	public static void main(String[] args) {
		new AppTabbedPane();
	}

}
