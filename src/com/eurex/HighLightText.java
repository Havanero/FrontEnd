/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eurex;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JTextArea;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Document;
import javax.swing.text.Highlighter;
import javax.swing.text.JTextComponent;

/**
 *
 * @author carvcal
 */
public class HighLightText {
    private String word;
    private JTextArea textArea;
    private Graphics graphics;
    private Color color;
    
    public HighLightText(JTextArea pTextArea,String pWord, Color pColor){
        this.word = pWord;
        this.textArea = pTextArea;
//      color = pColor;
        highlight(textArea, word);
    }
    
    private void highlight(JTextComponent textComponent, String word){
        removeHighlights(textComponent);
        try {
             Highlighter hilite = textComponent.getHighlighter();
             Document doc = textComponent.getDocument();
             String text = doc.getText(0, doc.getLength());
             int pos = 0;
             while ((pos = text.toUpperCase().indexOf(word.toUpperCase(), pos)) >= 0) {
//              hilite.addHighlight(pos, pos+word.length(), myHighlightPainter);
                 hilite.addHighlight(pos, pos+word.length()+15, myHighlightPainter);
                pos += word.length();
             }
        }catch(BadLocationException  s){
        }
        
    }
   public void removeHighlights(JTextComponent textComp) {
        Highlighter hilite = textComp.getHighlighter();
        Highlighter.Highlight[] hilites = hilite.getHighlights();
        for (Highlighter.Highlight hilite1 : hilites) {
            if (hilite1.getPainter() instanceof MyHighlightPainter) {
                hilite.removeHighlight(hilite1);
            }
        }
    }
   
Highlighter.HighlightPainter myHighlightPainter = new MyHighlightPainter(Color.yellow);

// A private subclass of the default highlight painter
class MyHighlightPainter extends DefaultHighlighter.DefaultHighlightPainter {
    public MyHighlightPainter(Color color) {
        super(color);
    }
}
}
