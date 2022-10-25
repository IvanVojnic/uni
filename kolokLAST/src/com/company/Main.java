package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;



public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        String infile = "input2.txt";
        ArrayList<myTeg> tegs = new ArrayList<>();
        File fin1 = new File(infile);
        Scanner myReader1 = new Scanner(fin1);
        while (myReader1.hasNextLine()) {
            myTeg tmp = new myTeg(myReader1.nextLine());
            tegs.add(tmp);
        }
        myReader1.close();
        StringBuffer myText = new StringBuffer();
        String infile2 = "input1.txt";
        File fin2 = new File(infile2);
        Scanner myReader2 = new Scanner(fin2);
        while (myReader2.hasNextLine()) {
            myText.append(myReader2.nextLine());
        }
        myReader2.close();
        String newText = changeStr(String.valueOf(myText), tegs);
        try{
            File fin3 = new File("output1.txt");
            FileWriter myWriter = new FileWriter(fin3);
            for(int i = 0; i < newText.length(); i++){
                myWriter.write(newText.charAt(i));
            }
            myWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try{
            File fin4 = new File("output2.txt");
            FileWriter myWriter = new FileWriter(fin4);
            for(int i = 0; i < tegs.size(); i++){
                if(tegs.get(i).getEmplaysed() == false){
                    int tmpNum = tegs.get(i).getNumber();
                    String str = Integer.toString(tmpNum);
                    myWriter.write('[');
                    for(int j = 0; j < str.length(); j++){
                        myWriter.write(str.charAt(j));
                    }
                    myWriter.write(']');
                    String text = tegs.get(i).getTextTag();
                    for(int j = 0; j < text.length(); j++){
                        myWriter.write(text.charAt(j));
                    }
                    myWriter.write('\n');
                }
                if(i < tegs.size()){
                    myWriter.write('\n');
                }
            }
            myWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try{
            File fin5 = new File("output3.txt");
            FileWriter myWriter = new FileWriter(fin5);
            ArrayList<Integer> arr= new ArrayList<Integer>();
            for(int i = 0; i < tegs.size(); i++){
                int tmp = tegs.get(i).getNumber();
                arr.add(tmp);
            }
            Collections.sort(arr);
            Collections.reverse(arr);
            for(int i = 0; i < arr.size(); i++){
                String str = Integer.toString(arr.get(i));
                for(int j = 0; j < str.length(); j++){
                    myWriter.write(str.charAt(j));
                }
                if(i < arr.size()){
                    myWriter.write('\n');
                }
            }
            myWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static String changeStr(String text, ArrayList<myTeg> tegs){
        StringBuffer newStr = new StringBuffer();
        int i = 0;
        while(i < text.length()) {
            while (i < text.length() && text.charAt(i) != '[') {
                newStr.append(text.charAt(i));
                i++;
            }
            if(i == text.length()){
                break;
            }
            i++;
            StringBuffer tmp1 = new StringBuffer();
            while (text.charAt(i) != ']') {
                tmp1.append(text.charAt(i));
                i++;
            }
            i++;
            int num = Integer.parseInt(String.valueOf(tmp1));
            for (int j = 0; j < tegs.size(); j++) {
                if (tegs.get(j).getNumber() == num) {
                    newStr.append(tegs.get(j).getTextTag());
                    tegs.get(j).SetEmplayced();
                }
            }
        }
        return String.valueOf(newStr);

    }
}
