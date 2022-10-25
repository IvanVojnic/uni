package com.company;

import java.util.ArrayList;

public class Zachetka {

    private String surname;
    private int year;
    private Session[] sessions = new Session[8];
    private int numb;
    private int group;

    Zachetka(String surname,int year,Session[] sessions, int numb,int group){
        this.surname=surname;
        this.numb=numb;
        this.year=year;
        this.sessions=sessions;
        this.group=group;
    }
    public Zachetka() {
        for (int i = 0; i < 8; i++) {
            sessions[i] = new Session();
        }
    }
    public void add_stud(String fam, String group, String numb, String year) {
        this.surname = fam;
        this.group = Integer.parseInt(group);
        this.numb = Integer.parseInt(numb);
        this.year = Integer.parseInt(year);
    }

    public void add_exam(int numb, String subject, String prepod, String date, int hours, int mark) {

        sessions[numb].set_exam(subject, prepod, date, hours, mark);
    }

    public void add_zacet(int numb, String subject, String prepod, String date, int hours, int mark) {

        sessions[numb].set_zacet(subject, prepod, date, hours, mark);
    }


    public void print() {
        System.out.println("Зачетная книжка " + numb + ": " + "\n" +
                "Фамилия: " + surname + "; " + "\t" +
                "Группа: " + group + "; " + "\t" +
                "Год поступления: " + year + "; ");
        for (int i = 0; i < 8; i++) {
            int b = i + 1;
            if (sessions[i].getN() != 0) {
                System.out.println("Сессия №" + b + ": ");
                sessions[i].print();
                System.out.println();
            }
        }
    }

    public int getGroup() {
        return group;
    }

    public int getYear() {
        return year;
    }

    public int getNumb() {
        return numb;
    }

    public Session[] getSessions() {
        return sessions;
    }

    public String getSurname() {
        return surname;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    public void setNumb(int numb) {
        this.numb = numb;
    }

    public void setSessions(Session[] sessions) {
        this.sessions = sessions;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setYear(int year) {
        this.year = year;
    }

}
