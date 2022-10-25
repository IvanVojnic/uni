package com.company;
import java.io.*;
import java.math.BigDecimal;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        try {
            File myObj = new File("input.txt");
            Scanner myReader = new Scanner(myObj);
            String data = "";
            while (myReader.hasNextLine()) {
                data += myReader.nextLine();
            }
            myReader.close();
            wordTreatment(data);
        } catch (FileNotFoundException e) {
        }
    }
    private static void wordTreatment(String str) throws IOException {
        StringTokenizer st = new StringTokenizer(str, " /n/,/;");
        BigDecimal summ = new BigDecimal(0);
        while(st.hasMoreTokens()) {
            String word = st.nextToken();
            if(isDigitDouble(word)){
                BigDecimal tmp = new BigDecimal(Double.parseDouble(word));
                //summ.;
            }
        }
        FileWriter output = new FileWriter("output.txt");
        PrintWriter out = new PrintWriter(output);
        if(summ.equals(0)){
            out.print(summ);
            out.close();
        }
        else{
            out.print(0);
            out.close();
        }
    }
    private static boolean isDigitDouble(String s) throws NumberFormatException {
        try {
            Double.parseDouble(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}