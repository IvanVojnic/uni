package com.company;

import java.util.ArrayList;

public class RecordBook {
    RecordBook(int RB_year, int RB_number, ArrayList<Session> RB_sessionsList){
        this.RB_year = RB_year;
        this.RB_number = RB_number;
        this.RB_sessionsList = RB_sessionsList;
    }
    int GetRB_number(){
        return  this.RB_number;
    }
    private ArrayList<Session> RB_sessionsList = new ArrayList<>();
    private int RB_year;
    private int RB_number;
}
