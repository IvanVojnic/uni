package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Vedomost_ekz ved_geom, ved_ma, ved_zac_ga;
        ved_geom = new Vedomost_ekz("inputV1.txt");
        ved_ma = new Vedomost_ekz("inputV2.txt");
        ved_zac_ga = new Vedomost_ekz("inputZ1.txt");

        ved_geom.print();
        System.out.println();
        ved_ma.print();
        System.out.println();
        ved_zac_ga.print();
        System.out.println();

        Student b = new Student();
        b.setStudents("Students.txt");
        b.print();


        b.setSession_exam(ved_geom);
        b.setSession_exam(ved_ma);
        b.setSession_zacet(ved_zac_ga);
        System.out.println();
        b.print();

        System.out.println();
        b.show_student(2023218);
        b.show_student(202321238);
        System.out.println();

        //Сериализация
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("base.dat")))
        {
            oos.writeObject(b);
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }

        //Десериализация
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("base.dat")))
        {
            Student a=(Student) ois.readObject();
            a.print();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}
