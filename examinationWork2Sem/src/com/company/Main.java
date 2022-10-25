package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        String infile1 = "input1.txt";
        ArrayList<Empl> empls = new ArrayList<>();
        File fin1 = new File(infile1);
        Scanner myReader1 = new Scanner(fin1);
        while (myReader1.hasNextLine()) {
            String str = myReader1.nextLine();
            String[] subStr;
            String delimiter = ";";
            subStr = str.split(delimiter);
            Empl tmp = new Empl(subStr[0], subStr[1], subStr[2], subStr[3]);
            empls.add(tmp);
        }
        myReader1.close();

        String infile2 = "input2.txt";
        ArrayList<Project> projects = new ArrayList<>();
        File fin2 = new File(infile2);
        Scanner myReader2 = new Scanner(fin2);
        while (myReader2.hasNextLine()) {
            String str = myReader2.nextLine();
            String[] subStr;
            String delimiter = ";";
            subStr = str.split(delimiter);
            Project tmp = new Project(subStr[0], subStr[1]);
            projects.add(tmp);
        }
        myReader2.close();

        String infile3 = "input3.txt";
        ArrayList<PositionEmpl> positionEmpls = new ArrayList<>();
        File fin3 = new File(infile3);
        Scanner myReader3 = new Scanner(fin3);
        while (myReader3.hasNextLine()) {
            String str = myReader3.nextLine();
            String[] subStr;
            String delimiter = ";";
            subStr = str.split(delimiter);
            PositionEmpl tmp = new PositionEmpl(subStr[0], subStr[1], subStr[2], subStr[3],subStr[4]);
            positionEmpls.add(tmp);
        }
        myReader3.close();

        String infile4 = "input4.txt";
        ArrayList<Position> positions = new ArrayList<>();
        File fin4 = new File(infile4);
        Scanner myReader4 = new Scanner(fin4);
        while (myReader4.hasNextLine()) {
            String str = myReader4.nextLine();
            String[] subStr;
            String delimiter = ";";
            subStr = str.split(delimiter);
            Position tmp = new Position(subStr[0], subStr[1], subStr[2]);
            positions.add(tmp);
        }
        myReader4.close();

        String infile6 = "input6.txt";
        LocalDate dateBeg = null;
        LocalDate dateEnd = null;
        File fin6 = new File(infile6);
        Scanner myReader6 = new Scanner(fin6);
        while (myReader6.hasNextLine()) {
            String str = myReader6.nextLine();
            String[] subStr;
            String delimiter = ";";
            subStr = str.split(delimiter);
            int[] valDates1 = new int[3];
            String[] dateStr1;
            String delimiterDate = "\\.";
            dateStr1 = subStr[0].split(delimiterDate);
            valDates1[0] = Integer.parseInt(dateStr1[0]);
            valDates1[1] = Integer.parseInt(dateStr1[1]);
            valDates1[2] = Integer.parseInt(dateStr1[2]);
            dateBeg = LocalDate.of(valDates1[2],valDates1[1],valDates1[0]);
            int[] valDates2 = new int[3];
            String[] dateStr2;
            dateStr2 = subStr[1].split(delimiterDate);
            valDates2[0] = Integer.parseInt(dateStr2[0]);
            valDates2[1] = Integer.parseInt(dateStr2[1]);
            valDates2[2] = Integer.parseInt(dateStr2[2]);
            dateEnd = LocalDate.of(valDates2[2],valDates2[1],valDates2[0]);
        }
        myReader6.close();

        String infile8 = "input8.txt";
        int IDPROJ=0;
        File fin8 = new File(infile8);
        Scanner myReader8 = new Scanner(fin8);
        while (myReader8.hasNextLine()) {
            String str = myReader8.nextLine();
            IDPROJ = Integer.parseInt(str);
        }
        myReader8.close();

        String infile7 = "input7.txt";
        int IDPROJ2=0;
        File fin7 = new File(infile7);
        Scanner myReader7 = new Scanner(fin7);
        while (myReader7.hasNextLine()) {
            String str = myReader7.nextLine();
            IDPROJ2 = Integer.parseInt(str);
        }
        myReader7.close();

        SetWorkloads(empls,positionEmpls);
        try{
            Collections.sort(empls,new CompEmplByWS());
            File fout1 = new File("output1.txt");
            FileWriter myWriter = new FileWriter(fout1);
            for(int i = 0; i < empls.size(); i++){
                if(empls.get(i).getE_workload_sum() >100){
                    myWriter.write(String.valueOf(empls.get(i).getE_id()));
                    myWriter.write(";");
                    myWriter.write(empls.get(i).getE_surname());
                    myWriter.write(";");
                    myWriter.write(empls.get(i).getE_name());
                    myWriter.write(";");
                    myWriter.write(String.valueOf(empls.get(i).getE_workload_sum()));
                    myWriter.write("\n");
                }
            }
            myWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try{
            Collections.sort(empls,new CompEmplById());
            File fout2 = new File("output2.txt");
            FileWriter myWriter = new FileWriter(fout2);

            for(int i = 0; i < empls.size(); i++){
                for(int j = 0; j < positionEmpls.size(); j++){
                    if(empls.get(i).getE_id() == positionEmpls.get(j).getPE_empl_id()){
                        if(positionEmpls.get(j).getPE_project_id() == IDPROJ){
                            myWriter.write(String.valueOf(empls.get(i).getE_id()));
                            myWriter.write(";");
                            myWriter.write(empls.get(i).getE_surname());
                            myWriter.write(";");
                            myWriter.write(empls.get(i).getE_name());
                            myWriter.write("\n");
                        }
                    }
                }

            }
            myWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try{
            File fout3 = new File("output3.txt");
            FileWriter myWriter = new FileWriter(fout3);
            int countOpen = 0;
            for(int i = 0; i < positionEmpls.size(); i++){
                if(positionEmpls.get(i).getPE_project_id() == IDPROJ2){
                    for(int j = 0; j < projects.size(); j++){
                        if(positionEmpls.get(i).getPE_project_id() == projects.get(j).getP_id()){
                            LocalDate tmp = null;
                            for(int n = 0; n < positionEmpls.size();n++){
                                for(int m = 0; m < positions.size(); m++){
                                    if(positionEmpls.get(n).getPE_project_id() == positions.get(m).getPE_project_id()){
                                        tmp = positions.get(m).getP_openDate();
                                    }
                                }
                            }
                            int tmpYear = tmp.getYear();
                            int tmpMonth = tmp.getMonthValue();
                            int tmpDay = tmp.getDayOfMonth();
                            int begYear = dateBeg.getYear();
                            int begMon = dateBeg.getMonthValue();
                            int begDay = dateBeg.getDayOfMonth();
                            int endYear = dateEnd.getYear();
                            int endMon = dateEnd.getMonthValue();
                            int endDay = dateEnd.getDayOfMonth();
                            if((tmpYear < endYear && tmpYear > begYear)||(tmpYear < endYear && tmpYear == begYear)){
                                countOpen++;
                            } else if(tmpYear == endYear){
                                if((tmpMonth < endMon && tmpMonth > begMon)||(tmpMonth < endMon && tmpMonth == begMon)){
                                    if(tmpDay <= endDay){
                                        countOpen++;
                                    }
                                } else if(tmpMonth == endMon){
                                    if(tmpDay < endDay){
                                        countOpen++;
                                    }
                                }
                            }
                        }
                    }
                    }
                }
            for(int i = 0; i < projects.size(); i++){
                if(projects.get(i).getP_id() == IDPROJ2){
                    myWriter.write(projects.get(i).getP_name());
                    myWriter.write(";");
                    myWriter.write(String.valueOf(countOpen));
                    myWriter.write("\n");
                }
            }
            myWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static void SetWorkloads(ArrayList<Empl> empls, ArrayList<PositionEmpl> positions){
        for(int i = 0; i < empls.size(); i++){
            for(int j = 0; j < positions.size(); j++){
                if(empls.get(i).getE_id() == positions.get(j).getPE_empl_id()){
                    empls.get(i).setE_workload_sum(positions.get(j).getPE_workload());
                }
            }
        }
    }
}
