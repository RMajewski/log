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

import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import javax.swing.UIManager;

/**
 * Zeigt die Eintr�ge der Log-Liste an.
 * 
 * @author Ren� Majewski
 *
 * @version 0.1
 * @since 0.1
 */
public class LogViewListRenderer extends JLabel
		implements ListCellRenderer<LogData> {

	/**
	 * Serialisation ID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 */
	@Override
	public Component getListCellRendererComponent(JList<? extends LogData> list,
			LogData value, int index, boolean isSelected, boolean cekkHasFocus)
	{
		// Nachricht anzeigen
		setText(value.getMessage());
		
		// Muss aufgerufen werden, um den Hintergrund zu �ndern
		setOpaque(true);
		
		// Wurde das Element ausgew�hlt?
		if (isSelected) {
			setForeground(UIManager.getColor("List.selectionForeground"));
			setBackground(UIManager.getColor("List.seelctionBackground"));
		} else {
			setForeground(LogData.getForeground(value.getOut()));
			setBackground(LogData.getBackground(value.getOut()));
		}
		
		return this;
	}

}
