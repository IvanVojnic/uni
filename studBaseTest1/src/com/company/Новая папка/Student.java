package com.company;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class Student implements Serializable {
    private Zachetka[] zachetki;
    private int m;

    public Zachetka[] getZac() {
        return zachetki;
    }
    public void setZac(Zachetka[] zac) {
        this.zachetki = zac;
    }
    public int getM() {
        return m;
    }
    public void setM(int m) {
        this.m = m;
    }

    public Student() {
        this.zachetki = null;
        this.m = 0;
    }

    public void setStudents(String filename) throws FileNotFoundException {
        FileReader fr = new FileReader(filename);
        Scanner scanner = new Scanner(fr);
        this.m = Integer.parseInt(scanner.nextLine());
        zachetki = new Zachetka[m];
        int i = 0;
        while (scanner.hasNextLine()){
            String temp = scanner.nextLine();
            String[] words=temp.split(" ");
            zachetki[i] = new Zachetka();
            zachetki[i].add_stud(words[0],words[1], words[2], (words[3]));
            i++;
        }
    }

    public void setSession_exam(Vedomost_ekz ved) {
        ArrayList<Integer> nomers = new ArrayList<Integer>();
        nomers = ved.getZacetka();
        ArrayList <Integer> marks = new ArrayList<Integer>();
        marks = ved.getMark();
        int k = 0;
        for (int i = 0; i<m; i++){
            if(nomers.get(i) == zachetki[k].getNumb()){
                int numb_temp = ved.getSesion_numb() - 1;
                String subject_temp = ved.getSubject();
                String prepod_temp = ved.getPrepod();
                String date_temp = ved.getDate();
                int hours_temp = ved.getHours();
                int mark_temp = marks.get(i);
                zachetki[k].add_exam(numb_temp, subject_temp, prepod_temp, date_temp, hours_temp, mark_temp);
            }
            k++;
        }
    }

    public void setSession_zacet(Vedomost_ekz ved) {
        ArrayList <Integer> nomers = new ArrayList<Integer>();
        nomers = ved.getZacetka();
        ArrayList <Integer> marks = new ArrayList<Integer>();
        marks = ved.getMark();
        int k = 0;
        for (int i = 0; i<m; i++){
            if(nomers.get(i) == zachetki[k].getNumb()){
                int numb_temp = ved.getSesion_numb() - 1;
                String subject_temp = ved.getSubject();
                String prepod_temp = ved.getPrepod();
                String date_temp = ved.getDate();
                int hours_temp = ved.getHours();
                int mark_temp = marks.get(i);
                zachetki[k].add_zacet(numb_temp, subject_temp, prepod_temp, date_temp, hours_temp, mark_temp);
            }
            k++;
        }
    }

    public void print(){
        for(int i =0; i<m; i++)
        {
            zachetki[i].print();
        }
    }
    public void show_student(int number){
        boolean ex = false;
        System.out.println("Вы ввели номер: " + number + ";");
        for(int i = 0; i<m; i++){
            if(zachetki[i].getNumb()==number){
                System.out.println("Данные: ");
                zachetki[i].print();
                ex = true;
            }
        }
        if(ex == false){
            System.out.println("Студента с таким номером зачетки не существует.");
        }
    }

}
