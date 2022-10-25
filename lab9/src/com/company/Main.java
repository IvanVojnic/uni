package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        try {
            File myObj = new File("notes1.txt");
            Scanner myReader = new Scanner(myObj);
            String data = "";
            while (myReader.hasNextLine()) {
                data += myReader.nextLine();
            }
            myReader.close();
            TextTreatment(data);
        }
        catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    private static void TextTreatment(String str) {
        Pattern pattern = Pattern.compile("\\([^)]*\\)");
        Matcher matcher = pattern.matcher(str);
        while(matcher.find()){
            int start=matcher.start();
            int end=matcher.end();
            System.out.println("Найдено совпадение " + str.substring(start,end) + " с "+ start + " по " + (end-1) + " позицию");
        }
        System.out.println(matcher.replaceAll(""));
    }
}
