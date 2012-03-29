/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.greenwind.reallifequestlog;

import java.awt.Component;
import javax.swing.AbstractCellEditor;
import javax.swing.JTree;
import javax.swing.tree.TreeCellEditor;

/**
 *
 * @author piotr
 */
public class QuestTreeEditor extends AbstractCellEditor implements TreeCellEditor{

    @Override
    public Object getCellEditorValue() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Component getTreeCellEditorComponent(JTree tree, Object value, boolean isSelected, boolean expanded, boolean leaf, int row) {
        int i = 0;
        i++;
        
        
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
