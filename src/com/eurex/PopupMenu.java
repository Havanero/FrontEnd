package com.eurexchange.clear.frontend;

import javax.swing.*;

public class PopupMenu extends JPopupMenu {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    JMenuItem anItem;
    JMenuItem anItem1;
    public PopupMenu(){
        anItem = new JMenuItem("Select Text to Copy");
        anItem1 = new JMenuItem("Paste");
        add(anItem);
        add(anItem1);
    }

}
