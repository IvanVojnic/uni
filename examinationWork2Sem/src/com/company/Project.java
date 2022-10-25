package com.company;

public class Project {
    Project(String P_id, String P_name){
        this.P_id = Integer.parseInt(P_id);
        this.P_name = P_name;
    }


    public int getP_id(){
        return this.P_id;
    }
    public String getP_name(){
        return this.P_name;
    }


    private int P_id;
    private String P_name;
}
