package com.company;
import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;

class MyNote extends JFrame{
    MyNote(String title){
        super(title);
        Container c = getContentPane();
        c.setLayout (new FlowLayout(FlowLayout.CENTER));
        JTextField cityNameF = new JTextField("Вводите название города");
        c.add(cityNameF);
        JTextField hotelNameF = new JTextField("Вводите название отеля");
        c.add(hotelNameF);
        JTextField starsCountF = new JTextField("5");
        c.add(starsCountF);

        JTextArea ta =new JTextArea();
        ta.setEditable(false);
        c.add(ta);
        JPanel p = new JPanel();
        c.add(p,FlowLayout.LEFT);

        JButton b = new JButton("Перенести");
        JButton getHotelInfo = new JButton ("get hotel info");
        p.add(getHotelInfo, FlowLayout.LEFT);
        p.add(b, FlowLayout.LEFT);


        Hotels a = new Hotels(cityNameF.getText(),hotelNameF.getText(), starsCountF.getText());
        b.addActionListener(a);
        getHotelInfo.addActionListener(new TextMove(a.GetHotelInfo(), ta));

        // getHotelInfo.addActionListener(new );
        setSize(300,200);
        setVisible(true);
    }
    public static void main(String[] args) {
        JFrame f = new MyNote("Обработка ActionEvent");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
