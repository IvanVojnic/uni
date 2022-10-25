package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try {
            File myObj = new File("exam.txt");
            Scanner myReader = new Scanner(myObj);
            ArrayList<Exam> exList = new ArrayList<>();
            while (myReader.hasNextLine()) {
                System.out.println(myReader.nextLine());
            }
            myReader.close();
            myReader = new Scanner(myObj);

            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter count of words to delete: ");
            int wordCount = scanner.nextInt();
            //TextTreatment(data, wordCount);
        }
        catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
	Exam maths = new Exam("Maths", "Lomonosov", 34, "04.01.2022", 8);
    Record mathsR = new Record(maths, true);
    ArrayList<Exam> exList = new ArrayList<>();
    exList.add(maths);
    ArrayList<Record> recList = new ArrayList<>();
    recList.add(mathsR);
    Session session1 = new Session(exList, recList);
    ArrayList<Session> sessionsList = new ArrayList<>();
    sessionsList.add(session1);
    RecordBook recBookStud1 = new RecordBook(2019, 202331, sessionsList);
    Student man1 = new Student("Petrov", recBookStud1);
    }
}
