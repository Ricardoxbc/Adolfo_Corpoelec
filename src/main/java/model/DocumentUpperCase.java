/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 *
 * @author Ricardo Bermudez
 */
public class DocumentUpperCase extends PlainDocument{
   @Override
   public void insertString(int i, String string, AttributeSet as) throws BadLocationException {
        super.insertString(i, string.toUpperCase(), as);
    }
}