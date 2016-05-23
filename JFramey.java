package CustVars;
import java.awt.Cursor;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JPanel;
import java.awt.event.*;
public class JFramey {
    public JFramey(){
        frame = new JFrame();
        frame.setUndecorated(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        cont = frame.getContentPane();
        cont.setBackground(Color.red);
        cont.setLayout(null);
        cont.addMouseListener(new MouseAdapter(){
            public void mousePressed(MouseEvent x){
                mouseX = x.getX();
                mouseY = x.getY();
            }
        });
        cont.addMouseMotionListener(new MouseAdapter(){
            public void mouseDragged(MouseEvent x){
                frame.setLocation(x.getXOnScreen()-mouseX,x.getYOnScreen()-mouseY);
            }
        });
        panel = new JPanel();
        panel.setBackground(Color.lightGray);
        panel.setLayout(null);
        panel.addMouseMotionListener(new MouseAdapter(){});
        minim = new JLabel("_");
        minim.setSize(15,20);
        minim.setHorizontalAlignment(0);
        minim.setForeground(Color.red.darker().darker());
        minim.addMouseListener(new MouseAdapter(){
            public void mousePressed(MouseEvent x){
                frame.setState(JFrame.ICONIFIED);
            }
        });
        ex = new JLabel("X");
        ex.setSize(15,20);
        ex.setHorizontalAlignment(0);
        ex.setForeground(Color.red.darker().darker());
        ex.addMouseListener(new MouseAdapter(){
            public void mousePressed(MouseEvent x){
                frame.dispose();
            }
        });
        cont.add(panel);
        cont.add(ex);
        cont.add(minim);
        for(int i = 0;i<resizeHandles.length;i++)
            resizeHandles[i] = new JLabel();
    }
    public JFramey(String title){
        frame = new JFrame(title);
        frame.setUndecorated(true);
        cont = frame.getContentPane();
        cont.setBackground(Color.red);
        cont.setLayout(null);
        cont.addMouseListener(new MouseAdapter(){
            public void mousePressed(MouseEvent x){
                mouseX = x.getX();
                mouseY = x.getY();
            }
        });
        cont.addMouseMotionListener(new MouseAdapter(){
            public void mouseDragged(MouseEvent x){
                frame.setLocation(x.getXOnScreen()-mouseX,x.getYOnScreen()-mouseY);
            }
        });
        panel = new JPanel();
        panel.setBackground(Color.lightGray);
        panel.setLayout(null);
        panel.addMouseMotionListener(new MouseAdapter(){});
        minim = new JLabel("_");
        minim.setSize(15,20);
        minim.setHorizontalAlignment(0);
        minim.setForeground(Color.red.darker().darker());
        minim.addMouseListener(new MouseAdapter(){
            public void mousePressed(MouseEvent x){
                frame.setState(JFrame.ICONIFIED);
            }
        });
        ex = new JLabel("X");
        ex.setSize(15,20);
        ex.setHorizontalAlignment(0);
        ex.setForeground(Color.red.darker().darker());
        ex.addMouseListener(new MouseAdapter(){
            public void mousePressed(MouseEvent x){
                frame.dispose();
            }
        });
        cont.add(panel);
        cont.add(ex);
        cont.add(minim);
        for(int i = 0;i<resizeHandles.length;i++)
            resizeHandles[i] = new JLabel();
    }
    public void setTitle(String title){
        frame.setTitle(title);
    }
    public String getTitle(){
        return frame.getTitle();
    }
    public void add(Component toAdd){
        toAdd.setBackground(Color.lightGray);
        panel.add(toAdd);
    }
    public void addExitListener(final ActionListener action){
        ex.addMouseListener(new MouseAdapter(){
            public void mousePressed(MouseEvent e){
                action.actionPerformed(null);
            }
        });
    }
    public Component sAdd(Component toAdd){
        return panel.add(toAdd);
    }
    public void setSize(int width,int height){
        frame.setSize(width+6,height+26);
        frame.setLocationRelativeTo(null);
        panel.setSize(width,height);
        panel.setLocation(3,23);
        ex.setLocation(width-18,3);
        minim.setLocation(width-36,3);
        resizeHandles[0].setSize(5,5);
        resizeHandles[1].setSize(width,5);
        resizeHandles[2].setSize(5,5);
        resizeHandles[3].setSize(5,height+20);
        resizeHandles[4].setSize(5,5);
        resizeHandles[5].setSize(width,5);
        resizeHandles[6].setSize(5,5);
        resizeHandles[7].setSize(5,height+20);
    }
    public Dimension getSize(){
        return panel.getSize();
    }
    public void setBackColor(Color color){
        cont.setBackground(color);
        minim.setForeground(color.darker().darker());
        ex.setForeground(color.darker().darker());
    }
    public void setBackColor(Color backColor,Color textColor){
        cont.setBackground(backColor);
        minim.setForeground(textColor);
        ex.setForeground(textColor);
    }
    public void setForeColor(Color color){
        panel.setBackground(color);
    }
    public Color getBackColor(){
        return cont.getBackground();
    }
    public Color getForeColor(){
        return panel.getBackground();
    }
    public void activate(){
        frame.setVisible(true);
    }
    public void hide(){
        frame.setVisible(false);
    }
    public void setResizable(){
        sharedAction = new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent x){
                mousePos[0]=x.getXOnScreen();
                mousePos[1]=x.getYOnScreen();
                if(compNum != panel.getComponentCount()){
                    compNum = panel.getComponentCount();
                    widthRatio = new double[compNum];
                    fontRatio = new double[compNum];
                    heightRatio = new double[compNum];
                    xRatio = new double[compNum];
                    yRatio = new double[compNum];
                    for(int i = 0;i<compNum;i++){
                        widthRatio[i]=((double)panel.getComponents()[i].getSize().width)/((double)panel.getWidth());
                        heightRatio[i]=((double)panel.getComponents()[i].getSize().height)/((double)panel.getHeight());
                        xRatio[i]=((double)panel.getComponents()[i].getX())/((double)panel.getWidth());
                        yRatio[i]=((double)panel.getComponents()[i].getY())/((double)panel.getHeight());
                        fontRatio[i]=((double)panel.getComponents()[i].getFont().getSize())/((double)panel.getComponents()[i].getHeight());
                    }
                }
            }
            @Override
            public void mouseDragged(MouseEvent x){
                panel.setSize(frame.getWidth()-6,frame.getHeight()-26);
                ex.setLocation(panel.getWidth() -18,3);
                minim.setLocation(panel.getWidth()-36,3);
                for(int i = 0;i<compNum;i++){
                    panel.getComponents()[i].setSize((int)(panel.getWidth()*widthRatio[i]),(int)(panel.getHeight()*heightRatio[i]));
                    panel.getComponents()[i].setLocation((int)(panel.getWidth()*xRatio[i]),(int)(panel.getHeight()*yRatio[i]));
                    panel.getComponents()[i].setFont(panel.getComponents()[i].getFont().deriveFont((float)(panel.getComponents()[i].getHeight()*fontRatio[i])));
                }
                resizeHandles[1].setSize(panel.getWidth(),5);
                resizeHandles[3].setSize(5,panel.getHeight()+20);
                resizeHandles[5].setSize(panel.getWidth(),5);
                resizeHandles[7].setSize(5,panel.getHeight()+20);
                resizeHandles[6].setLocation(-2,frame.getHeight()-3);
                resizeHandles[5].setLocation(3,frame.getHeight()-3);
                resizeHandles[4].setLocation(frame.getWidth()-3,frame.getHeight()-3);
                resizeHandles[3].setLocation(frame.getWidth()-3,3);
                resizeHandles[2].setLocation(frame.getWidth()-3,-2);
            }
        };
        resizeActions[0] = new MouseAdapter(){
            public void mouseDragged(MouseEvent x){
                dif[0] = mousePos[0]-x.getXOnScreen();
                dif[1] = mousePos[1]-x.getYOnScreen();
                if((frame.getSize().width+dif[0]>=55)&&(frame.getSize().height+dif[1]>=30)){
                    frame.setSize(frame.getSize().width+dif[0],frame.getSize().height+dif[1]);
                    frame.setLocation(frame.getLocationOnScreen().x-dif[0],frame.getLocationOnScreen().y-dif[1]);
                    mousePos[0]=x.getXOnScreen();
                    mousePos[1]=x.getYOnScreen();
                    sharedAction.mouseDragged(x);
                }else if(frame.getSize().width+dif[0]>=55){
                    frame.setSize(frame.getSize().width+dif[0],frame.getSize().height);
                    frame.setLocation(frame.getLocationOnScreen().x-dif[0],frame.getLocationOnScreen().y);
                    mousePos[0]=x.getXOnScreen();
                    sharedAction.mouseDragged(x);
                }else if(frame.getSize().height+dif[1]>=30){
                    frame.setSize(frame.getSize().width,frame.getSize().height+dif[1]);
                    frame.setLocation(frame.getLocationOnScreen().x,frame.getLocationOnScreen().y-dif[1]);
                    mousePos[1]=x.getYOnScreen();
                    sharedAction.mouseDragged(x);
                }
            }
        };
        resizeActions[1] = new MouseAdapter(){
            public void mouseDragged(MouseEvent x){
                dif[1] = mousePos[1]-x.getYOnScreen();
                if(frame.getSize().height+dif[1]>=30){
                    frame.setSize(frame.getSize().width,frame.getSize().height+dif[1]);
                    frame.setLocation(frame.getLocationOnScreen().x,frame.getLocationOnScreen().y-dif[1]);
                    mousePos[1]=x.getYOnScreen();
                    sharedAction.mouseDragged(x);
                }
            }
        };
        resizeActions[2] = new MouseAdapter(){
            public void mouseDragged(MouseEvent x){
                dif[0] = mousePos[0]-x.getXOnScreen();
                dif[1] = mousePos[1]-x.getYOnScreen();
                if((frame.getSize().width-dif[0]>=55)&&(frame.getSize().height+dif[1]>=30)){
                    frame.setSize(frame.getSize().width-dif[0],frame.getSize().height+dif[1]);
                    frame.setLocation(frame.getLocationOnScreen().x,frame.getLocationOnScreen().y-dif[1]);
                    mousePos[0]=x.getXOnScreen();
                    mousePos[1]=x.getYOnScreen();
                    sharedAction.mouseDragged(x);
                }else if(frame.getSize().width-dif[0]>=55){
                    frame.setSize(frame.getSize().width-dif[0],frame.getSize().height);
                    mousePos[0]=x.getXOnScreen();
                    sharedAction.mouseDragged(x);
                }else if(frame.getSize().height+dif[1]>=30){
                    frame.setSize(frame.getSize().width,frame.getSize().height+dif[1]);
                    frame.setLocation(frame.getLocationOnScreen().x,frame.getLocationOnScreen().y-dif[1]);
                    mousePos[1]=x.getYOnScreen();
                    sharedAction.mouseDragged(x);
                }
            }
        };
        resizeActions[3] = new MouseAdapter(){
            public void mouseDragged(MouseEvent x){
                dif[0] = mousePos[0]-x.getXOnScreen();
                if(frame.getSize().width-dif[0]>=55){
                    frame.setSize(frame.getSize().width-dif[0],frame.getSize().height);
                    mousePos[0]=x.getXOnScreen();
                    sharedAction.mouseDragged(x);
                }
            }
        };
        resizeActions[4] = new MouseAdapter(){
            public void mouseDragged(MouseEvent x){
                dif[0] = mousePos[0]-x.getXOnScreen();
                dif[1] = mousePos[1]-x.getYOnScreen();
                if((frame.getSize().width-dif[0]>=55)&&(frame.getSize().height-dif[1]>=30)){
                    frame.setSize(frame.getSize().width-dif[0],frame.getSize().height-dif[1]);
                    mousePos[0]=x.getXOnScreen();
                    mousePos[1]=x.getYOnScreen();
                    sharedAction.mouseDragged(x);
                }else if(frame.getSize().width-dif[0]>=55){
                    frame.setSize(frame.getSize().width-dif[0],frame.getSize().height);
                    mousePos[0]=x.getXOnScreen();
                    sharedAction.mouseDragged(x);
                }else if(frame.getSize().height-dif[1]>=30){
                    frame.setSize(frame.getSize().width,frame.getSize().height-dif[1]);
                    mousePos[1]=x.getYOnScreen();
                    sharedAction.mouseDragged(x);
                }
            }
        };
        resizeActions[5] = new MouseAdapter(){
            public void mouseDragged(MouseEvent x){
                dif[1] = mousePos[1]-x.getYOnScreen();
                if(frame.getSize().height-dif[1]>=30){
                    frame.setSize(frame.getSize().width,frame.getSize().height-dif[1]);
                    mousePos[1]=x.getYOnScreen();
                    sharedAction.mouseDragged(x);
                }
            }
        };
        resizeActions[6] = new MouseAdapter(){
            public void mouseDragged(MouseEvent x){
                dif[0] = mousePos[0]-x.getXOnScreen();
                dif[1] = mousePos[1]-x.getYOnScreen();
                if((frame.getSize().width+dif[0]>=55)&&(frame.getSize().height-dif[1]>=30)){
                    frame.setSize(frame.getSize().width+dif[0],frame.getSize().height-dif[1]);
                    frame.setLocation(frame.getLocationOnScreen().x-dif[0],frame.getLocationOnScreen().y);
                    mousePos[0]=x.getXOnScreen();
                    mousePos[1]=x.getYOnScreen();
                    sharedAction.mouseDragged(x);
                }else if(frame.getSize().width+dif[0]>=55){
                    frame.setSize(frame.getSize().width+dif[0],frame.getSize().height);
                    frame.setLocation(frame.getLocationOnScreen().x-dif[0],frame.getLocationOnScreen().y);
                    mousePos[0]=x.getXOnScreen();
                    sharedAction.mouseDragged(x);
                }else if(frame.getSize().height-dif[1]>=30){
                    frame.setSize(frame.getSize().width,frame.getSize().height-dif[1]);
                    mousePos[1]=x.getYOnScreen();
                    sharedAction.mouseDragged(x);
                }
            }
        };
        resizeActions[7] = new MouseAdapter(){
            public void mouseDragged(MouseEvent x){
                dif[0] = mousePos[0]-x.getXOnScreen();
                if(frame.getSize().width+dif[0]>=55){
                    frame.setSize(frame.getSize().width+dif[0],frame.getSize().height);
                    frame.setLocation(frame.getLocationOnScreen().x-dif[0],frame.getLocationOnScreen().y);
                    mousePos[0]=x.getXOnScreen();
                    sharedAction.mouseDragged(x);
                }
            }
        };
        resizeHandles[0].setLocation(-2,-2);
        resizeHandles[0].setCursor(Cursor.getPredefinedCursor(Cursor.NW_RESIZE_CURSOR));
        resizeHandles[1].setLocation(3,-2);
        resizeHandles[1].setCursor(Cursor.getPredefinedCursor(Cursor.N_RESIZE_CURSOR));
        resizeHandles[2].setLocation(frame.getWidth()-3,-2);
        resizeHandles[2].setCursor(Cursor.getPredefinedCursor(Cursor.NE_RESIZE_CURSOR));
        resizeHandles[3].setLocation(frame.getWidth()-3,3);
        resizeHandles[3].setCursor(Cursor.getPredefinedCursor(Cursor.E_RESIZE_CURSOR));
        resizeHandles[4].setLocation(frame.getWidth()-3,frame.getHeight()-3);
        resizeHandles[4].setCursor(Cursor.getPredefinedCursor(Cursor.SE_RESIZE_CURSOR));
        resizeHandles[5].setLocation(3,frame.getHeight()-3);
        resizeHandles[5].setCursor(Cursor.getPredefinedCursor(Cursor.S_RESIZE_CURSOR));
        resizeHandles[6].setLocation(-2,frame.getHeight()-3);
        resizeHandles[6].setCursor(Cursor.getPredefinedCursor(Cursor.SW_RESIZE_CURSOR));
        resizeHandles[7].setLocation(-2,3);
        resizeHandles[7].setCursor(Cursor.getPredefinedCursor(Cursor.W_RESIZE_CURSOR));
        for(int i = 0;i<resizeHandles.length;i++){
            cont.add(resizeHandles[i]);
            resizeHandles[i].addMouseListener(sharedAction);
            resizeHandles[i].addMouseMotionListener(resizeActions[i]);
        }
    }
    public void deactivate(){
        frame.dispose();
    }
    public JFrame getFrame(){
        return frame;
    }
    public JPanel getPanel(){
        return panel;
    }
    //<editor-fold desc="Variables">
    public JFrame frame;
    public Container cont;
    public JLabel minim,ex;
    public JPanel panel;
    public int mouseX,mouseY;
    //Resizing Vars
    private final int[] dif = new int[2];
    private final int[] mousePos = new int[2];
    private final JLabel[] resizeHandles = new JLabel[8];
    private final MouseAdapter[] resizeActions = new MouseAdapter[8];
    private int compNum = 0;
    private MouseAdapter sharedAction;
    private double[] widthRatio;
    private double[] heightRatio;
    private double[] xRatio;
    private double[] yRatio;
    private double[] fontRatio;
    //</editor-fold>
}
