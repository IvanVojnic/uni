package com.company;

public class Record extends Exam {
    Record(String R_subName, String R_fio, int R_countOfHours, String R_date, boolean R_mark){
        super(R_subName, R_fio, R_countOfHours, R_date);
        this.R_mark = R_mark;
    }
    Record(Exam myExam, boolean myMark){
        super(myExam.getE_subName(), myExam.E_fio(), myExam.getE_countOfHours(), myExam.getE_date());
        this.R_mark = myMark;
    }
    private String R_subName;
    private String R_fio;
    private int R_countOfHours;
    private String R_date;
    private boolean R_mark;
}
