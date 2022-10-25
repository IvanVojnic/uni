package com.company;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class Vedomost_ekz implements Serializable {

    private String subject;
    private String prepod;
    private int hours;
    private String date;
    private int group;
    private int sesion_numb;
    private ArrayList<Integer> zacetka = new ArrayList<Integer>();
    private ArrayList <Integer> mark = new ArrayList<Integer>();





    public String getSubject() {
        return subject;
    }
    public void setSubject(String subject) {
        this.subject = subject;
    }
    public String getPrepod() {
        return prepod;
    }
    public void setPrepod(String prepod) {
        this.prepod = prepod;
    }
    public int getHours() {
        return hours;
    }
    public void setHours(int hours) {
        this.hours = hours;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public ArrayList<Integer> getZacetka() {
        return zacetka;
    }
    public void setZacetka(ArrayList<Integer> zacet) {
        this.zacetka = zacet;
    }
    public ArrayList<Integer> getMark() {
        return mark;
    }
    public void setMark(ArrayList<Integer> mark) {
        this.mark = mark;
    }
    public int getGroup() {
        return group;
    }
    public void setGroup(int group) {
        this.group = group;
    }
    public int getSesion_numb() {
        return sesion_numb;
    }
    public void setSesion_numb(int sesion_numb) {
        this.sesion_numb = sesion_numb;
    }

    Vedomost_ekz(String filename) throws FileNotFoundException {
        FileReader fr = new FileReader(filename);
        Scanner scanner = new Scanner(fr);
        this.subject = scanner.nextLine();
        this.prepod = scanner.nextLine();
        this.date = scanner.nextLine();
        this.sesion_numb = scanner.nextInt();
        this.hours = scanner.nextInt();
        this.group = scanner.nextInt();
        while (scanner.hasNext()){
            zacetka.add(Integer.parseInt(scanner.next()));
            mark.add(Integer.parseInt(scanner.next()));
        }
    }

    public void print(){
        System.out.println("Ведомость по предмету " + subject + ": " + "\n"+
                "Преподаватель: " + prepod + "; " + "\n" +
                "Часы занятий: " + hours + "; " + "\n" +
                "Дата экзамена: " + date + "; " + "\n" +
                "Учебная группа: " + group + "; " + "\n" +
                "Номер сессии: " + sesion_numb + "; ");
        for(int i = 0; i< zacetka.size(); i++){
            System.out.println("Номер зачетки: " + zacetka.get(i) +  ";" + "\t " + "Оценка: " + mark.get(i) + ";");
        }
    }


}