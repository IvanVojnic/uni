package com.company;

public class Exam {
    Exam(String E_subName, String E_fio, int E_countOfHours, String E_date, int E_mark){
        this.E_subName = E_subName;
        this.E_fio = E_fio;
        this.E_countOfHours = E_countOfHours;
        this.E_date = E_date;
        this.E_mark = E_mark;
    }
    Exam(String E_subName, String E_fio, int E_countOfHours, String E_date){
        this.E_subName = E_subName;
        this.E_fio = E_fio;
        this.E_countOfHours = E_countOfHours;
        this.E_date = E_date;
    }
    protected String getE_subName(){
        return E_subName;
    }
    public void setMark(int mark) {
        this.E_mark = mark;
    }

    public void setHours(int hours) {
        this.E_countOfHours = hours;
    }

    public String getTeacher_name() {
        return E_fio;
    }

    public int getHours() {
        return E_countOfHours;
    }

    public int getMark() {
        return E_mark;
    }

    public String getDate() {
        return E_date;
    }

    public void setDate(String date) {
        this.E_date = date;
    }

    public void setSubject(String subject) {
        this.E_subName = subject;
    }

    public void setTeacher_name(String teacher_name) {
        this.E_fio = teacher_name;
    }

    @Override
    public String toString() {
        return "Ekzamen{" +
                "subject='" + E_subName + '\'' +
                ", teacher_name='" + E_fio + '\'' +
                ", hours=" + E_countOfHours +
                ", mark=" + E_mark +
                '}'+ '\'';
    }
    protected String E_fio(){
        return E_fio;
    }
    protected int getE_countOfHours(){
        return E_countOfHours;
    }
    protected String getE_date(){
        return E_date;
    }
    private String E_subName;
    private String E_fio;
    private int E_countOfHours;
    private String E_date;
    private int E_mark;
}
