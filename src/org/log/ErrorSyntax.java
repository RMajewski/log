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

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Toolkit;
import java.util.HashMap;
import java.util.Map;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultEditorKit;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.Element;
import javax.swing.text.MutableAttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.TabSet;
import javax.swing.text.TabStop;

/**
 * Stellt den Fehlerbericht farbig dar.
 * 
 * @author Ren� Majewski
 *
 * @version 0.1
 * @since 0.1
 */
public class ErrorSyntax extends DefaultStyledDocument {
	/**
	 * Serial ID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Speichert den Namen f�r die standard Schriftart.
	 */
	private static final String DEFAULT_FONT_FAMILY = "Curier New";
	
	/**
	 * Speichert die standard Schriftgr��e.
	 */
	private static final int DEFAULT_FONT_SIZE = 12;
	
	/**
	 * Schrift-Attribute f�r normale Ausgabe.
	 */
	public static final SimpleAttributeSet DEFAULT_NORMAL;
	
	/**
	 * Schrift-Attribute f�r Fehler-Klassen.
	 */
	public static final SimpleAttributeSet DEFAULT_ERROR;
	
	/**
	 * Schrift-Attribute f�r eigene Klassen.
	 */
	public static final SimpleAttributeSet DEFAULT_CLASSES;
	
	/**
	 * Schrift-Attribute f�r Datei-Namen.
	 */
	public static final SimpleAttributeSet DEFAULT_FILE;
	
	static {
		DEFAULT_NORMAL = new SimpleAttributeSet();
		StyleConstants.setForeground(DEFAULT_NORMAL, Color.WHITE);
		StyleConstants.setBackground(DEFAULT_NORMAL, Color.BLACK);
		StyleConstants.setFontFamily(DEFAULT_NORMAL, DEFAULT_FONT_FAMILY);
		StyleConstants.setFontSize(DEFAULT_NORMAL, DEFAULT_FONT_SIZE);

		DEFAULT_ERROR = new SimpleAttributeSet();
		StyleConstants.setForeground(DEFAULT_ERROR, Color.RED);
		StyleConstants.setBackground(DEFAULT_ERROR, Color.BLACK);
		StyleConstants.setFontFamily(DEFAULT_ERROR, DEFAULT_FONT_FAMILY);
		StyleConstants.setFontSize(DEFAULT_ERROR, DEFAULT_FONT_SIZE);

		DEFAULT_CLASSES = new SimpleAttributeSet();
		StyleConstants.setForeground(DEFAULT_CLASSES, Color.GREEN);
		StyleConstants.setBackground(DEFAULT_CLASSES, Color.BLACK);
		StyleConstants.setFontFamily(DEFAULT_CLASSES, DEFAULT_FONT_FAMILY);
		StyleConstants.setFontSize(DEFAULT_CLASSES, DEFAULT_FONT_SIZE);

		DEFAULT_FILE = new SimpleAttributeSet();
		StyleConstants.setForeground(DEFAULT_FILE, Color.BLUE);
		StyleConstants.setBackground(DEFAULT_FILE, Color.BLACK);
		StyleConstants.setFontFamily(DEFAULT_FILE, DEFAULT_FONT_FAMILY);
		StyleConstants.setFontSize(DEFAULT_FILE, DEFAULT_FONT_SIZE);
	}
	
	/**
	 * Speichert das Dokument, in welchem der Text dargestellt wird.
	 */
	private DefaultStyledDocument _doc;
	
	/**
	 * Speichert das Dokument, in dem alle anderen Elemente eingef�gt werden.
	 */
	private Element _rootElement;
	
	/**
	 * Speichert die Attribute f�r normale Ausgaben.
	 */
	private MutableAttributeSet _normal = DEFAULT_NORMAL;
	
	/**
	 * Speichert die Attribute f�r Fehler-Klassen.
	 */
	private MutableAttributeSet _error = DEFAULT_ERROR;
	
	/**
	 * Speichert die Attribute f�r eigene Klassen
	 */
	private MutableAttributeSet _class = DEFAULT_CLASSES;
	
	/**
	 * Speichert die Attribute f�r Datei-Namen
	 */
	private MutableAttributeSet _file = DEFAULT_FILE;
	
	/**
	 * Zuordnung der Schrift-Attribute zu den Schl�sselw�rtern.
	 */
	private HashMap<String, MutableAttributeSet> _keywords;
	
	/**
	 * Zuordnung der Schrift-Attribute zu den Fehlerklassen.
	 */
	private HashMap<String, MutableAttributeSet> _classes;
	
	/**
	 * Speichert die Schriftgr��e.
	 */
	private int _fontSize;
	
	/**
	 * Speichert die Schriftart.
	 */
	private String _fontName;
	
	/**
	 * Initialisiert die Daten.
	 */
	public ErrorSyntax() {
		_doc = this;
		_rootElement = _doc.getDefaultRootElement();
		putProperty(DefaultEditorKit.EndOfLineStringProperty,
				System.lineSeparator());
		_fontSize = DEFAULT_FONT_SIZE;
		_fontName = DEFAULT_FONT_FAMILY;
		_keywords = new HashMap<String, MutableAttributeSet>();
		_classes = new HashMap<String, MutableAttributeSet>();
	}
	
	/**
	 * Ordnet zu den Schl�sselwort die entsprechenden Schrift-Formatierungen
	 * zu.
	 * 
	 * @param key Schl�sselwort, welches in die Liste eingetragen werden soll.
	 * 
	 * @param attr Schrift-Attribute, die dem Schl�sselwort zugeordnet werden
	 * sollen.
	 */
	public void addKeyword(String key, MutableAttributeSet attr) {
		_keywords.put(key, attr);
	}
	
	/**
	 * F�gt den Namen einer Fehler-Klasse hinzu und ordnet ihr die
	 * Schrift-Formatierungen f�r Fehler-Klassen zu.
	 * 
	 * @param exception Name der Fehler-Klasse.
	 */
	public void addException(String exception) {
		_classes.put(exception, _error);
	}
	
	/**
	 * Ordnet den Namen einer Klasse die entsprechenden Schrift-Formatierungen
	 * zu.
	 * 
	 * @param name Name der Klasse.
	 * 
	 * @param attr Schrift-Attribute, die der Klasse zugeordnet werden sollen.
	 */
	public void addClassName(String name, MutableAttributeSet attr) {
		_classes.put(name, attr);
	}
	
	/**
	 * Ermittelt die SChrift-Attribute f�r das ausgew�hlte Schl�sselwort.
	 * 
	 * @param key Schl�sselwort, dessen Schrift-Attribute ermittelt werden
	 * sollen.
	 * 
	 * @return Schrift-Attribute des ausgew�hlten Schl�sselwortes.
	 */
	public MutableAttributeSet getKeywordFormatting(String key) {
		return _keywords.get(key);
	}
	
	/**
	 * Ermittelt die Schrift-Attribute f�r eine Fehler-Klasse.
	 * 
	 * @return Schrift-Attribute f�r die Fehler-Klassen.
	 */
	public MutableAttributeSet getExceptionFormatting() {
		return _error;
	}
	
	/**
	 * L�scht ein Schl�sselwort aus der Liste.
	 * 
	 * @param key Schl�sselwort, dass aus der Liste gel�scht werden soll.
	 */
	public void removeKeyword(String key) {
		_keywords.remove(key);
	}
	
	/**
	 * L�scht eine Fehler-Fehlerklasse aus der Liste.
	 * 
	 * @param exception Fehler-Klasse, die aus der Liste gel�scht werden soll.
	 */
	public void removeException(String exception) {
		_classes.remove(exception);
	}
	
	/**
	 * Setzt die Anzahl der Zeichen f�r einen Tabulator.
	 * 
	 * @param count Anzahl der Zeichen f�r einen Tabulator.
	 */
	public void setTabs(int count) {
		Font font = new Font(_fontName, Font.PLAIN, _fontSize);
		FontMetrics metrics = Toolkit.getDefaultToolkit().getFontMetrics(font);
		int charWidth = metrics.charWidth(' ');
		int tabWidth = charWidth * count;
		
		TabStop[] tabs = new TabStop[35];
		for (int i = 0; i < tabs.length; i++)
			tabs[i] = new TabStop(i * tabWidth);
		
		TabSet ts = new TabSet(tabs);
		SimpleAttributeSet attributes = new SimpleAttributeSet();
		StyleConstants.setTabSet(attributes, ts);
		
		setParagraphAttributes(0, getLength(), attributes, false);
	}
	
	/**
	 * Gibt die verwendete Schriftgr��e zur�ck.
	 * 
	 * @return Verwendete Schriftgr��e.
	 */
	public int getFontSize() {
		return _fontSize;
	}
	
	/**
	 * Setzt die verwendete Schriftgr��e neu.
	 * 
	 * @param size Neue Schriftgr��e.
	 */
	public void setFontSize(int size) {
		_fontSize = size;
		
		StyleConstants.setFontSize(_error, size);
		StyleConstants.setFontSize(_normal, size);
		StyleConstants.setFontSize(_file, size);
		StyleConstants.setFontSize(_class, size);
	}
	
	/**
	 * Gibt die verwendete Schriftart zur�ck.
	 * 
	 * @return Vervendete Schriftart.
	 */
	public String getFontName() {
		return _fontName;
	}
	
	/**
	 * Setzt die verwendete Schriftart neu.
	 * 
	 * @param name Name der neue Schriftart.
	 */
	public void setFontName(String name) {
		_fontName = name;
		
		StyleConstants.setFontFamily(_error, name);
		StyleConstants.setFontFamily(_normal, name);
		StyleConstants.setFontFamily(_file, name);
		StyleConstants.setFontFamily(_class, name);
	}
	
	/**
	 * F�gt neuen Text in das Dokument ein.
	 * 
	 * @param offset Stelle, an die der Text eingef�gt werden soll.
	 * 
	 * @param str Zeichenkette, die eingef�gt werden soll.
	 * 
	 * @param atr Schrift-Attribute.
	 */
	@Override
	public void insertString(int offset, String str, AttributeSet atr)
			throws BadLocationException {
		super.insertString(offset, str, atr);
		processChangedLines(offset, str.length());
	}
	
	/**
	 * L�scht die angegebene Zeichenkette.
	 * 
	 * @param offset Stelle, von der an gel�scht werden soll.
	 * 
	 * @param length Anzahl Zeichen, die gel�scht werden sollen.
	 */
	@Override
	public void remove(int offset, int length) throws BadLocationException {
		super.remove(offset, length);
		processChangedLines(offset, 0);
	}
	
	/**
	 * Liest die ver�nderten Zeichen ein.
	 * 
	 * @param offset Stelle, an der die Ver�nderung beginnt.
	 * 
	 * @param length Anzahl Zeichen, die ver�ndert wurden.
	 * 
	 * @throws BadLocationException Wird aufgerufen, wenn an einer Stelle Text
	 * ge�ndert werden soll, die nicht vorhanden ist. 
	 */
	public void processChangedLines(int offset, int length)
			throws BadLocationException {
		String content = _doc.getText(0,  _doc.getLength());
		
		int startLine = _rootElement.getElementIndex(offset);
		int endLine = _rootElement.getElementIndex(offset + length);
		
		for (int i = startLine; i <= endLine; i++)
			applyHightlighting(content, i);
	}
	
	/**
	 * Durchsucht die �bergebewne Zeichenkette nach Zeichen, die mit einem
	 * Highlight versehen werden sollen.
	 * 
	 * @param content Zeichenkette, die verarbeitet werden soll.
	 * 
	 * @param line Nummer der Zeile, die durchlaufen wird.
	 */
	private void applyHightlighting(String content, int line) {
		int startOffset = _rootElement.getElement(line).getStartOffset();
		int endOffset = _rootElement.getElement(line).getEndOffset();
		int lineLength = endOffset - startOffset;
		int contentLength = content.length();
		
		if (endOffset >= contentLength)
			endOffset = contentLength - 1;
		
		// erste Zeichenbeschr�nkungen
		int test1 = content.indexOf(':', startOffset);
		int test2 = content.indexOf('(', startOffset);
		
		// �berpr�fen, ib eine Klasse existiert
		int length = 0;
		if ((test1 > -1) && (test1 <= endOffset) && (test2 > endOffset)) {
			length = test1 - startOffset;
		} else if ((test2 > -1) && (test2 <= endOffset) && (test2 < test1)) {
			length = test2 - startOffset;
		} else if ((startOffset < endOffset) && (test2 > endOffset)) {
			length = endOffset - startOffset;
		}
		
		// Klasse gefunden?
		if (length > 0) {
			String name = content.substring(startOffset, startOffset + length);
			for (Map.Entry<String, MutableAttributeSet> e : 
					_classes.entrySet()) {
				if (isInString(name, e.getKey())) {
					_doc.setCharacterAttributes(startOffset, length, 
							e.getValue(), true);
					startOffset += length;
				}
			}
		}
		
		// Nach Datei-Namen suchen
		if ((test2 >= startOffset) && (test2 < endOffset)) {
			// Sind Zeichen zwischen Datenamen und Klasse vorhanden?
			if (startOffset <= test2)
				_doc.setCharacterAttributes(startOffset, 
						test2 - startOffset + 1, _normal, true);
			
			int test3 = content.indexOf(')', test2);
			if ((test2 > startOffset) && (test3 <= endOffset)) {
				length = test3 - test2;
				_doc.setCharacterAttributes(startOffset, lineLength, _file, 
						true);
				startOffset = test2 + length;
			}
		}
		
		_doc.setCharacterAttributes(startOffset, lineLength, _normal, true);
	}
	
	/**
	 * �berpr�ft, ob in der Zeichenkette source die Zeichenkette part enthalten
	 * ist. Ist dies der Fall, so wird true zur�ck gegeben. Wenn nicht, dann
	 * false.
	 * 
	 * @param source Zeichenktte, die durchsucht werden soll.
	 * 
	 * @param part Zeichenkette, die existieren soll.
	 * 
	 * @return Wurde part in source gefunden?
	 */
	private boolean isInString(String source, String part) {
		if ((source == null) || source.isEmpty() || (part == null) ||
				part.isEmpty())
			return false;
		
		if (source.indexOf(part) > -1)
			return true;
		
		return false;
	}
}
