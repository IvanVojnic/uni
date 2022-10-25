package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {
        try {
            File myObj = new File("notes1.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                System.out.println(myReader.nextLine());
            }
            myReader.close();
            myReader = new Scanner(myObj);

            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter count of words to delete: ");
            int wordCount = scanner.nextInt();
            TextTreatment(data, wordCount);
        }
        catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    private static void TextTreatment(String str, int wordCount) {
        StringTokenizer st = new StringTokenizer(str," ");
        StringTokenizer ins = new StringTokenizer(str, " ");
        int cnt = 0;
        while (ins.hasMoreTokens()) {
            String word = ins.nextToken();
            cnt++; }
        if(wordCount > cnt){
            System.out.println("Current string has less words then you enter");
            return;
        }
        if(wordCount == cnt){
            str = "";
            System.out.println(str);
            return;
        }
        for(int i = 0 ; i < wordCount; i++)
        {
            String word = st.nextToken();
            str = str.substring(word.length()+1, str.length());
        }
        System.out.println(str);
    }
}


/**/