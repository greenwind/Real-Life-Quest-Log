package pl.greenwind.reallifequestlog;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Date;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeCellRenderer;
import pl.greenwind.reallifequestlog.model.Quest;

/**
 *
 * @author piotr.janik
 */
public class QuestTreeRenderer extends DefaultTreeCellRenderer {

    private JPanel panel;
    private JLabel textRenderer;
    private JCheckBox checkBox;
    private Quest quest;
    
    public QuestTreeRenderer() {
        panel  = new JPanel();
    	textRenderer = new JLabel();
        checkBox = new JCheckBox();
    }

    @Override
    public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded, boolean leaf, int row, boolean hasFocus) {

        if(value instanceof Quest) {
            quest = (Quest) value;

            textRenderer.setText("aaa");
            checkBox.setSelected(quest.getDateStop() == null);
            
 /*           checkBox.addMouseListener(new MouseListener() {


                public void mouseClicked(MouseEvent evt) {
                                if(evt.getClickCount() == 2 && evt.getButton() == MouseEvent.BUTTON1) {
            System.out.println(evt);
            
            Quest target = (Quest) evt.getSource();
            if(target.getDateStop() == null) {
                target.setDateStop(new Date());
            }
            else {
                target.setDateStop(null);
            }
        }
                    throw new UnsupportedOperationException("Not supported yet.");
                }

                @Override
                public void mousePressed(MouseEvent e) {
                    
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                   
                }

                @Override
                public void mouseEntered(MouseEvent e) {
                    
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    
                }
            });
            */
                
            panel.add(textRenderer);
            panel.add(checkBox);
            return panel;
        }

        return super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row, hasFocus);
    }

    public Quest getQuest() {
        return quest;
    } 

}
