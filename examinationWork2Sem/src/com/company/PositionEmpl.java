package com.company;

import java.time.LocalDate;

public class PositionEmpl {
    PositionEmpl(String PE_pos_id, String PE_project_id, String PE_empl_id,  String PE_workload, String PE_billyAble){
        this.PE_empl_id = Integer.parseInt(PE_empl_id);
        this.PE_pos_id = Integer.parseInt(PE_pos_id);
        this.PE_project_id = Integer.parseInt(PE_project_id);
        this.PE_workload = Integer.parseInt(PE_workload);
        this.PE_billyAble = PE_billyAble;

    }

    public int getPE_pos_id(){
        return this.PE_pos_id;
    }
    public int getPE_project_id(){
        return this.PE_project_id;
    }
    public int getPE_empl_id(){
        return this.PE_empl_id;
    }
    public int getPE_workload(){
        return this.PE_workload;
    }

    public void setOpenDate(String openDate){
        int[] valDates = new int[3];
        String[] dateStr;
        String delimiter = "\\.";
        dateStr = openDate.split(delimiter);
        valDates[0] = Integer.parseInt(dateStr[0]);
        valDates[1] = Integer.parseInt(dateStr[1]);
        valDates[2] = Integer.parseInt(dateStr[2]);
        this.PE_openDate = LocalDate.of(valDates[2],valDates[1],valDates[0]);
    }


    private int PE_pos_id;
    private int PE_project_id;
    private int PE_empl_id;
    private int PE_workload;
    private String PE_billyAble;
    private LocalDate PE_openDate;
}
