package com.company;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class TextMove implements ActionListener{
    private JTextField tf;
    private JTextArea ta;
    private String info;
    TextMove(String info, JTextArea ta){
        this.info = info; this.ta=ta;
        ShowInfoHotelPerformed(this.ta, this.info);
    }
    public void actionPerformed(ActionEvent ae){
        ta.append(tf.getText()+"\n");
    }
    public void ShowInfoHotelPerformed(JTextArea ta, String info){
        ta.append(info);
    }

}
