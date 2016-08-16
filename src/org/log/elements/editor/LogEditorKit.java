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

package org.log.elements.editor;

import javax.swing.text.Document;
import javax.swing.text.StyledEditorKit;

/**
 * Erstellt das Dokument zum highlighten.
 * 
 * @author René Majewski
 *
 * @version 0.2
 * Im Konstruktor wird nun das Package übergeben, in dem sich die eigenen
 * Klassen befinden.
 *
 * @version 0.1
 * Highlighten der verschiedenen Fehlerklassen.
 * 
 * @since 0.1
 */
public class LogEditorKit extends StyledEditorKit {
	/**
	 * Serial ID
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Speichert, in welchem Package sich die eigenen Klassen befinden.
	 */
	private String _begin;
	
	/**
	 * Initialisiert das Dokument.
	 * 
	 * @param begin Name des Packges, wo die eigenen Klassen sich befinden.
	 */
	public LogEditorKit(String begin) {
		_begin = begin;
	}

	/**
	 * Erstellt das Dokument, welches die Fehlerbeschreibung highlightet.
	 * 
	 * Sytem_properties:
	 * log.ClassName Klassen-Name, der als eigene Klasse gehighlightet werden
	 * soll.
	 */
	@Override
	public Document createDefaultDocument() {
		ErrorSyntax syntax = new ErrorSyntax();
		
		// Fehlerklassen von Java
		syntax.addException("java.lang.Exception");
		
		syntax.addException("java.lang.IllegalArgumentException");
		
		syntax.addException("java.lang.ClassNotFoundException");
		syntax.addException("java.lang.ClassCastException");
		syntax.addException("java.lang.InterruptedException");
		syntax.addException("java.lang.RuntimeException");
		syntax.addException("java.lang.NullPointerException");
		syntax.addException("java.lang.ArithmeticException");
		syntax.addException("java.lang.ArrayStoreException");
		syntax.addException("java.lang.CloneNotSupportedException");
		syntax.addException("java.lang.EnumConstantNotPresentException");
		syntax.addException("java.lang.IllegalMonitorStateException");
		syntax.addException("java.lang.IllegalStateException");
		syntax.addException("java.lang.IndexOutOfBoundsException");
		syntax.addException("java.lang.ArrayIndexOutOfBoundsException");
		syntax.addException("java.lang.StringIndexOutOfBoundsException");
		syntax.addException("java.lang.NegativeArraySizeException");
		syntax.addException("java.lang.SecurityException");
		syntax.addException("java.lang.TypeNotPresentException");
		syntax.addException("java.lang.UnsupportedOperationException");
		syntax.addException(
				"java.lang.annotation.AnnotationTypeMismatchException");
		syntax.addException(
				"java.lang.annotation.IncompleteAnnotationException");
		syntax.addException("java.lang.invoke.WrongMethodTypeException");
		syntax.addException(
				"java.lang.reflect.MalformedParameterizedTypeException");
		syntax.addException("java.lang.reflect.UndeclaredThrowableException");
		syntax.addException("javax.lang.model.type.MirroredTypesException");
		syntax.addException("javax.management.JMRuntimeException");
		syntax.addException("java.security.ProviderException");
		syntax.addException("java.nio.BufferOverflowException");
		syntax.addException("java.nio.BufferUnderflowException");
		syntax.addException("java.nio.file.FileSystemAlreadyExistsException");
		syntax.addException("java.nio.file.FileSystemNotFoundException");
		syntax.addException("java.nio.file.ProviderNotFoundException");
		syntax.addException("java.io.IOException");
		syntax.addException("java.io.FileNotFoundException");
		syntax.addException("java.io.ObjectStreamException");
		syntax.addException("java.io.NotSerializableException");
		syntax.addException("java.net.MalformedURLException");
		syntax.addException("java.util.ConcurrentModificationException");
		syntax.addException("java.util.EmptyStackException");
		syntax.addException("java.util.IllformedLocaleException");
		syntax.addException("java.util.MissingResourceException");
		syntax.addException("java.util.NoSuchElementException");
		syntax.addException("java.util.concurrent.RejectedExecutionException");
		syntax.addException("javax.xml.bind.DataBindingException");
		syntax.addException("javax.lang.model.UnknownEntityException");
		syntax.addException("javax.print.attribute.UnmodifiableSetException");
		syntax.addException("org.w3c.dom.DOMException");
		syntax.addException("org.w3c.dom.events.EventException");
		syntax.addException("org.w3c.dom.ls.LSException");
		syntax.addException("javax.xml.crypto.NoSuchMechanismException");
		syntax.addException("javax.xml.bind.TypeConstraintException");
		syntax.addException("javax.xml.ws.WebServiceException");
		syntax.addException("javax.swing.undo.CannotRedoException");
		syntax.addException("javax.swing.undo.CannotUndoException");
		syntax.addException("java.awt.color.CMMException");
		syntax.addException("java.awt.geom.IllegalPathStateException");
		syntax.addException("java.awt.image.ImagingOpException");
		syntax.addException("java.awt.color.ProfileDataException");
		syntax.addException("java.awt.image.RasterFormatException");
		syntax.addException("org.omg.CORBA.SystemException");		
		
		// Eigene Klassen
		syntax.addClassName(_begin, ErrorSyntax.DEFAULT_CLASSES);
		
		return syntax;
	}
}
