package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Point2D;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.awt.Container;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JFrame;

public class MainFrame extends JFrame {
    public MainFrame() throws HeadlessException {
        super();
        setSize(WIDTH, HEIGHT);
        setLocation((int)(Toolkit.getDefaultToolkit().getScreenSize().width/2 - WIDTH/2),
                (int)(Toolkit.getDefaultToolkit().getScreenSize().height/2 - HEIGHT/2));
        setTitle("Test frame");
        Scanner in = new Scanner(System.in);
        System.out.print("Input num of oval: ");
        numOval = in.nextInt();
        File myObj = new File("notes1.txt");
        Scanner myReader = null;
        try {
            myReader = new Scanner(myObj);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (myReader.hasNextLine()) {
            strArr.add(myReader.nextLine());
        }
        myReader.close();
        Container content = getContentPane();
        TestPanel tp = new TestPanel(list, this);
        content.add(tp);
    }
    public int GetNumOval(){
        return numOval;
    }
    public ArrayList<String> GetList(){
        return strArr;
    }
    public void addPoint(Point2D p) {
        list.add(p);
        //System.out.println(p.getX() + " " + p.getY());
    }
    private ArrayList<String> strArr = new ArrayList<>();
    private int numOval;
    private final int WIDTH = 500;
    private final int HEIGHT = 500;
    private ArrayList list = new ArrayList();
}