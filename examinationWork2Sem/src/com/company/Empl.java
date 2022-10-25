package com.company;

public class Empl {
    Empl(String E_id, String E_surname, String E_name, String E_skill){
        this.E_id = Integer.parseInt(E_id);
        this.E_name = E_name;
        this.E_surname = E_surname;
        this.E_skill = E_skill;
    }

    public int getE_workload_sum(){
        return this.E_workload_sum;
    }
    public int getE_id(){
        return this.E_id;
    }
    public String getE_name(){
        return this.E_name;
    }
    public String getE_surname(){
        return this.E_surname;
    }

    public void setE_workload_sum(int EwS){
        this.E_workload_sum += EwS;
    }

    private int E_id;
    private String E_name;
    private String E_surname;
    private String E_skill;
    private int E_workload_sum = 0;
}
