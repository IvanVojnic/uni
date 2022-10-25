package com.company;

import java.time.LocalDate;

public class Position {
    Position(String P_project_id, String P_pos_id, String P_openDate){
        this.P_pos_id = Integer.parseInt(P_pos_id);
        this.P_project_id = Integer.parseInt(P_project_id);
        int[] valDates = new int[3];
        String[] dateStr;
        String delimiter = "\\.";
        dateStr = P_openDate.split(delimiter);
        valDates[0] = Integer.parseInt(dateStr[0]);
        valDates[1] = Integer.parseInt(dateStr[1]);
        valDates[2] = Integer.parseInt(dateStr[2]);
        this.P_openDate = LocalDate.of(valDates[2],valDates[1],valDates[0]);
    }

    public int getPE_pos_id(){
        return this.P_pos_id;
    }
    public int getPE_project_id(){
        return this.P_project_id;
    }

    public void setOpenDate(String openDate){
        int[] valDates = new int[3];
        String[] dateStr;
        String delimiter = "\\.";
        dateStr = openDate.split(delimiter);
        valDates[0] = Integer.parseInt(dateStr[0]);
        valDates[1] = Integer.parseInt(dateStr[1]);
        valDates[2] = Integer.parseInt(dateStr[2]);
        this.P_openDate = LocalDate.of(valDates[2],valDates[1],valDates[0]);
    }
    public LocalDate getP_openDate(){
        return this.P_openDate;
    }
    private int P_pos_id;
    private int P_project_id;
    private LocalDate P_openDate;
}
