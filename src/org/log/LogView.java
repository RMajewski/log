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

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.Box;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * In diesem Fenster wird das Log angezeigt.
 * 
 * Wenn auf ein Element der List mit Log-Nachrichten geklickt wird, wird die
 * Fehlermeldung angezeigt, sofern sie vorhanden ist. Die Fehlermeldungen k�nnen
 * in die Zwischenablage kopiert und / oder gespeichert werden.
 * 
 * @author Ren� Majewski
 *
 * @version 0.1
 * @since 0.1
 */
public class LogView extends JInternalFrame
	implements ActionListener, ListSelectionListener, ClipboardOwner {
	/**
	 * Serial ID
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Speichert den Titel des Fensters.
	 */
	private static final String WND_TITLE = "Log";
	
	/**
	 * Speichert das Kommando f�r den OK-Button.
	 */
	private static final String OK = "LogView.ok";
	
	/**
	 * Speichert das Kommando zum Einf�gen in die Zwischenablage.
	 */
	private static final String CLIPBOARD = "LogView.clipboard";
	
	/**
	 * Speichert das Kommando zum Speichern der Log-Eintr�ge.
	 */
	private static final String SAVE = "LogView.save";
	
	/**
	 * Ausgabe der Fehlermeldungen.
	 */
	private JEditorPane _txtError;
	
	/**
	 * Speichert die List mit den Log-Eintr�gen.
	 */
	private JList<LogData> _listLog;
	
	/**
	 * Initialisiert das Fenster und zeigt es an.
	 */
	public LogView() {
		super();
		
		// Fenstergr��e und Fenster-Titel
		setSize(800, 600);
		setTitle(WND_TITLE);
		
		// Fenster-Eigenschaften
		setResizable(true);
		setClosable(true);
		setMaximizable(true);
		setIconifiable(true);
		
		// Liste anzeigen
		final DefaultListModel<LogData> model = new DefaultListModel<LogData>();
		StatusBar status = StatusBar.getInstance();
		for (int i = 0; i < status.getLog().size(); i++) {
			LogData log = status.getLog().get(i);
			if (log.getOut() > LogData.NO_OUT)
				model.addElement(log);
		}
		
		// Layout
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		// Panel f�r die Buttons
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.SOUTH);
		
		// OK-Button
		JButton btn = new JButton("OK");
		btn.setMnemonic('O');
		btn.addActionListener(this);
		btn.setActionCommand(OK);
		panel.add(btn);
		
		Component hs = Box.createHorizontalStrut(75);
		panel.add(hs);
		
		// Button f�r ZWischenablage
		btn = new JButton("In die Zwischenablage");
		btn.setMnemonic('Z');
		btn.setActionCommand(CLIPBOARD);
		btn.addActionListener(this);
		panel.add(btn);
		
		// Button zum Speichern
		btn = new JButton("Speichern");
		btn.setMnemonic('S');
		btn.setActionCommand(SAVE);
		btn.addActionListener(this);
		panel.add(btn);
		
		// Splitplane einf�gen
		JSplitPane split = new JSplitPane();
		getContentPane().add(split, BorderLayout.CENTER);
		
		// Text-Feld f�r die Fehlerbeschreibung
		_txtError = new JEditorPane();
		_txtError.setEditable(false);
		_txtError.setEditorKitForContentType("text", new LogEditorKit());
		_txtError.setContentType("text");
		_txtError.setBackground(Color.BLACK);
		split.setRightComponent(new JScrollPane(_txtError));
		
		// Liste f�r Log-Eintr�ge
		_listLog = new JList<LogData>();
		_listLog.setModel(model);
		_listLog.setCellRenderer(new LogViewListRenderer());
		_listLog.addListSelectionListener(this);
		split.setLeftComponent(new JScrollPane(_listLog));
		
		split.setDividerLocation(300);
		
		// Fenster anzeigen
		setVisible(true);
	}

	/**
	 * Wird nicht benutzt. Muss aber durch den Zugriff auf die Zwischenablage
	 * implementiert sein.
	 */
	@Override
	public void lostOwnership(Clipboard arg0, Transferable arg1) {
	}

	/**
	 * Reagiert auf die Selektion der Liste.
	 * 
	 * @param lse Event-Daten
	 */
	@Override
	public void valueChanged(ListSelectionEvent lse) {
		if (lse.getFirstIndex() > -1) {
			if (!_listLog.getSelectedValue().getError().isEmpty())
				_txtError.setText(_listLog.getSelectedValue().getError());
			else
				_txtError.setText("Kein Fehlerbericht vorhanden.");
		}
	}

	/**
	 * Reagiert auf den Klick eines der Buttons
	 * 
	 * @param ae Event-Daten
	 */
	@Override
	public void actionPerformed(ActionEvent ae) {
		// OK-Button
		if (ae.getActionCommand().equals(OK))
				setVisible(false);
		
		// Fehlerbeschreibung in die Zwischenablage kopieren
		else if (ae.getActionCommand().equals(CLIPBOARD)) {
			Clipboard cb = Toolkit.getDefaultToolkit().getSystemClipboard();
			StringSelection sc = new StringSelection(_txtError.getText());
			cb.setContents(sc, this);
		}
		
		// Log-Daten speichern
		else if (ae.getActionCommand().equals(SAVE)) {
			// Speichern Dialog aufrufen
			JFileChooser fc = new JFileChooser();
			fc.setFileFilter(new FileNameExtensionFilter("Log-Datei log",
					"log"));
			fc.setDialogTitle("Log speichern");
			int state = fc.showSaveDialog(null);
			
			if (state == JFileChooser.APPROVE_OPTION) {
				writeToFile(fc.getSelectedFile());
			}
		}
	}

	/**
	 * Speichert alle Log-Eintr�ge in die angegebene Datei.
	 * 
	 * @param file Datei, in die die Log-Eintr�ge geschrieben werden sollen.
	 */
	public static void writeToFile(File file) {
		try {
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream(file), "UTF-8"));
			
			List<LogData> list = StatusBar.getInstance().getLog();
			for (int i = 0; i < list.size(); i++) {
				if (i > 0)
					bw.write(System.lineSeparator());
				
				LogData data = list.get(i);
				
				bw.write(DateFormat.getDateTimeInstance(
						DateFormat.MEDIUM, DateFormat.MEDIUM)
						.format(new Date(data.getCreateTime())));
				
				bw.write(": ");
				
				bw.write(data.getMessage());
				bw.write(System.lineSeparator());
				
				if (!data.getError().isEmpty()) {
					bw.write(data.getError());
					bw.write(System.lineSeparator());
				}
			}
			
			bw.close();
		} catch (IOException e) {
			StatusBar.getInstance().setMessage("Es ist ein Fehler " + 
					"beim Speichern der Log-Datei aufgetreten.", e);
		}
	}
}
