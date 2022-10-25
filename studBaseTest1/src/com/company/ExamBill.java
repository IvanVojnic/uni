package com.company;
import java.time.LocalDate;

import java.util.ArrayList;

public class ExamBill {
    ExamBill(String EB_lecturerFio, String EB_subName, int year, int month, int day, ArrayList<Integer> arrR, ArrayList<Integer> arrM){
        this.EB_lecturerFio = EB_lecturerFio;
        this.EB_subName = EB_subName;
        this.EB_date = LocalDate.of(year, month, day);
        this.EB_recordBookNums = arrR;
        this.EB_marks = arrM;
    }
    String EB_lecturerFio;
    String EB_subName;
    LocalDate EB_date;
    ArrayList<Integer> EB_recordBookNums = new ArrayList<Integer>();
    ArrayList<Integer> EB_marks = new ArrayList<Integer>();
}
