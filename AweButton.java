package CustVars;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
public class AweButton {
    public AweButton(){
        label = new JLabel();
        label.setHorizontalAlignment(0);
        label.setBorder(BorderFactory.createLineBorder(Color.black));
        label.setOpaque(true);
        label.addMouseListener(new MouseAdapter(){
            public void mousePressed(MouseEvent x){
                if(x.getButton()==1)
                    label.setBackground(label.getBackground().darker());
            }
            public void mouseReleased(MouseEvent x){
                if(x.getButton()==1)
                    label.setBackground(label.getBackground().brighter());
            }
        });
    }
    public AweButton(String text){
        label = new JLabel(text);
        label.setHorizontalAlignment(0);
        label.setBorder(BorderFactory.createLineBorder(Color.black));
        label.setOpaque(true);
        label.addMouseListener(new MouseAdapter(){
            public void mousePressed(MouseEvent x){
                if(x.getButton()==1)
                    label.setBackground(label.getBackground().darker());
            }
            public void mouseReleased(MouseEvent x){
                if(x.getButton()==1)
                    label.setBackground(label.getBackground().brighter());
            }
        });
    }
    public void addAction(final ActionListener action){
        added.add(action);
        label.addMouseListener(new MouseAdapter(){
            public void mouseReleased(MouseEvent x){
                if(x.getButton()==1)
                    action.actionPerformed(null);
            }
        });
    }
    public void removeAction(final ActionListener action){
        if(added.contains(action)){
            added.remove(action);
            label.removeMouseListener(new MouseAdapter(){
                public void mouseReleased(MouseEvent x){
                    action.actionPerformed(null);
                }
            });
        }
    }
    public void setTextColor(Color color){
        label.setForeground(color);
    }
    public void setBorderColor(Color color){
        label.setBorder(BorderFactory.createLineBorder(color));
    }
    public void setLocation(int x,int y){
        label.setLocation(x,y);
    }
    public void setSize(int width,int height){
        label.setSize(width,height);
    }
    public void setText(String text){
        label.setText(text);
    }
    public JLabel getJLabel(){
        return label;
    }
    //<editor-fold desc="Variables">
    private final JLabel label;
    private ArrayList<ActionListener> added = new ArrayList<>();
    //</editor-fold>
}
