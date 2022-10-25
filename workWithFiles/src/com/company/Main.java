package com.company;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        String inputfile = "D:/JavaBSU/workWithFiles/input1.txt";
        File file = new File(inputfile);
        ArrayList<myFile> filesArr = new ArrayList<>();
        File fin1 = new File("input1.txt");
        Scanner myReader1 = new Scanner(fin1);
        int countOfBytesProb = 0;
        int countOfLines = 0;
        while (myReader1.hasNextLine()) {
            countOfBytesProb = Integer.parseInt(myReader1.nextLine());
            countOfLines++;
        }
        System.out.println("Пропускная способность = "+countOfBytesProb);
        myReader1.close();
        File fin2 = new File("input2.txt");
        Scanner myReader3 = new Scanner(fin2);
        String dataFile = "";
        while (myReader3.hasNextLine()){
            dataFile += myReader3.nextLine();
        }
        Scanner myReader2 = new Scanner(fin2);
        int countOfBytes;
        if (fin2.exists()) {
            countOfBytes = Integer.parseInt(getFileSizeBytes(fin2));
        } else {
            countOfBytes = 0;
            System.out.println("File doesn't exist");
        }
        myReader2.close();
        System.out.println("количество байтов, которое занимает файл = "+countOfBytes);
        int countOfFiles = (int) (getCountOfFiles(countOfBytes, countOfBytesProb));
        System.out.println("count of fies = " + countOfFiles);
        setFilesArr(filesArr, dataFile, countOfBytesProb);
        for(int i = 0; i < filesArr.size(); i++){
            System.out.println(filesArr.get(i));
        }
        for(int i = 0; i< filesArr.size(); i++)
        {
            try(FileWriter writer = new FileWriter(filesArr.get(i).getF_name() + filesArr.get(i).getF_type(), false))
            {
                // запись всей строки
                String text = filesArr.get(i).getF_text();
                writer.write(text);
                // запись по символам

            }
            catch(IOException ex){

                System.out.println(ex.getMessage());
            }
        }
    }
    private static String getFileSizeBytes(File file) {
        return file.length() + "";
    }
    private static double getCountOfFiles(int countOfBytes, int countOfBytesProb){
        int n = countOfBytes / countOfBytesProb + ((countOfBytes % countOfBytesProb == 0) ? 0 : 1);
        return n;
    }
    private static void setFilesArr(ArrayList<myFile> filesArr, String dataFile, int countOfBytesProb){
        char[] tmpArrChar = dataFile.toCharArray();
        int val = dataFile.length();
        for(int i = 0, j = 0; i < dataFile.length(); i++, j++){
            char[] tmpStr = new char[countOfBytesProb];
            int k = 0;
            while (k < countOfBytesProb && k < tmpArrChar.length && i < tmpArrChar.length){
                tmpStr[k] = tmpArrChar[i];
                i++;
                k++;
            }
            if(i == tmpArrChar.length){
                char[] endFileText = new char[k];
                for(int g = 0; g < k; g++){
                    endFileText[g] = tmpStr[g];
                }
                String currentStr = new String(endFileText);
                String nameFile = Integer.toString(j+1) + "input1";
                myFile tmpObj = new myFile(nameFile, ".txt", currentStr);
                filesArr.add(tmpObj);
            } else {
                String currentStr = new String(tmpStr);
                String nameFile = Integer.toString(j+1) + "#input1.txt";
                myFile tmpObj = new myFile(nameFile, ".txt", currentStr);
                filesArr.add(tmpObj);
                i--;
            }

        }
    }
}
