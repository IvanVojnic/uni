package com.company;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import javax.swing.JPanel;

import javax.swing.JPanel;
public class TestPanel extends JPanel {
    public TestPanel(ArrayList aList, MainFrame frame) {
        super();
        list = aList;
        this.frame = frame;
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        double R = (getWidth() + getHeight())/8;
        int tmp = frame.GetNumOval();
        for(int i = 0; i < tmp; i++){
            g.drawOval((int)((getWidth()/2)+(R*Math.cos(i*Math.PI*2/tmp))),(int)((getHeight()/2)+(R*Math.sin(i * Math.PI * 2 /tmp))),25,25);
            g.drawString(frame.GetList().get(i),(int)((getWidth()/2)+(R*Math.cos(i*Math.PI*2/tmp))) , (int)((getHeight()/2)+(R*Math.sin(i * Math.PI * 2 /tmp))));
        }
        g.drawLine((int)((getWidth()/2)+(R*Math.cos(1*Math.PI*2/tmp))),(int)((getHeight()/2)+(R*Math.sin(1 * Math.PI * 2 /tmp))) ,(int)((getWidth()/2)+(R*Math.cos(2*Math.PI*2/tmp))),(int)((getHeight()/2)+(R*Math.sin(2 * Math.PI * 2 /tmp))));
        g.drawLine((int)((getWidth()/2)+(R*Math.cos(4*Math.PI*2/tmp))),(int)((getHeight()/2)+(R*Math.sin(4 * Math.PI * 2 /tmp))),(int)((getWidth()/2)+(R*Math.cos(5*Math.PI*2/tmp))),(int)((getHeight()/2)+(R*Math.sin(5 * Math.PI * 2 /tmp))));
    }

    private ArrayList list;
    private MainFrame frame;
}
