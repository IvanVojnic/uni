package com.company;

import java.util.ArrayList;

public class Session {
    Session(ArrayList<Exam> eL, ArrayList<Record> rL){
        this.examsList = eL;
        this.recordsList = rL;
    }
    private ArrayList<Exam> examsList = new ArrayList<>();
    private ArrayList<Record> recordsList = new ArrayList<>();
}
