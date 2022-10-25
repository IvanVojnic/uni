package com.company;

import java.util.ArrayList;

public class myTeg {
    myTeg(String text){
        int i =0;
        while(text.charAt(i) != '['){
            i++;
        }
        i++;
        StringBuffer tmp1 = new StringBuffer();
        while(text.charAt(i) != ']'){
            tmp1.append(text.charAt(i));
            i++;
        }
        i++;
        int num = Integer.parseInt(String.valueOf(tmp1));
        this.Number = num;
        StringBuffer tmp2 = new StringBuffer();
        while (i < text.length()){
            tmp2.append(text.charAt(i));
            i++;
        }
        i++;
        this.textTag = String.valueOf(tmp2);
        this.emplayced = false;
    }
    void SetEmplayced(){
        this.emplayced = true;
    }
    int getNumber(){
        return this.Number;
    }
    String getTextTag(){
        return this.textTag;
    }
    boolean getEmplaysed(){
        return this.emplayced;
    }
    private int Number;
    private String textTag;
    private boolean emplayced;
}
