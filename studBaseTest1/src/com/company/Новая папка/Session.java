package com.company;

import java.io.Serializable;


public class Session implements Serializable {


    private Zachet[] zac = new Zachet[10];
    private Ekzamen[] ekz=new Ekzamen[5];
    private int n = 0;
    private int m = 0;

    public Ekzamen[] getEkz() {
        return ekz;
    }

    public int getM() {
        return m;
    }

    public int getN() {
        return n;
    }

    public void setEkz(Ekzamen[] ekz) {
        this.ekz = ekz;
    }

    public void setM(int m) {
        this.m = m;
    }

    public void setN(int n) {
        this.n = n;
    }

    public void setZac(Zachet[] zac) {
        this.zac = zac;
    }

    public Zachet[] getZac() {
        return zac;
    }
    Session(Ekzamen[] temp1, Zachet[] temp2, int n, int m){
        this.n = n;
        this.m = m;

        ekz = new Ekzamen[n];
        zac = new Zachet[m];

        for (int i = 0; i < n; i++) {
            ekz[i].setSubject(temp1[i].getSubject());
            ekz[i].setTeacher_name(temp1[i].getTeacher_name());
            ekz[i].setHours(temp1[i].getHours());
            ekz[i].setDate(temp1[i].getDate());
            ekz[i].setMark(temp1[i].getMark());
        }
        for (int i = 0; i < m; i++) {
            zac[i].setSubject(temp2[i].getSubject());
            zac[i].setTeacher_name(temp2[i].getTeacher_name());
            zac[i].setHours(temp2[i].getHours());
            zac[i].setData(temp2[i].getData());
            zac[i].setMark(temp2[i].getMark());
        }



    }
    public void set_exam(String subject, String prepod, String date, int hours, int mark) {
        boolean exist = false;
        for (int i = 0; i < 5; i++) {
            if (ekz[i] != null && ekz[i].getSubject() == subject) {
                exist = true;
                ekz[i] = new Ekzamen(subject, prepod, mark, hours,date);
            }
        }
        if (exist == false) {
            for (int i = 0; i < 5; i++) {
                if (ekz[i] == null) {
                    ekz[i] = new Ekzamen(subject, prepod, mark, hours, date);
                    exist = true;
                    n++;
                    break;
                }
            }
        }
    }

    public void set_zacet(String subject, String prepod, String date, int hours, int mark) {
        boolean exist = false;
        boolean temp;
        if(mark == 1) {
            temp = true;
        }
        else{
            temp = false;
        }
        for (int i = 0; i < 10; i++) {
            if (zac[i] != null && zac[i].getSubject() == subject) {
                exist = true;

                zac[i] = new Zachet(subject, prepod, hours,temp,date );
            }
        }
        if (exist == false) {
            for (int i = 0; i < 10; i++) {
                if (zac[i] == null) {
                    zac[i] = new Zachet(subject, prepod, hours, temp,date);
                    exist = true;
                    m++;
                    break;
                }
            }
        }
    }

    Session(){};
    public void print(){
        for(int i = 0; i<5; i++){
            if(ekz[i] != null){
                System.out.println(ekz[i]);
            }
        }
        for(int i = 0; i<10; i++){
            if(zac[i] != null){
                System.out.println(zac[i]);
            }
        }
    }






}
