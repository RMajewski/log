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

package org.log.renderer;

import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import javax.swing.UIManager;

import org.log.datas.LogData;

/**
 * Zeigt die Einträge der Log-Liste an.
 * 
 * @author René Majewski
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
		
		// Muss aufgerufen werden, um den Hintergrund zu ändern
		setOpaque(true);
		
		// Wurde das Element ausgewählt?
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
