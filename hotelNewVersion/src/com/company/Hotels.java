package com.company;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.io.File;
import java.util.ArrayList;
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Collections;
import java.util.Scanner; // Import the Scanner class to read text files

public class Hotels implements Comparable<Hotels>, ActionListener{
    private JTextArea ta;
    String CityName;
    String HotelName;
    int StarsCount;
    String GetCityName(){
        return this.CityName;
    }
    int GetStarsCount(){
        return this.StarsCount;
    }
    String GetHotelInfo(){
         String infoStr = "in " + this.CityName + ", Hotel name - " + this.HotelName + ". stars count - " + this.StarsCount;
         return infoStr;
    }
    Hotels(String CityName, String HotelName, String StarsCount){
        this.CityName = CityName;
        this.HotelName = HotelName;
        try {
            this.StarsCount = Integer.valueOf(StarsCount);
        }catch (NumberFormatException e) {
            System.err.println("Неправильный формат строки!");
        }
    }
    void print(){
        System.out.println("City name - " + this.CityName + ". Hotel name - " + this.HotelName + ". stars count - " + this.StarsCount);
    }
    @Override
    public int compareTo(Hotels o) {
        if(this.CityName.compareTo(o.GetCityName()) == 0){
            if(this.StarsCount < o.GetStarsCount()){
                return -1;
            }
            else {
                return 1;
            }
        }
        else {
            return this.CityName.compareTo(o.GetCityName());
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ta.append(CityName + HotelName + StarsCount +"\n");
    }
}
