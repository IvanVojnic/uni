package com.company;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;

import javax.swing.JPanel;

public class TestPanel extends JPanel {
    public TestPanel(ArrayList aList, Main frame) {
        super();
        list = aList;
        addMouseListener(new MyMouseClick(frame));
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawString("Hello, World!", 100, 100);
        Graphics2D g2 = (Graphics2D)g;
        for(int i=0; i<list.size(); i++) {
            g2.setColor(Color.BLUE);
            int x = (int)((Point2D)(list.get(i))).getX();
            int y = (int)((Point2D)(list.get(i))).getY();
            g.drawRect(x-1, y-1, 3, 3);
        }
    }

    private ArrayList list;
    private MainFrame frame;
}
