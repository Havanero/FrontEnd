package com.eurexchange.clear.frontend;

import javax.swing.text.JTextComponent;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class PopClickListener extends MouseAdapter {

    JTextComponent jTextComponent = null;
    private Clipboard clipboard;

    public void mousePressed(MouseEvent e) {
        clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        if (e.isPopupTrigger())
            doPop(e);
        jTextComponent = (JTextComponent) e.getSource();
        try {

            if (jTextComponent.getSelectedText() != null) {
                doPop(e);
            }
        } catch (Exception s) {
        }
    }

    public void mouseReleased(MouseEvent e) {
        if (e.isPopupTrigger())
            doPop(e);
    }

    private void doPop(MouseEvent e) {
        PopupMenu menu = new PopupMenu();
        menu.show(e.getComponent(), e.getX(), e.getY());
        menu.anItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jTextComponent.copy();
            }
        });

        menu.anItem1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (clipboard.isDataFlavorAvailable(DataFlavor.stringFlavor)) {
                    jTextComponent.paste();
                }
            }
        });
    }
}

